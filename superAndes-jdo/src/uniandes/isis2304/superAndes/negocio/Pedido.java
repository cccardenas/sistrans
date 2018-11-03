package uniandes.isis2304.superAndes.negocio;

import java.util.Date;

/**
 *  Clase para modelar el concepto PEDIDO del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */

public class Pedido {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador ÚNICO del pedido.
	 */

	private long numeroPedido;

	/**
	 * El nit de la empresa a la que se le realizó el pedido.
	 */

	private int  nitProveedor;

	/**
	 * El nombre de la sucursal que hizo el pedido.
	 */

	private String nombreSucursal;

	/**
	 * La dirección de la sucursal que hizo el pedido.
	 */

	private String direccionSucursal;

	/**
	 * La ciudad de la sucursal que hizo el pedido.
	 */

	private String ciudadSucursal;

	/**
	 * El c�digo de barras del producto pedido.
	 */

	private String codigoDeBarrasProducto;


	/**
	 * La fecha esperada en la que se entregue el pedido.
	 */

	private Date fechaEsperada;

	/**
	 * La fecha en la que se entregó el pedido.
	 */

	private Date fechaEntrega;

	/**
	 * La valoración de calidad del pedido.
	 */

	private String calidad;

	/**
	 * La calificación cuantificable del pedido.
	 */

	private int calificacion;

	/**
	 * El precio total del pedido.
	 */

	private double  precio;

	/**
	 * La cantidad en cm3 solicitada en el pedido del producto.
	 */

	private double  cantidadVolumen;


	/* ****************************************************************
	 * 			M�todos 
	 *****************************************************************/

	/**
	 * Constructor sin par�metros por defecto
	 */
	public Pedido()
	{
		this.setNumeroPedido(0);
		this.setNitProveedor(0);
		this.setNombreSucursal("");
		this.setDireccionSucursal("");
		this.setCiudadSucursal("");
		this.setCodigoDeBarrasProducto("");
		this.setFechaEsperada(new Date());
		this.setFechaEntrega(new Date());
		this.setCalidad("");
		this.setCalificacion(0);
		this.setPrecio(0.0);
		this.setCantidadVolumen(0.0);
	}
	/**
	 * Constructor con valores.
	 * @param numeroPedido - El número del pedido.
	 * @param nitProveedor - El nit de la empresa a la que se le realizó el pedido.
	 * @param nombreSucursal - El nombre de la sucursal que hizo el pedido.
	 * @param direccionSucursal - La dirección de la sucursal que hizo el pedido.
	 * @param ciudadSucursal - La ciudad de la sucursal que hizo el pedido.
	 * @param codigoDeBarrasProducto -El código de barras del producto pedido.
	 * @param fechaEsperada - La fecha esperada en la que se entregue el pedido.
	 * @param fechaEntrega - La fecha en la que se entregó el pedido.
	 * @param calidad - La valoración de calidad del pedido.
	 * @param calificacion - La calificación cuantificable del pedido.
	 * @param precio - El precio total del pedido.
	 * @param cantidadVolumen - La cantidad en cm3 solicitada en el pedido del producto.
	 */
	public Pedido(int numeroPedido, int nitProveedor, String nombreSucursal, String direccionSucursal, String ciudadSucursal, String codigoDeBarrasProducto, Date fechaEsperada, Date fechaEntrega, String calidad, int calificacion, double precio, double cantidadVolumen)
	{
		this.setNumeroPedido(numeroPedido);
		this.setNitProveedor(nitProveedor);
		this.setNombreSucursal(nombreSucursal);
		this.setDireccionSucursal(direccionSucursal);
		this.setCiudadSucursal(ciudadSucursal);
		this.setCodigoDeBarrasProducto(codigoDeBarrasProducto);
		this.setFechaEsperada(fechaEsperada);
		this.setFechaEntrega(fechaEntrega);
		this.setCalidad(calidad);
		this.setCalificacion(calificacion);
		this.setPrecio(precio);
		this.setCantidadVolumen(cantidadVolumen);
	}

	/**
	 * Retorna el número único de pedido.
	 * 
	 * @return El número único de pedido.
	 */
	public long getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * Asigna el número único de pedido.
	 * 
	 * @param numeroPedido - El número único de pedido.
	 */
	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	/**
	 * Retorna el nit del proveedor del pedido.
	 * 
	 * @return El nit del proveedor del pedido.
	 */
	public int getNitProveedor() {
		return nitProveedor;
	}

	/**
	 * Asigna el nit del proveedor del pedido.
	 * 
	 * @param nitProveedor - El nit del proveedor del pedido.
	 */
	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	/**
	 * Retorna el nombre de la sucursal que hizo el pedido.
	 * 
	 * @return El nombre de la sucursal que hizo el pedido.
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Asigna el nombre de la sucursal que hizo el pedido.
	 * 
	 * @param nombreSucursal - El nombre de la sucursal que hizo el pedido.
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Retorna la dirección de la sucursal que hizo el pedido.
	 * 
	 * @return La dirección de la sucursal que hizo el pedido.
	 */
	public String getDireccionSucursal() {
		return direccionSucursal;
	}

	/**
	 * Asigna la dirección�n de la sucursal que hizo el pedido.
	 * 
	 * @param direccionSucursal - La dirección de la sucursal que hizo el pedido.
	 */
	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}

	/**
	 * Retorna la ciudad de la sucursal que hizo el pedido.
	 * 
	 * @return La ciudad de la sucursal que hizo el pedido.
	 */
	public String getCiudadSucursal() {
		return ciudadSucursal;
	}

	/**
	 * Asigna la ciudad de la sucursal que hizo el pedido.
	 * 
	 * @param ciudadSucursal - La ciudad de la sucursal que hizo el pedido.
	 */
	public void setCiudadSucursal(String ciudadSucursal) {
		this.ciudadSucursal = ciudadSucursal;
	}

	/**
	 * Retorna el código de barras del producto pedido.
	 * 
	 * @return El código de barras del producto pedido.
	 */
	public String getCodigoDeBarrasProducto() {
		return codigoDeBarrasProducto;
	}

	/**
	 * Asigna el código de barras del producto pedido.
	 * 
	 * @param codigoDeBarrasProducto - El código de barras del producto pedido.
	 */
	public void setCodigoDeBarrasProducto(String codigoDeBarrasProducto) {
		this.codigoDeBarrasProducto = codigoDeBarrasProducto;
	}

	/**
	 * Retorna la fecha esperada en la que se entregue el pedido.
	 * 
	 * @return La fecha esperada en la que se entregue el pedido.
	 */
	public Date getFechaEsperada() {
		return fechaEsperada;
	}

	/**
	 * Asigna la fecha esperada en la que se entregue el pedido.
	 * 
	 * @param fechaEsperada - La fecha esperada en la que se entregue el pedido.
	 */
	public void setFechaEsperada(Date fechaEsperada) {
		this.fechaEsperada = fechaEsperada;
	}
	/**
	 * Retorna la fecha en la que se entregó el pedido.
	 * 
	 * @return La fecha en la que se entregó el pedido.
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * Asigna la fecha en la que se entregó el pedido.
	 * 
	 * @param fechaEntrega - La fecha en la que se entregó el pedido.
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * Retorna la valoración de calidad del pedido.
	 * 
	 * @return La valoración de calidad del pedido.
	 */
	public String getCalidad() {
		return calidad;
	}

	/**
	 * Asigna la valoración de calidad del pedido.
	 * 
	 * @param calidad - La valoración de calidad del pedido.
	 */
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	/**
	 * Retorna la calificación cuantificable del pedido.
	 * 
	 * @return La calificación cuantificable del pedido.
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * Asigna la calificación cuantificable del pedido.
	 * 
	 * @param calificacion - La calificación cuantificable del pedido.
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * Retorna el precio total del pedido.
	 * 
	 * @return El precio total del pedido.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Asigna el precio total del pedido.
	 * 
	 * @param precio - El precio total del pedido.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Retorna la cantidad en cm3 solicitada en el pedido del producto.
	 * 
	 * @return La cantidad en cm3 solicitada en el pedido del producto.
	 */
	public double getCantidadVolumen() {
		return cantidadVolumen;
	}	

	/**
	 * Asigna la cantidad en cm3 solicitada en el pedido del producto.
	 * 
	 * @param cantidadVolumen - La cantidad en cm3 solicitada en el pedido del producto.
	 */
	public void setCantidadVolumen(double cantidadVolumen) {
		this.cantidadVolumen = cantidadVolumen;
	}

}
