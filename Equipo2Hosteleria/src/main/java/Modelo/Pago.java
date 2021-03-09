package Modelo;

public class Pago {
	
	private ConexionMySQL conexionMySQL;
	private Pedido pedido1;
	private Ticket ticket1;
	private Incluye incluye1;
	private boolean funciona;
	
	public boolean crearTicket(int NTransaccion, String fecha, String nif_local, String tipo) {
		ticket1 = new Ticket(NTransaccion, fecha, nif_local, tipo);
		Ticket tic = conexionMySQL.registrarTicket(ticket1);
		
		if (tic != null) {
			funciona=true;			
		}else {
			funciona=false;
		}
		return funciona;
	}

	public boolean crearPedido(int NTransaccion, String tipoPedido, String domicilio) {
		funciona=false;
		if(tipoPedido.equals("ENTREGA")) {
			pedido1 = new Pedido(NTransaccion, tipoPedido, domicilio);
			conexionMySQL.registrarPedidoConDomicilio(pedido1);
			funciona=true;
		}else if (tipoPedido.equals("RECOGIDA")) {
			pedido1 = new Pedido(NTransaccion, tipoPedido);
			conexionMySQL.registrarPedidoSinDomicilio(pedido1);
			funciona=true;
		}
		return funciona;
	}

	public void crearIncluye(int NTransaccion, Object lista[][]) {
		for(int i = 0;i<lista.length;i++) {
			incluye1 = new Incluye(lista[i][0].toString(), NTransaccion, Integer.parseInt(lista[i][1].toString()), Double.parseDouble(lista[i][2].toString()));
			conexionMySQL.registrarIncluye(incluye1);
		}
	}
}
