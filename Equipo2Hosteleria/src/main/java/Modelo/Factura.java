package Modelo;

public class Factura extends Ticket{

	private String nif;

	
	//Constructor sin parametros
	public Factura() {}
			
	//Constructor con parametros
	public Factura(int NTransaccion, String nif) {
		this.setNTransaccion(NTransaccion);
		this.setNif(nif);
		
	}

	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}

	

	
	
}