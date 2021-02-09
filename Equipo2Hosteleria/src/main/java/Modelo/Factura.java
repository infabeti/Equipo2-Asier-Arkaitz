package Modelo;

public class Factura extends Ticket{

	private String nif;
	private String nombre;
	private String apellidos;
	
	//Constructor sin parametros
	public Factura() {}
			
	//Constructor con parametros
	public Factura(int NTransaccion, String fecha, String nif_local, String nif, String nombre, String apellidos) {
		this.setNTransaccion(NTransaccion);
		this.setFecha(fecha);
		this.setNif_local(nif_local);
		this.setNif(nif);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
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