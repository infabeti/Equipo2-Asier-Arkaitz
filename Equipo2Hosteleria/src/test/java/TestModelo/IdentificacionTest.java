package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Factura;

public class IdentificacionTest {

	private Factura f1 = new Factura(3, "26-06-2020", "12345678P", "87654321S", "Homer", "Simpson");
	private Factura f2 = new Factura();
	
	@Test
	public void testCreateFactura() {
		assertEquals(f1.getNTransaccion(), 3);
		assertEquals(f1.getFecha(), "26-06-2020");
		assertEquals(f1.getNif_local(), "12345678P");
		assertEquals(f1.getNif(), "87654321S");
		assertEquals(f1.getNombre(), "Homer");
		assertEquals(f1.getApellidos(), "Simpson");
		
		f2.setNif("87654321G");
		f2.setNombre("Peter");
		f2.setApellidos("Griffin");
		
		assertEquals(f2.getNif(), "87654321G");
		assertEquals(f2.getNombre(), "Peter");
		assertEquals(f2.getApellidos(), "Griffin");
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
	
	@Test
	public void testSetNombre() {
		f2.setNombre("Peter");
		assertEquals(f2.getNombre(), "Peter");
	}
	
	@Test
	public void testSetApellidos() {
		f2.setApellidos("Griffin");
		assertEquals(f2.getApellidos(), "Griffin");
	}
}
