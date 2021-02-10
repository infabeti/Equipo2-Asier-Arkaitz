package Modelo;

public class CarroCompra {
	
	String ListaCompra="";
	double TotalCarro=0;
	
	public void anadirProductos(String nombre, double precio, int cantidad) {
		double total=precio*cantidad;
		this.ListaCompra+=nombre+" - Cantidad: "+cantidad+" - Precio: "+precio+"€ - Total: "+total+"€\n";
	}
	
	public String leerLista() {
		return this.ListaCompra;
	}
	
	public void anadirCoste(double precio, int cantidad) {
		double total=precio*cantidad;
		this.TotalCarro+=total;
	}
	
	public double leerCoste() {
		return this.TotalCarro;
	}
	
	public void borrarListaCompra() {
		this.ListaCompra="";
		this.TotalCarro=0;
	}
	
}
