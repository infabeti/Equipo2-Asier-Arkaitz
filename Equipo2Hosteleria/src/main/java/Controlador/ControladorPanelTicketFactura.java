package Controlador;

import Modelo.Modelo;
import Vista.PanelTicketFactura;
import Vista.Vista;

@SuppressWarnings("static-access")
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
		return this.modelo.getNombresProductos().nombresProductos();
	}
	
	public double obtenerPrecioVentaProductos(String nombre) {
		return this.modelo.getPrecioVentaProductos().precioVentaProductos(nombre);
	}
	
	public String obtenerListaCompra() {
		return this.modelo.getListaCompra().leerLista();
	}
	
	public double obtenerTotalCarro() {
		return this.modelo.getTotalCarro().leerCoste();
	}
	
	public void mostrarPanelTicketFactura() {
		this.panelTicketFactura = new PanelTicketFactura(this);
		this.vista.mostrarPanel(this.panelTicketFactura);
	}
	
	public void accionadoBottonVolverPanelTicketFactura() {
		this.modelo.resetCarro().borrarListaCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelTicketFactura() {
		this.modelo.resetCarro().borrarListaCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPagarPanelTicketFactura() {
		this.modelo.resetCarro().borrarListaCompra();
		this.modelo.aumentarNumeroTransaccion().sumarNumTrans();
		this.controlador.navegarPanelOperatividad();
	}
	
	public int MostrarNumeroTransaccion() {
		return this.modelo.mostrarNumeroTransaccion().leerNumTrans();
	}
	
	public void accionadoBottonAadirAlCarroPanelTicketFactura(String nombre, int cantidad) {
		double precio=this.modelo.getPrecioVentaProductos().precioVentaProductos(nombre);
		this.modelo.setListaCompra().añadirProductos(nombre, precio, cantidad);
		this.modelo.setTotalCarro().añadirCoste(precio, cantidad);
	}
	
	public void accionadoBottonBorrarListaPanelTicketFactura() {
		this.modelo.resetCarro().borrarListaCompra();
	}
}
