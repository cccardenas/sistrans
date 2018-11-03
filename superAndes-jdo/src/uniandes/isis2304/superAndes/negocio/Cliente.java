package uniandes.isis2304.superAndes.negocio;

/**
 * Clase abstracta para modelar los posibles clientes del negocio de SuperAndes
 *
 * @author Juan Sebastián Bravo
 */

public class Cliente {


	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El nombre del cliente.
	 */
	protected String nombre;

	/**
	 * El correo ÚNICO del cliente.
	 */
	protected String correo;

	/**
	 * Los puntos de fidelización del cliente.
	 */
	protected int puntos_Fidelizacion;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor sin parámetros por defecto
	 */
	public Cliente()
	{
		this.setNombre("");
		this.setCorreo("");
		this.setPuntosFidelizacion(0);
	}
	/**
	 * Constructor con valores.
	 * @param nombre - El nombre del cliente.
	 * @param correo - El correo único del cliente.
	 * @param puntosFidelizacion - La cantidad de puntos de fidelización del cliente.
	 */
	public Cliente(String nombre, String correo, int puntosFidelizacion)
	{
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPuntosFidelizacion(puntosFidelizacion);
	}
	/**
	 * Retorna el nombre del cliente.
	 * 
	 * @return El nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Asigna el nombre del cliente.
	 * 
	 * @param nombre - El nombre del cliente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Retorna el correo del cliente.
	 * 
	 * @return El correo del cliente.
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Asigna el correo del cliente.
	 * 
	 * @param correo - El correo del cliente.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Retorna la cantidad de puntos de fidelización del cliente.
	 * 
	 * @return La cantidad de puntos de fidelización del cliente.
	 */
	public int getPuntosFidelizacion() {
		return puntos_Fidelizacion;
	}
	/**
	 * Asigna la cantidad de puntos de fidelización del cliente.
	 * 
	 * @param puntosFidelizacion - La cantidad de puntos de fidelización del cliente.
	 */
	public void setPuntosFidelizacion(int puntosFidelizacion) {
		this.puntos_Fidelizacion = puntosFidelizacion;
	}



}
