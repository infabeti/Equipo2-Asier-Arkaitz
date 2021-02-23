package Modelo;

public class CarroCompra {
	
	//String ListaCompra="";
	double TotalCarro=0;
	public ProductoEscogido[] arrayCarro;
	
	public void anadirProducto(String nombre, double precio, int cantidad) {
		
		boolean repetido=false;
		for(int i=0;i<arrayCarro.length;i++) {
			if(nombre == arrayCarro[i].getNombre()) {
				arrayCarro[i].setCantidad(arrayCarro[i].getCantidad()+cantidad);
				arrayCarro[i].setPrecioTotal(arrayCarro[i].getPrecioVenta()*arrayCarro[i].getCantidad());
				
				repetido=true;
			}
		}
		if(repetido==false) {
			for(int i=0;i<arrayCarro.length+1;i++) {
				if(arrayCarro[i].getNombre() == null) {
					arrayCarro[i].setNombre(nombre);
					arrayCarro[i].setCantidad(cantidad);
					arrayCarro[i].setPrecioVenta(precio);
					arrayCarro[i].setPrecioTotal(precio*cantidad);
				}
			}
		}
		this.TotalCarro+=precio*cantidad;
	}
	
	/*
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
	*/
}
