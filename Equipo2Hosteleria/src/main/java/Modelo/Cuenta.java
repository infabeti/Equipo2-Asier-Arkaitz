package Modelo;

public class Cuenta {
	
	private ConexionMySQL conexionMySQL;
	private Usuario usuario1;
	private boolean funciona;

	public boolean crearUsuario(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		conexionMySQL = new ConexionMySQL();
		usuario1 = new Usuario(dni, contrasena, nombre, apellidos, nif_local);
		Usuario usu = conexionMySQL.registrarUsuario(usuario1);
		usu = conexionMySQL.comprobarUsuarioRegistrado(usuario1);
		
		if (usu != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}	
	
	public boolean iniciarUsuario(String dni, String contrasena) {
		conexionMySQL = new ConexionMySQL();
		usuario1 = new Usuario(dni, contrasena);
		Usuario usu = conexionMySQL.obtenerUsuario(usuario1);
		
		if (usu != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}
}
