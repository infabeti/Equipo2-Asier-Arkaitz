package Controlador;

import Modelo.Modelo;
import Vista.PanelPedidos;
import Vista.Vista;

@SuppressWarnings("static-access")
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
	
	public String[] obtenerNombresProductos() {
		return this.modelo.getNombresProductos().nombresProductos();
	}
	
	public double obtenerPrecioVentaProductos(String nombre) {
		return this.modelo.getPrecioVentaProductos().precioVentaProductos(nombre);
	}
	
	public void accionadoBottonVolverPanelPedidos() {
		this.modelo.resetCarro().borrarListaCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelPedidos() {
		this.modelo.resetCarro().borrarListaCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPasarACajaPanelPedidos() {
		this.modelo.resetCarro().borrarListaCompra();
		this.modelo.aumentarNumeroTransaccion().sumarNumTrans();
		this.controlador.navegarPanelOperatividad();
	}
	
	public int mostrarNumeroTransaccion() {
		return this.modelo.mostrarNumeroTransaccion().leerNumTrans();
	}
	
	public void accionadoBottonAadirAlCarroPanelPedidos(String nombre, int cantidad) {
		double precio=this.modelo.getPrecioVentaProductos().precioVentaProductos(nombre);
		this.modelo.setListaCompra().añadirProductos(nombre, precio, cantidad);
		this.modelo.setTotalCarro().añadirCoste(precio, cantidad);
	}
	
	public void accionadoBottonListaCompraPanelPedidos() {
		this.controlador.navegarPanelListaCompra();
	}
}
