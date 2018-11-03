package uniandes.isis2304.superAndes.persistencia;

import java.util.LinkedList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.Proveedor;

class SQLCliente {

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
	public SQLCliente (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}

	/**
	 * -----------Requerimiento funcional 3A------------
	 * Crea y ejecuta la sentencia SQL para adicionar un CLIENTE a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param correo - El correo único del cliente.
	 * @param nombre - El nombre del cliente.
	 * @param puntosFidelizacion - Los puntos de fidelización del cliente. 
	 * @return El número de tuplas insertadas.
	 */
	public Long adicionarCliente(PersistenceManager pm, String correo, String nombre, int puntosFidelizacion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaCliente() + "(correo, nombre, puntos_fidelizacion) values (?, ?, ?)");
		q.setParameters(correo, nombre, puntosFidelizacion);
		return (long) q.executeUnique();   
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar un CLIENTE de la base de datos de SuperAndes, por su correo
	 * @param pm - El manejador de persistencia
	 * @param correo - El correo único del cliente.
	 * @return El número de tuplas eliminadas.
	 */
	public Long eliminarClientePorCorreo(PersistenceManager pm,String correo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaCliente () + " WHERE correo = ?");
		q.setParameters(correo);
		return (long) q.executeUnique();   
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar CLIENTES de la base de datos de SuperAndes, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre del cliente
	 * @return El número de tuplas eliminadas.
	 */
	public Long eliminarClientePorNombre(PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaCliente() + "WHERE nombre = " + nombre);
		return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN CLIENTE de la 
	 * base de datos de SuperAndes, por su correo
	 * @param pm - El manejador de persistencia
	 * @param nit - El correo del cliente.
	 * @return El objeto CLIENTE que tiene el identificador dado.
	 */
	public Cliente darClientePorCorreo (PersistenceManager pm, String correo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaCliente ()  + " WHERE correo = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(correo);
		return (Cliente) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de CLIENTES de la 
	 * base de datos de SuperAndes, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nit - El nombre del cliente.
	 * @return Una lista de objetos CLIENTE que tiene el nombre dado.
	 */
	public List<Cliente> darClientePorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaCliente () + " WHERE nombre = " + nombre);
		q.setResultClass(Cliente.class);
		q.setParameters(nombre);
		return (List<Cliente>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS CLIENTES de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos CLIENTES
	 */
	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaCliente ());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();

	}
	/**
	 * Crea y ejecuta la sentencia SQL para actualizar la información del CLIENTE de la 
	 * base de datos de SuperAndes con el correo dado.
	 * @param pm - El manejador de persistencia
	 * @param correo - El correo único del cliente a actualizar.
	 * @param nombre - El nuevo nombre del cliente.
	 * @param puntosFidelizacion - El nuevo número de puntos de fidelización del cliente.
	 * @return El número de tuplas actualizadas.
	 */
	public long actualizarCliente (PersistenceManager pm, String correo, String nombre, int puntosFidelizacion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + psa.darTablaCliente () + " SET (nombre, puntos_fidelizacion) VALUES (?, ?) WHERE nombre = ? ");
		q.setParameters(nombre,puntosFidelizacion,correo);
		return (long) q.executeUnique();
	}


}
