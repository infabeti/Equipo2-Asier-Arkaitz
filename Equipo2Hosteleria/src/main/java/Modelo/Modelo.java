package Modelo;

import java.time.LocalDate;

public class Modelo {

	private ConsultasBBDD consultasBBDD;
	private ConexionMySQL conexionMySQL;
	private CarroCompra carroCompra;
	private Cuenta cuenta;
	private Pago pago;
	LocalDate date = LocalDate.now();
	
	public Modelo() {
		consultasBBDD = new ConsultasBBDD();
		conexionMySQL = new ConexionMySQL();
		carroCompra = new CarroCompra();
		cuenta = new Cuenta();
		pago = new Pago();
	}
	
	public ConsultasBBDD getConsultasBBDD() {
		return this.consultasBBDD;
	}
	
	public void setConsultasBBDD(ConsultasBBDD consultasBBDD) {
		this.consultasBBDD = consultasBBDD;
	}

	public ConexionMySQL getConexionMySQL() {
		return conexionMySQL;
	}

	public void setConexionMySQL(ConexionMySQL conexionMySQL) {
		this.conexionMySQL = conexionMySQL;
	}
	
	public CarroCompra getCarroCompra() {
		return this.carroCompra;
	}
	
	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
}
