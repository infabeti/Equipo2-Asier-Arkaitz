package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Identificacion;

public class IdentificacionTest {

	private Identificacion i1 = new Identificacion("87654321S", "Homer", "Simpson");
	private Identificacion i2 = new Identificacion();
	
	@Test
	public void testCreateIdentificacion() {
		assertEquals("87654321S", i1.getNif());
		assertEquals("Homer", i1.getNombre());
		assertEquals("Simpson", i1.getApellidos());
	}
	
	@Test
	public void testSetNTransaccion() {
		i2.setNTransaccion(4);
		assertEquals(4, i2.getNTransaccion());
	}
	
	@Test
	public void testSetFecha() {
		i2.setFecha("01-10-2018");
		assertEquals("01-10-2018", i2.getFecha());
	}
	
	@Test
	public void testSetNif_local() {
		i2.setNif_local("12312312A");
		assertEquals("12312312A", i2.getNif_local());
	}
	
	@Test
	public void testSetNif() {
		i2.setNif("87654321G");
		assertEquals("87654321G", i2.getNif());
	}
	
	@Test
	public void testSetNombre() {
		i2.setNombre("Peter");
		assertEquals("Peter", i2.getNombre());
	}
	
	@Test
	public void testSetApellidos() {
		i2.setApellidos("Griffin");
		assertEquals("Griffin", i2.getApellidos());
	}
}
