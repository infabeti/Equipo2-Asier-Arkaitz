package Modelo;

import Vista.PanelListaCompra;
import Vista.PanelPedidos;
import Vista.PanelTicketFactura;
import Controlador.ControladorPanelListaCompra;


public class Modelo {

	public static double TotalProducto=0;
	
	public static String BorrarListaCompra() {

	String ListaCompra="";
	String ListaCompraTotal="";
	
	TotalProducto=0;
	
	PanelListaCompra.ListaCompra=ListaCompra;
	PanelTicketFactura.ListaCompra=ListaCompra;
	
	PanelListaCompra.ListaCompraTotal=ListaCompraTotal;
	PanelTicketFactura.ListaCompraTotal=ListaCompraTotal;
	
	return "";
	      
	}
	
}
