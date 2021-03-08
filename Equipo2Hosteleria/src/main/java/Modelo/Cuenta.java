package Modelo;

public class Cuenta {
	
	private ConexionMySQL conexionMySQL;
	private Usuario usuario1;

	public boolean crearUsuario(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		usuario1 = new Usuario(dni, contrasena, nombre, apellidos, nif_local);
		Usuario usu = conexionMySQL.registrarUsuario(usuario1);
		boolean creado=false;
		
		if (usu != null) {
			creado=true;
		}else {
			creado=false;
		}
		return creado;
	}
	
	public boolean iniciarUsuario(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		usuario1 = new Usuario(dni, contrasena, nombre, apellidos, nif_local);
		Usuario usu = conexionMySQL.registrarUsuario(usuario1);
		boolean creado=false;
		
		if (usu != null) {
			creado=true;
		}else {
			creado=false;
		}
		return creado;
	}
	
}
