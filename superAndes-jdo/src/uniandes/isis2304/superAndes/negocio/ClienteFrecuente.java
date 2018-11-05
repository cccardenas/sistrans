package uniandes.isis2304.superAndes.negocio;

import java.sql.Timestamp;

public class ClienteFrecuente {
	
	private int numeroCompras;
	
	private String correoCliente;
	
	private String fechaCompra;
	
	public ClienteFrecuente(int n,String c, String f)
	{
		numeroCompras = n;
		correoCliente = c;
		fechaCompra = f;
	}

	public int getNumeroCompras() {
		return numeroCompras;
	}

	public void setNumeroCompras(int numeroCompras) {
		this.numeroCompras = numeroCompras;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	

}
