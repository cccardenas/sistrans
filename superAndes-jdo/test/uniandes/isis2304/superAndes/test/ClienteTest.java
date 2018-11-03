package uniandes.isis2304.superAndes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileReader;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;


import uniandes.isis2304.superAndes.negocio.Cliente;
import uniandes.isis2304.superAndes.negocio.SuperAndes;

public class ClienteTest {

/* ****************************************************************
 * 			Constantes
 *****************************************************************/
/**
 * Logger para escribir la traza de la ejecución
 */
private static Logger log = Logger.getLogger(ClienteTest.class.getName());

/**
 * Ruta al archivo de configuración de los nombres de tablas de la base de datos: La unidad de persistencia existe y el esquema de la BD también
 */
private static final String CONFIG_TABLAS_A = "./resources/config/TablasBD_A.json"; 

/* ****************************************************************
 * 			Atributos
 *****************************************************************/
/**
 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
 */
private JsonObject tableConfig;

/**
 * La clase que se quiere probar
 */
private SuperAndes superAndes;

/* ****************************************************************
 * 			Métodos de prueba para la tabla TipoBebida - Creación y borrado
 *****************************************************************/
/**
 * Método que prueba las operaciones sobre la tabla TipoBebida
 * 1. Adicionar un tipo de bebida
 * 2. Listar el contenido de la tabla con 0, 1 y 2 registros insertados
 * 3. Borrar un tipo de bebida por su identificador
 * 4. Borrar un tipo de bebida por su nombre
 */
@Test
public void CRDPersonaNaturalTest() 
{
	// Probar primero la conexión a la base de datos
	try
	{
		System.out.println("Probando las operaciones CRD sobre Cliente");
		superAndes = new SuperAndes (openConfig (CONFIG_TABLAS_A));
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println("Prueba de CRD de Tipobebida incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
		System.out.println("La causa es: " + e.getCause ().toString ());

		String msg = "Prueba de CRD de Tipobebida incompleta. No se pudo conectar a la base de datos !!.\n";
		msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
		System.out.println (msg);
		fail (msg);
	}
	
	// Ahora si se pueden probar las operaciones
	try
	{
		// Lectura de los tipos de bebida con la tabla vacía
		List <Cliente> lista = superAndes.darClientes();
		
		assertEquals ("No debe haber clientes creados!!", 0, lista.size ());

		// Lectura de los tipos de bebida con un tipo de bebida adicionado
		String nombreCliente1 = "Piter Albeiro";
		String correoCliente1 = "piterAlbeiro@me.com";
		Cliente cliente1 = superAndes.adicionarCliente (nombreCliente1,correoCliente1);
		lista = superAndes.darClientes();
		assertEquals ("Debe haber un cliente creado", 1, lista.size ());
		assertEquals ("El objeto creado y el traido de la BD deben ser iguales !!", nombreCliente1, lista.get (0));

		// Lectura de los clientes con dos nombres adicionados
		String nombreCliente2 = "Johnny Sins";
		String correoCliente2 = "js@me.com";
		Cliente cliente2 = superAndes.adicionarCliente (nombreCliente2,correoCliente2);
		lista = superAndes.darClientes();
		assertEquals ("Debe haber dos clientes de bebida creados !!", 2, lista.size ());
		assertTrue ("El primer cliente adicionado debe estar en la tabla", cliente1.equals (lista.get (0)) || cliente1.equals (lista.get (1)));
		assertTrue ("El segundo tipo de bebida adicionado debe estar en la tabla", cliente2.equals (lista.get (0)) || cliente2.equals (lista.get (1)));

		// Prueba de eliminación de un cliente, dado su identificador
		long tbEliminados = superAndes.eliminarClientePorCorreo (cliente1.getCorreo());
		assertEquals ("Debe haberse eliminado un cliente !!", 1, tbEliminados);
		lista = superAndes.darClientes();
		assertEquals ("Debe haber un solo cliente !!", 1, lista.size ());
		assertFalse ("El primer cliente adicionado NO debe estar en la tabla", cliente1.equals (lista.get (0)));
		assertTrue ("El segundo cliente adicionado debe estar en la tabla", cliente2.equals (lista.get (0)));
		
		// Prueba de eliminación de un cliente, dado su identificador
		tbEliminados = superAndes.eliminarClientePorCorreo (nombreCliente2);
		assertEquals ("Debe haberse eliminado un cliente !!", 1, tbEliminados);
		lista = superAndes.darClientes();
		assertEquals ("La tabla debió quedar vacía !!", 0, lista.size ());
	}
	catch (Exception e)
	{
		e.printStackTrace();
		String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla TipoBebida.\n";
		msg += "Revise el log de superAndes y el de datanucleus para conocer el detalle de la excepción";
		System.out.println (msg);

		fail ("Error en las pruebas sobre la tabla TipoBebida");
	}
	finally
	{
		superAndes.limpiarSuperAndes ();
		superAndes.cerrarUnidadPersistencia ();    		
	}
}

/**
 * Método de prueba de la restricción de unicidad sobre el nombre de TipoBebida
 */
@Test
public void unicidadTipoBebidaTest() 
{
	// Probar primero la conexión a la base de datos
	try
	{
		System.out.println("Probando la restricción de UNICIDAD del nombre del tipo de bebida");
		superAndes = new SuperAndes (openConfig (CONFIG_TABLAS_A));
	}
	catch (Exception e)
	{
//		e.printStackTrace();
		System.out.println ("Prueba de UNICIDAD de Tipobebida incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
		System.out.println ("La causa es: " + e.getCause ().toString ());

		String msg = "Prueba de UNICIDAD de Tipobebida incompleta. No se pudo conectar a la base de datos !!.\n";
		msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
		System.out.println (msg);
		fail (msg);
	}
	
	// Ahora si se pueden probar las operaciones
	try
	{
		// Lectura de los tipos de bebida con la tabla vacía
		List <Cliente> lista = superAndes.darClientes();
		//assertEquals ("No debe haber clientes creados!!", 0, lista.size ());

		// Lectura de los tipos de bebida con un tipo de bebida adicionado
		String nombreCliente1 = "Germán";
		String correoCliente1 = "garmendia@me.com";
		Cliente tipoBebida1 = superAndes.adicionarCliente (nombreCliente1,correoCliente1);
		lista = superAndes.darClientes();
		assertEquals ("Debe haber un cliente creado !!", 1, lista.size ());

		Cliente tipoBebida2 = superAndes.adicionarCliente (nombreCliente1,correoCliente1);
		assertNull ("No puede adicionar dos clientes con el mismo correo !!", tipoBebida2);
	}
	catch (Exception e)
	{
		e.printStackTrace();
		String msg = "Error en la ejecución de las pruebas de UNICIDAD sobre la tabla CLIENTE.\n";
		msg += "Revise el log de SuperAndes y el de datanucleus para conocer el detalle de la excepción";
		System.out.println (msg);

		fail ("Error en las pruebas de UNICIDAD sobre la tabla CLIENTE");
	}    				
	finally
	{
		superAndes.limpiarSuperAndes ();
		superAndes.cerrarUnidadPersistencia ();    		
	}
}

/* ****************************************************************
 * 			Métodos de configuración
 *****************************************************************/
/**
 * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
 * @param tipo - El tipo de configuración deseada
 * @param archConfig - Archivo Json que contiene la configuración
 * @return Un objeto JSON con la configuración del tipo especificado
 * 			NULL si hay un error en el archivo.
 */
private JsonObject openConfig (String archConfig)
{
	JsonObject config = null;
	try 
	{
		Gson gson = new Gson( );
		FileReader file = new FileReader (archConfig);
		JsonReader reader = new JsonReader ( file );
		config = gson.fromJson(reader, JsonObject.class);
		System.out.println ("Se encontró un archivo de configuración de tablas válido");
	} 
	catch (Exception e)
	{
//		e.printStackTrace ();
		System.out.println ("NO se encontró un archivo de configuración válido");			
		JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de tablas válido: ", "TipoBebidaTest", JOptionPane.ERROR_MESSAGE);
	}	
    return config;
}	
}




