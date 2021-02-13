package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import Modelo.Factura;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Ticket;

@SuppressWarnings("unused")
public class ConstructoresTest {

	private Producto p1;
	private Ticket t1;
	private Ticket t2;
	private Factura f1;
	private Factura f2;
	private Pedido pe1;
	private Pedido pe2;
	
	@Test
	public void createProductoTest() {
		p1 = new Producto("Garbanzos","Comida","30-01-2021",5,5);
		
		assertEquals(p1.getNombre(), "Garbanzos");
		assertEquals(p1.getTipo(), "Comida");
		assertEquals(p1.getFechaCaducidad(), "30-01-2021");
		assertEquals(p1.getPrecioCompra(), 5, 1);
		assertEquals(p1.getPrecioVenta(), 5, 1);
		
		p1.setNombre("Duff");
		p1.setTipo("Bebida");
		p1.setFechaCaducidad("26-06-2021");
		p1.setPrecioCompra(6);
		p1.setPrecioVenta(7);
		
		assertEquals(p1.getNombre(), "Duff");
		assertEquals(p1.getTipo(), "Bebida");
		assertEquals(p1.getFechaCaducidad(), "26-06-2021");
		assertEquals(p1.getPrecioCompra(), 6, 1);
		assertEquals(p1.getPrecioVenta(), 7, 1);
	}
	@Test
	public void createTicketTest() {
		t1 = new Ticket(1, "26-06-2021", "12345678Z");
		t2 = new Ticket();
		
		assertEquals(t1.getNTransaccion(), 1);
		assertEquals(t1.getFecha(), "26-06-2021");
		assertEquals(t1.getNif_local(), "12345678Z");
		
		t2.setNTransaccion(2);
		t2.setFecha("26-06-2022");
		t2.setNif_local("12345678A");
		
		assertEquals(t2.getNTransaccion(), 2);
		assertEquals(t2.getFecha(), "26-06-2022");
		assertEquals(t2.getNif_local(), "12345678A");
	}
	@Test
	public void createFacturaTest() {
		f1 = new Factura(3, "26-06-2020", "12345678P", "87654321S", "Homer", "Simpson");
		f2 = new Factura();
		
		assertEquals(f1.getNTransaccion(), 3);
		assertEquals(f1.getFecha(), "26-06-2020");
		assertEquals(f1.getNif_local(), "12345678P");
		assertEquals(f1.getNif(), "87654321S");
		assertEquals(f1.getNombre(), "Homer");
		assertEquals(f1.getApellidos(), "Simpson");
		
		f2.setNTransaccion(4);
		f2.setFecha("01-10-2018");
		f2.setNif_local("12312312A");
		f2.setNif("87654321G");
		f2.setNombre("Peter");
		f2.setApellidos("Griffin");
		
		assertEquals(f2.getNTransaccion(), 4);
		assertEquals(f2.getFecha(), "01-10-2018");
		assertEquals(f2.getNif_local(), "12312312A");
		assertEquals(f2.getNif(), "87654321G");
		assertEquals(f2.getNombre(), "Peter");
		assertEquals(f2.getApellidos(), "Griffin");
	}
	@Test
	public void createPedidoTest() {
		pe1 = new Pedido(5, "26-06-2000", "12354678P", "ENTREGA", "South Park");
		pe2 = new Pedido();
		
		assertEquals(pe1.getNTransaccion(), 5);
		assertEquals(pe1.getFecha(), "26-06-2000");
		assertEquals(pe1.getNif_local(), "12354678P");
		assertEquals(pe1.getTipo(), "ENTREGA");
		assertEquals(pe1.getDomicilio(), "South Park");
		
		pe2.setNTransaccion(6);
		pe2.setFecha("02-10-2019");
		pe2.setNif_local("12312312C");
		pe2.setTipo("RECOGIDA");
		pe2.setDomicilio("Irk");
		
		assertEquals(pe2.getNTransaccion(), 6);
		assertEquals(pe2.getFecha(), "02-10-2019");
		assertEquals(pe2.getNif_local(), "12312312C");
		assertEquals(pe2.getTipo(), "RECOGIDA");
		assertEquals(pe2.getDomicilio(), "Irk");
	}
}