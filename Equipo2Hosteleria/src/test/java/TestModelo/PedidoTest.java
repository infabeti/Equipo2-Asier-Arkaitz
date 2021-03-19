package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Pedido;

public class PedidoTest {

	private Pedido pe1 = new Pedido(5, "ENTREGA", "South Park");
	private Pedido pe2 = new Pedido();
	private Pedido pe3 = new Pedido(5, "RECOGIDA");
	
	@Test
	public void testCreatePedido1() {
		assertEquals(5, pe1.getNTransaccion());
		assertEquals("ENTREGA", pe1.getTipoPedido());
		assertEquals("South Park", pe1.getDomicilio());
	}

	@Test
	public void testCreatePedido2() {
		assertEquals(5, pe3.getNTransaccion());
		assertEquals("RECOGIDA", pe3.getTipoPedido());
	}
	
	@Test
	public void testSetNTransaccion() {
		pe2.setNTransaccion(6);
		assertEquals(6, pe2.getNTransaccion());
	}
	
	@Test
	public void testSetTipoPedido() {
		pe2.setTipo("RECOGIDA");
		assertEquals("RECOGIDA", pe2.getTipo());
	}
	
	@Test
	public void testSetDomicilio() {
		pe2.setDomicilio("Irk");
		assertEquals("Irk", pe2.getDomicilio());
	}
}
