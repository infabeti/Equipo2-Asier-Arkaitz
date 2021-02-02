package Modelo;

public class AlmacenarDatos {
	static String ListaCompra="";
	static double TotalCarro=0;
	
	public static void añadirProductos(String nombre, double precio, int cantidad) {
		double total=precio*cantidad;
		ListaCompra+=nombre+" - Cantidad: "+cantidad+" - Precio: "+precio+"€ - Total: "+total+"€\n";
		//ListaCompra.concat(nombre+" - Cantidad: "+cantidad+" - Precio: "+precio+"€ - Total: "+total+"€\n");
	}
	
	public static String leerLista() {
		return ListaCompra;
	}
	
	public static void añadirCoste(double precio, int cantidad) {
		double total=precio*cantidad;
		TotalCarro+=total;
	}
	
	public static double leerCoste() {
		return TotalCarro;
	}
	
	public static void borrarListaCompra() {

		ListaCompra="";
		
		TotalCarro=0;
		
	}
	
}
