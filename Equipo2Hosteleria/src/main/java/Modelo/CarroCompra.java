package Modelo;

public class CarroCompra {
	
	//String ListaCompra="";
	double TotalCarro=0;
	public ProductoEscogido[] arrayCarro;
	public Object[][] array = new Object[99][4];
	
	public void anadirProducto(String nombre, double precio, int cantidad) {
		
		boolean repetido=false;
		for(int i=0;i<array.length;i++) {
			if(nombre == array[i][0]) {
				int c = array[i][1];
				array[i][1] = Integer.parseInt(array[i][1])+cantidad;
				array[i][3] = arrayCarro[i].getPrecioVenta()*arrayCarro[i].getCantidad();
				
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
	*/
	public Object[][] getCarroCompra() {
		for(int i=0;i<arrayCarro.length;i++) {
			if(arrayCarro[i].getNombre()!=null) {
				array[i][0]=arrayCarro[i].getNombre();
				array[i][1]=arrayCarro[i].getCantidad();
				array[i][2]=arrayCarro[i].getPrecioVenta();
				array[i][3]=arrayCarro[i].getPrecioTotal();
			}
		}
		return array;
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
	*/
	public double getTotalCarro() {
		return this.TotalCarro;
	}
	
	public void borrarCarroCompra() {
		arrayCarro = new ProductoEscogido[99];
		//this.ListaCompra="";
		this.TotalCarro=0;
		for(int i=0;i<arrayCarro.length;i++) {
			arrayCarro[i].setNombre(null);
			arrayCarro[i].setCantidad(0);
			arrayCarro[i].setPrecioVenta(0);
			arrayCarro[i].setPrecioTotal(0);
		}
	}
}
