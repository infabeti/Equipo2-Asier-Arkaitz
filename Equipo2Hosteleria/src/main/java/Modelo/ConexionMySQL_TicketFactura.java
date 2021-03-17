package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class ConexionMySQL_TicketFactura {
	
	private static Connection con=null;
	private static PreparedStatement ps = null;
	@SuppressWarnings("unused")
	private static Statement st=null;
	private static final String SETTICKET = "INSERT INTO ticket(num_trans, fecha, nif_local, tipo) VAlUES(?,?,?,?)";
	private static final String SETFACTURA = "INSERT INTO factura(num_trans, nif) VAlUES(?,?)";
	
	public Ticket registrarTicket(Ticket tic) {
		Ticket ticket1=null;
		try {
			Conexion();
			ps = con.prepareStatement(SETTICKET);
			 
			ps.setInt(1,tic.getNTransaccion());
			ps.setString(2,tic.getFecha());
			ps.setString(3,tic.getNif_local());
			ps.setString(4,tic.getTipo());
		
			 if( ps.executeUpdate()==0) { ticket1 = null;} else

				 ticket1 = new Ticket(tic.getNTransaccion(), tic.getFecha(),tic.getNif_local(), tic.getTipo());
			
			System.out.println("Se ha creado el ticket correctamente");
		} catch (Exception e) { System.out.println("Error en creacion del Ticket"); }
		return ticket1;
	}
	 
	public Factura registrarFactura(Factura fac) {
		Factura factura1=null;
		try {
			Conexion();
			ps = con.prepareStatement(SETFACTURA);
				 
			ps.setInt(1,fac.getNTransaccion());
			ps.setString(2,fac.getNif());
			
			 if( ps.executeUpdate()==0) { factura1 = null;} else

				 factura1 = new Factura(fac.getNTransaccion(), fac.getNif());
			System.out.println("Se ha creado la factura correctamente");
		} catch (Exception e) {
			System.out.println("Error en creacion de la Factura");
		}
		return factura1;
	}
	
	public static void Conexion() throws SQLException {
		con = ConexionMySQL.getConexion();	
		st = con.createStatement();
	}
}