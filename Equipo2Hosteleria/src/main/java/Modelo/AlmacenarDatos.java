package Modelo;

public class AlmacenarDatos {
	static String ListaCompra="";
	static double TotalCarro=0;
	static int NTransaccion=1;
	
	public static void a�adirProductos(String nombre, double precio, int cantidad) {
		double total=precio*cantidad;
		ListaCompra+=nombre+" - Cantidad: "+cantidad+" - Precio: "+precio+"� - Total: "+total+"�\n";
	}
	
	public static String leerLista() {
		return ListaCompra;
	}
	
	public static void a�adirCoste(double precio, int cantidad) {
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
	
	public static int leerNumTrans() {
		return NTransaccion;
	}
		
	public static int sumarNumTrans() {
		return NTransaccion++;
	}
	
}
