package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionMySQL_Usuarios {
	
	private static Connection con=null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	
	public Usuario obtenerUsuario(Usuario usu){
		Usuario usuario = null;
		
		try {
		
			con = ConexionMySQL.getConexion();
		
			String sql = "select*from usuario where dni = ? and contraseña =  ? ";
			
			pst = con.prepareStatement(sql);
			
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
			ConexionMySQL.Conexion();
			
			pst = con.prepareStatement("INSERT INTO usuario (dni, contraseña, nombre, apellido, nif_local)"+ " values(?,?,?,?,?)");		
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
			ConexionMySQL.Conexion();		
			String sql = "select*from usuario where dni = ? and contraseña =  ? and nombre =  ? and apellido =  ? and nif_local =  ? ";			
			pst = con.prepareStatement(sql);			
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
	
}