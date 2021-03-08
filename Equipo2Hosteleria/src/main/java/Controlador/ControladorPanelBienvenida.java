package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.Vista;

public class ControladorPanelBienvenida {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelBienvenida panelBienvenida;
	
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
	
	public void accionadoBottonMostrarPanelRegistro() {
		this.controlador.navegarPanelRegistro();
	}
	
	public boolean establecerConexion() {
		return this.modelo.getConsultasBBDD().Conectar();
	}
	
	public boolean accionadoBottonIniciarPanelOperatividad(String dni, String contrasena) {
		return this.modelo.getCuenta().iniciarUsuario(dni, contrasena);
	}
}
