package uniandes.isis2304.superAndes.negocio;

import java.util.Date;

/**
 * Clase para modelar el concepto PROMOCION del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Promocion {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador ÚNICO de la promoción.
	 */
	private long idPromocion;

	/**
	 * El nit del proveedor del producto del cual es la promoción.
	 */
	private int nitProveedor;

	/**
	 * El tipo de promoción.
	 */
	private String tipoPromocion;

	/**
	 * El nombre de la promoción.
	 */
	private String nombrePromocion;
	
	/**
	 * La cantidad de productos que abarca la promoción.
	 */
	private int cantidadProductos;

	/**
	 * La fecha de inicio de la promoción.
	 */
	private Date fechaInicial;

	/**
	 * La fecha de fin de la promoción.
	 */
	private Date fechaFinal;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */
	public Promocion()
	{
		this.setIdPromocion(0);
		this.setNitProveedor(0);
		this.setTipoPromocion("");
		this.setNombrePromocion("");
		this.setFechaInicial(new Date());
		this.setFechaFinal(new Date());
	}

	/**
	 * Constructor con valores.
	 * @param idPromocion - El identificador de la promoción.
	 * @param nitProveedor - El nit del proveedor del producto del cual es la promoción.
	 * @param tipoPromocion - El tipo de promoción.
	 * @param nombrePromocion - El nombre de la promoción.
	 * @param fechaInicial - La fecha de inicio de la promoción.
	 * @param fechaFinal - La fecha de fin de la promoción.
	 */
	public Promocion(long idPromocion, int nitProveedor, String tipoPromocion, String nombrePromocion, Date fechaInicial, Date fechaFinal)
	{
		this.setIdPromocion(idPromocion);
		this.setNitProveedor(nitProveedor);
		this.setTipoPromocion(tipoPromocion);
		this.setNombrePromocion(nombrePromocion);
		this.setFechaInicial(fechaInicial);
		this.setFechaFinal(fechaFinal);
	}

	/**
	 * Retorna el identificador de la promoción.
	 * 
	 * @return El identificador de la promoción.
	 */
	public long getIdPromocion() {
		return idPromocion;
	}

	/**
	 * Asigna el identificador de la promoción.
	 * 
	 * @param idPromocion - El identificador de la promoción.
	 */
	public void setIdPromocion(long idPromocion) {
		this.idPromocion = idPromocion;
	}

	/**
	 * Retorna el nit del proveedor del producto del cual es la promoción.
	 * 
	 * @return El nit del proveedor del producto del cual es la promoción.
	 */
	public int getNitProveedor() {
		return nitProveedor;
	}

	/**
	 * Asigna el nit del proveedor del producto del cual es la promoción.
	 * 
	 * @param nitProveedor - El nit del proveedor del producto del cual es la promoción.
	 */
	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	/**
	 * Retorna el tipo de la promoción.
	 * 
	 * @return El tipo de la promoción.
	 */
	public String getTipoPromocion() {
		return tipoPromocion;
	}

	/**
	 * Asigna el tipo de la promoción.
	 * 
	 * @param tipoPromocion - El tipo de la promoción.
	 */
	public void setTipoPromocion(String tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}

	/**
	 * Retorna el nombre de la promoción.
	 * 
	 * @return El nombre de la promoción.
	 */
	public String getNombrePromocion() {
		return nombrePromocion;
	}

	/**
	 * Asigna el nombre de la promoción.
	 * 
	 * @param nombrePromocion - El nombre de la promoción.
	 */
	public void setNombrePromocion(String nombrePromocion) {
		this.nombrePromocion = nombrePromocion;
	}

	/**
	 * Retorna la fecha de inicio de la promoción.
	 * 
	 * @return La fecha de inicio de la promoción.
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * Asigna la fecha de inicio de la promoción.
	 * 
	 * @param fechaInicial - La fecha de inicio de la promoción.
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * Retorna la fecha de fin de la promoción.
	 * 
	 * @return La fecha de fin de la promoción.
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * Asigna la fecha de fin de la promoción.
	 * 
	 * @param fechaFinal - La fecha de fin de la promoción.
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * Retorna la cantidad de productos que abarca la promoción.
	 * 
	 * @return La cantidad de productos que abarca la promoción.
	 */
	public int getCantidadProductos() {
		return cantidadProductos;
	}
	
	/**
	 * Asigna la cantidad de productos que abarca la promoción.
	 * 
	 * @param cantidadProductos - La cantidad de productos que abarca la promoción.
	 */
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}





}
