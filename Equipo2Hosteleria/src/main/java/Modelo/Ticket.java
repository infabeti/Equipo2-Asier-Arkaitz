package Modelo;

public class Ticket {

	protected int NTransaccion;
	protected String fecha;
	protected String nif_local;
	protected String tipo;
	
	//Constructor sin parametros
	public Ticket() {}
			
	//Constructor con parametros
	public Ticket(int NTransaccion, String fecha, String nif_local, String tipo) {
		this.setNTransaccion(NTransaccion);
		this.setFecha(fecha);
		this.setNif_local(nif_local);
		this.setTipo(tipo);
	}

	public int getNTransaccion() {
		return this.NTransaccion;
	}

	public void setNTransaccion(int nTransaccion) {
		this.NTransaccion = nTransaccion;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
