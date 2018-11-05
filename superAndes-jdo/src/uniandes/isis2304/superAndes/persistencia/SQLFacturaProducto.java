package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Producto;
import uniandes.isis2304.superAndes.negocio.Factura;


public class SQLFacturaProducto {
	
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
	public SQLFacturaProducto (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public Long adicionarFacturaProducto(PersistenceManager pm,Long numeroFactura, String codigoBarras,int cantidad )
	{
		 Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaFacturasProducto() + "(numeroFactura,codigoBarras,cantidad) values (?, ?,?)");
	     q.setParameters(numeroFactura,codigoBarras,cantidad);
	     return (long) q.executeUnique();
	}
	
	

}
