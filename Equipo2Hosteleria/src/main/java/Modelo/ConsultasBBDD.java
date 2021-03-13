package Modelo;

import java.sql.*;

public class ConsultasBBDD {

	public final String DB = "equipo2hosteleria_dam";
    public final String URL = "jdbc:mysql://localhost:33060/"+DB;
    public final String USER = "root";
    public final String PASS = "elorrieta";
    static boolean conexion=false;
    private static Producto arrayProducto[]=new Producto[5];
    
    public Producto[] getListaProductos() {
		arrayProducto[0] = new Producto("Garbanzos","Comida","30-01-2021",5,5);
		arrayProducto[1] = new Producto("Paella","Comida","31-01-2021",5,5);
		arrayProducto[2] = new Producto("Bacalao","Comida","02-02-2021",5,5);
		arrayProducto[3] = new Producto("Hamburguesa","Comida","30-01-2021",5,5);
		arrayProducto[4] = new Producto("Cerveza","Bebida","01-02-2021",5,5);
		return arrayProducto;
	}
    
    public String[] nombresProductos() {
    	Producto[] arrayProductos=getListaProductos();
    	String[] arrayNombresProducto = new String[arrayProductos.length];
		
		for(int i = 0;i<arrayProductos.length;i++)
		{
			arrayNombresProducto[i]=arrayProductos[i].getNombre();
		}
		return arrayNombresProducto;
	}
    
    public double precioVentaProductos(String nombre) {
    	Producto[] arrayProductos=getListaProductos();
    	double precio=0;
		
		for(int i = 0;i<arrayProductos.length;i++)
		{
			if(nombre.equals(arrayProductos[i].getNombre())) {
				precio=arrayProductos[i].getPrecioVenta();
				break;
			}
		}
		return precio;
	}
    	
	public boolean Conectar(){
	   
	   conexion=true;

       @SuppressWarnings("unused")
       Connection link = null;

       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           link = DriverManager.getConnection(this.URL, this.USER, this.PASS);
           
       }catch(Exception ex){
    	   conexion=false;
           ex.printStackTrace();
       }
       return conexion;
	}

	
}