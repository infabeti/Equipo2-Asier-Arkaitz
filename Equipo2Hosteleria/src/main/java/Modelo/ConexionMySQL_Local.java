package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConexionMySQL_Local {
	
	private static Connection con=null;
	private static ResultSet rs=null;
	private static Statement st=null;
	static boolean conexion=false;
	private final String GETNIFLOCAL_P1 = "SELECT nif FROM local where nombre='";
	private final String GETNIFLOCAL_P2 = "';";
	private final String GETNOMBRELOCAL = "SELECT nombre FROM local";
	private final String GETNUMTRANSACION = "SELECT num_trans FROM ticket";
	private final String GETLOCAL_P1 = "SELECT nif, L.nombre, nombre_propietario, tipo, direccion FROM local L join Usuario U on L.nif = U.nif_local where dni='";
	private final String GETLOCAL_P2 = "';";
	
	public final static String URL = "jdbc:mysql://localhost:33060/equipo2hosteleria_dam";
	public final static String USER = "root";
	public final static String PASS = "elorrieta";

	public String nifLocal(String nombreLocal) {
		try {
			Conexion();
			st = con.createStatement();
			rs = st.executeQuery(GETNIFLOCAL_P1+nombreLocal+GETNIFLOCAL_P2);
			String registro="";
			while (rs.next()) { registro=rs.getString("nif"); } 
			return registro;
		} catch (Exception e) {
			System.out.println("Error en creacion de la Incluye");
			return null;
		}	
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
			System.out.println("Error en creacion de la Incluye");
			return null;
		}	
	}
	
	public String NTransaccionTicketGeneral() {
		try {
			Conexion();
			st = con.createStatement();
			rs = st.executeQuery(GETNUMTRANSACION);
			String registro="";
			while (rs.next()) {
				registro=rs.getString("num_trans");			
			} 
			int registroEntero = Integer.parseInt (registro);
			registroEntero= registroEntero + 1;
			String registroString= ""+registroEntero;
			return registroString;
		} catch (Exception e) {
			System.out.println("Error en coger el Nif");
			return null;
		}	
	}
	
	public Local obtenerLocal(String dni) {
		Local local1 = new Local();
		try {
			Conexion();
			st = con.createStatement(); 
			rs = st.executeQuery(GETLOCAL_P1+dni+GETLOCAL_P2); 
			while (rs.next()) {
				local1 = new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));			
			}
		} catch (Exception e) {	System.out.println("Error en obtener el Local"); }	
		return local1;
	}
 
	public static void Conexion() throws SQLException {
		con = ConexionMySQL.getConexion();	
		st = con.createStatement();
	}
}