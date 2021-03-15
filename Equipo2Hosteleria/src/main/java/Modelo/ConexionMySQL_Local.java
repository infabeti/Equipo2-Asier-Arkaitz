package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class ConexionMySQL_Local {
	
	private static Connection con=null;
	private static ResultSet rs=null;
	private static Statement st=null;
	private static String sql;
	
	public String nifLocal(String nombreLocal) {
		try {
			ConexionMySQL.Conexion();
		
			sql = "SELECT nif FROM local where nombre='"+nombreLocal+"';";
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			String registro="";
				
			 while (rs.next()) {
				 registro=rs.getString("nif");			
			 } 
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
			ConexionMySQL.Conexion();
	
			String sql = "SELECT nombre FROM local";
	
			st = con.createStatement();
			rs = st.executeQuery(sql);
	
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
			ConexionMySQL.Conexion();
	
			String sql = "SELECT num_trans FROM ticket";
	
			st = con.createStatement();
			rs = st.executeQuery(sql);
	
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
			ConexionMySQL.Conexion();
			
			String sql = "SELECT nif, L.nombre, nombre_propietario, tipo, direccion FROM local L join Usuario U on L.nif = U.nif_local where dni='"+dni+"';";
			
			st = con.createStatement(); 
			rs = st.executeQuery(sql); 
			
			while (rs.next()) {
				local1 = new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));			
			}
	
		} catch (Exception e) {
			System.out.println("Error en obtener el Local");
		}	
		return local1;
	}
 
}