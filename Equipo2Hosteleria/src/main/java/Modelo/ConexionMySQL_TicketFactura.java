package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionMySQL_TicketFactura {
	
	private static Connection con=null;
	private static PreparedStatement ps = null;
	private static ResultSet rs=null;
	
	public Ticket registrarTicket(Ticket tic) {
		
		Ticket ticket1=null;
				 
		try {
			ConexionMySQL.Conexion();
			ps = con.prepareStatement("INSERT INTO ticket(num_trans, fecha, nif_local, tipo) VAlUES(?,?,?,?)");
			 
			ps.setInt(1,tic.getNTransaccion());
			ps.setString(2,tic.getFecha());
			ps.setString(3,tic.getNif_local());
			ps.setString(4,tic.getTipo());
			 
			ps.executeUpdate();
	
			String sql = "select*from ticket where num_trans = ? and fecha =  ? and nif_local =  ? and tipo =  ?";
				
			ps = con.prepareStatement(sql); 
			 
			ps.setInt(1,tic.getNTransaccion());
			ps.setString(2,tic.getFecha());
			ps.setString(3,tic.getNif_local());
			ps.setString(4,tic.getTipo());
			
			rs = ps.executeQuery();
		 
			while (rs.next()) {
				ticket1 = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));			
			}
		 
			System.out.println("Se ha creado el ticket correctamente");
		 
		} catch (Exception e) {
			System.out.println("Error en creacion del Ticket");
		}
		return ticket1;
	}
	 
	public Factura registrarFactura(Factura fac) {
		
		Factura factura1=null;
					 
		try {
			ConexionMySQL.Conexion();
			ps = con.prepareStatement("INSERT INTO factura(num_trans, nif) VAlUES(?,?)");
				 
			ps.setInt(1,fac.getNTransaccion());
			ps.setString(2,fac.getNif());
			
			ps.executeUpdate();

			String sql = "select*from factura where num_trans = ? and nif = ?";
					
			ps = con.prepareStatement(sql); 
				 
			ps.setInt(1,fac.getNTransaccion());
			ps.setString(2,fac.getNif());
					
			rs = ps.executeQuery();
			 
			while (rs.next()) {
				factura1 = new Factura(rs.getInt(1), rs.getString(2));			
			}
			 
			System.out.println("Se ha creado la factura correctamente");
			 
			} catch (Exception e) {
				System.out.println("Error en creacion de la Factura");
			}
			return factura1;
		}
	
}