package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Local;

public class LocalTest {

	private Local l1 = new Local("12345678Z", "Bar de Moe", "Moe", "BAR", "Springfield");
	private Local l2 = new Local();
	
	@Test
	public void testCreateLocal() {
		assertEquals(l1.getNIF(), "12345678Z");
		assertEquals(l1.getNombre(), "Bar de Moe");
		assertEquals(l1.getNombrePropietario(), "Moe");
		assertEquals(l1.getTipo(), "BAR");
		assertEquals(l1.getDireccion(), "Springfield");
	}
	
	@Test
	public void testSetNIF() {
		l2.setNIF("87654321A");
		assertEquals(l2.getNIF(), "87654321A");
	}
	
	@Test
	public void testSetNombre() {
		l2.setNombre("Freddy Fazbears Pizza");
		assertEquals(l2.getNombre(), "Freddy Fazbears Pizza");
	}
	
	@Test
	public void testSetNombrePropietario() {
		l2.setNombrePropietario("William Afton");
		assertEquals(l2.getNombrePropietario(), "William Afton");
	}
	
	@Test
	public void testSetTipo() {
		l2.setTipo("RESTAURANTE");
		assertEquals(l2.getTipo(), "RESTAURANTE");
	}
	
	@Test
	public void testSetDireccion() {
		l2.setDireccion("Calle El Mundo de las Pizzas 4");
		assertEquals(l2.getDireccion(), "Calle El Mundo de las Pizzas 4");
	}
}
