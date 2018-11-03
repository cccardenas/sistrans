package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto ESTANTE del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Estante extends Almacenamiento {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El nivel de abastecimiento que tiene un estante de los productos.
	 */
	private double nivelAbastecimiento;
	
	/**
	 * El nombre único del estante.
	 */
	private String nombreEstante;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */
	public Estante()
	{
		super();
		this.setNivelDeAbastecimiento(0.0);
		this.setNombreEstante("");
	}
	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id del estante.
	 * @param cantidadProductos - La cantidad de productos que posee el estante.
	 * @param capacidadPeso - El peso máximo que soporta el estante en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta el estante en cm3.
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece el estante.
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece el estante.
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece el estante.
	 * @param nivelDeAbastecimiento - El nivel de abastecimiento del producto que tiene el estante.
	 */
	public Estante(long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen, String nombreSucursal, String direccionSucursal, String ciudadSucursal, double nivelDeAbastecimiento)
	{
		super(idAlmacenamiento, cantidadProductos, capacidadPeso, capacidadVolumen, nombreSucursal, direccionSucursal, ciudadSucursal);
		this.setNivelDeAbastecimiento(nivelDeAbastecimiento);
	}

	/**
	 * Retorna el nivel de abastecimiento del estante.
	 *
	 * @return El id del abastecimiento.
	 */
	public double getNivelAbastecimiento() {
		return nivelAbastecimiento;
	}
	/**
	 * Asigna el nivel de abastecimiento del estante.
	 *
	 * @param nivelAbastecimiento -  El nivel de abastecimiento del estante.
	 */
	public void setNivelDeAbastecimiento(double nivelAbastecimiento) {
		this.nivelAbastecimiento = nivelAbastecimiento;
	}
	/**
	 * Retorna el nombre único del estante.
	 *
	 * @return El nombre único del estante.
	 */
	public String getNombreEstante() {
		return nombreEstante;
	}
	/**
	 * Asigna el nombre único del estante.
	 *
	 * @param nombreEstante - El nombre único del estante.
	 */
	public void setNombreEstante(String nombreEstante) {
		this.nombreEstante = nombreEstante;
	}

}
