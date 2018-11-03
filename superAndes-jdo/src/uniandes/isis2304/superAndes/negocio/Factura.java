package uniandes.isis2304.superAndes.negocio;

import java.util.Date;

/**
 * Clase para modelar el concepto FACTURA del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Factura {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador ÚNICO de la factura.
	 */
	private long numeroFactura;

	/**
	 * La fecha de radicación de la factura, cuando la compra fue hecha.
	 */
	private Date fechaCompra;

	/**
	 * El valor base de la factura.
	 */
	private double valorBase;

	/**
	 * El descuento opcional de la factura.
	 */
	private double descuento;

	/**
	 * El impuesto obligatorio iva de la factura.
	 */
	private double iva;

	/**
	 * El valor total de la factura.
	 */
	private double valorTotal;

	/**
	 * El correo del cliente dueño de la factura.
	 */
	private String correoCliente;

	/**
	 * El nombre de la sucursal a la cual pertenece la factura.
	 */
	private String nombreSucursal;

	/**
	 * La dirección de la sucursal a la cual pertenece la factura.
	 */
	private String direccionSucursal;

	/**
	 * La ciudad de la sucursal a la cual pertenece la factura.
	 */
	private String ciudadSucursal;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */	
	public Factura()
	{
		this.setNumeroFactura(0);
		this.setFechaCompra(new Date());
		this.setValorBase(0.0);
		this.setDescuento(0.0);
		this.setIva(0.0);
		this.setValorTotal(0.0);
		this.setCorreoCliente("");
		this.setNombreSucursal("");
		this.setDireccionSucursal("");
		this.setCiudadSucursal("");
	}

	/**
	 * Constructor con valores.
	 * @param numeroFactura - El número único de la factura.
	 * @param fechaCompra - La fecha en que se realizó la compra.
	 * @param valorBase - El valor base de la factura.
	 * @param iva - El iva de la factura.
	 * @param valorTotal - El valor total de la factura.
	 * @param correoCliente - El correo único del cliente dueño de la factura.
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece la factura.
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece la factura.
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece la factura.
	 */
	public Factura(long numeroFactura, Date fechaCompra, double valorBase, double descuento, double iva, double valorTotal, String correoCliente, String nombreSucursal, String direccionSucursal, String ciudadSucursal) 
	{
		this.setNumeroFactura(numeroFactura);
		this.setFechaCompra(fechaCompra);
		this.setValorBase(valorBase);
		this.setDescuento(descuento);
		this.setIva(iva);
		this.setValorTotal(valorTotal);
		this.setCorreoCliente(correoCliente);
		this.setNombreSucursal(nombreSucursal);
		this.setDireccionSucursal(direccionSucursal);
		this.setCiudadSucursal(ciudadSucursal);
	}

	/**
	 * Retorna el número de factura.
	 * 
	 * @return El número de factura.
	 */
	public long getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * Asigna el número de factura.
	 * 
	 * @param numeroFactura - El número de factura.
	 */
	public void setNumeroFactura(long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	/**
	 * Retorna la fecha en que se realizó la compra y se creó la factura.
	 * 
	 * @return La fecha en que se realizó la compra y se creó la factura.
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * Asigna la fecha en que se realizó la compra y se creó la factura.
	 * 
	 * @param fechaCompra - La fecha en que se realizó la compra y se creó la factura.
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * Retorna el valor base de la factura.
	 * 
	 * @return El valor base de la factura.
	 */
	public double getValorBase() {
		return valorBase;
	}

	/**
	 * Asigna el valor base de la factura.
	 * 
	 * @param valorBase - El valor base de la factura.
	 */
	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}
	
	/**
	 * Retorna el descuento de la factura.
	 * 
	 * @return El descuento de la factura.
	 */
	public double getDescuento() {
		return descuento;
	}

	/**
	 * Asigna el descuento de la factura.
	 * 
	 * @param descuento - El descuento de la factura.
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	/**
	 * Retorna el iva de la factura.
	 * 
	 * @return El iva de la factura.
	 */
	public double getIva() {
		return iva;
	}

	/**
	 * Asigna el iva de la factura.
	 * 
	 * @param iva - El iva de la factura.
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * Retorna el valor total de la factura.
	 * 
	 * @return El valor total de la factura.
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * Asigna el valor total de la factura.
	 * 
	 * @param valorTotal - El valor total de la factura.
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * Retorna el correo del cliente de la factura.
	 * 
	 * @return El correo del cliente de la factura.
	 */
	public String getCorreoCliente() {
		return correoCliente;
	}

	/**
	 * Asigna el correo del cliente de la factura.
	 * 
	 * @param correoCliente - El correo del cliente de la factura.
	 */
	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	/**
	 * Retorna el nombre de la sucursal a la cual pertenece la factura.
	 * 
	 * @return El nombre de la sucursal a la cual pertenece la factura.
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Asigna el nombre de la sucursal a la cual pertenece la factura.
	 * 
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece la factura.
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Retorna la dirección de la sucursal a la cual pertenece la factura.
	 * 
	 * @return La dirección de la sucursal a la cual pertenece la factura.
	 */
	public String getDireccionSucursal() {
		return direccionSucursal;
	}
	
	/**
	 * Asigna la dirección de la sucursal a la cual pertenece la factura.
	 * 
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece la factura.
	 */
	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}

	/**
	 * Retorna la ciudad de la sucursal a la cual pertenece la factura.
	 * 
	 * @return La ciudad de la sucursal a la cual pertenece la factura.
	 */
	public String getCiudadSucursal() {
		return ciudadSucursal;
	}

	/**
	 * Asigna la ciudad de la sucursal a la cual pertenece la factura.
	 * 
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece la factura.
	 */
	public void setCiudadSucursal(String ciudadSucursal) {
		this.ciudadSucursal = ciudadSucursal;
	}


}
