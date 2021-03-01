package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Producto;

public class ProductoTest {

	private Producto p1 = new Producto("Garbanzos","Comida","30-01-2021",5,5);
	
	@Test
	public void testCreateProducto() {
		assertEquals(p1.getNombre(), "Garbanzos");
		assertEquals(p1.getTipo(), "Comida");
		assertEquals(p1.getFechaCaducidad(), "30-01-2021");
		assertEquals(p1.getPrecioCompra(), 5, 1);
		assertEquals(p1.getPrecioVenta(), 5, 1);
	}
	
	@Test
	public void testSetNombre() {
		p1.setNombre("Duff");
		assertEquals(p1.getNombre(), "Duff");
	}
	
	@Test
	public void testSetTipo() {
		p1.setTipo("Bebida");
		assertEquals(p1.getTipo(), "Bebida");
	}
	
	@Test
	public void testSetFechaCaducidad() {
		p1.setFechaCaducidad("26-06-2021");
		assertEquals(p1.getFechaCaducidad(), "26-06-2021");
	}
	
	@Test
	public void testSetPrecioCompra() {
		p1.setPrecioCompra(6);
		assertEquals(p1.getPrecioCompra(), 6, 0);
	}
	
	@Test
	public void testPrecioVenta() {
		p1.setPrecioVenta(7);
		assertEquals(p1.getPrecioVenta(), 7, 0);
	}
}
