package Modelo;

public class Pago {
	
	private ConexionMySQL_TicketFactura conexionMySQL_TicketFactura;
	private ConexionMySQL_IdentIncluye conexionMySQL_IdentIncluye;
	private ConexionMySQL_Pedido conexionMySQL_Pedido;
	private Pedido pedido1;
	private Ticket ticket1;
	private Factura factura1;
	private Identificacion identificacion1;
	private Incluye incluye1;
	private boolean funciona;
	
	public Pago() {
		conexionMySQL_TicketFactura = new ConexionMySQL_TicketFactura();
		conexionMySQL_IdentIncluye = new ConexionMySQL_IdentIncluye();
		conexionMySQL_Pedido = new ConexionMySQL_Pedido();
	}
	
	public boolean crearTicket(int NTransaccion, String fecha, String nif_local, String tipo) {
		ticket1 = new Ticket(NTransaccion, fecha, nif_local, tipo);
		Ticket tic = this.conexionMySQL_TicketFactura.registrarTicket(ticket1);
		
		if (tic != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}
	
	public boolean crearFactura(int NTransaccion, String nif) {
		factura1 = new Factura(NTransaccion, nif);
		Factura fac = this.conexionMySQL_TicketFactura.registrarFactura(factura1);
		
		if (fac != null) {
			funciona=true;			
		}else {
			funciona=false;
		}
		return funciona;
	}
	
	public boolean crearIdentificacion(String nif, String nombre, String apellidos) {
		identificacion1 = new Identificacion(nif, nombre, apellidos);
		
		Identificacion ide1 = this.conexionMySQL_IdentIncluye.comprobarIdentificacion(identificacion1); 
		if (ide1 != null) {
			funciona=true;
			return funciona;
		}else {
			funciona=false;			
		}
			
		Identificacion ide = this.conexionMySQL_IdentIncluye.registrarIdentificacion(identificacion1);
		if (ide != null) {
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
			this.conexionMySQL_Pedido.registrarPedidoConDomicilio(pedido1);
			funciona=true;
		}else if (tipoPedido.equals("RECOGIDA")) {
			pedido1 = new Pedido(NTransaccion, tipoPedido);
			this.conexionMySQL_Pedido.registrarPedidoSinDomicilio(pedido1);
			funciona=true;
		}
		return funciona;
	}

	public boolean crearIncluye(int NTransaccion, Object lista[][]) {
		for(int i = 0;i<lista.length;i++) {
			incluye1 = new Incluye(lista[i][0].toString(), NTransaccion, Integer.parseInt(lista[i][1].toString()), Double.parseDouble(lista[i][2].toString()));
			Incluye inc = this.conexionMySQL_IdentIncluye.registrarIncluye(incluye1);

			if (inc != null) {
				funciona=true;			
			}else {
				funciona=false;
			}
		}
		return funciona;
	}
}
