package TestModelo;

import org.junit.Test;

import Modelo.CarroCompra;

@SuppressWarnings("unused")
public class CarroCompraTest {

	private CarroCompra carroCompra = new CarroCompra();
	private double resultadoDouble;
	private String resultadoString;
	private double resultadoEsperadoDouble;
	private String resultadoEsperadoString;
	
	@Test
	public void testListaCompra() {
		resultadoEsperadoString = "Hamburguesa";
		carroCompra.anadirProducto("Hamburguesa",5,2);
		Object[][] resultadoObjeto = carroCompra.getCarroCompra();
		org.junit.Assert.assertEquals(resultadoEsperadoString, resultadoObjeto[0][0]);
	}
	@Test
	public void testListaCompraRepe() {
		resultadoEsperadoString = "Hamburguesa";
		carroCompra.anadirProducto("Hamburguesa",5,2);
		Object[][] resultadoObjeto = carroCompra.getCarroCompra();
		carroCompra.anadirProducto("Hamburguesa",5,2);
		org.junit.Assert.assertEquals(resultadoEsperadoString, resultadoObjeto[0][0]);
	}

	@Test
	public void testListaCompraAumento() {
		resultadoEsperadoString = "Hamburguesa";
		carroCompra.anadirProducto("Hamburguesa",5,2);
		Object[][] resultadoObjeto = carroCompra.getCarroCompra();
		carroCompra.anadirProducto("Cerveza",5,1);
		org.junit.Assert.assertEquals(resultadoEsperadoString, resultadoObjeto[0][0]);
	}
	@Test
	public void testTotalCarro() {
		resultadoEsperadoDouble = 10;
		carroCompra.anadirProducto("Hamburguesa",5,2);
		resultadoDouble = carroCompra.getTotalCarro();
		org.junit.Assert.assertEquals(resultadoEsperadoDouble, resultadoDouble, 1);
	}
	@Test
	public void testResetCarroDouble() {
		resultadoEsperadoDouble = 0;
		carroCompra.borrarCarroCompra();
		resultadoDouble = carroCompra.getTotalCarro();
		org.junit.Assert.assertEquals(resultadoEsperadoDouble, resultadoDouble, 1);
	}
}
