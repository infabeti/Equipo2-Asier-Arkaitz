package TestModelo;

import org.junit.Test;

import Modelo.Cuenta;

@SuppressWarnings("unused")
public class CuentaTest {

	private Cuenta cuenta = new Cuenta();
	private double resultadoDouble;
	private String resultadoString;
	private double resultadoEsperadoDouble;
	private String resultadoEsperadoString;
	
	@Test
	public void testCrearUsuario() {
		boolean resultadoBoolean = cuenta.crearUsuario("12345678A", "123", "John", "Smith", "87654321Z");
		org.junit.Assert.assertEquals(false, resultadoBoolean);
	}
	
	@Test
	public void testIniciarUsuario() {
		boolean resultadoBoolean = cuenta.iniciarUsuario("11111111A", "111");
		org.junit.Assert.assertEquals(true, resultadoBoolean);
		resultadoBoolean = cuenta.iniciarUsuario("11111111B", "112");
		org.junit.Assert.assertEquals(false, resultadoBoolean);
	}
}
