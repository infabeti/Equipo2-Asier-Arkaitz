package Modelo;

import Vista.PanelListaCompra;
import Vista.PanelTicketFactura;


public class Modelo {

	public static double TotalProducto=0;
	public static int NTransaccion=1;
	private ObtenerDatos nombresProductos;
	private ObtenerDatos precioVentaProductos;
	private ObtenerDatos precioTotalCarro;
	private AlmacenarDatos añadirProductos;
	private AlmacenarDatos leerLista;
	private AlmacenarDatos añadirCoste;
	private AlmacenarDatos leerCoste;
	private AlmacenarDatos borrarListaCompra;
	
	//OBTENER DATOS DE PRODUCTOS
	public ObtenerDatos getNombresProductos() {
		return this.nombresProductos;
	}
	
	public ObtenerDatos getPrecioVentaProductos() {
		return this.precioVentaProductos;
	}
	
	//ALMACENAR DATOS CARRO DE LA COMPRA
	public AlmacenarDatos setListaCompra() {
		return this.añadirProductos;
	}
	
	public AlmacenarDatos getListaCompra() {
		return this.leerLista;
	}
	
	public AlmacenarDatos setTotalCarro() {
		return this.añadirCoste;
	}
	
	public AlmacenarDatos getTotalCarro() {
		return this.leerCoste;
	}
	
	public AlmacenarDatos resetCarro() {
		return this.borrarListaCompra;
	}
	
	//PARA ACTUALIZAR
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
