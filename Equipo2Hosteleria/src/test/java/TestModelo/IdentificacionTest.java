package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Identificacion;

public class IdentificacionTest {

	private Identificacion i1 = new Identificacion("87654321S", "Homer", "Simpson");
	private Identificacion i2 = new Identificacion();
	
	@Test
	public void testCreateFactura() {
		assertEquals(i1.getNif(), "87654321S");
		assertEquals(i1.getNombre(), "Homer");
		assertEquals(i1.getApellidos(), "Simpson");
		
		i2.setNif("87654321G");
		i2.setNombre("Peter");
		i2.setApellidos("Griffin");
		
		assertEquals(i2.getNif(), "87654321G");
		assertEquals(i2.getNombre(), "Peter");
		assertEquals(i2.getApellidos(), "Griffin");
	}
	
	@Test
	public void testSetNTransaccion() {
		i2.setNTransaccion(4);
		assertEquals(i2.getNTransaccion(), 4);
	}
	
	@Test
	public void testSetFecha() {
		i2.setFecha("01-10-2018");
		assertEquals(i2.getFecha(), "01-10-2018");
	}
	
	@Test
	public void testSetNif_local() {
		i2.setNif_local("12312312A");
		assertEquals(i2.getNif_local(), "12312312A");
	}
	
	@Test
	public void testSetNif() {
		i2.setNif("87654321G");
		assertEquals(i2.getNif(), "87654321G");
	}
	
	@Test
	public void testSetNombre() {
		i2.setNombre("Peter");
		assertEquals(i2.getNombre(), "Peter");
	}
	
	@Test
	public void testSetApellidos() {
		i2.setApellidos("Griffin");
		assertEquals(i2.getApellidos(), "Griffin");
	}
}
