package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto EMPRESA del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Empresa extends Cliente {


	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El nit ÚNICO de la empresa.
	 */
	private int nit;

	/**
	 * La dirección de la empresa.
	 */
	private String direccion;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor sin parámetros por defecto
	 */
	public Empresa()
	{
		super();
		this.setNit(0);
		this.setDireccion("");

	}
	/**
	 * Constructor con valores.
	 * @param nombre - El nombre de la empresa.
	 * @param correo - El correo único de la empresa.
	 * @param puntosFidelizacion - La cantidad de puntos de fidelización de la empresa.
	 * @param nit - El nit único de la empresa.
	 * @param direccion - La dirección de la empresa.
	 */
	public Empresa(String nombre, String correo, int puntosFidelizacion, int nit, String direccion)
	{
		super(nombre,correo,puntosFidelizacion);
		this.setDireccion (direccion);
		this.setNit (nit);
	}
	/**
	 * Retorna el nit de la empresa.
	 * 
	 * @return El nit de la empresa.
	 */
	public int getNit() {
		return nit;
	}
	/**
	 * Asigna el nit de la empresa.
	 * 
	 * @param nit - El nit de la empresa.
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}
	/**
	 * Retorna la dirección de la empresa.
	 * 
	 * @return La dirección de la empresa.
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Asigna la dirección de la empresa.
	 * 
	 * @param direccion - La dirección de la empresa.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


}
