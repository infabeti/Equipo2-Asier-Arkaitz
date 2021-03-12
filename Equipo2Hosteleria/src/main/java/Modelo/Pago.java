package Modelo;

public class Pago {
	
	private ConexionMySQL conexionMySQL;
	private Pedido pedido1;
	private Ticket ticket1;
	private Factura factura1;
	private Identificacion identificacion1;
	private Incluye incluye1;
	private boolean funciona;
	
	public boolean crearTicket(int NTransaccion, String fecha, String nif_local, String tipo) {
		conexionMySQL = new ConexionMySQL();
		ticket1 = new Ticket(NTransaccion, fecha, nif_local, tipo);
		Ticket tic = conexionMySQL.registrarTicket(ticket1);
		
		if (tic != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}
	
	public boolean crearFactura(int NTransaccion, String nif) {
		conexionMySQL = new ConexionMySQL();
		factura1 = new Factura(NTransaccion, nif);
		Factura fac = conexionMySQL.registrarFactura(factura1);
		
		if (fac != null) {
			funciona=true;			
		}else {
			funciona=false;
		}
		return funciona;
	}
	
	public boolean crearIdentificacion(String nif, String nombre, String apellidos) {
		conexionMySQL = new ConexionMySQL();
		identificacion1 = new Identificacion(nif, nombre, apellidos);
		Identificacion ide = conexionMySQL.registrarIdentificacion(identificacion1);
		
		if (ide != null) {
			funciona=true;			
		}else {
			funciona=false;
		}
		return funciona;
	}

	public boolean crearPedido(int NTransaccion, String tipoPedido, String domicilio) {
		conexionMySQL = new ConexionMySQL();
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

	public boolean crearIncluye(int NTransaccion, Object lista[][]) {
		conexionMySQL = new ConexionMySQL();
		for(int i = 0;i<lista.length;i++) {
			incluye1 = new Incluye(lista[i][0].toString(), NTransaccion, Integer.parseInt(lista[i][1].toString()), Double.parseDouble(lista[i][2].toString()));
			Incluye inc = conexionMySQL.registrarIncluye(incluye1);

			if (inc != null) {
				funciona=true;			
			}else {
				funciona=false;
			}
		}
		return funciona;
	}
}
