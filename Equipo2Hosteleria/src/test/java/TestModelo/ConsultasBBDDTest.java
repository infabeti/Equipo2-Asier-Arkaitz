package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import Modelo.CarroCompra;
import Modelo.ConsultasBBDD;
import Modelo.Modelo;
import Modelo.Producto;

@SuppressWarnings({ "unused" })
public class ConsultasBBDDTest {

	private static ConsultasBBDD consultasBBDD;
	private static CarroCompra carroCompra;
	private Modelo funciones = new Modelo(consultasBBDD, carroCompra);
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
		String[] resultadoArray = funciones.getConsultasBBDD().nombresProductos();
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
	
}
