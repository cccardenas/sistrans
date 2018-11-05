package uniandes.isis2304.superAndes.negocio;

import java.util.ArrayList;

import uniandes.isis2304.superAndes.persistencia.PersistenciaSuperAndes;

public class CarritoCompras {

	/*
	 * Lista de productos dentro del carrito inicia vacio y cada vez que se realiza una compra se vacia
	 */
	ArrayList productos;
	
	
	/*
	 * identificador del carrito
	 */
	long id;
	
	/**
	 * cedula del cliente que tiene asignado el carrito
	 */
	
	long cedula;
	
	/*
	 * Muestra si el carrito esta disponible en caso de que el carrito se devuelva o los productos se vendan la disponibilidad vuelve a true
	 */
	boolean disponible;
	
	
	public CarritoCompras(long id) {
		productos =  new ArrayList<>();
		this.id= id;
		disponible= true;
	}
	
	
	public boolean darDisponibilidad() {
		return this.disponible;
	}
	
	
	public long darCedula() {
		return this.cedula;
	}
	
	public void cambiarDisponibilidad() {
	
			if(this.disponible=true) {
				this.disponible=false;
				
			}
			else {
				this.disponible= true;
				
			}
	}
	
	public void devolverProductos() {
		
		for(int i=0;i<productos.size();i++) {
			Producto p=(Producto) productos.get(i);
			long id_almacenamiento= p.getIdAlmacenamiento();
		
		}
	}
	
	
	/*
	 * vacia un carrito y remueve los productos en caso de que no se complete la compra
	 */
	public boolean vaciarCarrito() {
		return productos.removeAll(productos);
			}
	
	/*
	 * Agregar productos al carrito
	 * 
	 */
	public void agregarProductosCarrito(Producto p)
	{
		
		productos.add(p);
	}
	
	public ArrayList darProductos() {
		return this.productos;
	}
	
	public void setCedula(long cedula) {
		this.cedula=cedula;
		cambiarDisponibilidad();
	}
	
	public long darId()
	{
		return this.id;
	}
}
