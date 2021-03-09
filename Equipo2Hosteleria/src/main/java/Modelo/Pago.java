package Modelo;

import javax.swing.JOptionPane;

public class Pago {
	
	private ConexionMySQL conexionMySQL;
	private Usuario usuario1;
	private Pedido pedido1 = new Pedido();
	private Ticket ticket1 = new Ticket();
	private Incluye incluye1 = new Incluye();
	private boolean funciona;

	public boolean crearPedido(int NTransaccion, String fecha, String nif_local, String tipo, String tipoPedido, String domicilio) {
		ticket1 = new Ticket(NTransaccion, fecha, nif_local, "PEDIDO");
		pedido1 = new Pedido(NTransaccion, tipoPedido, domicilio);
		
		Ticket tic = conexionMySQL.registrarTicket(ticket1);
		Pedido pedi = conexionMySQL.registrarPedidoConDomicilio(pedido1);
		
		if (tic != null && pedi != null && incl != null) {
			funciona=true;			
		}else {
			funciona=false;
		}
		return funciona;
	}
}
