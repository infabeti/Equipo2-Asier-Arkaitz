package Modelo;

public class CarroCompra {
		String ListaCompra="";
		double TotalCarro=0;
		static int NTransaccion=1;
	
	public void anadirProductos(String nombre, double precio, int cantidad) {
		double total=precio*cantidad;
		ListaCompra+=nombre+" - Cantidad: "+cantidad+" - Precio: "+precio+"€ - Total: "+total+"€\n";
	}
	
	public String leerLista() {
		return ListaCompra;
	}
	
	public void anadirCoste(double precio, int cantidad) {
		double total=precio*cantidad;
		TotalCarro+=total;
	}
	
	public double leerCoste() {
		return TotalCarro;
	}
	
	public void borrarListaCompra() {
		ListaCompra="";
		TotalCarro=0;
	}
	
	public int leerNumTrans() {
		return NTransaccion;
	}
		
	public int sumarNumTrans() {
		return NTransaccion++;
	}
	
}
