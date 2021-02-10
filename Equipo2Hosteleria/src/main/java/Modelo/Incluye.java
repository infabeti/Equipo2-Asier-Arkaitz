package Modelo;

public class Incluye {
	
	private String nombreProducto;
	private int ntransaccion;
	private int cantidad;
	private double precioVenta;
	private double precioCompra;
	
	
	
	public Incluye(String NombreProducto, int Ntransaccion, int Cantidad, double PrecioVenta,double PrecioCompra) {
		
		this.setNombreProducto(NombreProducto);
		this.setNtransaccion(Ntransaccion);
		this.setCantidad(Cantidad);
		this.setPrecioVenta(PrecioVenta);
		this.setPrecioCompra(PrecioCompra);
	}



	public double getPrecioCompra() {
		return precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public int getNtransaccion() {
		return ntransaccion;
	}
	
	
	
	
	
	
	
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public void setNtransaccion(int ntransaccion) {
		this.ntransaccion = ntransaccion;
	}
	
	
	
	

}
