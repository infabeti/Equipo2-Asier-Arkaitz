package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Local;

public class LocalTest {

	private Local l1 = new Local("12345678Z", "Bar de Moe", "Moe", "BAR", "Springfield");
	private Local l2 = new Local();
	
	@Test
	public void testCreateLocal() {
		assertEquals("12345678Z", l1.getNIF());
		assertEquals("Bar de Moe", l1.getNombre());
		assertEquals("Moe", l1.getNombrePropietario());
		assertEquals("BAR", l1.getTipo());
		assertEquals("Springfield", l1.getDireccion());
	}
	
	@Test
	public void testSetNIF() {
		l2.setNIF("87654321A");
		assertEquals("87654321A", l2.getNIF());
	}
	
	@Test
	public void testSetNombre() {
		l2.setNombre("Freddy Fazbears Pizza");
		assertEquals("Freddy Fazbears Pizza", l2.getNombre());
	}
	
	@Test
	public void testSetNombrePropietario() {
		l2.setNombrePropietario("William Afton");
		assertEquals("William Afton", l2.getNombrePropietario());
	}
	
	@Test
	public void testSetTipo() {
		l2.setTipo("RESTAURANTE");
		assertEquals("RESTAURANTE", l2.getTipo());
	}
	
	@Test
	public void testSetDireccion() {
		l2.setDireccion("Calle El Mundo de las Pizzas 4");
		assertEquals("Calle El Mundo de las Pizzas 4", l2.getDireccion());
	}
}
