package Modelo;

import javax.swing.ComboBoxModel;

public class Usuario {

	protected String usuario;
	protected String negocio;
	protected String contrase�a;
	protected String nombre;
	protected String apellidos;
	protected String nombreempresa;
	protected String nif;
	
			
	//Constructor con parametros
	public Usuario(String Usuario, String Contrase�a, String Negocio, String Nombre, String Apellidos, String NombreEmpresa, String NIF) {
		this.usuario = Usuario;
		this.negocio = Negocio;
		this.contrase�a = Contrase�a;
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.nombreempresa = NombreEmpresa;
		this.nif = NIF;

			}
	
	public Usuario(String Usuario, String Contrase�a, String Nombre, String Apellidos, String NIF) {
		this.usuario = Usuario;

		this.contrase�a = Contrase�a;
		this.nombre = Nombre;
		this.apellidos = Apellidos;

		this.nif = NIF;

			}
	
	public Usuario() {
		
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
		return nombreempresa;
	}

	public String getNif() {
		return nif;
	}

	public String getContrase�a() {
		
		return this.contrase�a;
	}
	
	
	
			
	//set
	public void setUsuario(String Usuario)
	{
		this.usuario = Usuario;
	}
	
	public void setTipo(String Negocio)
	{
		this.negocio = Negocio;
	}
	
	public void setContrase�a(String Contrase�a)
	{
		this.contrase�a = Contrase�a;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setNombreempresa(String nombreempresa) {
		this.nombreempresa = nombreempresa;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}

	
	
}

