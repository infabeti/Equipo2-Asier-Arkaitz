package Modelo;

public class Producto {

	protected String nombre;
	protected String tipo;
	protected String fechaCaducidad;
	protected double precioCompra;
	protected double precioVenta;
	
	//Constructor por defecto
	public Producto() {
				
	}
			
	//Constructor con parametros
	public Producto(String Nombre, String Tipo, String FechaCaducidad, double PrecioCompra, double PrecioVenta) {
		this.nombre = Nombre;
		this.tipo = Tipo;
		this.fechaCaducidad = FechaCaducidad;
		this.precioCompra = PrecioCompra;
		this.precioVenta = PrecioVenta;

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
	
			
	//set
	public void setNombre(String Nombre)
	{
	this.nombre = Nombre;
	}
	
	public void setTipo(String Tipo)
	{
	this.tipo = Tipo;
	}
	
	public void setFechaCaducidad(String FechaCaducidad)
	{
	this.fechaCaducidad = FechaCaducidad;
	}
	
	public void setPrecioCompra(double PrecioCompra)
	{
	this.precioCompra = PrecioCompra;
	}
	
	public void setPrecioVenta(double PrecioVenta)
	{
	this.precioVenta = PrecioVenta;
	}
	
	//METODOS
	
	 public String toString() {
	      return nombre;
	   }
	 
	 public double PrecioVenta() {
	      return precioVenta;
	   }
	
	
}

