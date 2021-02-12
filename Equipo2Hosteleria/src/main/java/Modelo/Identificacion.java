package Modelo;

public class Identificacion extends Factura{
	
	private String Nombre;
	private String Apellido;
	
	
	public Identificacion(String NIF, String Nombre, String Apellido) {
		this.setNif(NIF);
		this.setNombre(Nombre);
		this.setApellido(Apellido);
		
	}


	public Identificacion() {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return Nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	

}
