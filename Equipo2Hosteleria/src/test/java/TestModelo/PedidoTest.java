package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Pedido;

public class PedidoTest {

	private Pedido pe1 = new Pedido(5, "26-06-2000", "12354678P", "ENTREGA", "South Park");
	private Pedido pe2 = new Pedido();
	
	@Test
	public void testCreatePedido() {
		assertEquals(pe1.getNTransaccion(), 5);
		assertEquals(pe1.getFecha(), "26-06-2000");
		assertEquals(pe1.getNif_local(), "12354678P");
		assertEquals(pe1.getTipo(), "ENTREGA");
		assertEquals(pe1.getDomicilio(), "South Park");
	}
	
	@Test
	public void testSetNTransaccion() {
		pe2.setNTransaccion(6);
		assertEquals(pe2.getNTransaccion(), 6);
	}
	
	@Test
	public void testSetFecha() {
		pe2.setFecha("02-10-2019");
		assertEquals(pe2.getFecha(), "02-10-2019");
	}
	
	@Test
	public void testSetNif_local() {
		pe2.setNif_local("12312312C");
		assertEquals(pe2.getNif_local(), "12312312C");
	}
	
	@Test
	public void testSetTipo() {
		pe2.setTipo("RECOGIDA");
		assertEquals(pe2.getTipo(), "RECOGIDA");
	}
	
	@Test
	public void testSetDomicilio() {
		pe2.setDomicilio("Irk");
		assertEquals(pe2.getDomicilio(), "Irk");
	}
}
