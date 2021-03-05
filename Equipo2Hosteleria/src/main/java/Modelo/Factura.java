package Modelo;

public class Factura extends Ticket{

	protected String nif;
	
	//Constructor sin parametros
	public Factura() {}
			
	//Constructor con parametros
	public Factura(int NTransaccion, String tipo, String nif) {
		super.setNTransaccion(NTransaccion);
		super.setTipo(tipo);
		this.setNif(nif);
	}
	
	public Factura(int NTransaccion, String nif) {
		super.setNTransaccion(NTransaccion);
		this.setNif(nif);
	}
	
	public Factura(int NTransaccion, String fecha, String nif_local, String tipo, String nif, String nombre, String apellidos) {
		super.setNTransaccion(NTransaccion);
		super.setFecha(fecha);
		super.setNif_local(nif_local);
		super.setTipo(tipo);
		this.setNif(nif);
	}

	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	
}
