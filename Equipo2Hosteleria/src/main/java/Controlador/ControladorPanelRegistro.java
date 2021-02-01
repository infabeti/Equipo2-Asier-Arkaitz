package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelRegistro;
import Vista.Vista;

public class ControladorPanelRegistro {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelBienvenida panelBienvenida;
	private PanelRegistro panelRegistro;
	
	
	public void mostrarPanelRegistro() {
		this.panelRegistro = new PanelRegistro(this);
		this.vista.mostrarPanel(this.panelRegistro);
	
		
	}
	
	public ControladorPanelRegistro(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelBienvenida() {
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonMostrarPanelOperatividad() {
		this.controlador.navegarPanelOperatividad();
		
	}
	
	
}
