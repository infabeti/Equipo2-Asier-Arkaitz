package Modelo;

import java.util.Arrays;

public class CarroCompra {
	
	public double TotalCarro=0;
	public Object[][] array = new Object[0][4];
	public ProductoEscogido[] arrayProdEsc = new ProductoEscogido[0];
	
	public void anadirProducto(String nombre, double precio, int cantidad) {
		
		boolean repetido=false;
		for(int i=0;i<arrayProdEsc.length;i++) {
			if(nombre == arrayProdEsc[i].getNombre()) {
				arrayProdEsc[i].setCantidad(arrayProdEsc[i].getCantidad()+cantidad);
				arrayProdEsc[i].setPrecioTotal(precio*arrayProdEsc[i].getCantidad());
				
				repetido=true;
			}
		}
		if(repetido==false) {
			aumentarArray();
			for(int i=0;i<arrayProdEsc.length;i++) {
				if(arrayProdEsc[i] == null) {
					arrayProdEsc[i] = new ProductoEscogido();
					arrayProdEsc[i].setNombre(nombre);
					arrayProdEsc[i].setCantidad(cantidad);
					arrayProdEsc[i].setPrecioVenta(precio);
					arrayProdEsc[i].setPrecioTotal(precio*cantidad);
					break;
				}
			}
		}
		this.TotalCarro+=precio*cantidad;
	}
	
	public void aumentarArray() {
		ProductoEscogido[] arrayTemp = new ProductoEscogido[this.arrayProdEsc.length+1];
		for (int i = 0; i<this.arrayProdEsc.length;i++) {
			arrayTemp[i] = new ProductoEscogido();
			arrayTemp[i].setNombre(this.arrayProdEsc[i].getNombre());
			arrayTemp[i].setCantidad(this.arrayProdEsc[i].getCantidad());
			arrayTemp[i].setPrecioVenta(this.arrayProdEsc[i].getPrecioVenta());
			arrayTemp[i].setPrecioTotal(this.arrayProdEsc[i].getPrecioTotal());
		}
		this.arrayProdEsc = Arrays.copyOf(arrayTemp ,this.arrayProdEsc.length+1);
	}
	
	public Object[][] getCarroCompra() {
		this.array = new Object[arrayProdEsc.length][4];
		for(int i = 0;i<arrayProdEsc.length;i++)
		{
			array[i][0] = this.arrayProdEsc[i].getNombre();
			array[i][1] = this.arrayProdEsc[i].getCantidad();
			array[i][2] = this.arrayProdEsc[i].getPrecioVenta();
			array[i][3] = this.arrayProdEsc[i].getPrecioTotal();
		}
		
		return this.array;
	}
	
	public double getTotalCarro() {
		return this.TotalCarro;
	}
	
	public void borrarCarroCompra() {
		Object[][] arrayLimpiador = new Object[0][4];
		ProductoEscogido[] arrayProdEscLimpiador = new ProductoEscogido[0];
		this.array = Arrays.copyOf(arrayLimpiador ,0);
		this.arrayProdEsc = Arrays.copyOf(arrayProdEscLimpiador ,0);
		this.TotalCarro=0;
	}
}
