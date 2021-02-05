package Modelo;

public class ObtenerDatos {
		Producto arrayProducto[]=new Producto[5];
		String arrayNombresProducto[]=new String[5];
		double arrayVentaProducto[]=new double[5];
	
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
