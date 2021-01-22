package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	private ControladorPanelOperatividad controladorPanelOperatividad;
	private ControladorPanelPedidos controladorPanelPedidos;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	private ControladorPanelComandas controladorPanelComandas;
	private ControladorPanelTicketFactura controladorPanelTicketFactura;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelBienvenida = new ControladorPanelBienvenida(this.modelo, this.vista, this);
		this.controladorPanelOperatividad = new ControladorPanelOperatividad(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelPedidos(this.modelo, this.vista, this);
		this.controladorPanelAprovisionamiento = new ControladorPanelAprovisionamiento(this.modelo, this.vista, this);
		this.controladorPanelComandas = new ControladorPanelComandas(this.modelo, this.vista, this);
		this.controladorPanelTicketFactura = new ControladorPanelTicketFactura(this.modelo, this.vista, this);
		this.navegarPanelBienvenida();
	}
	
	public void navegarPanelBienvenida() {
		System.out.println("Navegar panel Bienvenida");
		this.controladorPanelBienvenida.mostrarPanelBienvenida();
	}
	
	public void navegarPanelOperatividad() {
		System.out.println("Navegar panel Operatividad");
		this.controladorPanelOperatividad.mostrarPanelOperatividad();
	}
	
	public void navegarPanelPedidos() {
		System.out.println("Navegar panel Pedidos");
		this.controladorPanelPedidos.mostrarPanelPedidos();
	}
	
	public void navegarPanelAprovisionamiento() {
		System.out.println("Navegar panel Aprovisionamiento");
		this.controladorPanelAprovisionamiento.mostrarPanelAprovisionamiento();
	}
	
	public void navegarPanelComandas() {
		System.out.println("Navegar panel Comandas");
		this.controladorPanelComandas.mostrarPanelComandas();
	}
	
	public void navegarPanelTicketFactura() {
		System.out.println("Navegar panel TicketFactura");
		this.controladorPanelTicketFactura.mostrarPanelTicketFactura();
	}
}
