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
	private String[] resultadoArrayString;
	private String[] resultadoEsperadoArrayString;
	private Producto[] arrayProductos;
	private Producto[] arrayProductosEsperado;
	private int NTransaccion=1;
	private String arrayNombresProducto[]= {"Garbanzos","Paella","Bacalao","Hamburguesa","Cerveza"};
	@Test
	public void testGetListaProductos() {
		arrayProductosEsperado = new Producto[5];
		arrayProductosEsperado[0] = new Producto("Garbanzos","Comida","30-01-2021",5,5);
		arrayProductosEsperado[1] = new Producto("Paella","Comida","31-01-2021",5,5);
		arrayProductosEsperado[2] = new Producto("Bacalao","Comida","02-02-2021",5,5);
		arrayProductosEsperado[3] = new Producto("Hamburguesa","Comida","30-01-2021",5,5);
		arrayProductosEsperado[4] = new Producto("Cerveza","Bebida","01-02-2021",5,5);
		arrayProductos = consultasBBDD.getListaProductos();
		resultadoEsperadoArrayString = arrayNombresProducto;
		resultadoArrayString = consultasBBDD.nombresProductos();
		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
		testNombresProductos();
		testGetPrecioVentaProductos();
	}
	@Test
	public void testNombresProductos() {
		resultadoEsperadoArrayString = arrayNombresProducto;
		resultadoArrayString = consultasBBDD.nombresProductos();
		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}
	@Test
	public void testGetPrecioVentaProductos() {
		resultadoEsperadoDouble = 5;
		resultadoDouble = consultasBBDD.precioVentaProductos("Hamburguesa");
		org.junit.Assert.assertEquals(resultadoEsperadoDouble, resultadoDouble, 1);
	}/*
	@Test
	public void testListaCompra() {
		resultadoEsperadoString = "Hamburguesa - Cantidad: "+2+" - Precio: "+5+"€ - Total: "+10+"€\n";
		carroCompra.anadirProductos("Hamburguesa",5,2);
		resultadoString = funciones.getCarroCompra().leerLista();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testTotalCarro() {
		resultadoEsperadoDouble = 10;
		carroCompra.anadirCoste(5,2);
		resultadoDouble = funciones.getCarroCompra().leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testResetCarroString() {
		resultadoEsperadoString = "";
		carroCompra.borrarListaCompra();
		resultadoString = funciones.getCarroCompra().leerLista();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testResetCarroDouble() {
		resultadoEsperadoDouble = 0;
		carroCompra.borrarListaCompra();
		resultadoDouble = funciones.getCarroCompra().leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testMostrarNumeroTransaccion() {
		resultadoEsperado = NTransaccion;
		resultado = consultasBBDD.getNTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testAumentarNumeroTransaccion() {
		resultadoEsperado = NTransaccion++;
		consultasBBDD.sumarNTransaccion();
		resultado = consultasBBDD.getNTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testPruebaConexion() {
		resultadoEsperadoBoolean = true;
		resultadoBoolean = consultasBBDD.probarConexion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	*/
}
