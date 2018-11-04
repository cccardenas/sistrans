package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Proveedor;

public class SQLProveedor {
	
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
	 * @param psa - El Manejador de persistencia de la aplicación
	 */
	public SQLProveedor (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * -----------Requerimiento funcional 1------------
	 * Crea y ejecuta la sentencia SQL para adicionar un PROVEEDOR a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param nit - El nit único del proveedor.
	 * @param nombre - El nombre único del proveedor.
	 * @param calificacion - La calificación cuantificable del proveedor.
	 * @param tipoProveedor - El tipo de proveedor, puede ser 'General' o 'Especifico'.
	 * @return El número de tuplas insertadas
	 */
	public long adicionarProveedor (PersistenceManager pm, long nit, String nombre, int calificacion, String tipoProveedor) 
	{
		System.out.println("Tabla proveedor: "+ psa.darTablaProveedor() );
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaProveedor() + "(nit, nombre, calificacion, tipoProveedor) values (?, ?, ?, ?)");
        q.setParameters(nit, nombre, calificacion, tipoProveedor);
        return (long) q.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar un PROVEEDOR de la base de datos de SuperAndes, por su nit
	 * @param pm - El manejador de persistencia
	 * @param nit - El nit único del proveedor.
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarProveedorPorNit (PersistenceManager pm, int nit)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaProveedor () + " WHERE nit = ?");
        q.setParameters(nit);
        return (long) q.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN PROVEEDOR de la base de datos de SuperAndes, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre único del proveedor.
	 * @return El número de tuplas eliminadas.
	 */
	public long eliminarProveedorPorNombre (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaProveedor () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PROVEEDOR de la 
	 * base de datos de SuperAndes, por su nit
	 * @param pm - El manejador de persistencia
	 * @param nit - El nit del proveedor.
	 * @return El objeto PROVEEDOR que tiene el identificador dado.
	 */
	public Proveedor darProveedorPorNit (PersistenceManager pm, int nit) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaProveedor ()  + " WHERE nit = ?");
		q.setResultClass(Proveedor.class);
		q.setParameters(nit);
		return (Proveedor) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PROVEEDOR de la 
	 * base de datos de SuperAndes, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre del proveedor.
	 * @return El objeto PROVEEDOR que tiene el identificador dado.
	 */
	public Proveedor darProveedorPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaProveedor ()  + " WHERE nombre = ?");
		q.setResultClass(Proveedor.class);
		q.setParameters(nombre);
		return (Proveedor) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PROVEEDORES de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos PROVEEDOR
	 */
	public List<Proveedor> darProveedores (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaProveedor());
		q.setResultClass(Proveedor.class);
		return (List<Proveedor>) q.executeList();
	}

	
}
