package Modelo;

public class Incluye  {
	
	private String nombreProducto;
	private int ntransaccion;
	private int cantidad;
	private double precio;
	private String tipo;
	
	public Incluye() {}
	
	public Incluye(String NombreProducto, int Ntransaccion, int Cantidad, double Precio,String Tipo) {
		this.nombreProducto = NombreProducto;
		this.ntransaccion = Ntransaccion;
		this.cantidad = Cantidad;
		this.precio = Precio;
		this.tipo = Tipo;
	}

	//Get y Set
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public int getNtransaccion() {
		return ntransaccion;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setNombreProducto(String NombreProducto) {
		this.nombreProducto = NombreProducto;
	}
	
	public void setNTransaccion(int Ntransaccion) {
		this.ntransaccion = Ntransaccion;
	}
	
	public void setCantidad(int Cantidad) {
		this.cantidad = Cantidad;
	}
	
	public void setPrecio(double Precio) {
		this.precio = Precio;
	}
	
	public void setTipo(String Tipo) {
		this.tipo = Tipo;
	}
}
