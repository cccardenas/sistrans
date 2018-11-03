package uniandes.isis2304.superAndes.negocio;
/**
 * Clase para modelar el concepto FACTURA del negocio de SuperAndes.
 *
 * @author Juan Esteban Cantor
 */
public class FacturaProducto {
	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * Numero de la factura.
	 */
	
	private int numeroFactura;
	
	/**
	 * Identificador unico de un producto.
	 */
	
	String codigoDeBarrasProducto;
	
	/**
	 * Cantidad x de un producto en una factura.
	 */
	
	int cantidad;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */	
	
	public FacturaProducto()
	{
		numeroFactura = 0;
		codigoDeBarrasProducto = "";
		cantidad = 0;
	}
	
	/**
	 * Constructor con valores.
	 * @param numeroFactura - El número único de la factura.
	 * @param codigoDeBarrasProducto - Identificador unico de prodcuto.
	 * @param cantidad - Cantidad de un producto en una factura.
	 */
	
	public FacturaProducto(int numeroFactura, String codigoDeBarrasProducto, int cantidad)
	{
		this.numeroFactura = numeroFactura;
		this.codigoDeBarrasProducto = codigoDeBarrasProducto;
		this.cantidad = cantidad;
	}
	/**
	 * Retorna el número de factura.
	 * 
	 * @return El número de factura.
	 */

	public int getNumeroFactura() {
		return numeroFactura;
	}
	
	/**
	 * Asigna el número de factura.
	 * 
	 * @param numeroFactura - El número de factura.
	 */

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	/**
	 * Retorna el codigo de barras del producto
	 * 
	 * @return El codigo de barras del producto.
	 */

	public String getCodigoDeBarrasProducto() {
		return codigoDeBarrasProducto;
	}
	
	/**
	 * Asigna el codigo de barras del producto.
	 * 
	 * @param numeroFactura - Codigo de barras del producto.
	 */

	public void setCodigoDeBarrasProducto(String codigoDeBarrasProducto) {
		this.codigoDeBarrasProducto = codigoDeBarrasProducto;
	}
	
	/**
	 * Retorna la cantidad del producto.
	 * 
	 * @return Cantidad del producto.
	 */

	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Asigna la cantidad de productos en una factura.
	 * 
	 * @param numeroFactura - Cantidad de productos en una factura.
	 */

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
