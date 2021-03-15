package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class ConexionMySQL_Local {
	
	private static Connection con=null;
	private static ResultSet rs=null;
	private static Statement st=null;
	private static String nombreLocal;
	private static String dni;
	private static final String GETNIFLOCAL = "SELECT nif FROM local where nombre='"+nombreLocal+"';";
	private static final String GETNOMBRELOCAL = "SELECT nombre FROM local";
	private static final String GETNTRANSACCION = "SELECT num_trans FROM ticket";
	private static final String GETLOCAL = "SELECT nif, L.nombre, nombre_propietario, tipo, direccion FROM local L join Usuario U on L.nif = U.nif_local where dni='"+dni+"';";
	
	public String nifLocal(String nombreLocal1) {
		try {
			ConexionMySQL.Conexion();
			nombreLocal = nombreLocal1;
			st = con.createStatement();
			rs = st.executeQuery(GETNIFLOCAL);
			
			String registro="";
				
			 while (rs.next()) {
				 registro=rs.getString("nif");			
			 } 
			 return registro;
		} catch (Exception e) {
			System.out.println("Error en obtencion del NIF del Local");
			return null;
		}
	}
	
	public String[] nombreLocal() {
		String [] registro = new String[3];
		int i=0;
		try {
			ConexionMySQL.Conexion();
	
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
			ConexionMySQL.Conexion();
			st = con.createStatement();
			rs = st.executeQuery(GETNTRANSACCION);
	
			String registro="";
			while (rs.next()) {
				registro=rs.getString("num_trans");			
			} 
			int registroEntero = Integer.parseInt (registro);
			registroEntero= registroEntero + 1;
			String registroString= ""+registroEntero;
	 
			return registroString;
		} catch (Exception e) {
			System.out.println("Error en obtencion del Numero de Transacción");
			return null;
		}	
	}
	
	public Local obtenerLocal(String dni1) {
		Local local1 = new Local();
			
		try {
			ConexionMySQL.Conexion();
			dni = dni1;			
			st = con.createStatement(); 
			rs = st.executeQuery(GETLOCAL); 
			
			while (rs.next()) {
				local1 = new Local(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));			
			}
		} catch (Exception e) {
			System.out.println("Error en obtener el Local");
		}	
		return local1;
	}
 
}