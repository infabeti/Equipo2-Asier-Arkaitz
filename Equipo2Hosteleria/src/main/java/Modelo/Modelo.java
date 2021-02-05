package Modelo;


public class Modelo {

	private Producto arrayProducto[]=new Producto[5];
	private String arrayNombresProducto[]=new String[5];
	private CarroCompra carro;
	private ConexionMySQL probarConexion;
	
	//OBTENER DATOS DE PRODUCTOS
	public String[] getNombresProductos() {
		//arrayNombresProducto = Producto.nombresProductos();
		
		return arrayNombresProducto;
	}
	
	public String[] nombresProductos() {
		//Producto arrayProducto[]=listaProductos();
				
		for(int i = 0;i<arrayProducto.length;i++)
		{
			arrayNombresProducto[i]=arrayProducto[i].getNombre();
		}
		
		return arrayNombresProducto;
	}
	
	public Producto getPrecioVentaProductos() {
		return this.precioVentaProductos;
	}
	
	//ALMACENAR DATOS CARRO DE LA COMPRA
	public CarroCompra setListaCompra() {
		this.anadirProductos;
	}
	
	public CarroCompra getListaCompra() {
		return this.leerLista;
	}
	
	public CarroCompra setTotalCarro() {
		return this.añadirCoste;
	}
	
	public CarroCompra getTotalCarro() {
		return this.leerCoste;
	}
	
	public CarroCompra resetCarro() {
		return this.borrarListaCompra;
	}
	
	public CarroCompra mostrarNumeroTransaccion() {
		return this.leerNumTrans;
	}
	
	public CarroCompra aumentarNumeroTransaccion() {
		return this.sumarNumTrans;
	}
	
	//MYSQL
	public ConexionMySQL pruebaConexion() {
		return this.probarConexion;
	}
	
}
