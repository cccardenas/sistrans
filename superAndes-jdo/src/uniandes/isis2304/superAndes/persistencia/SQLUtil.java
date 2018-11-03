package uniandes.isis2304.superAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


public class SQLUtil {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes psa;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLUtil (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ psa.darSeqSuperAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarSuperAndes (PersistenceManager pm)
	{
		Query qAlmacenamiento = pm.newQuery(SQL,"DELETE FROM" + psa.darTablaAlmacenamiento());
        Query qBodega = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaBodega ());          
        Query qCliente = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaCliente ());
        Query qEmpresa = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaEmpresa ());
        Query qEstante = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaEstante ());
        Query qFactura = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaFactura ());
        Query qLocalVentas = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaLocalVentas ());
        Query qPedido = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaPedidos ());
        Query qPersonaNatural = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaPersonaNatural ());
        Query qProducto = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaProducto ());
        Query qPromocion = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaPromocion ());
        Query qProveedor = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaProveedor ());
        Query qSucursal = pm.newQuery(SQL, "DELETE FROM " + psa.darTablaSucursal ());

        long almacenamientoEliminados = (long) qAlmacenamiento.executeUnique();
        long bodegaEliminados = (long) qBodega.executeUnique ();
        long clienteEliminados = (long) qCliente.executeUnique ();
        long empresaEliminadas = (long) qEmpresa.executeUnique ();
        long enstanteEliminados = (long) qEstante.executeUnique ();
        long facturaEliminados = (long) qFactura.executeUnique ();
        long localVentasEliminados = (long) qLocalVentas.executeUnique ();
        long pedidoEliminados = (long) qPedido.executeUnique ();
        long personaNaturalEliminados = (long) qPersonaNatural.executeUnique ();
        long productoEliminados = (long) qProducto.executeUnique ();
        long promocionEliminados = (long) qPromocion.executeUnique ();
        long proveedorEliminados = (long) qProveedor.executeUnique ();
        long sucursalEliminados = (long) qSucursal.executeUnique ();
        return new long[]
        		{almacenamientoEliminados,
        		bodegaEliminados, 
        		clienteEliminados,
        		empresaEliminadas,
        		enstanteEliminados,
        		facturaEliminados,
        		localVentasEliminados,
        		pedidoEliminados, 	
        		personaNaturalEliminados,		
        		productoEliminados,		
        		promocionEliminados,
        		proveedorEliminados,
        		sucursalEliminados};
	}


}
