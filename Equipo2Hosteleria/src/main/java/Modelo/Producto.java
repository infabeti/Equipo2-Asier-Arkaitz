package Modelo;

public class Producto {

	protected String nombre;
	protected String tipo;
	protected String fechaCaducidad;
	protected double precioCompra;
	protected double precioVenta;
	protected String alergeno;
	private int cantidad;
			
	//Constructor con parametros
	public Producto(String Nombre, String Tipo, String FechaCaducidad, double PrecioCompra, double PrecioVenta, String Alergeno, int Cantidad) {
		this.nombre = Nombre;
		this.tipo = Tipo;
		this.fechaCaducidad = FechaCaducidad;
		this.precioCompra = PrecioCompra;
		this.precioVenta = PrecioVenta;
		this.alergeno = Alergeno;
		this.cantidad = Cantidad;
	}
	
	//get y set
	//get
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String getFechaCaducidad() {
		return this.fechaCaducidad;
	}
	
	public double getPrecioCompra() {
		return this.precioCompra;
	}
	
	public double getPrecioVenta() {
		return this.precioVenta;
	}
	
	public String getAlergeno() {
		return this.alergeno;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	//set
	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}
	
	public void setTipo(String Tipo) {
		this.tipo = Tipo;
	}
	
	public void setFechaCaducidad(String FechaCaducidad) {
		this.fechaCaducidad = FechaCaducidad;
	}
	
	public void setPrecioCompra(double PrecioCompra) {
		this.precioCompra = PrecioCompra;
	}
	
	public void setPrecioVenta(double PrecioVenta) {
		this.precioVenta = PrecioVenta;
	}
	
	public void setAlergeno(String Alergeno) {
		this.alergeno = Alergeno;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}

