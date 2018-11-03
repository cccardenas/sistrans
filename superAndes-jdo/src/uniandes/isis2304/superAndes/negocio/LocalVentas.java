package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto LOCAL_VENTAS del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */

public class LocalVentas {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador ÚNICO del local de ventas.
	 */
	private long idLocalVentas;
	
	/**
	 * Los ingresos asociados al local de ventas.
	 */
	private int ingresos;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor sin parámetros por defecto
	 */
	public LocalVentas()
	{
		this.setIdLocalVentas(0);
		this.setIngresos(0);		
	}
	
	/**
	 * Constructor con valores.
	 * @param idLocalVentas - El id del local de ventas.
	 * @param ingresos - Los ingresos asociados al local de ventas.
	 */
	public LocalVentas(long idLocalVentas, int ingresos)
	{
		this.setIdLocalVentas(0);
		this.setIngresos(ingresos);
	}

	/**
	 * Retorna el id del local de ventas.
	 * 
	 * @return El id del local de ventas.
	 */
	public long getIdLocalVentas() {
		return idLocalVentas;
	}

	/**
	 * Asigna el id del local de ventas.
	 * 
	 * @param idLocalVentas -  El id del local de ventas.
	 */
	public void setIdLocalVentas(long idLocalVentas) {
		this.idLocalVentas = idLocalVentas;
	}

	/**
	 * Retorna los ingresos del local de ventas.
	 * 
	 * @return Los ingresos del local de ventas.
	 */
	public int getIngresos() {
		return ingresos;
	}

	/**
	 * Asigna los ingresos del local de ventas.
	 * 
	 * @param ingresos - Los ingresos del local de ventas.
	 */
	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}
	

}
