package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.ProductoEscogido;

public class ProductoEscogidoTest {

	private ProductoEscogido p1 = new ProductoEscogido();
	
	@Test
	public void testSetNombre() {
		p1.setNombre("NukaCola");
		assertEquals(p1.getNombre(), "NukaCola");
	}
	
	@Test
	public void testSetCantidad() {
		p1.setCantidad(3);
		assertEquals(p1.getCantidad(), 3);
	}
	
	@Test
	public void testSetPrecioVenta() {
		p1.setPrecioVenta(5);
		assertEquals(p1.getPrecioVenta(), 5, 0);
	}
	
	@Test
	public void testSetPrecioTotal() {
		p1.setPrecioTotal(6);
		assertEquals(p1.getPrecioTotal(), 6, 0);
	}
}
