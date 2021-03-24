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
	private String arrayNombresProducto[]= {"Cerveza","Refresco","Tabaco"};
	
	@Test
	public void testNombresProductos() {
		resultadoEsperadoArrayString = arrayNombresProducto;
		resultadoArrayString = consultasBBDD.nombresProductos("Taberna de Moe");
		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}
	@Test
	public void testGetPrecioVentaProductos() {
		resultadoEsperadoDouble = 3;
		resultadoDouble = consultasBBDD.precioVentaProductos("Cerveza", "Taberna de Moe");
		org.junit.Assert.assertEquals(resultadoEsperadoDouble, resultadoDouble, 0);
	}
}
