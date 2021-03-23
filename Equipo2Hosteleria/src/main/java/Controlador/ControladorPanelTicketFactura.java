package Controlador;

import Modelo.Modelo;
import Vista.PanelTicketFactura;
import Vista.Vista;

public class ControladorPanelTicketFactura {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTicketFactura panelTicketFactura;
	
	public ControladorPanelTicketFactura(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}
	
	public String[] obtenerNombresProductos(String local) {
		return this.modelo.getConsultasBBDD().nombresProductos(local);
	}
	
	public double obtenerPrecioVentaProductos(String nombre, String local) {
		return this.modelo.getConsultasBBDD().precioVentaProductos(nombre, local);
	}
	
	public Object[][] obtenerListaCompra() {
		return this.modelo.getCarroCompra().getCarroCompra();
	}
	
	public double obtenerTotalCarro() {
		return this.modelo.getCarroCompra().getTotalCarro();
	}
	
	public void mostrarPanelTicketFactura() {
		this.panelTicketFactura = new PanelTicketFactura(this);
		this.vista.mostrarPanel(this.panelTicketFactura);
	}
	
	public void accionadoBottonVolverPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.modelo.getConsultasBBDD().reiniciarArray();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonDesconectarsePanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.modelo.getConsultasBBDD().reiniciarArray();
		this.controlador.navegarPanelBienvenida();
	}
	
	public boolean accionadoBottonPagarPanelTicketFactura(int NTransaccion, String fecha, int factura, String nif, String nombre, String apellidos, Object lista[][]) {
		boolean funciona = false;
		if(factura==0) {
			funciona = this.modelo.getPago().crearTicket(NTransaccion, fecha, this.modelo.getLocal().getNIF(), "TICKET");
		}else if(factura==1) {
			funciona = this.modelo.getPago().crearIdentificacion(nif, nombre, apellidos);
			if (funciona == true) funciona = this.modelo.getPago().crearTicket(NTransaccion, fecha, this.modelo.getLocal().getNIF(), "FACTURA");
			if (funciona == true) funciona = this.modelo.getPago().crearFactura(NTransaccion, nif);
		}
		this.modelo.getPago().crearIncluye(NTransaccion, lista);
		return funciona;
	}
	
	public void transaccionFinalizadaPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
		this.modelo.getConsultasBBDD().reiniciarArray();
		this.controlador.navegarPanelOperatividad();
	}
	
	public void accionadoBottonAadirAlCarroPanelTicketFactura(String nombre, int cantidad, String local) {
		double precio=this.modelo.getConsultasBBDD().precioVentaProductos(nombre, local);
		this.modelo.getCarroCompra().anadirProducto(nombre, precio, cantidad);
	}
	
	public void accionadoBottonBorrarListaPanelTicketFactura() {
		this.modelo.getCarroCompra().borrarCarroCompra();
	}
	
	public String NTransaccionTicketGeneral() {
		if(this.modelo.getConexionMySQL_Local().NTransaccionTicketGeneral()==null) {return "1";
		} else return this.modelo.getConexionMySQL_Local().NTransaccionTicketGeneral();
	}
	
	public String obtenerNombreLocal() {
		return this.modelo.getLocal().getNombre();
	}
}
