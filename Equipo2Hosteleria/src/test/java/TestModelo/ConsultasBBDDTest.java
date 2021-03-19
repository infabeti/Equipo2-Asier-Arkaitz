package TestModelo;

import static org.junit.Assert.*;
import org.junit.Test;

import Modelo.ConsultasBBDD;

public class ConsultasBBDDTest {

	private ConsultasBBDD consultasBBDD = new ConsultasBBDD();
	private double resultadoDouble;
	private double resultadoEsperadoDouble;
	private String[] resultadoArrayString;
	private String[] resultadoEsperadoArrayString;
	private String arrayNombresProducto[]= {"Garbanzos","Paella","Bacalao","Hamburguesa","Cerveza"};
	
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
	}
}
