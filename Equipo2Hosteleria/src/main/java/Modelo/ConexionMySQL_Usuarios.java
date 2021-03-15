package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("unused")
public class ConexionMySQL_Usuarios {
	
	private static Connection con=null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	private static Statement st=null;
	static boolean conexion=false;
	private final String GETUSUARIO = "select*from usuario where dni = ? and contraseña =  ? ";
	private final String SETUSUARIO = "INSERT INTO usuario (dni, contraseña, nombre, apellido, nif_local)"+ " values(?,?,?,?,?)";
	private final String NEWUSUARIO = "select*from usuario where dni = ? and contraseña =  ? and nombre =  ? and apellido =  ? and nif_local =  ? ";
	
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

	public Usuario obtenerUsuario(Usuario usu){
		Usuario usuario = null;
		try {
			con = ConexionMySQL.getConexion();
			
			pst = con.prepareStatement(GETUSUARIO);
			pst.setString(1, usu.getDni());
			pst.setString(2, usu.getContrasena());
			rs = pst.executeQuery();
			
			while (rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));			
			}
			System.out.println("Se ha obtenido el usuario correctamente");
		} catch (Exception e) {
			System.out.println("Error en obtener usuario");
		}
		return usuario;
	}
	
	public Usuario registrarUsuario(Usuario usu){
		Usuario usuario3 = null;
		try {
			Conexion();
			pst = con.prepareStatement(SETUSUARIO);		
			pst.setString(1, usu.getDni());	pst.setString(2, usu.getContrasena());	pst.setString(3, usu.getNombre());	pst.setString(4, usu.getApellidos());	pst.setString(5, usu.getNif_local());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("El usuario ya existe o imposible implementar ese usuario");
		}
		return usuario3;
	}
	
	public Usuario comprobarUsuarioRegistrado(Usuario usu){
		Usuario usuario3 = null;
		try {
			Conexion();		

			pst = con.prepareStatement(NEWUSUARIO);			
			pst.setString(1, usu.getDni());	pst.setString(2, usu.getContrasena());	pst.setString(3, usu.getNombre());	pst.setString(4, usu.getApellidos());	pst.setString(5, usu.getNif_local());		
			rs = pst.executeQuery();
			
			while (rs.next()) {
				usuario3 = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));			
			}
			System.out.println("Se ha registrado el usuario correctamente");
		} catch (Exception e) {
			System.out.println("El usuario ya existe o imposible implementar ese usuario");
		}
		return usuario3;
	}
	
	public static void Conexion() throws SQLException {
		con = ConexionMySQL.getConexion();	
		st = con.createStatement();
	}
	
	public boolean Conectar(){
		conexion=true;
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