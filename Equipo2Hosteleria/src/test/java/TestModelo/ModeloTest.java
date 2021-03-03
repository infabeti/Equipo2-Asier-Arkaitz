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
		modelo.setConsultasBBDD(consultasBBDD);
		
		assertEquals(modelo.getConsultasBBDD(), consultasBBDD);
	}

	@Test
	public void setCarroCompraTest() {
		modelo = new Modelo();
		modelo.setCarroCompra(carroCompra);
		
		assertEquals(modelo.getCarroCompra(), carroCompra);
	}
}