package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.Empresa;
import uniandes.isis2304.superAndes.negocio.Sucursal;

public class SQLSucursal {
	
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
	public SQLSucursal (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	/**
	 * -----------Requerimiento funcional 4B------------
	 * Crea y ejecuta la sentencia SQL para adicionar una SUCURSAL a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia.
	 * @param nombre - El nombre de la sucursal.
	 * @param direccion - La dirección de la sucursal.
	 * @param ciudad - La ciudad de la sucursal.
	 * @param idLocalVentas - El local de ventas asociado a la sucursal.
	 * @return El número de tuplas insertadas.
	 */
	public long adicionarSucursal (PersistenceManager pm, String nombre, String direccion, String ciudad, int idLocalVentas) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaSucursal () + "(nombre, direccion, ciudad, id_localventas) VALUES (?, ?, ?, ?)");
        q.setParameters(nombre,direccion,ciudad,idLocalVentas);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una SUCURSAL de la base de datos de SuperAndes, por su nombre, dirección y ciudad.
	 * @param pm - El manejador de persistencia.
	 * @param nombre - El nombre de la sucursal.
	 * @param direccion - La dirección de la sucursal.
	 * @param ciudad - La ciudad de la sucursal.
	 * @return El objeto SUCURSAL que tiene el nombre, la dirección y ciudad dadas
	 */
	public Sucursal darSucursalPorNombreDireccionCiudad (PersistenceManager pm, String nombre, String direccion, String ciudad)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaSucursal () + " WHERE nombre = ? AND direccion = ? AND ciudad = ? ");
        q.setResultClass(Sucursal.class);
        q.setParameters(nombre, direccion, ciudad);
		return (Sucursal) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una SUCURSAL de la base de datos de SuperAndes, por su nombre, direccion y ciudad.
	 * @param pm - El manejador de persistencia.
	 * @param nombre - El nombre de la sucursal.
	 * @param direccion - La dirección de la sucursal.
	 * @param ciudad - La ciudad de la sucursal.
	 * @return El número de tuplas eliminadas.
	 */
	public long eliminarSucursalPorNombreDireccionCiudad (PersistenceManager pm, String nombre, String direccion, String ciudad)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaSucursal () + " WHERE nombre = ? AND direccion = ? AND ciudad = ? ");
        q.setParameters(nombre, direccion, ciudad);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS SUCURSALES de la 
	 * base de datos de SuperAndes, por su ciudad.
	 * @param pm - El manejador de persistencia
	 * @param ciudad - El ciudad de la sucursal.
	 * @return Una lista de objetos SUCURSAL que tiene la ciudad dada.
	 */
	public List<Sucursal> darSucursalesPorCiudad (PersistenceManager pm, String ciudad) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaSucursal () + " WHERE ciudad = ?");
		q.setResultClass(Sucursal.class);
		q.setParameters(ciudad);
		return (List<Sucursal>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS SUCURSALES de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos SUCURSAL
	 */
	public List<Sucursal> darSucursales (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaSucursal ());
		q.setResultClass(Sucursal.class);
		return (List<Sucursal>) q.executeList();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS SUCURSALES de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos SUCURSAL
	 */
	public String consultarFuncionamiento (PersistenceManager pm,String fechaInicio,String fechaFin) 
	{
		Query q = pm.newQuery(SQL, "WITH A AS(SELECT A_FACTURA.NUMERO_FACTURA FROM A_FACTURA WHERE FECHA_COMPRA BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'),\n" + 
				"B AS (SELECT A_FACTURA_PRODUCTO.CODIGO_DE_BARRAS,A_FACTURA_PRODUCTO.CANTIDAD FROM A_FACTURA_PRODUCTO INNER JOIN A ON A.NUMERO_FACTURA = A_FACTURA_PRODUCTO.NUMERO_FACTURA),\n" + 
				"C AS(SELECT NOMBRE, B.CANTIDAD CANTIDAD FROM A_PRODUCTO INNER JOIN B ON B.CODIGO_DE_BARRAS =A_PRODUCTO.CODIGO_DE_BARRAS),\n" + 
				"D AS(SELECT C.NOMBRE,C.CANTIDAD FROM C  ORDER BY C.CANTIDAD DESC)\n" + 
				"SELECT D.NOMBRE,D.CANTIDAD FROM D WHERE ROWNUM= 1;\n" + 
				" ");
		
		 return (String) q.executeUnique();
	}
	
	public List<Cliente> consultarBuenosClientes (PersistenceManager pm,String fechaInicio,String fechaFin) 
	{
		Query q = pm.newQuery(SQL, "WITH A AS(SELECT NUMERO_FACTURA,CORREO_CLIENTE FROM A_FACTURA WHERE FECHA_COMPRA BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'), \n" + 
				"B AS(SELECT CODIGO_DE_BARRAS FROM A_PRODUCTO WHERE PRECIO >=100000 AND CATEGORIA= 'TECNOLOGIA' AND CATEGORIA= 'HERRAMIENTAS'),\n" + 
				"C AS (SELECT NUMERO_FACTURA FROM A_FACTURA_PRODUCTO INNER JOIN B ON B.CODIGO_DE_BARRAS=A_FACTURA_PRODUCTO.CODIGO_DE_BARRAS), \n" + 
				"D AS(SELECT CORREO_CLIENTE FROM A INNER JOIN C ON A.NUMERO_FACTURA= C.NUMERO_FACTURA),\n" + 
				"E AS(SELECT TIPO_DOCUMENTO,NUMERO_IDENTIFICACION,CORREO_CLIENTE  FROM A_PERSONANATURAL ),\n" + 
				"F AS(SELECT E.TIPO_DOCUMENTO,E.NUMERO_IDENTIFICACION,E.CORREO_CLIENTE FROM E INNER JOIN D ON E.CORREO_CLIENTE=D.CORREO_CLIENTE)\n"+"SELECT *  FROM F"+";");
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}

}
