package Modelo;

public class Cuenta {
	
	private ConexionMySQL_Usuarios conexionMySQL_Usuarios;
	private Usuario usuario1;
	private boolean funciona;
	
	public Cuenta() {
		conexionMySQL_Usuarios = new ConexionMySQL_Usuarios();
	}

	public boolean crearUsuario(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		usuario1 = new Usuario(dni, contrasena, nombre, apellidos, nif_local);
		Usuario usu = this.conexionMySQL_Usuarios.registrarUsuario(usuario1);
		usu = this.conexionMySQL_Usuarios.comprobarUsuarioRegistrado(usuario1);
		
		if (usu != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}	
	
	public boolean iniciarUsuario(String dni, String contrasena) {
		usuario1 = new Usuario(dni, contrasena);
		Usuario usu = this.conexionMySQL_Usuarios.obtenerUsuario(usuario1);
		
		if (usu != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return funciona;
	}
	
}