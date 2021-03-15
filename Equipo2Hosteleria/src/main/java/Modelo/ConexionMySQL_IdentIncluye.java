package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionMySQL_IdentIncluye {
	
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	private static final String SETIDENTIFICACION = "INSERT INTO identificacion(nif, nombre, apellidos) VAlUES(?,?,?)";
	private static final String GETIDENTIFICACION = "select*from identificacion where nif = ? and nombre = ? and apellidos=?";
	private static final String SETINCLUYE = "INSERT INTO Incluye(nombre_producto, num_trans, cantidad, precio) VAlUES(?,?,?,?)";
	private static final String GETINCLUYE = "select*from Incluye where nombre_producto = ? and num_trans = ? and cantidad = ? and precio = ?";

	public Identificacion registrarIdentificacion(Identificacion ide) {
		
		Identificacion Identificacion1=null;
		
		try {
			 
			ConexionMySQL.Conexion();
			ps = con.prepareStatement(SETIDENTIFICACION);		 
			ps.setString(1,ide.getNif());
			ps.setString(2,ide.getNombre());
			ps.setString(3,ide.getApellidos());			
			ps.executeUpdate();

			String sql = GETIDENTIFICACION;
			pst = con.prepareStatement(sql); 
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
			 ConexionMySQL.Conexion();
			 ps = con.prepareStatement(SETINCLUYE);
			 ps.setString(1,inc.getNombreProducto());
			 ps.setInt(2,inc.getNtransaccion());
			 ps.setInt(3,inc.getCantidad());
			 ps.setDouble(4,inc.getPrecio());
			 ps.executeUpdate();
	
			 String sql = GETINCLUYE;
			 pst = con.prepareStatement(sql);
			 pst.setString(1,inc.getNombreProducto());
			 pst.setInt(2,inc.getNtransaccion());
			 pst.setInt(3,inc.getCantidad());
			 pst.setDouble(4,inc.getPrecio());
			 rs = pst.executeQuery();
	
			 while (rs.next()) {
				 incluye1 = new Incluye(rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getDouble(4));
			 }
			 System.out.println("Se ha creado la Incluye correctamente");
			 
		 } catch (Exception e) {
			 System.out.println("Error en creacion de la Incluye");
		 }
		 return incluye1;
	}
	
}