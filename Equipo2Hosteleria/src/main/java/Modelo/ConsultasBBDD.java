package Modelo;

import java.sql.*;
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Arrays;

public class ConsultasBBDD {

    public String DB = "equipo2hosteleria_dam";
    public String URL = "jdbc:mysql://localhost:33060/"+DB;
    public String USER = "root";
    public String PASS = "elorrieta";
    static boolean conexion=false;
    private static Producto arrayProducto[]=new Producto[5];
    private Ticket arrayTicket[]=new Ticket[99];
    private Factura arrayFactura[]=new Factura[99];
    private Pedido arrayPedido[]=new Pedido[99];
	static int NTransaccion=1;
	LocalDate date = LocalDate.now();
=======

public class ConsultasBBDD {

    public final String DB = "equipo2hosteleria_dam";
    public final String URL = "jdbc:mysql://localhost:33060/"+DB;
    public final String USER = "root";
    public final String PASS = "elorrieta";
    static boolean conexion=false;
    private static Producto arrayProducto[]=new Producto[5];
	static int NTransaccion=1;
>>>>>>> main
    
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
<<<<<<< HEAD
		
=======
>>>>>>> main
		return arrayNombresProducto;
	}
    
    public double precioVentaProductos(String nombre) {
    	Producto[] arrayProductos=getListaProductos();
    	double precio=0;
		
		for(int i = 0;i<arrayProductos.length;i++)
		{
			if(nombre.equals(arrayProductos[i].getNombre())) {
				precio=arrayProductos[i].getPrecioVenta();
<<<<<<< HEAD
				i=arrayProductos.length;
			}
		}
		
		return precio;
	}
    
    public void makeTicket() {
    	String fecha = date.toString();
		arrayTicket[getNTransaccion()-1] = new Ticket(getNTransaccion(), fecha, getNIFLocal());
		System.out.println(Arrays.toString(arrayTicket));
	}
    
    public void makeFactura(String nif, String nombre, String apellidos) {
    	String fecha = date.toString();
		arrayFactura[getNTransaccion()-1] = new Factura(getNTransaccion(), nif);
		System.out.println(Arrays.toString(arrayFactura));
	}
    
    public void makePedido(String tipo, String domicilio) {
    	String fecha = date.toString();
		arrayPedido[getNTransaccion()-1] = new Pedido(getNTransaccion(), fecha, getNIFLocal(), tipo, domicilio);
		System.out.println(Arrays.toString(arrayPedido));
	}
    
=======
				break;
			}
		}
		return precio;
	}
    
>>>>>>> main
    public int getNTransaccion() {
		return NTransaccion;
	}

	public void setNTransaccion(int nTransaccion) {
		NTransaccion = nTransaccion;
	}
	
	public void sumarNTransaccion() {
		NTransaccion++;
	}
	
	public String getNIFLocal() {
		return "12345678L";
	}


<<<<<<< HEAD
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
   
   public boolean probarConexion() {         
	   
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
=======
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
   
>>>>>>> main
