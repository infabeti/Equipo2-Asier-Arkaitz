package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Ticket;

public class TicketTest {

	private Ticket t1 = new Ticket(1, "26-06-2021", "12345678Z", "TICKET");
	private Ticket t2 = new Ticket();
	
	@Test
	public void testCreateTicket() {
		assertEquals(1, t1.getNTransaccion());
		assertEquals("26-06-2021", t1.getFecha());
		assertEquals("12345678Z", t1.getNif_local());
		assertEquals("TICKET", t1.getTipo());
	}
	
	@Test
	public void testSetNTransaccion() {
		t2.setNTransaccion(2);
		assertEquals(2, t2.getNTransaccion());
	}
	
	@Test
	public void testSetFecha() {
		t2.setFecha("26-06-2022");
		assertEquals("26-06-2022", t2.getFecha());
	}
	
	@Test
	public void testSetNif_local() {
		t2.setNif_local("12345678A");
		assertEquals("12345678A", t2.getNif_local());
	}
	
	@Test
	public void testSetTipo() {
		t2.setTipo("FACTURA");
		assertEquals("FACTURA", t2.getTipo());
	}
}
