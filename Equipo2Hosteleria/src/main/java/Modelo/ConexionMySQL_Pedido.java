package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConexionMySQL_Pedido {
	
	private static Connection con=null;
	private static PreparedStatement ps = null;
	@SuppressWarnings("unused")
	private static Statement st=null;
	private static final String SETENTREGA = "INSERT INTO pedido(num_trans, tipo, domicilio) VAlUES(?,?,?)";
	private static final String SETRECOGIDA = "INSERT INTO pedido(num_trans, tipo) VAlUES(?,?)";

	
	public Pedido registrarPedidoConDomicilio(Pedido pedi) {
		Pedido pedido1=null;
		try {
			Conexion();
			ps = con.prepareStatement(SETENTREGA);
				 
			ps.setInt(1,pedi.getNTransaccion());
			ps.setString(2,pedi.getTipoPedido());
			ps.setString(3,pedi.getDomicilio());
			
			 if( ps.executeUpdate()==0) { pedido1 = null;} else

				 pedido1 = new Pedido(pedi.getNTransaccion(), pedi.getTipoPedido(),pedi.getDomicilio());
		
			System.out.println("Se ha creado el pedido correctamente");
		} catch (Exception e) {	System.out.println("Error en creacion del Pedido");	}
		return pedido1;
	}

	public Pedido registrarPedidoSinDomicilio(Pedido pedi) {
		Pedido pedido1=null;
		try {
			Conexion();
			ps = con.prepareStatement(SETRECOGIDA);
				 
			ps.setInt(1,pedi.getNTransaccion());
			ps.setString(2,pedi.getTipoPedido());
			
			 if( ps.executeUpdate()==0) { pedido1 = null;} else

				 pedido1 = new Pedido(pedi.getNTransaccion(), pedi.getTipoPedido());
			 
			System.out.println("Se ha creado el pedido correctamente");
		}catch (Exception e) {
			System.out.println("Error en creacion del Pedido");
		}
		return pedido1;
	}
	
	public static void Conexion() throws SQLException {
		con = ConexionMySQL.getConexion();	
		st = con.createStatement();
	}
}