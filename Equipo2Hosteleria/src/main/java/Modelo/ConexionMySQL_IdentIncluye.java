package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("unused")
public class ConexionMySQL_IdentIncluye {
	
	private static Connection con=null;
	private static PreparedStatement ps = null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	private static Statement st=null;
	static boolean conexion=false;
	private final String SETIDENTIFICACION = "INSERT INTO identificacion(nif, nombre, apellidos) VAlUES(?,?,?)";
	private final String GETIDENTIFICACION = "select*from identificacion where nif = ? and nombre = ? and apellidos=?";
	private final String SETINCLUYE = "INSERT INTO Incluye(nombre_producto, num_trans, cantidad, precio) VAlUES(?,?,?,?)";
	private final String GETINCLUYE = "select*from Incluye where nombre_producto = ? and num_trans = ? and cantidad = ? and precio = ?";
	
	public final static String URL = "jdbc:mysql://localhost:33060/equipo2hosteleria_dam";
	public final static String USER = "root";
	public final static String PASS = "elorrieta";
	
	public static Connection getConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Driver no Instalado");
		} catch (SQLException e) {
			System.out.println("Error de conexi�n con la Base de Datos");
		}
		return con;
	}

	public Identificacion registrarIdentificacion(Identificacion ide) {
		Identificacion Identificacion1=null;
		try {
			Conexion();
			ps = con.prepareStatement(SETIDENTIFICACION);
			ps.setString(1,ide.getNif());
			ps.setString(2,ide.getNombre());
			ps.setString(3,ide.getApellidos());
			ps.executeUpdate();
			pst = con.prepareStatement(GETIDENTIFICACION); 
			pst.setString(1,ide.getNif());
			pst.setString(2,ide.getNombre());
			pst.setString(3,ide.getApellidos());
			rs = pst.executeQuery();
			while (rs.next()) {
				Identificacion1 = new Identificacion(rs.getString(1), rs.getString(2), rs.getString(3));			
			}
			System.out.println("Se ha creado la Identificacion correctamente");
		}catch (Exception e) {
			System.out.println("Error en creacion de la Identificacion");
		}
		return Identificacion1;
	}
	 
	public Incluye registrarIncluye(Incluye inc) {
		 Incluye incluye1=null;
		 try {
			 Conexion();
			 ps = con.prepareStatement(SETINCLUYE);
			 ps.setString(1,inc.getNombreProducto());
			 ps.setInt(2,inc.getNtransaccion());
			 ps.setInt(3,inc.getCantidad());
			 ps.setDouble(4,inc.getPrecio());
			 ps.executeUpdate();
			 pst = con.prepareStatement(GETINCLUYE);
			 pst.setString(1,inc.getNombreProducto());
			 pst.setInt(2,inc.getNtransaccion());
			 pst.setInt(3,inc.getCantidad());
			 pst.setDouble(4,inc.getPrecio());
			 rs = pst.executeQuery();
			 while (rs.next()) {
				 incluye1 = new Incluye(rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getDouble(4));
			 }
			 System.out.println("Se ha creado la Incluye correctamente");
		 } catch (Exception e) { System.out.println("Error en creacion de la Incluye");	 }
		 return incluye1;
	}
	
	public static void Conexion() throws SQLException {
		con = getConexion();
		st = con.createStatement();
	}
}