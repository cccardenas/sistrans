package uniandes.isis2304.superAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superAndes.negocio.Producto;
import uniandes.isis2304.superAndes.negocio.Proveedor;

public class SQLProducto {
	
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
	public SQLProducto (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * -----------Requerimiento funcional 2------------
	 * Crea y ejecuta la sentencia SQL para adicionar un PRODUCTO a la base de datos de SuperAndes
	 * @param pm - - El manejador de persistencia.
	 * @param codigoDeBarras - El código de barras único del producto.
	 * @param nombre - El nombre único del producto.
	 * @param marca - La marca del producto.
	 * @param precioUnitario - El precio por unidad del producto.
	 * @param volumenEmpaquetado - El volumen del empaquetado en cm3 o ml.
	 * @param peso - El peso del producto en gr.
	 * @param precioUnidadMedida - El precio por unidad de medida del producto.
	 * @param cantidadPresentacion - La cantidad de porciones o servicios del producto por presentación.
	 * @param unidadDeMedida - La unidad de medida del producto, puede ser 'cm3' o 'ml'.
	 * @param precio - El precio del producto.
	 * @param categoria - La categoría a la que pertenece el producto. 
	 * @param nivelDeReorden - El nivel de reorden del producto.
	 * @param numeroFactura - El número de factura asociado al producto.
	 * @param idAlmacenamiento - El identificador del almacenamiento al cual pertenece el producto.
	 * @param nitProveedor - El nit del proveedor del producto.
	 * @return El número de tuplas insertadas
	 */
	public long adicionarProducto (PersistenceManager pm, String codigoDeBarras,long idPromocion, String nombre, String marca, double precioUnitario, double volumenEmpaquetado, double peso,String categoria, double nivelReorden,long idFactura,long idAlmacenamiento, long nitProveedor,double precioUnidadMedida,int cantidad,String unidadMedida) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + psa.darTablaProducto() + "(CODIGO_DE_BARRAS, ID_PROMOCION, MARCA, PRECIO_UNITARIO, VOLUMEN_EMPAQUETADO, PESO, PRECIO_UNIDAD_MEDIDA, CANTIDAD_PRESENTACION, UNIDAD_DE_MEDIDA, PRECIO, CATEGORIA, NIVEL_DE_REORDEN, NUMERO_FACTURA, ID_ALMACENAMIENTO, NIT_PROVEEDOR) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(codigoDeBarras, nombre, marca, precioUnitario, volumenEmpaquetado, peso, precioUnidadMedida, cantidad, unidadMedida, precioUnitario, categoria, nivelReorden, idFactura, idAlmacenamiento, nitProveedor);
        return (long) q.executeUnique();
                                                                                                                                                            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar un PRODUCTO de la base de datos de SuperAndes, por su código de barras
	 * @param pm - El manejador de persistencia
	 * @param codigoDeBarras - El código de barras único del producto.
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarProductoPorCodigoDeBarras (PersistenceManager pm, String codigoDeBarras)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaProducto () + " WHERE codigo_de_barras = ?");
        q.setParameters(codigoDeBarras);
        return (long) q.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN PRODUCTO de la base de datos de SuperAndes, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre único del producto.
	 * @return El número de tuplas eliminadas.
	 */
	public long eliminarProductoPorNombre (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaProducto () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PRODUCTO de la 
	 * base de datos de SuperAndes, por su código de barras.
	 * @param pm - El manejador de persistencia
	 * @param codigoDeBarras - El código de barras único del producto.
	 * @return El objeto PRODUCTO que tiene el identificador dado.
	 */
	public Producto darProductoPorCodigoDeBarras (PersistenceManager pm, String codigoDeBarras) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaProducto ()  + " WHERE codigo_de_barras = ?");
		q.setResultClass(Producto.class);
		q.setParameters(codigoDeBarras);
		return (Producto) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PRODUCTO de la 
	 * base de datos de SuperAndes, por su nombre.
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre único del producto.
	 * @return El objeto PRODUCTO que tiene el identificador dado.
	 */
	public Producto darProductoPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaProducto ()  + " WHERE nombre = ?");
		q.setResultClass(Producto.class);
		q.setParameters(nombre);
		return (Producto) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PRODUCTOS de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos PRODUCTO
	 */
	public List<Producto> darProductos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + psa.darTablaProducto());
		q.setResultClass(Producto.class);
		return (List<Producto>) q.executeList();
	}


}
