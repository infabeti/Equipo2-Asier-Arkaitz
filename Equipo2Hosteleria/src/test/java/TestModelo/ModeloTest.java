package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Modelo;

public class ModeloTest {

	private Modelo funciones = new Modelo();
	private int resultado;
	private int resultadoEsperado;
	private int NTransaccion;
	
	@Test
	public void testMostrarNumeroTransaccion() {
		resultadoEsperado = 1;
		resultado = funciones.MostrarNumeroTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	
	public void testAumentarNumeroTransaccion() {
		NTransaccion = funciones.MostrarNumeroTransaccion();
		resultadoEsperado = 2;
		resultado = funciones.AumentarNumeroTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	
}
