package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelOperatividad;
import Vista.PanelTicketFactura;
import Vista.PanelListaCompra;
import Vista.Vista;

public class ControladorPanelListaCompra {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelListaCompra panelListaCompra;
	
	public ControladorPanelListaCompra(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelListaCompra() {
		this.panelListaCompra = new PanelListaCompra(this);
		this.vista.mostrarPanel(this.panelListaCompra);
	}
	
	public void accionadoBottonVolverPanelListaCompra() {
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelListaCompra() {
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPagarPanelListaCompra() {
		this.controlador.navegarPanelOperatividad();
		//Reducir Stock de productos vendidos (de haberlos)
	}
}
