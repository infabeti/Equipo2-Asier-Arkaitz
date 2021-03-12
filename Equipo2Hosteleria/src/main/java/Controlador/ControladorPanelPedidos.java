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
	
	public boolean accionadoBottonPasarACajaPanelPedidos(int NTransaccion, String fecha, String nif_local, String tipoPedido, String domicilio, Object lista[][]) {
		this.modelo.getPago().crearTicket(NTransaccion, fecha, nif_local, "PEDIDO");
		this.modelo.getPago().crearIncluye(NTransaccion, lista);
		return this.modelo.getPago().crearPedido(NTransaccion, tipoPedido, domicilio);
	}
	
	public void transaccionFinalizadaPanelPedidos() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.modelo.getConsultasBBDD().sumarNTransaccion();
		this.controlador.navegarPanelOperatividad();
	}
	
	public String NTransaccionTicketGeneral() {
		if(this.modelo.getConexionMySQL().NTransaccionTicketGeneral()==null) {return "1";} else return this.modelo.getConexionMySQL().NTransaccionTicketGeneral();
	}
	
	public void accionadoBottonAadirAlCarroPanelPedidos(String nombre, int cantidad) {
		double precio=this.modelo.getConsultasBBDD().precioVentaProductos(nombre);
		this.modelo.getCarroCompra().anadirProducto(nombre, precio, cantidad);
	}
	
	public void accionadoBottonBorrarListaPanelPedidos() {
		this.modelo.getCarroCompra().borrarCarroCompra();
	}
}