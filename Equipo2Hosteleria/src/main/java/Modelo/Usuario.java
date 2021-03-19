package Modelo;

public class Usuario {

	private String dni;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String nif_local;
	
	public Usuario() {}
			
	//Constructor con parametros
	public Usuario(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		this.setDni(dni);
		this.setContrasena(contrasena);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setNif_local(nif_local);
	}
	
	public Usuario(String dni, String contrasena) {
		this.setDni(dni);
		this.setContrasena(contrasena);
	}
	
	public Usuario(String dni) {
		this.setDni(dni);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif_local() {
		return nif_local;
	}

	public void setNif_local(String nif_local) {
		this.nif_local = nif_local;
	}
	
}