package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Incluye;

public class IncluyeTest {

	private Incluye i1 = new Incluye("Cerveza", 1, 3, 5);
	private Incluye i2 = new Incluye();
	
	@Test
	public void testCreateIncluye() {
		assertEquals("Cerveza", i1.getNombreProducto());
		assertEquals(1, i1.getNtransaccion());
		assertEquals(3, i1.getCantidad());
		assertEquals(5, i1.getPrecio(), 0);
	}
	
	@Test
	public void testSetNombreProducto() {
		i2.setNombreProducto("Hamburguesa");
		assertEquals("Hamburguesa", i2.getNombreProducto());
	}
	
	@Test
	public void testSetNtransaccion() {
		i2.setNTransaccion(2);
		assertEquals(2, i2.getNtransaccion());
	}
	
	@Test
	public void testSetCantidad() {
		i2.setCantidad(4);
		assertEquals(4, i2.getCantidad());
	}
	
	@Test
	public void testSetPrecio() {
		i2.setPrecio(6);
		assertEquals(6, i2.getPrecio(), 0);
	}
}
