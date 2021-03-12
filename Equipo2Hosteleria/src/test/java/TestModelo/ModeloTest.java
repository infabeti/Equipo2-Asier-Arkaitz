package TestModelo;

import static org.junit.Assert.*;
import org.junit.Test;

import Modelo.Modelo;
import Modelo.Pago;
import Modelo.ConsultasBBDD;
import Modelo.Cuenta;
import Modelo.CarroCompra;
import Modelo.ConexionMySQL;

public class ModeloTest {

	private Modelo modelo;
	private ConsultasBBDD consultasBBDD = new ConsultasBBDD();
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	private CarroCompra carroCompra = new CarroCompra();
	private Cuenta cuenta = new Cuenta();
	private Pago pago = new Pago();
	
	@Test
	public void setConsultasBBDDTest() {
		modelo = new Modelo();
		modelo.setConsultasBBDD(consultasBBDD);
		
		assertEquals(modelo.getConsultasBBDD(), consultasBBDD);
	}
	
	@Test
	public void setConexionMySQLTest() {
		modelo = new Modelo();
		modelo.setConexionMySQL(conexionMySQL);
		
		assertEquals(modelo.getConexionMySQL(), conexionMySQL);
	}

	@Test
	public void setCarroCompraTest() {
		modelo = new Modelo();
		modelo.setCarroCompra(carroCompra);
		
		assertEquals(modelo.getCarroCompra(), carroCompra);
	}

	@Test
	public void setCuentaTest() {
		modelo = new Modelo();
		modelo.setCuenta(cuenta);
		
		assertEquals(modelo.getCuenta(), cuenta);
	}

	@Test
	public void setPagoTest() {
		modelo = new Modelo();
		modelo.setPago(pago);
		
		assertEquals(modelo.getPago(), pago);
	}
}