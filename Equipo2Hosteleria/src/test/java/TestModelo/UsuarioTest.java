package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Usuario;

public class UsuarioTest {

	private Usuario u1 = new Usuario("12345678A", "123", "John", "Smith", "87654321Z");
	private Usuario u2 = new Usuario();
	private Usuario u3 = new Usuario("12345678P", "1234");
	
	@Test
	public void testCreateUsuario() {
		org.junit.Assert.assertEquals("12345678A", u1.getDni());
		org.junit.Assert.assertEquals("123", u1.getContrasena());
		org.junit.Assert.assertEquals("John", u1.getNombre());
		org.junit.Assert.assertEquals("Smith", u1.getApellidos());
		org.junit.Assert.assertEquals("87654321Z", u1.getNif_local());
	}
	
	@Test
	public void testCreateUsuarioAlt() {
		org.junit.Assert.assertEquals("12345678P", u3.getDni());
		org.junit.Assert.assertEquals("1234", u3.getContrasena());
	}
	
	@Test
	public void testSetDni() {
		u2.setDni("12345678A");
		assertEquals(u2.getDni(), "12345678A");
	}
	
	@Test
	public void testSetContrasena() {
		u2.setContrasena("123");
		assertEquals(u2.getContrasena(), "123");
	}
	
	@Test
	public void testSetNombre() {
		u2.setNombre("John");
		assertEquals(u2.getNombre(), "John");
	}
	
	@Test
	public void testSetApellidos() {
		u2.setApellidos("Smith");
		assertEquals(u2.getApellidos(), "Smith");
	}
	
	@Test
	public void testSetNif_local() {
		u2.setNif_local("87654321Z");
		assertEquals(u2.getNif_local(), "87654321Z");
	}
}
