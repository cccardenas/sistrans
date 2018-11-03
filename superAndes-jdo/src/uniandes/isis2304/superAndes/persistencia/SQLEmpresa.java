package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.Empresa;
import uniandes.isis2304.superAndes.negocio.PersonaNatural;

public class SQLEmpresa {
	
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
	public SQLEmpresa (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * -----------Requerimiento funcional 3B_2------------
	 * Crea y ejecuta la sentencia SQL para adicionar una EMPRESA a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param nit - El nit único de la empresa.
	 * @param dirección - la dirección de la empresa.
	 * @param correo - El correo relacionado a la empresa.
	 * @return El número de tuplas insertadas.
	 */
	public Long adicionarEmpresa(PersistenceManager pm, int nit, String direccion,String correo)
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaEmpresa () + "(nit, direccion, correo_cliente) values (?, ?, ?)");
	     q.setParameters(nit, direccion, correo);
	     return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una EMPRESA de la base de datos de SuperAndes, por su correo.
	 * @param pm - El manejador de persistencia
	 * @param correo - El correo único de la empresa.
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarEmpresaPorCorreo(PersistenceManager pm,String correo)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaEmpresa() + "WHERE correo_cliente = ?");
		q.setParameters(correo);
		return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una EMPRESA de la base de datos de SuperAndes, por su nit.
	 * @param pm - El manejador de persistencia
	 * @param nit - El nit único de la empresa.
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarEmpresaPorNit(PersistenceManager pm,int nit)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaEmpresa() + "WHERE nit = ?");
		q.setParameters(nit);
		return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA EMPRESA de la 
	 * base de datos de SuperAndes, por su correo.
	 * @param pm - El manejador de persistencia
	 * @param correo - El correo único de la empresa.
	 * @return El objeto EMPRESA que tiene el correo dado.
	 */
	public Empresa darEmpresaPorCorreo (PersistenceManager pm, String correo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEmpresa() + " WHERE correo_cliente = ?");
		q.setResultClass(Empresa.class);
		q.setParameters(correo);
		return (Empresa) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA EMPRESA de la 
	 * base de datos de SuperAndes, por su nit.
	 * @param pm - El manejador de persistencia
	 * @param correo - El correo único de la empresa.
	 * @return El objeto EMPRESA que tiene el identificador dado.
	 */
	public Empresa darEmpresaPorNit (PersistenceManager pm, int nit) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEmpresa () + " WHERE nit = ?");
		q.setResultClass(Empresa.class);
		q.setParameters(nit);
		return (Empresa) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS EMPRESAS de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos EMPRESA.
	 */
	public List<Empresa> darEmpresas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaEmpresa ());
		q.setResultClass(Empresa.class);
		return (List<Empresa>) q.executeList();
	}

}
