package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	
	private static Connection con=null;
	static boolean conexion=false;
	
	public final static String URL = "jdbc:mysql://localhost:33060/equipo2hosteleria_dam";
	public final static String USER = "root";
	public final static String PASS = "elorrieta";
	
	public static Connection getConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Driver no Instalado");
		} catch (SQLException e) {
			System.out.println("Error de conexión con la Base de Datos");
		}
		return con;
	}
	
	public boolean Conectar(){
		conexion=true;
	    @SuppressWarnings("unused")
	    Connection link = null;
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	link = DriverManager.getConnection(ConexionMySQL.URL, ConexionMySQL.USER, ConexionMySQL.PASS);
	    }catch(Exception ex){
	    	conexion=false;
	    	ex.printStackTrace();
	    }
	    return conexion;
	}

}