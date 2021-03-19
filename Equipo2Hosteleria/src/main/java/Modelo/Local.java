package Modelo;

public class Local {

	protected String nif;
	protected String nombre;
	protected String nombre_propietario;
	protected String tipo;
	protected String direccion;
	
	//Constructor sin parametros
	public Local() {}
	
	//Constructor con parametros
	public Local(String NIF, String Nombre, String NombrePropietario, String Tipo, String Direccion) {
		this.nif = NIF;
		this.nombre = Nombre;
		this.nombre_propietario = NombrePropietario;
		this.tipo = Tipo;
		this.direccion = Direccion;
	}
	
	public Local(String Nombre) {
		this.nombre = Nombre;
	}

	//get y set
	//get
	public String getNIF() {
		return this.nif;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getNombrePropietario() {
		return this.nombre_propietario;
	}
		
	public String getTipo() {
		return this.tipo;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
		
			
	//set
	public void setNIF(String NIF) {
		this.nif = NIF;
	}
	
	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}
	
	public void setNombrePropietario(String NombrePropietario) {
		this.nombre_propietario = NombrePropietario;
	}
	
	public void setTipo(String Tipo) {
		this.tipo = Tipo;
	}
	
	public void setDireccion(String Direccion) {
		this.direccion = Direccion;
	}
	
}