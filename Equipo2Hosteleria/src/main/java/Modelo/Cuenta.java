package Modelo;

public class Cuenta {
	
	private ConexionMySQL_Usuarios conexionMySQL_Usuarios;
	private Usuario usuario1;
	private boolean funciona;

	public boolean crearUsuario(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		conexionMySQL_Usuarios = new ConexionMySQL_Usuarios();
		usuario1 = new Usuario(dni, contrasena, nombre, apellidos, nif_local);
		Usuario usu = conexionMySQL_Usuarios.registrarUsuario(usuario1);
		usu = conexionMySQL_Usuarios.comprobarUsuarioRegistrado(usuario1);
		
		if (usu != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}	
	
	public boolean iniciarUsuario(String dni, String contrasena) {
		conexionMySQL_Usuarios = new ConexionMySQL_Usuarios();
		usuario1 = new Usuario(dni, contrasena);
		Usuario usu = conexionMySQL_Usuarios.obtenerUsuario(usuario1);
		
		if (usu != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}
}
