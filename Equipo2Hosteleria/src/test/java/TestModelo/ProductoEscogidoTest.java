package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.ProductoEscogido;

public class ProductoEscogidoTest {

	private ProductoEscogido p1 = new ProductoEscogido();
	
	@Test
	public void testSetNombre() {
		p1.setNombre("NukaCola");
		assertEquals("NukaCola", p1.getNombre());
	}
	
	@Test
	public void testSetCantidad() {
		p1.setCantidad(3);
		assertEquals(3, p1.getCantidad());
	}
	
	@Test
	public void testSetPrecioVenta() {
		p1.setPrecioVenta(5);
		assertEquals(5, p1.getPrecioVenta(), 0);
	}
	
	@Test
	public void testSetPrecioTotal() {
		p1.setPrecioTotal(6);
		assertEquals(6, p1.getPrecioTotal(), 0);
	}
}
