package Modelo;

public class Modelo {

	private ConsultasBBDD consultasBBDD;
	private ConexionMySQL conexionMySQL;
	private ConexionMySQL_IdentIncluye conexionMySQL_IdentIncluye;
	private ConexionMySQL_Local conexionMySQL_Local;
	private ConexionMySQL_Pedido conexionMySQL_Pedido;
	private ConexionMySQL_TicketFactura conexionMySQL_TicketFactura;
	private ConexionMySQL_Usuarios conexionMySQL_Usuarios;
	private CarroCompra carroCompra;
	private Cuenta cuenta;
	private Pago pago;
	private Local local;
	
	public Modelo() {
		consultasBBDD = new ConsultasBBDD();
		conexionMySQL = new ConexionMySQL();
		conexionMySQL_IdentIncluye = new ConexionMySQL_IdentIncluye();
		conexionMySQL_Local = new ConexionMySQL_Local();
		conexionMySQL_Pedido = new ConexionMySQL_Pedido();
		conexionMySQL_TicketFactura = new ConexionMySQL_TicketFactura();
		conexionMySQL_Usuarios = new ConexionMySQL_Usuarios();
		carroCompra = new CarroCompra();
		cuenta = new Cuenta();
		pago = new Pago();
		local = new Local();
	}
	
	public ConsultasBBDD getConsultasBBDD() {
		return this.consultasBBDD;
	}
	
	public void setConsultasBBDD(ConsultasBBDD consultasBBDD) {
		this.consultasBBDD = consultasBBDD;
	}

	public ConexionMySQL getConexionMySQL() { return conexionMySQL;	}

	public void setConexionMySQL(ConexionMySQL conexionMySQL) {
		this.conexionMySQL = conexionMySQL;
	}

	public ConexionMySQL_IdentIncluye getConexionMySQL_IdentIncluye() {	return conexionMySQL_IdentIncluye; }

	public void setConexionMySQL_IdentIncluye(ConexionMySQL_IdentIncluye conexionMySQL_IdentIncluye) {
		this.conexionMySQL_IdentIncluye = conexionMySQL_IdentIncluye;
	}

	public ConexionMySQL_Local getConexionMySQL_Local() { return conexionMySQL_Local; }

	public void setConexionMySQL_Local(ConexionMySQL_Local conexionMySQL_Local) {
		this.conexionMySQL_Local = conexionMySQL_Local;
	}

	public ConexionMySQL_Pedido getConexionMySQL_Pedido() {	return conexionMySQL_Pedido; }

	public void setConexionMySQL_Pedido(ConexionMySQL_Pedido conexionMySQL_Pedido) {
		this.conexionMySQL_Pedido = conexionMySQL_Pedido;
	}

	public ConexionMySQL_TicketFactura getConexionMySQL_TicketFactura() { return conexionMySQL_TicketFactura; }

	public void setConexionMySQL_TicketFactura(ConexionMySQL_TicketFactura conexionMySQL_TicketFactura) {
		this.conexionMySQL_TicketFactura = conexionMySQL_TicketFactura;
	}

	public ConexionMySQL_Usuarios getConexionMySQL_Usuarios() {	return conexionMySQL_Usuarios;	}

	public void setConexionMySQL_Usuarios(ConexionMySQL_Usuarios conexionMySQL_Usuarios) {
		this.conexionMySQL_Usuarios = conexionMySQL_Usuarios;
	}
	
	public CarroCompra getCarroCompra() { return this.carroCompra;	}
	
	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}

	public Cuenta getCuenta() {	return cuenta;	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Pago getPago() {	return pago; }

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Local getLocal() { return local; }

	public void setLocal(String dni) {
		this.local = getCuenta().obtenerLocal(dni);
	}
	
}