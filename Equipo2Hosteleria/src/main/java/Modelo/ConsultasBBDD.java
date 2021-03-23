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
	private final String GETPRODUCTO = "SELECT nombre_producto, P.tipo, fecha_caducidad, precio_venta, precio_compra, alergeno, cantidad FROM tiene T join producto P on T.nombre_producto = P.nombre join local L on L.nif = T.nif_local WHERE L.nombre = ?";

    private static Producto arrayProducto[]=new Producto[2];
    
	public Producto[] getListaProductos(String localNombre) {
    	try {
			con = ConexionMySQL.getConexion();	
			ps = con.prepareStatement(GETPRODUCTO);
			
			ps.setString(1, localNombre);
			rs = ps.executeQuery();
			
			while (rs.next()) { 			
				arrayProducto[i] = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getInt(7)); 
				i++; }
				
		} catch (Exception e) {
		//	System.out.println("No se ha podido coger el producto");
		}   	
		return arrayProducto;
	}
    
    public String[] nombresProductos(String localNombre) {
    	Producto[] arrayProductos=getListaProductos(localNombre);
    	String[] arrayNombresProducto = new String[arrayProductos.length];
		
		for(int i = 0;i<arrayProductos.length;i++)
		{
			arrayNombresProducto[i]=arrayProductos[i].getNombre();
		}
		return arrayNombresProducto;
	}
    
    public double precioVentaProductos(String nombre, String localNombre) {
    	Producto[] arrayProductos=getListaProductos(localNombre);
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