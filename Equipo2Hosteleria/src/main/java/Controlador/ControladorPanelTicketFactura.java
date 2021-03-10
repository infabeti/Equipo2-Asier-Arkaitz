package Controlador;

import Modelo.Modelo;
import Vista.PanelTicketFactura;
import Vista.Vista;

public class ControladorPanelTicketFactura {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTicketFactura panelTicketFactura;
	
	public ControladorPanelTicketFactura(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}
	
	public String[] obtenerNombresProductos() {
		return this.modelo.getConsultasBBDD().nombresProductos();
	}
	
	public double obtenerPrecioVentaProductos(String nombre) {
		return this.modelo.getConsultasBBDD().precioVentaProductos(nombre);
	}
	
	public Object[][] obtenerListaCompra() {
		return this.modelo.getCarroCompra().getCarroCompra();
	}
	
	public double obtenerTotalCarro() {
		return this.modelo.getCarroCompra().getTotalCarro();
	}
	
	public void mostrarPanelTicketFactura() {
		this.panelTicketFactura = new PanelTicketFactura(this);
		this.vista.mostrarPanel(this.panelTicketFactura);
	}
	
	public void accionadoBottonVolverPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public boolean accionadoBottonPagarPanelTicketFactura(int NTransaccion, String fecha, String nif_local, int factura, String nif, String nombre, String apellidos) {
		boolean funciona = false;
		if(factura==0) {
			funciona = this.modelo.getPago().crearTicket(NTransaccion, fecha, nif_local, "TICKET");
		}else if(factura==1) {
			funciona = this.modelo.getPago().crearTicket(NTransaccion, fecha, nif_local, "FACTURA");
			if (funciona == true) funciona = this.modelo.getPago().crearFactura(NTransaccion, nif);
			if (funciona == true) funciona = this.modelo.getPago().crearIdentificacion(nif, nombre, apellidos);
		}
		return funciona;
	}
	
	public void transaccionFinalizadaPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.modelo.getConsultasBBDD().sumarNTransaccion();
		this.controlador.navegarPanelOperatividad();
	}
	
	public int mostrarNumeroTransaccion() {
		return this.modelo.getConsultasBBDD().getNTransaccion();
	}
	
	public void accionadoBottonAadirAlCarroPanelTicketFactura(String nombre, int cantidad) {
		double precio=this.modelo.getConsultasBBDD().precioVentaProductos(nombre);
		this.modelo.getCarroCompra().anadirProducto(nombre, precio, cantidad);
	}
	
	public void accionadoBottonBorrarListaPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
	}
}
