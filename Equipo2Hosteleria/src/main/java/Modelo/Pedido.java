package Modelo;

public class Pedido extends Ticket{

	private String tipo;
	private String domicilio;
	
	//Constructor sin parametros
	public Pedido() {}
	
	public Pedido(int NTransaccion, String tipo) {
		this.setNTransaccion(NTransaccion);
		this.setTipo(tipo);
	}
			
	public Pedido(int NTransaccion, String tipo, String domicilio) {
		this.setNTransaccion(NTransaccion);
		this.setTipo(tipo);
		this.setDomicilio(domicilio);
	}
	
	//Constructor con parametros
	public Pedido(int NTransaccion, String fecha, String nif_local, String tipo, String domicilio) {
		this.setNTransaccion(NTransaccion);
		this.setFecha(fecha);
		this.setNif_local(nif_local);
		this.setTipo(tipo);
		this.setDomicilio(domicilio);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
}