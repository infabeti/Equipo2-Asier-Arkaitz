package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelOperatividad;
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
	
	public void mostrarPanelTicketFactura() {
		this.panelTicketFactura = new PanelTicketFactura(this);
		this.vista.mostrarPanel(this.panelTicketFactura);
	}
	
	public void accionadoBottonVolverPanelTicketFactura() {
		this.modelo.BorrarListaCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelTicketFactura() {
		this.modelo.BorrarListaCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPagarPanelTicketFactura() {
		this.modelo.BorrarListaCompra();
		this.modelo.AumentarNumeroTransaccion();
		this.controlador.navegarPanelOperatividad();
	}
	
	public int MostrarNumeroTransaccion() {
		return Modelo.MostrarNumeroTransaccion();
	}
	
	public void accionadoBottonAadirAlCarroPanelTicketFactura() {
		this.controlador.navegarPanelTicketFactura();
	}
	
	public void accionadoBottonBorrarListaPanelTicketFactura() {
		this.modelo.BorrarListaCompra();
		this.controlador.navegarPanelTicketFactura();
	}
}
