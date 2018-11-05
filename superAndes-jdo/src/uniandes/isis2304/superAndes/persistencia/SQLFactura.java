package uniandes.isis2304.superAndes.persistencia;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.ClienteFrecuente;
import uniandes.isis2304.superAndes.negocio.Factura;
import uniandes.isis2304.superAndes.negocio.PersonaNatural;

public class SQLFactura {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes psa;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLFactura (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public Long adicionarFactura(PersistenceManager pm,Long numeroFactura, String fecha,String nombreCliente, String nombreSucursal, double valorTotal)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaFactura () + "(numeroFactura, fecha, nombreCliente,nombreSucursal,valorTotal) values (?, ?, ?, ?, ? )");
	     q.setParameters(numeroFactura,fecha,nombreCliente,nombreSucursal,valorTotal);
	     return (long) q.executeUnique();
	}
	
	public Long eliminarFacturaPorNumeroFactura(PersistenceManager pm,Long numeroFactura)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaFactura() + "WHERE numeroFactura = ?");
		q.setParameters(numeroFactura);
		return (long) q.executeUnique();
	}
	
	
	public Factura darFacturaPorNumeroFactura (PersistenceManager pm, Long numeroFactura) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaFactura () + " WHERE numeroFactura = ?");
		q.setResultClass(Factura.class);
		q.setParameters(numeroFactura);
		return (Factura) q.executeUnique();
	}
	
	public List<Factura> darFacturasPorNombreCliente (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaFactura () + " WHERE nombreCliente = ?");
		q.setResultClass(Factura.class);
		q.setParameters(nombre);
		return (List<Factura>) q.executeList();
	}
	
	public List<Factura> darFacturasRangoFecha (PersistenceManager pm, String fechaInicial, String fechaFinal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaFactura () + " WHERE fecha BETWEEN '?' AND '?'");
		q.setResultClass(Factura.class);
		q.setParameters(fechaInicial,fechaFinal);
		return (List<Factura>) q.executeList();
	}
	
	public List<Factura> darFacturasPorNombreSucursal (PersistenceManager pm, String nombreSucursal)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaFactura () + " WHERE nombreSucursal = ?");
		q.setParameters(nombreSucursal);
		q.setResultClass(Factura.class);
		return (List<Factura>) q.executeList();
	}

	public List<ClienteFrecuente> darClientesFrecuentes(PersistenceManager pm, String sucursal)
	{
		
		String clausure = "SELECT COUNT(FECHA_COMPRA)AS NUMERO_DE_COMPRAS,CORREO_CLIENTE,FECHA_COMPRA FROM " +  psa.darTablaFactura() +" WHERE SUCURSAL_NOMBRE = " +"'"+ sucursal +"'"+ " GROUP BY (EXTRACT(MONTH FROM FECHA_COMPRA)),CORREO_CLIENTE,FECHA_COMPRA";
		Query q = pm.newQuery(SQL, clausure);
		List executeList = q.executeList();
		List<ClienteFrecuente> rsp = new LinkedList<>();
		
		for(Object obj: executeList)
		{
			Object [] datos = (Object []) obj;
			int numeroCompras = ((Number)datos[0]).intValue();
			String correoCliente = (String)datos[1];
			String fechaCompra = ((Timestamp)datos[2]).toString();
			rsp.add(new ClienteFrecuente(numeroCompras,correoCliente,fechaCompra));
		}
		
		return rsp;
	}

}
