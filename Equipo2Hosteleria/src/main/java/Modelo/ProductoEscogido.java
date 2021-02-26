package Modelo;

public class ProductoEscogido {

	protected String nombre;
	protected int cantidad;
	protected double precioVenta;
	protected double precioTotal;
			
	//Constructor con parametros
	public ProductoEscogido(String Nombre, int Cantidad, double PrecioVenta, double PrecioTotal) {
		this.setNombre(Nombre);
		this.setCantidad(Cantidad);
		this.setPrecioVenta(PrecioVenta);
		this.setPrecioTotal(PrecioTotal);
	}

	public ProductoEscogido() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}