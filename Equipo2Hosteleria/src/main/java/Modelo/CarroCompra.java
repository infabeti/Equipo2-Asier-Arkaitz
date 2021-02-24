package Modelo;

import java.util.Arrays;

public class CarroCompra {
	
	//String ListaCompra="";
	double TotalCarro=0;
	//public ProductoEscogido[] arrayCarro;
	public Object[][] array = new Object[0][4];
	
	public void anadirProducto(String nombre, double precio, int cantidad) {
		
		boolean repetido=false;
		for(int i=0;i<array.length;i++) {
			if(nombre == array[i][0]) {
				int canti = (int) array[i][1];
				array[i][1] = canti+cantidad;
				array[i][3] = precio*(canti+cantidad);
				
				repetido=true;
			}
		}
		if(repetido==false) {
			aumentarArray();
			for(int i=0;i<array.length;i++) {
				if(array[i][0] == null) {
					array[i][0] = nombre;
					array[i][1] = cantidad;
					array[i][2] = precio;
					array[i][3] = precio*cantidad;
					i=array.length;
				}
			}
		}
		this.TotalCarro+=precio*cantidad;
	}
	
	public void aumentarArray() {
		Object[][] arrayTemp = new Object[this.array.length+1][4];
		for (int i = 0; i<this.array.length;i++) {
			arrayTemp[i][0] = this.array[i][0];
			arrayTemp[i][1] = this.array[i][1];
			arrayTemp[i][2] = this.array[i][2];
			arrayTemp[i][3] = this.array[i][3];
		}
		this.array = Arrays.copyOf(arrayTemp ,this.array.length+1);
	}
	
	public Object[][] getCarroCompra() {
		return this.array;
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
		Object[][] arrayLimpiador = new Object[0][4];
		this.array = Arrays.copyOf(arrayLimpiador ,0);
		this.TotalCarro=0;
		for(int i=0;i<array.length;i++) {
			array[i][0] = null;
			array[i][1] = null;
			array[i][2] = null;
			array[i][3] = null;
		}
	}
}
