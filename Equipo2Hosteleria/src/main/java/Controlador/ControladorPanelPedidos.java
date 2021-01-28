package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelOperatividad;
import Vista.PanelListaCompra;
import Vista.PanelPedidos;
import Vista.Vista;

public class ControladorPanelPedidos {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPedidos panelPedidos;
	
	public ControladorPanelPedidos(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelPedidos() {
		this.panelPedidos = new PanelPedidos(this);
		this.vista.mostrarPanel(this.panelPedidos);
	}
	
	public void accionadoBottonVolverPanelPedidos() {
		Modelo.BorrarListaCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelPedidos() {
		Modelo.BorrarListaCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPasarACajaPanelPedidos() {
		this.controlador.navegarPanelTicketFactura();
	}
	
	public void accionadoBottonAadirAlCarroPanelPedidos() {
		//this.controlador.anadirAListaCompra();
	}
	
	public void accionadoBottonListaCompraPanelPedidos() {
		this.controlador.navegarPanelListaCompra();
	}
}
