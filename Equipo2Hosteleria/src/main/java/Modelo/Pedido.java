package Modelo;

public class Pedido extends Ticket{

	private String tipoPedido;
	private String domicilio;
	
	//Constructor sin parametros
	public Pedido() {}
	
	//Constructor con parametros
	public Pedido(int NTransaccion, String tipo, String tipoPedido) {
		super.setNTransaccion(NTransaccion);
		super.setTipo(tipo);
		this.setTipoPedido(tipoPedido);
	}
	
	public Pedido(int NTransaccion, String tipoPedido) {
		super.setNTransaccion(NTransaccion);
		this.setTipoPedido(tipoPedido);
	}
			
	public Pedido(int NTransaccion, String tipo, String tipoPedido, String domicilio) {
		super.setNTransaccion(NTransaccion);
		super.setTipo(tipo);
		this.setTipoPedido(tipoPedido);
		this.setDomicilio(domicilio);
	}
	
	public Pedido(int NTransaccion, String fecha, String nif_local, String tipo, String tipoPedido, String domicilio) {
		super.setNTransaccion(NTransaccion);
		super.setFecha(fecha);
		super.setNif_local(nif_local);
		super.setTipo(tipo);
		this.setTipoPedido(tipoPedido);
		this.setDomicilio(domicilio);
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
}