package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasBBDD {

	private static Connection con=null;
	private static ResultSet rs=null;
	@SuppressWarnings("unused")
	private static Statement st=null;
	private static PreparedStatement ps = null;
	private static int i = 0;
	private final String GETPRODUCTO = "SELECT nombre, tipo, fecha_caducidad, precio_venta, precio_compra, alergeno, cantidad FROM tiene T join producto P on T.nombre_producto = P.nombre WHERE nif_local = 'B78107158';";

    private static Producto arrayProducto[]=new Producto[3];
    
	public Producto[] getListaProductos() {
    	try {
			con = ConexionMySQL.getConexion();	
			
			ps = con.prepareStatement(GETPRODUCTO);	
			rs = ps.executeQuery();
			
			while (rs.next()) { 			
				arrayProducto[i] = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getInt(7)); 
				i++; }
				
		} catch (Exception e) {
		//	System.out.println("No se ha podido coger el producto");
		}   	
		return arrayProducto;
	}
    
    public String[] nombresProductos() {
    	Producto[] arrayProductos=getListaProductos();
    	String[] arrayNombresProducto = new String[arrayProductos.length];
		
		for(int i = 0;i<arrayProductos.length;i++)
		{
			arrayNombresProducto[i]=arrayProductos[i].getNombre();
		}
		return arrayNombresProducto;
	}
    
    public double precioVentaProductos(String nombre) {
    	Producto[] arrayProductos=getListaProductos();
    	double precio=0;
		
		for(int i = 0;i<arrayProductos.length;i++)
		{
			if(nombre.equals(arrayProductos[i].getNombre())) {
				precio=arrayProductos[i].getPrecioVenta();
				break;
			}
		}
		return precio;
	}
    
	public static void Conexion() throws SQLException {
		con = ConexionMySQL.getConexion();	
		st = con.createStatement();
	}
}