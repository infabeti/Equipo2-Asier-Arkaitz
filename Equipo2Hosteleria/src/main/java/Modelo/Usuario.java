package Modelo;

public class Usuario {

	protected String usuario;
	protected String negocio;
	protected String contraseña;
	protected String nombre;
	protected String apellidos;
	protected String nombreEmpresa;
	protected String nif;
	
	public Usuario() {}
			
	//Constructor con parametros
	public Usuario(String Usuario, String Contraseña, String Negocio, String Nombre, String Apellidos, String NombreEmpresa, String NIF) {
		this.usuario = Usuario;
		this.negocio = Negocio;
		this.contraseña = Contraseña;
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.nombreEmpresa = NombreEmpresa;
		this.nif = NIF;
	}
	
	public Usuario(String Usuario, String Contraseña, String Nombre, String Apellidos, String NIF) {
		this.usuario = Usuario;
		this.contraseña = Contraseña;
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.nif = NIF;
	}
	
	//get y set
	//get
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getTipo() {
		return this.negocio;
	}
	
	public String getNombre() {
		return nombre;
	}
		
	public String getApellidos() {
		return apellidos;
	}
	
	public String getNombreempresa() {
		return nombreEmpresa;
	}

	public String getNif() {
		return nif;
	}

	public String getContraseña() {
		return this.contraseña;
	}
		
	//set
	public void setUsuario(String Usuario) {
		this.usuario = Usuario;
	}
	
	public void setTipo(String Negocio) {
		this.negocio = Negocio;
	}
	
	public void setContraseña(String Contraseña) {
		this.contraseña = Contraseña;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setNombreempresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}

}

