package Modelo;

public class Cuenta {
	
	private ConexionMySQL_Usuarios conexionMySQL_Usuarios;
	private ConexionMySQL_Local conexionMySQL_Local;
	private Usuario usuario1;
	private Local local1;
	private boolean funciona;
	
	public Cuenta() {
		conexionMySQL_Usuarios = new ConexionMySQL_Usuarios();
		conexionMySQL_Local = new ConexionMySQL_Local();
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
	
	public String obtenerNifLocal(String nombre) {
		local1 = new Local(nombre);
		Local loc = this.conexionMySQL_Local.obtenerNifLocal(local1);
	
		if (loc != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return loc.getNIF(); 
	}	
	
	public Local obtenerLocal(String dni) {
		usuario1 = new Usuario(dni);
		local1 = new Local();
		Local loc = this.conexionMySQL_Local.obtenerLocal(local1,usuario1);
	
		if (loc != null) {
			funciona=true;
		}else {
			funciona=false;
		}
		return loc; 
	}
	
}