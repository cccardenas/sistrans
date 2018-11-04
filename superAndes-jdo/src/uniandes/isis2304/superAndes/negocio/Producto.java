package uniandes.isis2304.superAndes.negocio;

/**
 *  Clase para modelar el concepto PRODUCTO del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */

public class Producto {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El código de barras ÚNICO del producto.
	 */
	private String codigoDeBarras;

	/**
	 * El identificador de la promoción del producto.
	 */
	private long idPromocion;

	/**
	 * El nombre del producto.
	 */
	private String nombre;

	/**
	 * La marca asociada al producto.
	 */
	private String marca;

	/**
	 * El precio por unidad del producto.
	 */
	private double precioUnitario;

	/**
	 * El volumen del producto empaquetado en cm3 o ml.
	 */
	private double volumenEmpaquetado;

	/**
	 * El peso en gr del producto.
	 */
	private double peso;

	/**
	 * El precio por unidad de medida del producto.
	 */
	private double precioPorUnidadMedida;

	/**
	 * La cantidad de porciones o servicios del producto.
	 */
	private int cantidadPresentacion;

	/**
	 * La unidad de medida del producto que puede ser cm3 o ml. 
	 */
	private String unidadMedida;

	/**
	 * El precio del producto.
	 */
	private double precio;

	/**
	 * La categoría a la que pertenece el producto.
	 */
	private String categoria;

	/**
	 * El nivel de reorden mínimo entre estantes y bodegas para el producto.
	 */
	private double nivelDeReorden;

	/**
	 * El número de factura a la cual pertenece el producto.
	 */
	private long numeroFactura;

	/**
	 * El identificador del almacenamiento a donde pertenece el producto en una sucursal.
	 */
	private long idAlmacenamiento;

	/**
	 * El nit del proveedor del producto.
	 */
	private long nitProveedor;


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor sin parámetros por defecto
	 */
	public Producto()
	{
		this.setCodigoDeBarras("");
		this.setIdPromocion(0);
		this.setNombre("");
		this.setMarca("");
		this.setPrecioUnitario(0.0);
		this.setVolumenEmpaquetado(0.0);
		this.setPeso(0.0);
		this.setPrecioPorUnidadMedida(0.0);
		this.setCantidadPresentacion(0);
		this.setUnidadMedida("");
		this.setPrecio(0.0);
		this.setCategoria("");
		this.setNivelDeReorden(0.0);
		this.setNumeroFactura(0);
		this.setIdAlmacenamiento(0);
		this.setNitProveedor(0);

	}

	/**
	 * Constructor con valores.
	 * @param codigoDeBarras - El código de barras del producto.
	 * @param idPromocion - El identificador de la promoción del producto.
	 * @param nombre - El nombre del producto.
	 * @param marca - La marca asociada al producto.
	 * @param precioUnitario - El precio por unidad del producto.
	 * @param volumenEmpaquetado - El volumen del producto empaquetado en cm3 o ml.
	 * @param peso - El peso en gr del producto.
	 * @param precioPorUnidadMedida - El precio por unidad de medida del producto.
	 * @param cantidadPresentacion - La cantidad de porciones o servicios del producto.
	 * @param unidadMedida - La unidad de medida del producto que puede ser cm3 o ml. 
	 * @param precio - El precio del producto.
	 * @param categoria - La categoría a la que pertenece el producto.
	 * @param nivelDeReorden - El nivel de reorden mínimo entre estantes y bodegas para el producto.
	 * @param numeroFactura - El número de factura a la cual pertenece el producto.
	 * @param idAlmacenamiento - El identificador del almacenamiento a donde pertenece el producto en una sucursal.
	 * @param nitProveedor - El nit del proveedor del producto.
	 */
	public Producto(String codigoDeBarras, long idPromocion, String nombre, String marca, double precioUnitario, double volumenEmpaquetado, double peso, double precioPorUnidadMedida, int cantidadPresentacion, String unidadMedida, double precio, String categoria, double nivelDeReorden, long numeroFactura, long idAlmacenamiento, long nitProveedor) 
	{
		this.setCodigoDeBarras(codigoDeBarras);
		this.setIdPromocion(idPromocion);
		this.setNombre(nombre);
		this.setMarca(marca);
		this.setPrecioUnitario(precioUnitario);
		this.setVolumenEmpaquetado(volumenEmpaquetado);
		this.setPeso(peso);
		this.setPrecioPorUnidadMedida(precioPorUnidadMedida);
		this.setCantidadPresentacion(cantidadPresentacion);
		this.setUnidadMedida(unidadMedida);
		this.setPrecio(precio);
		this.setCategoria(categoria);
		this.setNivelDeReorden(nivelDeReorden);
		this.setNumeroFactura(numeroFactura);
		this.setIdAlmacenamiento(idAlmacenamiento);
		this.setNitProveedor(nitProveedor);
	}

	/**
	 * Retorna el código de barras del producto.
	 * 
	 * @return El código de barras del producto.
	 */
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	/**
	 * Asigna el código de barras del producto.
	 * 
	 * @param codigoDeBarras - El código de barras del producto.
	 */
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	/**
	 * Retorna el identificador de la promoción del producto.
	 * 
	 * @return El identificador de la promoción del producto.
	 */
	public long getIdPromocion() {
		return idPromocion;
	}

	/**
	 * Asigna el identificador de la promoción del producto.
	 * 
	 * @param idPromocion - El identificador de la promoción del producto.
	 */
	public void setIdPromocion(long idPromocion) {
		this.idPromocion = idPromocion;
	}

	/**
	 * Retorna el nombre del producto.
	 * 
	 * @return El nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el nombre del producto.
	 * 
	 * @param nombre - El nombre del producto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna la marca del producto.
	 * 
	 * @return La marca del producto.
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Asigna la marca del producto.
	 * 
	 * @param marca - La marca del producto.
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Retorna el precio por unidad del producto.
	 * 
	 * @return El precio por unidad del producto.
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * Asigna el precio por unidad del producto.
	 * 
	 * @param precioUnitario - El precio por unidad del producto.
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * Retorna el volumen del producto empaquetado en cm3 o ml.
	 * 
	 * @return El volumen del producto empaquetado en cm3 o ml.
	 */
	public double getVolumenEmpaquetado() {
		return volumenEmpaquetado;
	}

	/**
	 * Asigna el volumen del producto empaquetado en cm3 o ml.
	 * 
	 * @param volumenEmpaquetado - El volumen del producto empaquetado en cm3 o ml.
	 */
	public void setVolumenEmpaquetado(double volumenEmpaquetado) {
		this.volumenEmpaquetado = volumenEmpaquetado;
	}

	/**
	 * Retorna el peso en gr del producto.
	 * 
	 * @return El peso en gr del producto.
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Asigna el peso en gr del producto.
	 * 
	 * @param peso - El peso en gr del producto.
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Retorna el precio por unidad de medida del producto.
	 * 
	 * @return El precio por unidad de medida del producto.
	 */
	public double getPrecioPorUnidadMedida() {
		return precioPorUnidadMedida;
	}

	/**
	 * Asigna el precio por unidad de medida del producto.
	 * 
	 * @param precioPorUnidadMedida - El precio por unidad de medida del producto.
	 */
	public void setPrecioPorUnidadMedida(double precioPorUnidadMedida) {
		this.precioPorUnidadMedida = precioPorUnidadMedida;
	}

	/**
	 * Retorna la cantidad de porciones o servicios del producto.
	 * 
	 * @return La cantidad de porciones o servicios del producto.
	 */
	public int getCantidadPresentacion() {
		return cantidadPresentacion;
	}

	/**
	 * Asigna la cantidad de porciones o servicios del producto.
	 * 
	 * @param cantidadPresentacion - La cantidad de porciones o servicios del producto.
	 */
	public void setCantidadPresentacion(int cantidadPresentacion) {
		this.cantidadPresentacion = cantidadPresentacion;
	}

	/**
	 * Retorna la unidad de medida del producto que puede ser cm3 o ml.
	 * 
	 * @return La unidad de medida del producto que puede ser cm3 o ml.
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * Asigna la unidad de medida del producto que puede ser cm3 o ml.
	 * 
	 * @param unidadMedida - La unidad de medida del producto que puede ser cm3 o ml.
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/**
	 * Retorna el precio del producto.
	 * 
	 * @return El precio del producto.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Asigna el precio del producto.
	 * 
	 * @param precio - El precio del producto.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Retorna la categoría a la que pertenece el producto.
	 * 
	 * @return La categoría a la que pertenece el producto.
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Asigna la categoría a la que pertenece el producto.
	 * 
	 * @param categoria - La categoría a la que pertenece el producto.
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Retorna el nivel de reorden mínimo entre estantes y bodegas para el producto.
	 * 
	 * @return El nivel de reorden mínimo entre estantes y bodegas para el producto.
	 */
	public double getNivelDeReorden() {
		return nivelDeReorden;
	}

	/**
	 * Asigna el nivel de reorden mínimo entre estantes y bodegas para el producto.
	 * 
	 * @param nivelDeReorden - El nivel de reorden mínimo entre estantes y bodegas para el producto.
	 */
	public void setNivelDeReorden(double nivelDeReorden) {
		this.nivelDeReorden = nivelDeReorden;
	}

	/**
	 * Retorna el número de factura a la cual pertenece el producto.
	 * 
	 * @return El número de factura a la cual pertenece el producto.
	 */
	public long getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * Asigna el número de factura a la cual pertenece el producto.
	 * 
	 * @param numeroFactura - El número de factura a la cual pertenece el producto.
	 */
	public void setNumeroFactura(long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	/**
	 * Retorna el identificador del almacenamiento a donde pertenece el producto en una sucursal.
	 * 
	 * @return El identificador del almacenamiento a donde pertenece el producto en una sucursal.
	 */
	public long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	/**
	 * Asigna el identificador del almacenamiento a donde pertenece el producto en una sucursal.
	 * 
	 * @param idAlmacenamiento - El identificador del almacenamiento a donde pertenece el producto en una sucursal.
	 */
	public void setIdAlmacenamiento(long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	/**
	 * Retorna el nit del proveedor del producto.
	 * 
	 * @return El nit del proveedor del producto.
	 */
	public long getNitProveedor() {
		return nitProveedor;
	}

	/**
	 * Asigna el nit del proveedor del producto.
	 * 
	 * @param nitProveedor - El nit del proveedor del producto.
	 */
	public void setNitProveedor(long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	@Override
	public String toString()
	{
		return "Producto [nombre=" + nombre + ", categoria= " + categoria + ", marca= " + marca + ", precio= " + precio +
				", precioUnitario=" + precioUnitario + ", volumenEmpaquetado=" + volumenEmpaquetado + ", peso=" + peso +
				", precioUnidadMedida=" + precioPorUnidadMedida + ", unidadMedida" + unidadMedida +"]";
	}

}
