package Modelo;

import java.time.LocalDate;

public class Modelo {

	private ConsultasBBDD consultasBBDD;
	private ConexionMySQL conexionMySQL;
	private CarroCompra carroCompra;
	private Ticket ticket1;
    private Factura factura1;
    private Pedido pedido1;
    private Usuario usuario1;
	LocalDate date = LocalDate.now();
	
	public Modelo() {
		consultasBBDD = new ConsultasBBDD();
		conexionMySQL = new ConexionMySQL();
		carroCompra = new CarroCompra();
		ticket1 = new Ticket();
		factura1 = new Factura();
		pedido1 = new Pedido();
		usuario1 = new Usuario();
	}
	
	public ConsultasBBDD getConsultasBBDD() {
		return this.consultasBBDD;
	}
	
	public void setConsultasBBDD(ConsultasBBDD consultasBBDD) {
		this.consultasBBDD = consultasBBDD;
	}

	public ConexionMySQL getConexionMySQL() {
		return conexionMySQL;
	}

	public void setConexionMySQL(ConexionMySQL conexionMySQL) {
		this.conexionMySQL = conexionMySQL;
	}
	
	public CarroCompra getCarroCompra() {
		return this.carroCompra;
	}
	
	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}
	
	public Ticket getTicket() {
		return this.ticket1;
	}
	
	public void setTicket() {
    	String fecha = date.toString();
		ticket1=new Ticket(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), "TICKET");
	}
	
	public Factura getFactura() {
		return this.factura1;
	}
    
    public void setFactura(String nif, String nombre, String apellidos) {
    	String fecha = date.toString();
		factura1=new Factura(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), "FACTURA", nif, nombre, apellidos);
	}
	
	public Pedido getPedido() {
		return this.pedido1;
	}
    
    public void setPedido(String tipoPedido, String domicilio) {
    	String fecha = date.toString();
		pedido1=new Pedido(this.consultasBBDD.getNTransaccion(), fecha, this.consultasBBDD.getNIFLocal(), "PEDIDO", tipoPedido, domicilio);
	}

	public Usuario getUsuario() {
		return usuario1;
	}

	public boolean crearUsuario(String dni, String contrasena, String nombre, String apellidos, String nif_local) {
		usuario1 = new Usuario(dni, contrasena, nombre, apellidos, nif_local);
		Usuario usu = conexionMySQL.registrarUsuario(usuario1);
		boolean creado=false;
		
		if (usu != null) {
			creado=true;
		}else {
			creado=false;
		}
		return creado;
	}
	
}
