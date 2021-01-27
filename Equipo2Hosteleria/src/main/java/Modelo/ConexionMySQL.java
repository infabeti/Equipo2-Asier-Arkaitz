package Modelo;

 
import java.sql.*;
import javax.swing.JOptionPane;


public class ConexionMySQL {

    public String db = "equipo2hosteleria_dam";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "elorrieta";


   public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("org.gjt.mm.mysql.Driver");

           link = DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(Exception ex){

           JOptionPane.showMessageDialog(null, ex);

       }


       return link;

   }
   
   private void btnProbarconexionActionPerformed(java.awt.event.ActionEvent evt) {                                                  


       ConexionMySQL mysql = new ConexionMySQL();

       java.sql.Connection cn= mysql.Conectar();


       if(cn!=null){

               JOptionPane.showMessageDialog(null, "Conectado");

               try{

                   cn.close();

               }catch(SQLException ex){

                   System.out.println("Error al desconectar "+ex);

               }

       }
       

   }                                                 


}
   
