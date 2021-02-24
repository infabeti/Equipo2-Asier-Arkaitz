package Modelo;

import java.util.Arrays;

public class CarroCompra {
	
	public double TotalCarro=0;
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
	
	public double getTotalCarro() {
		return this.TotalCarro;
	}
	
	public void borrarCarroCompra() {
		Object[][] arrayLimpiador = new Object[0][4];
		this.array = Arrays.copyOf(arrayLimpiador ,0);
		this.TotalCarro=0;
	}
}
