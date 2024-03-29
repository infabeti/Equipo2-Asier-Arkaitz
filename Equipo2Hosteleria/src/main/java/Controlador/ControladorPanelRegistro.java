package Controlador;

import Modelo.Modelo;
import Vista.PanelRegistro;
import Vista.Vista;

public class ControladorPanelRegistro {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
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
	
	public boolean accionadoBottonCrearPanelRegistro(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		return this.modelo.getCuenta().crearUsuario(dni, contrasena, nombre, apellidos, nif_local);
	}	
	public String MostrarNifLocal(String nombreLocal) {
		return this.modelo.getCuenta().obtenerNifLocal(nombreLocal);
	}
	public String[] MostrarNombreLocal() {
		return this.modelo.getConexionMySQL_Local().nombreLocal();
	}
}
