package Modelo;

public class Identificacion extends Factura{
	
	private String nombre;
	private String apellidos;
	
	public Identificacion() {}
	
	public Identificacion(String NIF, String nombre, String apellidos) {
		this.setNif(NIF);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
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
	
}
