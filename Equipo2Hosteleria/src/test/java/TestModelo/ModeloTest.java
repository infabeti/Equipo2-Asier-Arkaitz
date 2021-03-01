package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import Modelo.Modelo;
import Modelo.ConsultasBBDD;
import Modelo.CarroCompra;

public class ModeloTest {

	private Modelo modelo;
	private ConsultasBBDD consultasBBDD = new ConsultasBBDD();
	private CarroCompra carroCompra = new CarroCompra();
	
	@Test
	public void setConsultasBBDDTest() {
		modelo = new Modelo();
		modelo.setConsultasBBDD(consultasBBDDMock);
		
		assertEquals(modelo.getConsultasBBDD(), consultasBBDDMock);
	}

	@Test
	public void setCarroCompraTest() {
		modelo = new Modelo();
		modelo.setCarroCompra(carroCompraMock);
		
		assertEquals(modelo.getCarroCompra(), carroCompraMock);
	}

	@Test
	public void setMakersTest() {
		modelo = new Modelo();
		modelo.setMakers(makersMock);
		
		assertEquals(modelo.getMakers(), makersMock);
	}
}