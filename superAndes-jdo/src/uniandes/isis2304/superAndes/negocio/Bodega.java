package uniandes.isis2304.superAndes.negocio;

/**
 * Clase para modelar el concepto BODEGA del negocio de SuperAndes.
 *
 * @author Juan Sebastián Bravo
 */
public class Bodega extends Almacenamiento {


	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El nombre único de la bodega.
	 */
	private String nombreBodega;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor sin parámetros por defecto
	 */
	public Bodega()
	{
		super();
		this.setNombreBodega("");
	}
	
	/**
	 * Constructor con únicamente el nombre
	 * @param nombreBodega - El nombre único de la bodega.
	 */
	
	public Bodega(String nombreBodega)
	{
		super();
		this.setNombreBodega(nombreBodega);
	}

	/**
	 * Constructor con valores.
	 * @param idAlmacenamiento - El id de la bodega.
	 * @param cantidadProductos - La cantidad de productos que posee la bodega.
	 * @param capacidadPeso - El peso máximo que soporta la bodega en gr.
	 * @param capacidadVolumen - El volumen máximo que soporta la bodega en cm3.
	 * @param nombreSucursal - El nombre de la sucursal a la cual pertenece la bodega.
	 * @param direccionSucursal - La dirección de la sucursal a la cual pertenece la bodega.
	 * @param ciudadSucursal - La ciudad de la sucursal a la cual pertenece la bodega.
	 * @param nombreBodega - El nombre único de la bodega.
	 */
	public Bodega (long idAlmacenamiento, int cantidadProductos, double capacidadPeso, double capacidadVolumen, String nombreSucursal, String direccionSucursal, String ciudadSucursal, String nombreBodega)
	{
		super(idAlmacenamiento, cantidadProductos, capacidadPeso, capacidadVolumen, nombreSucursal, direccionSucursal, ciudadSucursal);
		this.setNombreBodega(nombreBodega);
	}

	/**
	 * Retorna el nombre único de la bodega.
	 * 
	 * @return El nombre único de la bodega.
	 */
	public String getNombreBodega() {
		return nombreBodega;
	}

	/**
	 * Asigna el nombre único de la bodega.
	 * 
	 * @return El nombre único de la bodega.
	 */
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}


}
