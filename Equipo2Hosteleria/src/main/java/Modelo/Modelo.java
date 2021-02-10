package Modelo;

public class Modelo {

	private ConsultasBBDD consultasBBDD;
	private CarroCompra carroCompra;
	
	public Modelo() {
		consultasBBDD = new ConsultasBBDD();
		carroCompra = new CarroCompra();
	}
	
	public ConsultasBBDD getConsultasBBDD() {
		return this.consultasBBDD;
	}
	
	public void setConsultasBBDD(ConsultasBBDD consultasBBDD) {
		this.consultasBBDD = consultasBBDD;
	}
	
	public CarroCompra getCarroCompra() {
		return this.carroCompra;
	}
	
	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}
	
}
