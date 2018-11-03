package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto SUCURSAL del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Sucursal {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El nombre de la sucursal.
	 */
	private String nombre;
	
	/**
	 * La dirección dónde se ubica la sucursal.
	 */
	private String direccion;

	/**
	 * La ciudad dónde se ubica la sucursal.
	 */
	private String ciudad;

	/**
	 * El identificador del local asociado a la sucursal.
	 */
	private long idLocalVentas;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */
	public Sucursal()
	{
		this.setNombre("");
		this.setDireccion("");
		this.setCiudad("");
		this.setIdLocalVentas(0);
	}

	/**
	 * Constructor con valores.
	 * @param nombre - El nombre de la sucursal.
	 * @param direccion - La dirección dónde se ubica la sucursal.
	 * @param ciudad - La ciudad dónde se ubica la sucursal.
	 * @param idLocalVentas - El identificador del local asociado a la sucursal.
	 */
	public Sucursal(String nombre, String direccion, String ciudad, long idLocalVentas)
	{
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCiudad(ciudad);
		this.setIdLocalVentas(idLocalVentas);
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the idLocalVentas
	 */
	public long getIdLocalVentas() {
		return idLocalVentas;
	}

	/**
	 * @param idLocalVentas the idLocalVentas to set
	 */
	public void setIdLocalVentas(long idLocalVentas) {
		this.idLocalVentas = idLocalVentas;
	}




}
