package Modelo;

import java.sql.*;

public class ConsultasBBDD {

    public static String DB = "equipo2hosteleria_dam";
    public static String URL = "jdbc:mysql://localhost:33060/"+DB;
    public static String USER = "root";
    public static String PASS = "elorrieta";
    static boolean conexion=false;
    private static Producto arrayProducto[]=new Producto[5];
	static int NTransaccion=1;
    
    public Producto[] listaProductos() {
		arrayProducto[0] = new Producto("Garbanzos","Comida","30-01-2021",5,5);
		arrayProducto[1] = new Producto("Paella","Comida","31-01-2021",5,5);
		arrayProducto[2] = new Producto("Bacalao","Comida","02-02-2021",5,5);
		arrayProducto[3] = new Producto("Hamburguesa","Comida","30-01-2021",5,5);
		arrayProducto[4] = new Producto("Cerveza","Bebida","01-02-2021",5,5);
		return arrayProducto;
	}
    
    public String[] getNombresProductos(Producto[] arrayProducto) {
    	String[] arrayNombresProducto = new String[arrayProducto.length];
		
		for(int i = 0;i<arrayProducto.length;i++)
		{
			arrayNombresProducto[i]=arrayProducto[i].getNombre();
		}
		
		return arrayNombresProducto;
	}
    
    public double precioVentaProductos(String nombre, Producto[] arrayProducto) {
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
    
    public int getNTransaccion() {
		return NTransaccion;
	}

	public void setNTransaccion(int nTransaccion) {
		NTransaccion = nTransaccion;
	}


   @SuppressWarnings("static-access")
   public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("com.mysql.cj.jdbc.Driver");

           link = DriverManager.getConnection(this.URL, this.USER, this.PASS);

       }catch(Exception ex){
    	   
    	   conexion=false;
           ex.printStackTrace();

       }


       return link;

   }
   
   public static boolean probarConexion() {         
	   
	   conexion=false;
	   
	   ConsultasBBDD mysql = new ConsultasBBDD();

       java.sql.Connection cn= mysql.Conectar();


       if(cn!=null){

    	   conexion=true;

               try{

                   cn.close();

               }catch(SQLException ex){

            	   System.out.println("Error al desconectar "+ex);
            	   conexion=false;

               }

       }
       
       return conexion;

   }


}
   
