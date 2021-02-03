package Controlador;

import Modelo.Modelo;
import Vista.PanelOperatividad;
import Vista.Vista;

@SuppressWarnings("static-access")
public class ControladorPanelOperatividad {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelOperatividad panelOperatividad;
	
	public ControladorPanelOperatividad(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelOperatividad() {
		this.panelOperatividad = new PanelOperatividad(this);
		this.vista.mostrarPanel(this.panelOperatividad);
	}
	
	public void accionadoBottonVolverPanelOperatividad() {
		this.modelo.resetCarro().borrarListaCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public boolean accionadoBottonPruebaConexionPanelOperatividad() {
		return this.modelo.pruebaConexion().probarConexion();
	}
	
	public void accionadoBottonMostrarPanelPedidos() {
		this.controlador.navegarPanelPedidos();
	}
	
	public void accionadoBottonMostrarPanelComandas() {
		this.controlador.navegarPanelComandas();
	}
	
	public void accionadoBottonMostrarPanelAprovisionamiento() {
		this.controlador.navegarPanelAprovisionamiento();
	}
	
	public void accionadoBottonMostrarPanelTicketFactura() {
		this.controlador.navegarPanelTicketFactura();
	}
}
