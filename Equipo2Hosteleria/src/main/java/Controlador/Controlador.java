package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	private ControladorPanelOperatividad controladorPanelOperatividad;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelBienvenida = new ControladorPanelBienvenida(this.modelo, this.vista, this);
		this.controladorPanelOperatividad = new ControladorPanelOperatividad(this.modelo, this.vista, this);
		this.navegarPanelBienvenida();
	}
	
	public void navegarPanelBienvenida() {
		System.out.println("Navegar panel Bienvenida");
		this.controladorPanelBienvenida.mostrarPanelBienvenida();
	}
	
	public void navegarPanelOperatividad() {
		System.out.println("Navegar panel Generos");
		this.controladorPanelOperatividad.mostrarPanelOperatividad();
	}
}
