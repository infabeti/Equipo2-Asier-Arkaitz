package Modelo;

import Vista.PanelListaCompra;
import Vista.PanelTicketFactura;


public class Modelo {

	public static double TotalProducto=0;
	public static int NTransaccion=1;
	private ObtenerDatos nombresProductos;
	private ObtenerDatos precioVentaProductos;
	private ObtenerDatos precioTotalCarro;
	
	public ObtenerDatos getNombresProductos() {
		return this.nombresProductos;
	}
	
	public ObtenerDatos getPrecioVentaProductos() {
		return this.precioVentaProductos;
	}
	
	public ObtenerDatos getPrecioTotalCarro() {
		return this.precioTotalCarro;
	}
	
	public String BorrarListaCompra() {

	String ListaCompra="";
	String ListaCompraTotal="";
	
	TotalProducto=0;
	
	PanelListaCompra.ListaCompra=ListaCompra;
	PanelTicketFactura.ListaCompra=ListaCompra;
	
	PanelListaCompra.ListaCompraTotal=ListaCompraTotal;
	PanelTicketFactura.ListaCompraTotal=ListaCompraTotal;
	
	return "";
	      
	}
	
	public static int MostrarNumeroTransaccion() {
		
	return NTransaccion;
	      
	}
	
	public static int AumentarNumeroTransaccion() {
	
	return NTransaccion++;
	      
	}
	
}
