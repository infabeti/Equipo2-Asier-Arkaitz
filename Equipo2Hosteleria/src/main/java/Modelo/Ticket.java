package Modelo;

public class Ticket {

	protected int NTransaccion;
	protected String fecha;
	protected String nif_local;
	
	//Constructor sin parametros
	public Ticket() {}
			
	//Constructor con parametros
	public Ticket(int NTransaccion, String fecha, String nif_local) {
		this.setNTransaccion(NTransaccion);
		this.setFecha(fecha);
		this.setNif_local(nif_local);
	}

	public int getNTransaccion() {
		return NTransaccion;
	}

	public void setNTransaccion(int nTransaccion) {
		NTransaccion = nTransaccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNif_local() {
		return nif_local;
	}

	public void setNif_local(String nif_local) {
		this.nif_local = nif_local;
	}
	
}
