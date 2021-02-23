package Modelo;

public class CarroCompra {
	
	String ListaCompra="";
	double TotalCarro=0;
	
	public void anadirProductos(String nombre, double precio, int cantidad) {
		double total=precio*cantidad;
		this.ListaCompra+=nombre+" - Cantidad: "+cantidad+" - Precio: "+precio+"€ - Total: "+total+"€\n";
		this.TotalCarro+=total;
	}
	
	public String getListaCompra() {
		return this.ListaCompra;
	}
	
	public double getTotalCarro() {
		return this.TotalCarro;
	}
	
	public void borrarCarroCompra() {
		this.ListaCompra="";
		this.TotalCarro=0;
	}
	
}
