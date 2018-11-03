package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.Factura;
import uniandes.isis2304.superAndes.negocio.Promocion;

public class SQLPromocion {
	
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
	public SQLPromocion (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public Long adicionarPromocion(PersistenceManager pm,Long idPromocion, String codigoBarras,String nitProveedor, String tipoPromocion, String nombrePromocion)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaPromocion () + "(idPromocion, codigoBarras, nitProveedor,tipoPromocion,nombrePromocion) values (?, ?, ?, ?, ? )");
	     q.setParameters(idPromocion,codigoBarras,nitProveedor,tipoPromocion,nombrePromocion);
	     return (long) q.executeUnique();
	}
	
	public Long eliminarPromocionPorId(PersistenceManager pm,Long idPromocion)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaPromocion() + "WHERE idPromocion = ?");
		q.setParameters(idPromocion);
		return (long) q.executeUnique();
	}
	
	
	public Promocion darPromocionPorId (PersistenceManager pm, Long idFactura) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPromocion() + " WHERE idPromocion = ?");
		q.setResultClass(Promocion.class);
		q.setParameters(idFactura);
		return (Promocion) q.executeUnique();
	}
	
	public List<Promocion> darPromocionesPorRangoFecha (PersistenceManager pm, String fechaInicial, String fechaFinal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPromocion() + " WHERE fechaInicial >= '?' AND fechaFinal <= '?'");
		q.setResultClass(Promocion.class);
		q.setParameters(fechaInicial,fechaFinal);
		return (List<Promocion>) q.executeList();
	}
	
	public List<Promocion> darPromociones (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPromocion());
		q.setResultClass(Promocion.class);
		return (List<Promocion>) q.executeList();
	}
	

}
