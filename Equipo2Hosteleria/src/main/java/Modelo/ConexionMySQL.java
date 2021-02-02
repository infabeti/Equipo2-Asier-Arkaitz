package Modelo;


import java.sql.*;
import javax.swing.JOptionPane;



public class ConexionMySQL {

    public static String DB = "equipo2hosteleria_dam";
    public static String URL = "jdbc:mysql://localhost:33060/"+DB;
    public static String USER = "root";
    public static String PASS = "elorrieta";


   public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("com.mysql.cj.jdbc.Driver");

           link = DriverManager.getConnection(this.URL, this.USER, this.PASS);

           Statement s = link.createStatement();
           ResultSet rs = s.executeQuery ("select * from identificacion");
           
           while (rs.next())
           {
               System.out.println (rs.getInt (1) + " " + rs.getString(2));
           }
           
           link.close();
           
       }catch(Exception ex){

           JOptionPane.showMessageDialog(null, "Error al conectar: "+ex);
           ex.printStackTrace();
           System.exit(0);

       }


       return link;

   }
   
   public static void btnProbarconexionActionPerformed(/*java.awt.event.ActionEvent evt*/) {                                                  


       ConexionMySQL mysql = new ConexionMySQL();

       java.sql.Connection cn= mysql.Conectar();


       if(cn!=null){

               JOptionPane.showMessageDialog(null, "Conectado");

               try{

                   cn.close();

               }catch(SQLException ex){

            	   JOptionPane.showMessageDialog(null, "Error al conectar");
            	   System.out.println("Error al desconectar "+ex);
            	   System.exit(0);

               }

       }
       

   }


   
}
   
