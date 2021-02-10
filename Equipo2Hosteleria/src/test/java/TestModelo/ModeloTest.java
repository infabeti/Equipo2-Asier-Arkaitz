package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import Modelo.Modelo;
import Modelo.ConsultasBBDD;
import Modelo.CarroCompra;

public class ModeloTest {

	private Modelo modelo;
	private ConsultasBBDD consultasBBDDMock = mock(ConsultasBBDD.class);
	private ConsultasBBDD consultasBBDDMock2 = mock(ConsultasBBDD.class);
	private CarroCompra carroCompraMock = mock(CarroCompra.class);
	private CarroCompra carroCompraMock2 = mock(CarroCompra.class);
	
	@Test
	public void constructorModeloTest() {
		modelo = new Modelo(consultasBBDDMock, carroCompraMock);
		
		assertEquals(modelo.getConsultasBBDD(), consultasBBDDMock);
		assertEquals(modelo.getCarroCompra(), carroCompraMock);
	}

	@Test
	public void setConsultasBBDDTest() {
		modelo = new Modelo(consultasBBDDMock, null);
		modelo.setConsultasBBDD(consultasBBDDMock2);
		
		assertEquals(modelo.getConsultasBBDD(), consultasBBDDMock2);
	}

	@Test
	public void setCarroCompraTest() {
		modelo = new Modelo(null, carroCompraMock);
		modelo.setCarroCompra(carroCompraMock2);
		
		assertEquals(modelo.getCarroCompra(), carroCompraMock2);
	}
}