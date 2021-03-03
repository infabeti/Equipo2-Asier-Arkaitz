package Modelo;

public class Factura extends Ticket{

	private String nif;
<<<<<<< HEAD

=======
	private String nombre;
	private String apellidos;
>>>>>>> main
	
	//Constructor sin parametros
	public Factura() {}
			
	//Constructor con parametros
<<<<<<< HEAD
	public Factura(int NTransaccion, String nif) {
		this.setNTransaccion(NTransaccion);
		this.setNif(nif);
		
=======
	public Factura(int NTransaccion, String fecha, String nif_local, String nif, String nombre, String apellidos) {
		super.setNTransaccion(NTransaccion);
		super.setFecha(fecha);
		super.setNif_local(nif_local);
		this.setNif(nif);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
>>>>>>> main
	}

	public String getNif() {
		return nif;
	}

<<<<<<< HEAD

=======
>>>>>>> main
	public void setNif(String nif) {
		this.nif = nif;
	}

<<<<<<< HEAD
	

	
	
}
=======
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
>>>>>>> main
