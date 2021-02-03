package Modelo;

import java.sql.*;

public class ConexionMySQL {

    public static String DB = "equipo2hosteleria_dam";
    public static String URL = "jdbc:mysql://localhost:33060/"+DB;
    public static String USER = "root";
    public static String PASS = "elorrieta";
    static boolean conexion=false;


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
	   
	   ConexionMySQL mysql = new ConexionMySQL();

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
   
