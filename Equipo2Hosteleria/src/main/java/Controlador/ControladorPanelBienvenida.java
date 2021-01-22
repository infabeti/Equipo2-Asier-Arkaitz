package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.Vista;

public class ControladorPanelBienvenida {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelBienvenida panelBienvenida;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public ControladorPanelBienvenida(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelBienvenida() {
		this.panelBienvenida = new PanelBienvenida(this);
		this.vista.mostrarPanel(this.panelBienvenida);
	}
	
	public void accionadoBottonMostrarPanelOperatividad() {
		this.controlador.navegarPanelOperatividad();
	}
}
