package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Factura;

public class FacturaTest {

	private Factura f1 = new Factura(3, "87654321S");
	private Factura f2 = new Factura();
	
	@Test
	public void testCreateFactura() {
		assertEquals(3, f1.getNTransaccion());
		assertEquals("87654321S", f1.getNif());
	}
	
	@Test
	public void testSetNTransaccion() {
		f2.setNTransaccion(4);
		assertEquals(4, f2.getNTransaccion());
	}
	
	@Test
	public void testSetFecha() {
		f2.setFecha("01-10-2018");
		assertEquals("01-10-2018", f2.getFecha());
	}
	
	@Test
	public void testSetNif_local() {
		f2.setNif_local("12312312A");
		assertEquals("12312312A", f2.getNif_local());
	}
	
	@Test
	public void testSetNif() {
		f2.setNif("87654321G");
		assertEquals("87654321G", f2.getNif());
	}
}
