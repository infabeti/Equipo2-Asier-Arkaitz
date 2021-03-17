package TestModelo;

import static org.junit.Assert.*;
import org.junit.Test;

import Modelo.Modelo;
import Modelo.Pago;
import Modelo.ConsultasBBDD;
import Modelo.Cuenta;
import Modelo.CarroCompra;
import Modelo.ConexionMySQL;
import Modelo.ConexionMySQL_IdentIncluye;
import Modelo.ConexionMySQL_Local;
import Modelo.ConexionMySQL_Pedido;
import Modelo.ConexionMySQL_TicketFactura;
import Modelo.ConexionMySQL_Usuarios;

public class ModeloTest {

	private Modelo modelo;
	private ConsultasBBDD consultasBBDD = new ConsultasBBDD();
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	private ConexionMySQL_IdentIncluye conexionMySQL_IdentIncluye = new ConexionMySQL_IdentIncluye();
	private ConexionMySQL_Local conexionMySQL_Local = new ConexionMySQL_Local();
	private ConexionMySQL_Pedido conexionMySQL_Pedido = new ConexionMySQL_Pedido();
	private ConexionMySQL_TicketFactura conexionMySQL_TicketFactura = new ConexionMySQL_TicketFactura();
	private ConexionMySQL_Usuarios conexionMySQL_Usuarios = new ConexionMySQL_Usuarios();
	private CarroCompra carroCompra = new CarroCompra();
	private Cuenta cuenta = new Cuenta();
	private Pago pago = new Pago();
	
	@Test
	public void setConsultasBBDDTest() {
		modelo = new Modelo();
		modelo.setConsultasBBDD(consultasBBDD);
		
		assertEquals(consultasBBDD, modelo.getConsultasBBDD());
	}
	
	@Test
	public void setConexionMySQLTest() {
		modelo = new Modelo();
		modelo.setConexionMySQL(conexionMySQL);
		
		assertEquals(conexionMySQL, modelo.getConexionMySQL());
	}
	
	@Test
	public void setConexionMySQL_IdentIncluyeTest() {
		modelo = new Modelo();
		modelo.setConexionMySQL_IdentIncluye(conexionMySQL_IdentIncluye);
		
		assertEquals(conexionMySQL_IdentIncluye, modelo.getConexionMySQL_IdentIncluye());
	}
	
	@Test
	public void setConexionMySQL_LocalTest() {
		modelo = new Modelo();
		modelo.setConexionMySQL_Local(conexionMySQL_Local);
		
		assertEquals(conexionMySQL_Local, modelo.getConexionMySQL_Local());
	}
	
	@Test
	public void setConexionMySQL_PedidoTest() {
		modelo = new Modelo();
		modelo.setConexionMySQL_Pedido(conexionMySQL_Pedido);
		
		assertEquals(conexionMySQL_Pedido, modelo.getConexionMySQL_Pedido());
	}
	
	@Test
	public void setConexionMySQL_TicketFacturaTest() {
		modelo = new Modelo();
		modelo.setConexionMySQL_TicketFactura(conexionMySQL_TicketFactura);
		
		assertEquals(conexionMySQL_TicketFactura, modelo.getConexionMySQL_TicketFactura());
	}
	
	@Test
	public void setConexionMySQL_UsuariosTest() {
		modelo = new Modelo();
		modelo.setConexionMySQL_Usuarios(conexionMySQL_Usuarios);
		
		assertEquals(conexionMySQL_Usuarios, modelo.getConexionMySQL_Usuarios());
	}

	@Test
	public void setCarroCompraTest() {
		modelo = new Modelo();
		modelo.setCarroCompra(carroCompra);
		
		assertEquals(carroCompra, modelo.getCarroCompra());
	}

	@Test
	public void setCuentaTest() {
		modelo = new Modelo();
		modelo.setCuenta(cuenta);
		
		assertEquals(cuenta, modelo.getCuenta());
	}

	@Test
	public void setPagoTest() {
		modelo = new Modelo();
		modelo.setPago(pago);
		
		assertEquals(pago, modelo.getPago());
	}

	@Test
	public void setLocalTest() {
		modelo = new Modelo();
		modelo.setLocal("12345678A");
		
		assertEquals("B95970901", modelo.getLocal().getNIF());
	}
}