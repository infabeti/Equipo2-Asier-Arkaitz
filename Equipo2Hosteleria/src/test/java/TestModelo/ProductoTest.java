package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Producto;

public class ProductoTest {
	
	private Producto p1 = new Producto("Garbanzos","Comida","30-01-2021",5,5,"GLUTEN",6);
	
	@Test
	public void testCreateProducto() {
		assertEquals("Garbanzos", p1.getNombre());
		assertEquals("Comida", p1.getTipo());
		assertEquals("30-01-2021", p1.getFechaCaducidad());
		assertEquals(5, p1.getPrecioCompra(), 0);
		assertEquals(5, p1.getPrecioVenta(), 0);
		assertEquals("GLUTEN", p1.getAlergeno());
		assertEquals(6, p1.getCantidad(), 0);
	}
	
	@Test
	public void testSetNombre() {
		p1.setNombre("Duff");
		assertEquals("Duff", p1.getNombre());
	}
	
	@Test
	public void testSetTipo() {
		p1.setTipo("Bebida");
		assertEquals("Bebida", p1.getTipo());
	}
	
	@Test
	public void testSetFechaCaducidad() {
		p1.setFechaCaducidad("26-06-2021");
		assertEquals("26-06-2021", p1.getFechaCaducidad());
	}
	
	@Test
	public void testSetPrecioCompra() {
		p1.setPrecioCompra(6);
		assertEquals(6, p1.getPrecioCompra(), 0);
	}
	
	@Test
	public void testPrecioVenta() {
		p1.setPrecioVenta(7);
		assertEquals(7, p1.getPrecioVenta(), 0);
	}
	
	@Test
	public void testAlergeno() {
		p1.setAlergeno("MARISCO");
		assertEquals("MARISCO", p1.getAlergeno());
	}
	
	@Test
	public void testCantidad() {
		p1.setCantidad(8);
		assertEquals(8, p1.getCantidad(),0);
	}
}
