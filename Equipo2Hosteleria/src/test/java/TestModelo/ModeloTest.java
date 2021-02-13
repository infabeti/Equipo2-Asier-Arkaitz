package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import Modelo.Modelo;
import Modelo.ConsultasBBDD;
import Modelo.Makers;
import Modelo.CarroCompra;

@SuppressWarnings("unused")
public class ModeloTest {

	private Modelo modelo;
	private ConsultasBBDD consultasBBDDMock = mock(ConsultasBBDD.class);
	private CarroCompra carroCompraMock = mock(CarroCompra.class);
	private Makers makersMock = mock(Makers.class);
	
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