package Modelo;

public class Producto {

	protected String nombre;
	protected String tipo;
	protected String fechaCaducidad;
	protected double precioCompra;
	protected double precioVenta;
	Producto arrayProducto[]=new Producto[5];
	String arrayNombresProducto[]=new String[5];
			
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
	public Producto[] listaProductos() {
		arrayProducto[0] = new Producto("Garbanzos","Comida","30-01-2021",5,5);
		arrayProducto[1] = new Producto("Paella","Comida","31-01-2021",5,5);
		arrayProducto[2] = new Producto("Bacalao","Comida","02-02-2021",5,5);
		arrayProducto[3] = new Producto("Hamburguesa","Comida","30-01-2021",5,5);
		arrayProducto[4] = new Producto("Cerveza","Bebida","01-02-2021",5,5);
		return arrayProducto;
	}
	
	public String[] nombresProductos() {
		Producto arrayProducto[]=listaProductos();
				
		for(int i = 0;i<arrayProducto.length;i++)
		{
			arrayNombresProducto[i]=arrayProducto[i].getNombre();
		}
		
		return arrayNombresProducto;
	}
	
	public double precioVentaProductos(String nombre) {
		Producto arrayProducto[]=listaProductos();
		
		double precio=0;
		
		for(int i = 0;i<arrayProducto.length;i++)
		{
			if(nombre.equals(arrayProducto[i].getNombre())) {
				precio=arrayProducto[i].getPrecioVenta();
				i=arrayProducto.length;
			}
		}
		
		return precio;
	}
	
}

