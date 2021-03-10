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
		assertEquals(pe1.getNTransaccion(), 5);
		assertEquals(pe1.getTipoPedido(), "ENTREGA");
		assertEquals(pe1.getDomicilio(), "South Park");
	}

	@Test
	public void testCreatePedido2() {
		assertEquals(pe3.getNTransaccion(), 5);
		assertEquals(pe3.getTipoPedido(), "RECOGIDA");
	}
	
	@Test
	public void testSetNTransaccion() {
		pe2.setNTransaccion(6);
		assertEquals(pe2.getNTransaccion(), 6);
	}
	
	@Test
	public void testSetTipoPedido() {
		pe2.setTipo("RECOGIDA");
		assertEquals(pe2.getTipo(), "RECOGIDA");
	}
	
	@Test
	public void testSetDomicilio() {
		pe2.setDomicilio("Irk");
		assertEquals(pe2.getDomicilio(), "Irk");
	}
}
