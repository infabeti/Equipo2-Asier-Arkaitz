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
		NTransaccion=Modelo.NTransaccion;
		resultadoEsperado = NTransaccion;
		resultado = funciones.MostrarNumeroTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testAumentarNumeroTransaccion() {
		NTransaccion=Modelo.NTransaccion;
		resultadoEsperado = NTransaccion++;
		resultado = funciones.AumentarNumeroTransaccion();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	
}
