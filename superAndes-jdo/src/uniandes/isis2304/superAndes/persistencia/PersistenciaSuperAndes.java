package uniandes.isis2304.superAndes.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.superAndes.negocio.Bodega;
import uniandes.isis2304.superAndes.negocio.Cliente;



public class PersistenciaSuperAndes {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecuci�n
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el �nico objeto de la clase - Patr�n SINGLETON
	 */
	private static PersistenciaSuperAndes instance;
	
	/**
	 * F�brica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a la tabla BODEGA de la base de datos
	 * 
	 */
	private SQLAlmacenamiento sqlAlmacenamiento;
	
	private SQLBodega sqlBodega;
	
	private SQLEmpresa sqlEmpresa;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLCliente sqlCliente;
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLEstante sqlEstante;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLFactura sqlFactura;
	
	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLLocalVentas sqlLocalVentas;
	
	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLPedido sqlPedido;
	
	/**
	 * Atributo para el acceso a la tabla VISITAN de la base de datos
	 */
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLPersonaNatural sqlPersonaNatural;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLProducto sqlProducto;
	
	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLPromocion sqlPromocion;
	
	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLSucursal sqlSucursal;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/* ****************************************************************
	 * 			M�todos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patr�n SINGLETON
	 */
	private PersistenciaSuperAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("superAndes_sequence"); //0
		tablas.add ("A_ALMACENAMIENTO"); //1
		tablas.add ("A_BODEGA"); //2        
		tablas.add ("A_CLIENTE");//3        
		tablas.add ("A_EMPRESA");//4       
		tablas.add ("A_ESTANTE");// 5        
		tablas.add ("A_FACTURA");// 6        
		tablas.add ("A_LOCAL_VENTAS"); //7   
		tablas.add ("A_PEDIDO");//8         
        tablas.add ("A_PERSONANATURAL"); //9 
	    tablas.add ("A_PRODUCTO"); //10      
	    tablas.add ("A_PROMOCION"); //11
	    tablas.add ("A_PROVEEDOR"); //12
	    tablas.add ("A_SUCURSAL"); //13       
	
	}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patr�n SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaSuperAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}
	
	
	/**
	 * @return Retorna el �nico objeto PersistenciaSuperAndes existente - Patr�n SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el �nico objeto PersistenciaSuperAndes existente - Patr�n SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexi�n con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle espec�fico del problema encontrado
	 * @param e - La excepci�n que ocurrio
	 * @return El mensaje de la excepci�n JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bodega de superandes
	 */                                                                       
	public String darTablaAlmacenamiento ()                                           
	{                                                                         
		return tablas.get (1);                                                
	}      

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bodega de superandes
	 */                                                                       
	public String darTablaBodega ()                                           
	{                                                                         
		return tablas.get (2);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Cliente de superandes 
	 */                                                                       
	public String darTablaCliente ()                                          
	{                                                                         
		return tablas.get (3);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Empresa de superandes 
	 */                                                                       
	public String darTablaEmpresa ()                                          
	{                                                                         
		return tablas.get (4);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Estante de superandes 
	 */
	public String darTablaEstante ()
	{
		return tablas.get (5);
	}

	/**                                                                      
	 * @return La cadena de caracteres con el nombre de la tabla de Factura de superAndes 
	 */                                                                    
	public String darTablaFactura ()                                       
	{                                                                      
		return tablas.get (6);                                             
	}                                                                      
                                                                           
	/**                                                                    
	 * @return La cadena de caracteres con el nombre de la tabla de LocalVenta de superAndess
	 */                                                                       
	public String darTablaLocalVentas ()                                      
	{                                                                         
		return tablas.get (7);                                                
	}                                                                         
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Pedidos de superAndes 
	 */                                                                        
	public String darTablaPedidos ()                                           
	{                                                                          
		return tablas.get (8);                                                 
	}                                                                          
	                                                                                                                                                 
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de PersonaNatural de superAndes
	 */
	public String darTablaPersonaNatural ()
	{
		return tablas.get (9);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Producto de superAndes 
	 */                                                                         
	public String darTablaProducto ()                                           
	{                                                                           
		return tablas.get (10);                                                 
	}                                                                           
                                                                                
	/**                                                                         
	 * @return La cadena de caracteres con el nombre de la tabla de Promocion de superAndese
	 */                                                                       
	public String darTablaPromocion ()                                        
	{                                                                         
		return tablas.get (11);                                               
	}    
	
	/**                                                                         
	 * @return La cadena de caracteres con el nombre de la tabla de Promocion de superAndese
	 */                                                                       
	public String darTablaProveedor ()                                        
	{                                                                         
		return tablas.get (12);                                               
	}
                                                                              
	/**                                                                       
	 * @return La cadena de caracteres con el nombre de la tabla de Sucursal de superAndes 
	 */
	public String darTablaSucursal ()
	{
		return tablas.get (13);
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlAlmacenamiento = new SQLAlmacenamiento(this);
		sqlBodega = new SQLBodega(this);
		sqlCliente = new SQLCliente(this);
		sqlEmpresa = new SQLEmpresa(this);
		sqlEstante = new SQLEstante(this);
		sqlFactura = new SQLFactura(this);
		sqlLocalVentas = new SQLLocalVentas (this);
		sqlPedido = new SQLPedido(this);		
		sqlPersonaNatural = new SQLPersonaNatural (this);
		sqlProducto = new SQLProducto(this);		
		sqlPromocion = new SQLPromocion(this);
		sqlSucursal = new SQLSucursal(this);
	}
	
	/**
	 * Transacci�n para el generador de secuencia de SuperAndes
	 * Adiciona entradas al log de la aplicaci�n
	 * @return El siguiente n�mero del secuenciador de SuperAndes
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        System.out.println ("Generando secuencia: " + resp);
        return resp;
    }

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqSuperAndes ()
	{
		return tablas.get (0);
	}
	

	/* ****************************************************************
	 * 			M�todos para manejar los CLIENTES
	 *****************************************************************/

	/**
	 * M�todo que inserta, de manera transaccional, una tupla en la tabla Clientes
	 * Adiciona entradas al log de la aplicaci�n
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepci�n
	 */
	public Cliente adicionarCliente(String nombre, String correo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            //long idCliente = nextval ();
            long tuplasInsertadas = sqlCliente.adicionarCliente(pm, correo, nombre,0);
            tx.commit();
            
            log.trace ("Inserci�n de cliente: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Cliente (nombre, correo,0);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	System.out.println ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * M�todo que elimina, de manera transaccional, una tupla en la tabla Cliente, dado el nombre del tipo de bebida
	 * Adiciona entradas al log de la aplicaci�n
	 * @param nombre - El nombre del tipo de bebida
	 * @return El n�mero de tuplas eliminadas. -1 si ocurre alguna Excepci�n
	 */
	public long eliminarClientePorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCliente.eliminarClientePorNombre(pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * M�todo que elimina, de manera transaccional, una tupla en la tabla Cliente, dado el identificador del tipo de bebida
	 * Adiciona entradas al log de la aplicaci�n
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return El n�mero de tuplas eliminadas. -1 si ocurre alguna Excepci�n
	 */
	public long eliminarClientePorCorreo (String correo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCliente.eliminarClientePorCorreo(pm, correo);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * M�todo que consulta todas las tuplas en la tabla Clientes
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<Cliente> darClientes()
	{
		return sqlCliente.darClientes (pmf.getPersistenceManager());
	}
 
	/**
	 * M�todo que consulta todas las tuplas en la tabla Cliente que tienen el nombre dado
	 * @param nombre - El nombre del tipo de bebida
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<Cliente> darClientesPorNombre (String nombre)
	{
		return sqlCliente.darClientePorNombre (pmf.getPersistenceManager(), nombre);
	}
 
	/**
	 * M�todo que consulta todas las tuplas en la tabla TipoBebida con un identificador dado
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return El objeto TipoBebida, construido con base en las tuplas de la tabla TIPOBEBIDA con el identificador dado
	 */
	public Cliente darClientePorCorreo (String correo)
	{
		return sqlCliente.darClientePorCorreo (pmf.getPersistenceManager(), correo);
	}
	

	/* ****************************************************************
	 * 			M�todos para manejar las Bodegas
	 *****************************************************************/

	/**
	 * M�todo que inserta, de manera transaccional, una tupla en la tabla Clientes
	 * Adiciona entradas al log de la aplicaci�n
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepci�n
	 */
	public Bodega adicionarBodega(int idAlmacenamiento, String nombreBodega)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            //long idCliente = nextval ();
            long tuplasInsertadas = sqlBodega.adicionarBodega(pm, idAlmacenamiento, nombreBodega);
            tx.commit();
            
            log.trace ("Inserci�n de bodega: " + nombreBodega + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Bodega (nombreBodega);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	System.out.println ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * M�todo que elimina, de manera transaccional, una tupla en la tabla Cliente, dado el nombre del tipo de bebida
	 * Adiciona entradas al log de la aplicaci�n
	 * @param nombre - El nombre del tipo de bebida
	 * @return El n�mero de tuplas eliminadas. -1 si ocurre alguna Excepci�n
	 */
	public long eliminarBodegaPorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBodega.eliminarBodegaPorNombre(pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


	/**
	 * M�todo que consulta todas las tuplas en la tabla Clientes
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<Bodega> darBodegas()
	{
		return sqlBodega.darBodegas (pmf.getPersistenceManager());
	}
 
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de SuperAndes
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 7 n�meros que indican el n�mero de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarSuperAndes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarSuperAndes (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}

	

}
