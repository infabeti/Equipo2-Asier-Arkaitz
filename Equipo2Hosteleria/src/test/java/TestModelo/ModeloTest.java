package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Modelo;
import Modelo.Producto;

@SuppressWarnings({ "static-access", "unused" })
public class ModeloTest {

	private Modelo funciones = new Modelo();
	private int resultado;
	private double resultadoDouble;
	private String resultadoString;
	private boolean resultadoBoolean;
	private int resultadoEsperado;
	private double resultadoEsperadoDouble;
	private String resultadoEsperadoString;
	private boolean resultadoEsperadoBoolean;
	private int NTransaccion=1;
	private String arrayNombresProducto[]= {"Garbanzos","Paella","Bacalao","Hamburguesa","Cerveza"};
	

	@Test
	public void testGetNombresProductos() {
		String[] resultadoEsperadoArray = arrayNombresProducto;
		String[] resultadoArray = funciones.getNombresProductos().nombresProductos();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testGetPrecioVentaProductos() {
		resultadoEsperadoDouble = 5;
		resultadoDouble = funciones.getPrecioVentaProductos().precioVentaProductos("Hamburguesa");
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testListaCompra() {
		resultadoEsperadoString = "Hamburguesa - Cantidad: "+2+" - Precio: "+5+"€ - Total: "+10+"€\n";
		funciones.setListaCompra().añadirProductos("Hamburguesa",5,2);
		resultadoString = funciones.getListaCompra().leerLista();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testTotalCarro() {
		resultadoEsperadoDouble = 10;
		funciones.setTotalCarro().añadirCoste(5,2);
		resultadoDouble = funciones.getTotalCarro().leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testResetCarroString() {
		resultadoEsperadoString = "";
		funciones.resetCarro().borrarListaCompra();
		resultadoString = funciones.getListaCompra().leerLista();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testResetCarroDouble() {
		resultadoEsperadoDouble = 0;
		funciones.resetCarro().borrarListaCompra();
		resultadoDouble = funciones.getTotalCarro().leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testMostrarNumeroTransaccion() {
		resultadoEsperado = NTransaccion;
		resultado = funciones.mostrarNumeroTransaccion().leerNumTrans();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testAumentarNumeroTransaccion() {
		resultadoEsperado = NTransaccion++;
		resultado = funciones.aumentarNumeroTransaccion().sumarNumTrans();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testPruebaConexion() {
		resultadoEsperadoBoolean = true;
		resultadoBoolean = funciones.pruebaConexion().probarConexion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	
}
