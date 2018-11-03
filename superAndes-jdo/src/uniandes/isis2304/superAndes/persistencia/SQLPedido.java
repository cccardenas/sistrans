package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Estante;
import uniandes.isis2304.superAndes.negocio.Pedido;
import uniandes.isis2304.superAndes.negocio.Sucursal;

public class SQLPedido {
	
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
	public SQLPedido (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public long adicionarPedido (PersistenceManager pm, Long numeroPedido, String fechaEntrega, String sucursalSolicitante,String nitProveedor, int cantidadProductos, int calidad, int calificacion, double precio, double cantidadVolumen) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaPedidos () + "(numeroPedido, fechaEntrega, sucursalSolicitante, nitProveedor, cantidadProductos, calidad, calificacion,precio,cantidadVolumen) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(numeroPedido,fechaEntrega,sucursalSolicitante,nitProveedor,cantidadProductos, calidad,calificacion,precio, cantidadVolumen);
        return (long) q.executeUnique();
	}


	public long eliminarPedidoPorNumeroPedido (PersistenceManager pm, Long numeroPedido)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaPedidos () + " WHERE numeroPedido = ?");
        q.setParameters(numeroPedido);
        return (long) q.executeUnique();
	}

	
	public List<Pedido> darPedidosPorSucursal (PersistenceManager pm, String nombreSucursal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPedidos () + " WHERE nombreSucursal = ?");
		q.setResultClass(Pedido.class);
		q.setParameters(nombreSucursal);
		return (List<Pedido>) q.executeUnique();
	}
	
	public List<Pedido> darPedidosPorNIT (PersistenceManager pm, String nitProveedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPedidos () + " WHERE nitProveedor = ?");
		q.setResultClass(Pedido.class);
		q.setParameters(nitProveedor);
		return (List<Pedido>) q.executeList();
	}

	
	public List<Pedido> darPedidos (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPedidos ());
		q.setResultClass(Pedido.class);
		return (List<Pedido>) q.executeList();
	}

}
