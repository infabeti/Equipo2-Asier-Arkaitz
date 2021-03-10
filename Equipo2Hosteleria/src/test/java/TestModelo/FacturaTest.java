package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Factura;

public class FacturaTest {

	private Factura f1 = new Factura(3, "87654321S");
	private Factura f2 = new Factura();
	
	@Test
	public void testCreateFactura() {
		assertEquals(f1.getNTransaccion(), 3);
		assertEquals(f1.getNif(), "87654321S");
		
		f2.setNif("87654321G");
		
		assertEquals(f2.getNif(), "87654321G");
	}
	
	@Test
	public void testSetNTransaccion() {
		f2.setNTransaccion(4);
		assertEquals(f2.getNTransaccion(), 4);
	}
	
	@Test
	public void testSetFecha() {
		f2.setFecha("01-10-2018");
		assertEquals(f2.getFecha(), "01-10-2018");
	}
	
	@Test
	public void testSetNif_local() {
		f2.setNif_local("12312312A");
		assertEquals(f2.getNif_local(), "12312312A");
	}
	
	@Test
	public void testSetNif() {
		f2.setNif("87654321G");
		assertEquals(f2.getNif(), "87654321G");
	}
}
