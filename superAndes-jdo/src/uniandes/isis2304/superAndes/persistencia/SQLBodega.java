package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Bodega;


class SQLBodega {
	
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
	 * 			M�todos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLBodega (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * -----------Requerimiento funcional 5B------------
	 * Crea y ejecuta la sentencia SQL para adicionar una BODEGA a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param idAlmacenamiento - El identificador único del almacenamiento.
	 * @param nombreBodega - El nombre único de la bodega.
	 * @return El número de tuplas insertadas.
	 */
	public long adicionarBodega (PersistenceManager pm, int idAlmacenamiento, String nombreBodega) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaBodega () + "(ID_ALMACENAMIENTO, NOMBRE_BODEGA) values (?, ?)");
        q.setParameters(idAlmacenamiento, nombreBodega);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar una BODEGA de la base de datos de SuperAndes, por su nombre.
	 * @param pm - El manejador de persistencia.
	 * @param nombreBodega - El nombre único de la bodega.
	 * @return El objeto BODEGA que tiene el nombre dado.
	 */
	public Bodega darBodegaPorNombre (PersistenceManager pm, String nombreBodega)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaBodega () + " WHERE nombre_bodega = ?");
        q.setResultClass(Bodega.class);
        q.setParameters(nombreBodega);
        return (Bodega) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una BODEGA de la base de datos de SuperAndes, por su nombre.
	 * @param pm - El manejador de persistencia.
	 * @param nombreBodega - El nombre único de la bodega.
	 * @return El número de tuplas eliminadas.
	 */
	public long eliminarBodegaPorNombre (PersistenceManager pm, String nombreBodega)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaBodega () + " WHERE nombre_bodega = ?");
        q.setParameters(nombreBodega);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS BODEGAS de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BODEGA
	 */
	public List<Bodega> darBodegas (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaBodega ());
		q.setResultClass(Bodega.class);
		return (List<Bodega>) q.executeList();
	}
	
	


}
