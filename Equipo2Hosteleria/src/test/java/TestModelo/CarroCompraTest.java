package TestModelo;

import org.junit.Test;

import Modelo.CarroCompra;

@SuppressWarnings("unused")
public class CarroCompraTest {

	private CarroCompra carroCompra = new CarroCompra();
	private int resultado;
	private double resultadoDouble;
	private String resultadoString;
	private int resultadoEsperado;
	private double resultadoEsperadoDouble;
	private String resultadoEsperadoString;
	private int NTransaccion=1;
	
	@Test
	public void testListaCompra() {
		resultadoEsperadoString = "Hamburguesa - Cantidad: "+2+" - Precio: "+5.0+"€ - Total: "+10.0+"€\n";
		carroCompra.anadirProductos("Hamburguesa",5,2);
		resultadoString = carroCompra.leerLista();
		org.junit.Assert.assertEquals(resultadoEsperadoString, resultadoString);
	}
	@Test
	public void testTotalCarro() {
		resultadoEsperadoDouble = 10;
		carroCompra.anadirCoste(5,2);
		resultadoDouble = carroCompra.leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperadoDouble, resultadoDouble, 1);
	}
	@Test
	public void testResetCarroString() {
		resultadoEsperadoString = "";
		carroCompra.borrarListaCompra();
		resultadoString = carroCompra.leerLista();
		org.junit.Assert.assertEquals(resultadoEsperadoString, resultadoString);
	}
	@Test
	public void testResetCarroDouble() {
		resultadoEsperadoDouble = 0;
		carroCompra.borrarListaCompra();
		resultadoDouble = carroCompra.leerCoste();
		org.junit.Assert.assertEquals(resultadoEsperadoDouble, resultadoDouble, 1);
	}
}
