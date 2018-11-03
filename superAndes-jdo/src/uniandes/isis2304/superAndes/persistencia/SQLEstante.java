package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Bodega;
import uniandes.isis2304.superAndes.negocio.Estante;
import uniandes.isis2304.superAndes.negocio.Sucursal;

public class SQLEstante {
	
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
	public SQLEstante (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	/**
	 * -----------Requerimiento funcional 6B------------
	 * Crea y ejecuta la sentencia SQL para adicionar un ESTANTE a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param idAlmacenamiento - El identificador único del almacenamiento.
	 * @param nombreEstante - El nombre único del estante.
	 * @param nivelAbastecimiento - El nivel de abastecimiento del estante.
	 * @return El número de tuplas insertadas.
	 */
	public long adicionarEstante (PersistenceManager pm, int idAlmacenamiento, String nombreEstante, double nivelAbastecimiento) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaEstante() + "(ID_ALMACENAMIENTO,NOMBRE_ESTANTE, NIVEL_ABASTECIMIENTO) values (?, ?, ?)");
        q.setParameters(idAlmacenamiento, nombreEstante, nivelAbastecimiento);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar un ESTANTE de la base de datos de SuperAndes, por su nombre.
	 * @param pm - El manejador de persistencia.
	 * @param nombreEstante - El nombre único de la estante.
	 * @return El objeto ESTANTE que tiene el nombre dado.
	 */
	public Estante darEstantePorNombre (PersistenceManager pm, String nombreEstante)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEstante () + " WHERE nombre_estante = ?");
        q.setResultClass(Estante.class);
        q.setParameters(nombreEstante);
        return (Estante) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar un ESTANTE de la base de datos de SuperAndes, por su nombre.
	 * @param pm - El manejador de persistencia.
	 * @param nombreEstante - El nombre único de la estante.
	 * @return El objeto ESTANTE que tiene el nombre dado.
	 */
	public long eliminarEstantePorNombre (PersistenceManager pm, String nombreEstante)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaEstante () + " WHERE nombre_estante = ?");
        q.setParameters(nombreEstante);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ESTANTES de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ESTANTE
	 */
	public List<Estante> darEstantes (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEstante ());
		q.setResultClass(Estante.class);
		return (List<Estante>) q.executeList();
	}

}
