package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Incluye;

public class IncluyeTest {

	private Incluye i1 = new Incluye("Cerveza", 1, 3, 5);
	private Incluye i2 = new Incluye();
	
	@Test
	public void testCreateIncluye() {
		assertEquals(i1.getNombreProducto(), "Cerveza");
		assertEquals(i1.getNtransaccion(), 1);
		assertEquals(i1.getCantidad(), 3);
		assertEquals(i1.getPrecio(), 5, 0);
	}
	
	@Test
	public void testSetNombreProducto() {
		i2.setNombreProducto("Hamburguesa");
		assertEquals(i2.getNombreProducto(), "Hamburguesa");
	}
	
	@Test
	public void testSetNtransaccion() {
		i2.setNTransaccion(2);
		assertEquals(i2.getNtransaccion(), 2);
	}
	
	@Test
	public void testSetCantidad() {
		i2.setCantidad(4);
		assertEquals(i2.getCantidad(), 4);
	}
	
	@Test
	public void testSetPrecio() {
		i2.setPrecio(6);
		assertEquals(i2.getPrecio(), 6, 0);
	}
}
