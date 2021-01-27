package Modelo;


import java.sql.*;
import javax.swing.JOptionPane;



public class ConexionMySQL {

    public String db = "equipo2hosteleria_dam";
    public String url = "jdbc:mysql://localhost:33060/"+db;
    public String user = "root";
    public String pass = "elorrieta";


   public Connection Conectar(){

       Connection link = null;

       try{

           //Class.forName("com.mysql.jdbc.Driver");
           Class.forName("com.mysql.cj.jdbc.Driver");

           link = DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(Exception ex){

           //JOptionPane.showMessageDialog(null, ex);
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

            	   //JOptionPane.showMessageDialog(null, "Error al desconectar "+ex);
            	   JOptionPane.showMessageDialog(null, "Error al conectar");
            	   System.out.println("Error al desconectar "+ex);
            	   System.exit(0);

               }

       }
       

   }


}
   
