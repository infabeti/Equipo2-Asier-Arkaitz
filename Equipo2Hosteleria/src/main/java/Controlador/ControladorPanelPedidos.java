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
	
	public Object[][] obtenerListaCompra() {
		return this.modelo.getCarroCompra().getCarroCompra();
	}
	
	public double obtenerTotalCarro() {
		return this.modelo.getCarroCompra().getTotalCarro();
	}
	
	public void accionadoBottonVolverPanelPedidos() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelPedidos() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.controlador.navegarPanelBienvenida();
	}
	
	public void accionadoBottonPasarACajaPanelPedidos(int NTransaccion, String tipoPedido, String domicilio, String nombreProducto, int cantidad, double precio) {
		this.modelo.setTicket("PEDIDO");
		this.modelo.setPedido(tipoPedido, domicilio);
	}
	
	public void transaccionFinalizadaPanelPedidos() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.modelo.getConsultasBBDD().sumarNTransaccion();
		this.controlador.navegarPanelOperatividad();
	}
	
	public int mostrarNumeroTransaccion() {
		return this.modelo.getConsultasBBDD().getNTransaccion();
	}
	
	public void accionadoBottonAadirAlCarroPanelPedidos(String nombre, int cantidad) {
		double precio=this.modelo.getConsultasBBDD().precioVentaProductos(nombre);
		this.modelo.getCarroCompra().anadirProducto(nombre, precio, cantidad);
	}
	
	public void accionadoBottonBorrarListaPanelPedidos() {
		this.modelo.getCarroCompra().borrarCarroCompra();
	}
}