package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelOperatividad;
import Vista.PanelAprovisionamiento;
import Vista.Vista;

public class ControladorPanelAprovisionamiento {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelAprovisionamiento panelAprovisionamiento;
	
	public ControladorPanelAprovisionamiento(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelAprovisionamiento() {
		this.panelAprovisionamiento = new PanelAprovisionamiento(this);
		this.vista.mostrarPanel(this.panelAprovisionamiento);
	}
	
	public void accionadoBottonVolverPanelAprovisionamiento() {
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelAprovisionamiento() {
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonAadirAlCarroPanelAprovisionamiento() {
		//this.controlador.anadirAListaCompra();
	}
	
}
