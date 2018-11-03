package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Almacenamiento;
import uniandes.isis2304.superAndes.negocio.Empresa;
import uniandes.isis2304.superAndes.negocio.Sucursal;

class SQLAlmacenamiento {
	
	
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
	 * @param psa - El Manejador de persistencia de la aplicación
	 */
	public SQLAlmacenamiento (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * -----------Requerimiento funcional (5/6)_A------------
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAMIENTO a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param idAlmacenamiento - El identificador único del almacenamiento.
	 * @param categoria - La categoría de productos que almacena el almacenamiento.
	 * @param capacidadVolumen - La capacidad volumétrica máxima del almacenamiento en cm3.
	 * @param capacidadPeso - El peso máximo que soporta el almacenamiento en gr.
	 * @param cantidadProductos - La cantidad de productos que guarda actualmente.
	 * @param sucursalNombre - El nombre de la sucursal donde se encuentra el almacenamiento.
	 * @param sucursalDireccion - La dirección de la sucursal donde se encuentra el almacenamiento. 
	 * @param sucursalCiudad - La ciudad de la sucursal donde se encuentra el almacenamiento.
	 * @return El número de tuplas insertadas.
	 */
	public long adicionarAlmacenamiento (PersistenceManager pm, int idAlmacenamiento, String categoria, double capacidadVolumen, double capacidadPeso, int cantidadProductos, String sucursalNombre, String sucursalDireccion, String sucursalCiudad) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaAlmacenamiento() + "(ID_ALMACENAMIENTO, CATEGORIA, CAPACIDAD_VOLUMEN, CAPACIDAD_PESO, CANTIDAD_PRODUCTOS, SUCURSAL_NOMBRE, SUCURSAL_DIRECCION, SUCURSAL_CIUDAD) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idAlmacenamiento, categoria, capacidadVolumen, capacidadPeso, cantidadProductos, sucursalNombre, sucursalDireccion, sucursalCiudad);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar un ALMACENAMIENTO de la base de datos de SuperAndes, por su identificador.
	 * @param pm - El manejador de persistencia.
	 * @param idAlmacenamiento - El identificador único del almacenamiento.
	 * @return El objeto ALMACENAMIENTO que tiene el identificador dado.
	 */
	public Almacenamiento darAlmacenamientoPorId (PersistenceManager pm, int idAlmacenamiento)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaAlmacenamiento () + " WHERE ID_ALMACENAMIENTO = ?");
        q.setResultClass(Almacenamiento.class);
        q.setParameters(idAlmacenamiento);        
		return (Almacenamiento) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar un ALMACENAMIENTO de la base de datos de SuperAndes, por su identificador.
	 * @param pm - El manejador de persistencia.
	 * @param idAlmacenamiento - El identificador único del almacenamiento.
	 * @return El número de tuplas eliminadas.
	 */
	public long eliminarAlmacenamientoPorId (PersistenceManager pm, int idAlmacenamiento)
	{
		   Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaAlmacenamiento () + " WHERE ID_ALMACENAMIENTO = ?");
	        q.setParameters(idAlmacenamiento);        
			return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALMACENAMIENTOS de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ALMACENAMIENTO
	 */
	public List<Almacenamiento> darAlmacenamientos (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaAlmacenamiento ());
		q.setResultClass(Almacenamiento.class);
		return (List<Almacenamiento>) q.executeList();
	}
	

}
