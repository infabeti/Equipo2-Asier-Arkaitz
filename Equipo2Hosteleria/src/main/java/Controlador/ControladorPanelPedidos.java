package Controlador;

import Modelo.Modelo;
import Vista.PanelPedidos;
import Vista.Vista;

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
		return this.modelo.getConsultasBBDD().nombresProductos();
	}
	
	public double obtenerPrecioVentaProductos(String nombre) {
		return this.modelo.getConsultasBBDD().precioVentaProductos(nombre);
	}
	
	public void accionadoBottonVolverPanelPedidos() {
		this.modelo.getCarroCompra().borrarListaCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelPedidos() {
		this.modelo.getCarroCompra().borrarListaCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPasarACajaPanelPedidos(String tipo, String domicilio) {
		this.modelo.getMakers().makePedido(tipo, domicilio);
		this.modelo.getCarroCompra().borrarListaCompra();
		this.modelo.getConsultasBBDD().sumarNTransaccion();
		this.controlador.navegarPanelOperatividad();
	}
	
	public int mostrarNumeroTransaccion() {
		return this.modelo.getConsultasBBDD().getNTransaccion();
	}
	
	public void accionadoBottonAadirAlCarroPanelPedidos(String nombre, int cantidad) {
		double precio=this.modelo.getConsultasBBDD().precioVentaProductos(nombre);
		this.modelo.getCarroCompra().anadirProductos(nombre, precio, cantidad);
		this.modelo.getCarroCompra().anadirCoste(precio, cantidad);
	}
	
	public void accionadoBottonListaCompraPanelPedidos() {
		this.controlador.navegarPanelListaCompra();
	}
}
