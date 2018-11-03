package uniandes.isis2304.superAndes.negocio;

/**
 * Clase abstracta para modelar los posibles almacenamientos del negocio de SuperAndes
 *
 * @author Juan Sebastián Bravo
 */

public abstract class Almacenamiento {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del almacenamiento
	 */
	protected long idAlmacenamiento;

	/**
	 * La categoría de los productos que almacena el almacenamiento. 
	 */

	protected String categoria;
	/**
	 * La capacidad volumétrica máxima del almacenamiento en cm3. 
	 */

	protected double capacidadVolumen;

	/**
	 * La capacidad máxima de peso del almacenamiento en gr. 
	 */

	protected double capacidadPeso;

	/**
	 * La cantidad de productos que tiene el almacenamiento.
	 */

	protected int cantidadProductos;

	/**
	 * El nombre de la sucursal a la cual pertenece el almacenamiento.
	 */

	protected String nombreSucursal;

	/**
	 * La dirección de la sucursal a la cual pertenece el almacenamiento.
	 */

	protected String direccionSucursal;

	/**
	 * La ciudad de la sucursal a la cual pertenece el almacenamiento.
	 */

	protected String ciudadSucursal;


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor sin parámetros por defecto
	 */
	public Almacenamiento() 
	{
		this.setIdAlmacenamiento(0);
		this.setCantidadProductos(0);
		this.setCapacidadPeso(0.0);
		this.setCapacidadVolumen(0.0);
		this.setNombreSucursal("");
		this.setDireccionSucursal("");
		this.setCiudadSucursal("");
	}

	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id del almacenamiento.
	 * @param cantidadProductos - La cantidad de productos que posee el almacenamiento.
	 * @param capacidadPeso - El peso máximo que soporta el almacenamiento en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta el almacenamiento en cm3.
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece el almacenamiento.
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece el almacenamiento.
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece el almacenamiento.
	 */
	public Almacenamiento(long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen, String nombreSucursal, String direccionSucursal, String ciudadSucursal) 
	{
		this.setIdAlmacenamiento(idAlmacenamiento);
		this.setCantidadProductos(cantidadProductos);
		this.setCapacidadPeso(capacidadPeso);
		this.setCapacidadVolumen(capacidadVolumen);
		this.setNombreSucursal(nombreSucursal);
		this.setDireccionSucursal(direccionSucursal);
		this.setCiudadSucursal(ciudadSucursal);
	}

	/**
	 * Retorna el id del almacenamiento.
	 * 
	 * @return El id del almacenamiento.
	 */
	public long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	/**
	 * Asigna el id del almacenamiento.
	 * 
	 * @param idAlmacenamiento - El id del almacenamiento.
	 */
	public void setIdAlmacenamiento(long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	/**
	 * Retorna la capacidad volumétrica máxima del almacenamiento.
	 * 
	 * @return La capacidad volumétrica máxima del almacenamiento.
	 */
	public double getCapacidadVolumen() {
		return capacidadVolumen;
	}

	/**
	 * Asigna la capacidad volumétrica máxima del almacenamiento.
	 * 
	 * @param capacidadVolumen - La capacidad volumétrica máxima del almacenamiento.
	 */
	public void setCapacidadVolumen(double capacidadVolumen) {
		this.capacidadVolumen = capacidadVolumen;
	}

	/**
	 * Retorna el peso máximo que soporta el almacenamiento.
	 * 
	 * @return El peso máximo que soporta el almacenamiento.
	 */
	public double getCapacidadPeso() {
		return capacidadPeso;
	}

	/**
	 * Asigna el peso máximo que soporta el almacenamiento.
	 * 
	 * @param capacidadPeso -  El peso máximo que soporta el almacenamiento.
	 */
	public void setCapacidadPeso(double capacidadPeso) {
		this.capacidadPeso = capacidadPeso;
	}

	/**
	 * Retorna la cantidad de productos que tiene el almacenamiento actualmente.
	 * 
	 * @return La cantidad de productos que tiene el almacenamiento actualmente.
	 */
	public int getCantidadProductos() {
		return cantidadProductos;
	}

	/**
	 * Asigna la cantidad de productos que tiene el almacenamiento actualmente.
	 * 
	 * @param cantidadProductos - La cantidad de productos que tiene el almacenamiento actualmente.
	 */
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	/**
	 * Retorna el nombre de la sucursal a la cual pertenece el almacenamiento.
	 * 
	 * @return El nombre de la sucursal a la cual pertenece el almacenamiento.
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Asigna el nombre de la sucursal a la cual pertenece el almacenamiento.
	 * 
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece el almacenamiento.
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Retorna la dirección de la sucursal a la cual pertenece el almacenamiento.
	 * 
	 * @return La dirección de la sucursal a la cual pertenece el almacenamiento.
	 */
	public String getDireccionSucursal() {
		return direccionSucursal;
	}

	/**
	 * Asigna la dirección de la sucursal a la cual pertenece el almacenamiento.
	 * 
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece el almacenamiento.
	 */
	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}

	/**
	 * Retorna la ciudad de la sucursal a la cual pertenece el almacenamiento.
	 * 
	 * @return La ciudad de la sucursal a la cual pertenece el almacenamiento.
	 */
	public String getCiudadSucursal() {
		return ciudadSucursal;
	}

	/**
	 * Asigna la ciudad de la sucursal a la cual pertenece el almacenamiento.
	 * 
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece el almacenamiento.
	 */
	public void setCiudadSucursal(String ciudadSucursal) {
		this.ciudadSucursal = ciudadSucursal;
	}

	/**
	 * Retorna la categoría de los productos que almacena el almacenamiento.
	 * 
	 *  @return La categoría de los productos que almacena el almacenamiento. 
	 */
	
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Asigna la categoría de los productos que almacena el almacenamiento.
	 * 
	 *  @param categoria - La categoría de los productos que almacena el almacenamiento. 
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
