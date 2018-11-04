package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.PersonaNatural;
import uniandes.isis2304.superAndes.negocio.Producto;

public class SQLPersonaNatural {
	
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
	public SQLPersonaNatural (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}

	/**
	 * -----------Requerimiento funcional 3B_1------------
	 * Crea y ejecuta la sentencia SQL para adicionar una PERSONA NATURAL a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param tipoDocumento - El tipo de documento de la persona natural. Puede ser 'CC','TI','TP','CE','RC'.
	 * @param numeroIdentificacion - El número de identificación de la persona natural.
	 * @param correo - El correo relacionado a la persona natural.
	 * @return El número de tuplas insertadas.
	 */
	public Long adicionarPersonaNatural(PersistenceManager pm,String tipoDocumento, long numeroIdentificacion,String correo)
	{
		 System.out.println("SQL");
		 System.out.println(tipoDocumento);
		 System.out.println(correo);
		 System.out.println(numeroIdentificacion);
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaPersonaNatural () + "(CORREO_CLIENTE, TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION) values (?, ?, ?)");
	     q.setParameters(correo, tipoDocumento, numeroIdentificacion);
	     return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una PERSONA NATURAL de la base de datos de SuperAndes, por su correo.
	 * @param pm - El manejador de persistencia
	 * @param correo - El correo único de la persona natural.
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarPersonaNaturalPorCorreo(PersistenceManager pm,String correo)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaPersonaNatural() + "WHERE correo_cliente = ?");
		q.setParameters(correo);
		return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una PERSONA NATURAL de la base de datos de SuperAndes, por su tipo de documento y número de identificación.
	 * @param pm - El manejador de persistencia
	 * @param tipoDocumento - El tipo de documento de la persona natural.
	 * @param numeroIdentificacion - El número de identificación de la persona natural.
	 * @return El número de tuplas eliminadas.
	 */
	public Long eliminarPersonaNaturalPorIdentificacion(PersistenceManager pm,String tipoDocumento, String numeroIdentificacion)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaPersonaNatural() + "WHERE tipo_documento = ? AND numero_identificacion = ?");
		q.setParameters(tipoDocumento, numeroIdentificacion);
		return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una PERSONA NATURAL de la base de datos de SuperAndes, por su nombre.
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre de la persona natural.
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarPersonaNaturalPorNombre(PersistenceManager pm,String nombre)
	{
		Query q = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaPersonaNatural() + "WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA PERSONA NATURAL de la 
	 * base de datos de SuperAndes, por su correo.
	 * @param pm - El manejador de persistencia
	 * @param correo - El correo único de la persona natural.
	 * @return El objeto PERSONA NATURAL que tiene el identificador dado.
	 */
	public PersonaNatural darPersonaNaturalPorCorreo (PersistenceManager pm, String correo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPersonaNatural () + " WHERE correo_cliente = ?");
		q.setResultClass(PersonaNatural.class);
		q.setParameters(correo);
		return (PersonaNatural) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS PERSONAS NATURALES de la 
	 * base de datos de SuperAndes, por su nombre.
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre de las personas naturales.
	 * @return Una lista de objetos PERSONA NATURAL con el nombre dado.
	 */
	public List<PersonaNatural> darPersonasNaturalesPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPersonaNatural () + " WHERE nombre = ?");
		q.setResultClass(PersonaNatural.class);
		q.setParameters(nombre);
		return (List<PersonaNatural>) q.executeList();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS PERSONAS NATURALES de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos PERSONA NATURAL.
	 */
	public List<PersonaNatural> darPersonasNaturales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaPersonaNatural ());
		q.setResultClass(PersonaNatural.class);
		return (List<PersonaNatural>) q.executeList();
	}

}
