package TestModelo;

import org.junit.Test;

import Modelo.CarroCompra;
import Modelo.Pago;

public class PagoTest {

	private Pago pago = new Pago();
	private CarroCompra carroCompra = new CarroCompra();
	
	@Test
	public void testCrearTicket() {
		boolean resultadoBoolean = pago.crearTicket(1, "2021-03-12", "Z12345678", "PEDIDO");
		org.junit.Assert.assertEquals(false, resultadoBoolean);
	}
	
	@Test
	public void testCrearFactura() {
		boolean resultadoBoolean = pago.crearFactura(2, "A87654321");
		org.junit.Assert.assertEquals(false, resultadoBoolean);
	}
	
	@Test
	public void testCrearIdentificacion() {
		boolean resultadoBoolean = pago.crearIdentificacion("12345678P", "Jose", "Augusto");
		org.junit.Assert.assertEquals(false, resultadoBoolean);
	}
	
	@Test
	public void testCrearPedidoEntrega() {
		boolean resultadoBoolean = pago.crearPedido(3, "ENTREGA", "123");
		org.junit.Assert.assertEquals(true, resultadoBoolean);
	}
	
	@Test
	public void testCrearPedidoRecogida() {
		boolean resultadoBoolean = pago.crearPedido(4, "RECOGIDA", null);
		org.junit.Assert.assertEquals(true, resultadoBoolean);
	}
	
	@Test
	public void testCrearPedidoNinguno() {
		boolean resultadoBoolean = pago.crearPedido(5, "NINGUNO", null);
		org.junit.Assert.assertEquals(false, resultadoBoolean);
	}
	
	@Test
	public void testCrearIncluye() {
		carroCompra.anadirProducto("Cerveza", 5, 3);
		boolean resultadoBoolean = pago.crearIncluye(6, carroCompra.getCarroCompra());
		org.junit.Assert.assertEquals(false, resultadoBoolean);
	}
}
