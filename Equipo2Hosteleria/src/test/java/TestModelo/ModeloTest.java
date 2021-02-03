package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Modelo;

@SuppressWarnings("static-access")
public class ModeloTest {

	private Modelo funciones = new Modelo();
	private int resultado;
	private int resultadoEsperado;
	private int NTransaccion=1;
	
	@Test
	public void testMostrarNumeroTransaccion() {
		resultadoEsperado = NTransaccion;
		resultado = funciones.mostrarNumeroTransaccion().leerNumTrans();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	@Test
	public void testAumentarNumeroTransaccion() {
		resultadoEsperado = NTransaccion++;
		resultado = funciones.aumentarNumeroTransaccion().sumarNumTrans();
		org.junit.Assert.assertEquals(resultadoEsperado, resultado);
	}
	
}
