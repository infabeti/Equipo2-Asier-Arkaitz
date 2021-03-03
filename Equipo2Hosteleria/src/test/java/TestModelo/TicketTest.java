package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Ticket;

public class TicketTest {

	private Ticket t1 = new Ticket(1, "26-06-2021", "12345678Z");
	private Ticket t2 = new Ticket();
	
	@Test
	public void testCreateTicket() {
		assertEquals(t1.getNTransaccion(), 1);
		assertEquals(t1.getFecha(), "26-06-2021");
		assertEquals(t1.getNif_local(), "12345678Z");
	}
	
	@Test
	public void testSetNTransaccion() {
		t2.setNTransaccion(2);
		assertEquals(t2.getNTransaccion(), 2);
	}
	
	@Test
	public void testSetFecha() {
		t2.setFecha("26-06-2022");
		assertEquals(t2.getFecha(), "26-06-2022");
	}
	
	@Test
	public void testSetNif_local() {
		t2.setNif_local("12345678A");
		assertEquals(t2.getNif_local(), "12345678A");
	}
}
