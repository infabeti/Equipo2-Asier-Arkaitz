package Modelo;


public class Modelo {

	private ObtenerDatos nombresProductos;
	private ObtenerDatos precioVentaProductos;
	private AlmacenarDatos a�adirProductos;
	private AlmacenarDatos leerLista;
	private AlmacenarDatos a�adirCoste;
	private AlmacenarDatos leerCoste;
	private AlmacenarDatos borrarListaCompra;
	private AlmacenarDatos leerNumTrans;
	private AlmacenarDatos sumarNumTrans;
	private ConexionMySQL probarConexion;
	
	//OBTENER DATOS DE PRODUCTOS
	public ObtenerDatos getNombresProductos() {
		return this.nombresProductos;
	}
	
	public ObtenerDatos getPrecioVentaProductos() {
		return this.precioVentaProductos;
	}
	
	//ALMACENAR DATOS CARRO DE LA COMPRA
	public AlmacenarDatos setListaCompra() {
		return this.a�adirProductos;
	}
	
	public AlmacenarDatos getListaCompra() {
		return this.leerLista;
	}
	
	public AlmacenarDatos setTotalCarro() {
		return this.a�adirCoste;
	}
	
	public AlmacenarDatos getTotalCarro() {
		return this.leerCoste;
	}
	
	public AlmacenarDatos resetCarro() {
		return this.borrarListaCompra;
	}
	
	public AlmacenarDatos mostrarNumeroTransaccion() {
		return this.leerNumTrans;
	}
	
	public AlmacenarDatos aumentarNumeroTransaccion() {
		return this.sumarNumTrans;
	}
	
	//MYSQL
	public ConexionMySQL pruebaConexion() {
		return this.probarConexion;
	}
	
}
