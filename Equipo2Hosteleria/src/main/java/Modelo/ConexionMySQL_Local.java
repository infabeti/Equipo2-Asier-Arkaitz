package Modelo;

import java.sql.*;

public class ConexionMySQL_Local {
	
	private static Connection con=null;
	private static ResultSet rs=null;
	private static Statement st=null;
	private static PreparedStatement ps = null;
	private final String GETNIFLOCAL = "SELECT nif, nombre, nombre_propietario, tipo, direccion FROM local where nombre=?";
	private final String GETNOMBRELOCAL = "SELECT nombre FROM local";
	private final String GETNUMTRANSACION = "SELECT num_trans FROM ticket";
	private final String GETLOCAL = "SELECT nif, L.nombre, nombre_propietario, tipo, direccion FROM local L join Usuario U on L.nif = U.nif_local where dni=?";

	public Local obtenerNifLocal(Local loc){
		Local local1 = null;
		try {
			con = ConexionMySQL.getConexion();	
			
			ps = con.prepareStatement(GETNIFLOCAL);
			ps.setString(1, loc.getNombre());		
			rs = ps.executeQuery();
			
			while (rs.next()) { local1 = new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)); }			
		} catch (Exception e) {
			System.out.println("El local no se ha cogido correctamente");
		}
		return local1;
	}
	
	public Local obtenerLocal(Local loc, Usuario usu) {
		Local local1 = new Local();
		try {
			con = ConexionMySQL.getConexion();	
			
			ps = con.prepareStatement(GETLOCAL);
			ps.setString(1, usu.getDni());		
			rs = ps.executeQuery();
			
			while (rs.next()) { local1 = new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)); }			
		} catch (Exception e) {
			System.out.println("El local no se ha cogido correctamente");
		}
		return local1;
	}
	
	public String[] nombreLocal() {
		String [] registro = new String[3];
		int i=0;
		try {
			Conexion();
			st = con.createStatement();
			rs = st.executeQuery(GETNOMBRELOCAL);
			while (rs.next()) {
				registro[i] = rs.getString("nombre");	
				i++;
			} 
			return registro;
		} catch (Exception e) {
			System.out.println("Error en obtencion del Nombre del Local");
			return null;
		}	
	}
	
	public String NTransaccionTicketGeneral() {
		try {
			Conexion();
			st = con.createStatement();
			rs = st.executeQuery(GETNUMTRANSACION);
			String registro="";
			while (rs.next()) { registro=rs.getString("num_trans");	} 
			int registroEntero = Integer.parseInt(registro);
			registroEntero= registroEntero + 1;
			String registroString= ""+registroEntero;
			return registroString;
		} catch (Exception e) {
			System.out.println("Error en obtener el Numero de Transacción");
			return null;
		}	
	}
 
	public static void Conexion() throws SQLException {
		con = ConexionMySQL.getConexion();	
		st = con.createStatement();
	}
}