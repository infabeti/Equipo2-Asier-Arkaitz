package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import Modelo.ConsultasBBDD;
import Modelo.Producto;

public class ConsultasBBDDTest {

	private ConsultasBBDD consultasBBDD = new ConsultasBBDD();
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
	private Producto arrayProducto[];
	
	@Test
	public void testGetListaProductos() {
		arrayProducto = new Producto[5];
		arrayProducto[0] = new Producto("Garbanzos","Comida","30-01-2021",5,5);
		arrayProducto[1] = new Producto("Paella","Comida","31-01-2021",5,5);
		arrayProducto[2] = new Producto("Bacalao","Comida","02-02-2021",5,5);
		arrayProducto[3] = new Producto("Hamburguesa","Comida","30-01-2021",5,5);
		arrayProducto[4] = new Producto("Cerveza","Bebida","01-02-2021",5,5);
		Producto[] resultadoEsperadoArray = arrayProducto;
		Producto[] resultadoArray = consultasBBDD.getListaProductos();
		//org.junit.Assert.assertEquals(resultadoEsperadoArray, resultadoArray);
		assertArrayEquals(resultadoEsperadoArray, resultadoArray);
	}
	/*
	@Test
	public void testNombresProductos() {
		String[] resultadoEsperadoArray = arrayNombresProducto;
		String[] resultadoArray = consultasBBDD.getListaProductos();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testGetPrecioVentaProductos() {
		resultadoEsperadoDouble = 5;
		resultadoDouble = funciones.getConsultasBBDD().precioVentaProductos("Hamburguesa");
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testListaCompra() {
		resultadoEsperadoString = "Hamburguesa - Cantidad: "+2+" - Precio: "+5+"€ - Total: "+10+"€\n";
		funciones.getCarroCompra().anadirProductos("Hamburguesa",5,2);
		resultadoString = funciones.getCarroCompra().leerLista();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testTotalCarro() {
		resultadoEsperadoDouble = 10;
		funciones.getCarroCompra().anadirCoste(5,2);
		resultadoDouble = funciones.getCarroCompra().leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testResetCarroString() {
		resultadoEsperadoString = "";
		funciones.getCarroCompra().borrarListaCompra();
		resultadoString = funciones.getCarroCompra().leerLista();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testResetCarroDouble() {
		resultadoEsperadoDouble = 0;
		funciones.getCarroCompra().borrarListaCompra();
		resultadoDouble = funciones.getCarroCompra().leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testMostrarNumeroTransaccion() {
		resultadoEsperado = NTransaccion;
		resultado = funciones.getConsultasBBDD().getNTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testAumentarNumeroTransaccion() {
		resultadoEsperado = NTransaccion++;
		funciones.getConsultasBBDD().sumarNTransaccion();
		resultado = funciones.getConsultasBBDD().getNTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testPruebaConexion() {
		resultadoEsperadoBoolean = true;
		resultadoBoolean = funciones.getConsultasBBDD().probarConexion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	*/
}
