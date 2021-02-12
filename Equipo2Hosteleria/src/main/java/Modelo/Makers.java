package Modelo;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Makers {

	private ConsultasBBDD consultasBBDD;
	private Ticket ticket1=new Ticket();
    private Factura factura1=new Factura();
    private Pedido pedido1=new Pedido();
	LocalDate date = LocalDate.now();
    
    public void makeTicket() {
    	consultasBBDD = new ConsultasBBDD();
    	String fecha = date.toString();
		ticket1=new Ticket(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal());
	}
    
    public void makeFactura(String nif, String nombre, String apellidos) {
    	consultasBBDD = new ConsultasBBDD();
    	String fecha = date.toString();
		factura1=new Factura(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), nif, nombre, apellidos);
	}
    
    public void makePedido(String tipo, String domicilio) {
    	consultasBBDD = new ConsultasBBDD();
    	String fecha = date.toString();
		pedido1=new Pedido(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), tipo, domicilio);
	}


}
   
