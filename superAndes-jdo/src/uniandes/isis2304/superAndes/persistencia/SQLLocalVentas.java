package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.Empresa;
import uniandes.isis2304.superAndes.negocio.Factura;
import uniandes.isis2304.superAndes.negocio.LocalVentas;

public class SQLLocalVentas {
	
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
	public SQLLocalVentas (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * -----------Requerimiento funcional 4A------------
	 * Crea y ejecuta la sentencia SQL para adicionar un LOCAL VENTAS a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param idLocalVentas - El identificador único del local de ventas.
	 * @param ingresos - Los ingresos del local de ventas.
	 * @return El número de tuplas insertadas.
	 */
	public Long adicionarLocalVentas(PersistenceManager pm, int idLocalVentas, double ingresos)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaLocalVentas () + "(id_localventas,ingresos) values (?, ?)");
	     q.setParameters(idLocalVentas,ingresos);
	     return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar una LOCAL VENTAS de la base de datos de SuperAndes, por su identificación.
	 * @param pm - El manejador de persistencia
	 * @param idLocalVentas - El identificador único del local de ventas.
	 * @return El objeto LOCAL VENTAS con el identificador dado.
	 */
	public LocalVentas darLocalVentasPorId(PersistenceManager pm,int idLocalVentas)
	{
		Query q = pm.newQuery(SQL,"SELECT * FROM" + psa.darTablaLocalVentas() + "WHERE id_localventas = ?");
		q.setResultClass(LocalVentas.class);
		q.setParameters(idLocalVentas);
		return (LocalVentas) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una LOCAL VENTAS de la base de datos de SuperAndes, por su identificación.
	 * @param pm - El manejador de persistencia
	 * @param idLocalVentas - El identificador único del local de ventas.
	 * @return El número de tuplas eliminadas.
	 */
	public Long eliminarLocalVentasPorId(PersistenceManager pm,int idLocalVentas)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaLocalVentas() + "WHERE id_localventas = ?");
		q.setParameters(idLocalVentas);
		return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los LOCAL VENTAS de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos LOCAL VENTAS.
	 */
	public List<LocalVentas> darLocalesVentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaLocalVentas ());
		q.setResultClass(LocalVentas.class);
		return (List<LocalVentas>) q.executeList();
	}

}
