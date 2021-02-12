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
	
	public String obtenerListaCompra() {
		return this.modelo.getCarroCompra().leerLista();
	}
	
	public double obtenerTotalCarro() {
		return this.modelo.getCarroCompra().leerCoste();
	}
	
	public void mostrarPanelTicketFactura() {
		this.panelTicketFactura = new PanelTicketFactura(this);
		this.vista.mostrarPanel(this.panelTicketFactura);
	}
	
	public void accionadoBottonVolverPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarListaCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelTicketFactura() {
		this.modelo.getCarroCompra().borrarListaCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPagarPanelTicketFactura(int factura, String nif, String nombre, String apellidos) {
		if(factura==0) {
			this.modelo.getMakers().makeTicket();	
		}else if(factura==1) {
			this.modelo.getMakers().makeFactura(nif, nombre, apellidos);	
		}
		this.modelo.getCarroCompra().borrarListaCompra();
		this.modelo.getConsultasBBDD().sumarNTransaccion();
		this.controlador.navegarPanelOperatividad();
	}
	
	public int mostrarNumeroTransaccion() {
		return this.modelo.getConsultasBBDD().getNTransaccion();
	}
	
	public void accionadoBottonAadirAlCarroPanelTicketFactura(String nombre, int cantidad) {
		double precio=this.modelo.getConsultasBBDD().precioVentaProductos(nombre);
		this.modelo.getCarroCompra().anadirProductos(nombre, precio, cantidad);
		this.modelo.getCarroCompra().anadirCoste(precio, cantidad);
	}
	
	public void accionadoBottonBorrarListaPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarListaCompra();
	}
}
