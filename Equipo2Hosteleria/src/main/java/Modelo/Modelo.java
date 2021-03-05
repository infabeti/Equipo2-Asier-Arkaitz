package Modelo;

import java.time.LocalDate;

public class Modelo {

	private ConsultasBBDD consultasBBDD;
	private CarroCompra carroCompra;
	private Ticket ticket1;
    private Factura factura1;
    private Pedido pedido1;
	LocalDate date = LocalDate.now();
	
	public Modelo() {
		consultasBBDD = new ConsultasBBDD();
		carroCompra = new CarroCompra();
		ticket1 = new Ticket();
		factura1 = new Factura();
		pedido1 = new Pedido();
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
	
	public Ticket getTicket() {
		return this.ticket1;
	}
	
	public void setTicket() {
    	String fecha = date.toString();
		ticket1=new Ticket(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), "TICKET");
	}
	
	public Factura getFactura() {
		return this.factura1;
	}
    
    public void setFactura(String nif, String nombre, String apellidos) {
    	String fecha = date.toString();
		factura1=new Factura(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), "FACTURA", nif, nombre, apellidos);
	}
	
	public Pedido getPedido() {
		return this.pedido1;
	}
    
    public void setPedido(String tipoPedido, String domicilio) {
    	String fecha = date.toString();
		pedido1=new Pedido(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), "PEDIDO", tipoPedido, domicilio);
	}
	
}
