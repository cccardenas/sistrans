package uniandes.isis2304.superAndes.negocio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.superAndes.negocio.Pedido;
import uniandes.isis2304.superAndes.negocio.Promocion;
import uniandes.isis2304.superAndes.negocio.Bodega;
import uniandes.isis2304.superAndes.negocio.LocalVentas;
import uniandes.isis2304.superAndes.negocio.Sucursal;
import uniandes.isis2304.superAndes.persistencia.PersistenciaSuperAndes;

public class SuperAndes {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(SuperAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperAndes psa;
	
	
	/**
	 * carritos de compras 
	 */
	
	ArrayList carritos = new ArrayList<CarritoCompras>();
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public SuperAndes ()
	{
		psa = PersistenciaSuperAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public SuperAndes (JsonObject tableConfig)
	{
		psa = PersistenciaSuperAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		psa.cerrarUnidadPersistencia ();
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los CLIENTES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un cliente 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo cliente
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public Cliente adicionarCliente (String nombre, String correo)
	{
        log.info ("Adicionando Cliente: " + nombre);
        Cliente cliente = psa.adicionarCliente (nombre,correo);		
        log.info ("Adicionando Cliente: " + cliente);
        return cliente;
	}
	
	/**
	 * Elimina un cliente por su nombre
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del cliente a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarClientePorNombre (String nombre)
	{
		log.info ("Eliminando Tipo de bebida por nombre: " + nombre);
        long resp = psa.eliminarClientePorNombre (nombre);		
        log.info ("Eliminando Cliente por nombre: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	/**
	 * Elimina un tipo de bebida por su identificador
	 * Adiciona entradas al log de la aplicación
	 * @param idTipoBebida - El id del tipo de bebida a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarClientePorCorreo (String correo)
	{
		log.info ("Eliminando Cliente por correo: " + correo);
        long resp = psa.eliminarClientePorCorreo (correo);		
        log.info ("Eliminando Cliente por correo: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	/**
	 * Encuentra todos los clientes en Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Clientes con todos los tipos de bebida que conoce la aplicación, llenos con su información básica
	 */
	public List<Cliente> darClientes ()
	{
		System.out.println ("Consultando Clientes");
        List<Cliente> clientes = psa.darClientes ();	
        System.out.println ("Consultando Clientes: " + clientes.size() + " existentes");
        return clientes;
	}


	/**
	 * Encuentra el tipos de bebida en Parranderos con el nombre solicitado
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre de la bebida
	 * @return Un objeto TipoBebida con el tipos de bebida de ese nombre que conoce la aplicación, 
	 * lleno con su información básica
	 */
	public Cliente darClientePorNombre (String nombre)
	{
		log.info ("Buscando Cliente por nombre: " + nombre);
		List<Cliente> tb = psa.darClientesPorNombre (nombre);
		return !tb.isEmpty () ? tb.get (0) : null;
	}
	
	/**
	 * Encuentra todos los tipos de bebida en Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos TipoBebida con todos los tipos de bebida que conoce la aplicación, llenos con su información básica
	 */
	public List<Bodega> darBodegas ()
	{
		log.info ("Consultando Bodegas");
        List<Bodega> bodegas = psa.darBodegas ();	
        log.info ("Consultando Tipos de bebida: " + bodegas.size() + " existentes");
        return bodegas;
	}
	
	/**
	 * Encuentra todos los tipos de bebida en Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos TipoBebida con todos los tipos de bebida que conoce la aplicación, llenos con su información básica
	 */
	
	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de SuperAndes
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarSuperAndes ()
	{
        log.info ("Limpiando la BD de SuperAndes");
        long [] borrrados = psa.limpiarSuperAndes();	
        log.info ("Limpiando la BD de SuperAndes: Listo!");
        return borrrados;
	}

	public Producto adicionarProducto(String text, String text2, String text3, String text4, double parseDouble,
			double parseDouble2, double parseDouble3, String text5, double parseDouble4, int parseInt, long parseLong,
			JTextField nit) {
		
		return null;
	}

	public Proveedor adicionarProveedor(long parseLong, String text, int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public PersonaNatural adicionarPersonaNatural(String text, String text2, int parseInt, String text3,
			long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sucursal adicionarSucursal(String text, String text2, String text3, long parseLong2) {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalVentas adicionarLocalVentas(long parseLong, double parseDouble) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bodega adicionarBodega(long parseLong, String text, String text2, String text3, double parseDouble,
			double parseDouble2, int parseInt,String nombreBodega) {
		// TODO Auto-generated method stub
		return null;
	}

	public Estante adicionarEstante(long parseLong, String text, String text2, String text3, double parseDouble,
			double parseDouble2, int parseInt, String text4, double parseDouble3) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pedido adicionarPedido(long parseLong, double parseDouble, String text, String text2, String text3,
			String text4, String text5, String text6, int parseInt, double parseDouble2, int parseInt2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Factura adicionarFactura(long parseLong, String text, double parseDouble, double parseDouble2,
			double parseDouble3, double parseDouble4, String text2, String text3, String text4, String text5,
			String text6) {
		// TODO Auto-generated method stub
		return null;
	}

	public Promocion adicionarPromocion(long parseLong, long parseLong2, String text, String text2, String text3,
			String text4) {
		// TODO Auto-generated method stub
		return null;
	}

/*
 *
 *********************************************
 *ITERACION 2 
 * *******************************************
 */
	

	public int crearCarritos() {
		for(int i=0;i<19;i++) {
			CarritoCompras carrito= new CarritoCompras(i);
			carritos.add(carrito);
		}
	return	carritos.size();
	}

	public void tomarCarrito(long cedula) {
		boolean tomado=false;
		for(int i=0; i<carritos.size() || tomado==true;i++) {
			CarritoCompras c= (CarritoCompras) carritos.get(i);
			if(c.darDisponibilidad()==true) {
				c.setCedula(cedula);
				tomado=false;
			}
		}
	}
	
	public void dejarCarritoSinCompra(long cedula) {
		boolean found= false;
		for(int i=0;i<carritos.size()||found==false;i++) {
			CarritoCompras c= (CarritoCompras) carritos.get(i);
			if(c.darCedula()==cedula) {
				c.devolverProductos();
				c.setCedula(0);
				found=true;
			}
		}
	}
	
	public void devolverProductoAlAlmacenamiento(long idAlmacenamiento) {
		psa.devolverProducto(idAlmacenamiento);
	}
	
	
	public void terminarCompra(long cedula,long numeroFactura) {
		boolean found= false;
		for(int i=0;i<carritos.size()||found==false;i++) {
			CarritoCompras c= (CarritoCompras) carritos.get(i);
			if(c.darCedula()==cedula) {
				for(int j=0;j<c.darProductos().size();j++) {
					Producto p= (Producto) c.darProductos().get(j);
					String codigo= p.getCodigoDeBarras();
					
					
				}
				found=true;
			}
		}
	}
	
	public void agregarProductoAllCarrito( String codigoBarras, String cedula) {
			
	long ced= Long.parseLong(cedula);
	
	long idCarrito=0;
	for (int i=0;i<carritos.size();i++) {
	CarritoCompras c= (CarritoCompras) carritos.get(i);
	if(c.darCedula()==ced) {
		idCarrito=c.darId();
	}
	}
		
	Producto p= psa.buscarPorducto(codigoBarras);
		
		CarritoCompras carrito= (CarritoCompras) carritos.get((int) idCarrito);
		
		carrito.agregarProductosCarrito(p);
		psa.tomarProductoAlmacenamiento(p.getIdAlmacenamiento(), 1);
			}
}
