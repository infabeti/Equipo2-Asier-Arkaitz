package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionMySQL_Pedido {
	
	private static Connection con=null;
	private static PreparedStatement ps = null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	
	public Pedido registrarPedidoConDomicilio(Pedido pedi) {
		 
		Pedido pedido1=null;
				 
		try {
			ConexionMySQL.Conexion();
			ps = con.prepareStatement("INSERT INTO pedido(num_trans, tipo, domicilio) VAlUES(?,?,?)");
				 
			ps.setInt(1,pedi.getNTransaccion());
			ps.setString(2,pedi.getTipoPedido());
			ps.setString(3,pedi.getDomicilio());
			
			ps.executeUpdate();

			String sql = "select*from pedido where num_trans = ? and tipo = ? and domicilio = ?";
					
			pst = con.prepareStatement(sql); 
				 
			pst.setInt(1,pedi.getNTransaccion());
			pst.setString(2,pedi.getTipoPedido());
			pst.setString(3,pedi.getDomicilio());

			rs = pst.executeQuery();
			 
			while (rs.next()) {
				pedido1 = new Pedido(rs.getInt(1), rs.getString(2), rs.getString(3));			
			}
			System.out.println("Se ha creado el pedido correctamente");
			
		} catch (Exception e) {
			System.out.println("Error en creacion del Pedido");
		}
		return pedido1;
	}

	public Pedido registrarPedidoSinDomicilio(Pedido pedi) {
		
		Pedido pedido1=null;
					 
		try {
			ConexionMySQL.Conexion();
			ps = con.prepareStatement("INSERT INTO pedido(num_trans, tipo) VAlUES(?,?)");
				 
			ps.setInt(1,pedi.getNTransaccion());
			ps.setString(2,pedi.getTipoPedido());
		
			ps.executeUpdate();

			String sql = "select*from pedido where num_trans = ? and tipo = ?";
					
			pst = con.prepareStatement(sql); 
				 
			pst.setInt(1,pedi.getNTransaccion());
			pst.setString(2,pedi.getTipoPedido());
			
			rs = pst.executeQuery();
			 
			while (rs.next()) {
				pedido1 = new Pedido(rs.getInt(1), rs.getString(2));			
			}
			
			System.out.println("Se ha creado el pedido correctamente");
				
		}catch (Exception e) {
			System.out.println("Error en creacion del Pedido");
		}
		return pedido1;
	}
	
}