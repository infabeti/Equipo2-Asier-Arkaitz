package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConexionMySQL {
	
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:33060/equipo2hosteleria_dam";
			String usr = "root";
			String psw = "elorrieta";
			
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Driver no Instalado");
		} catch (SQLException e) {
			System.out.println("Error de conexión con la Base de Datos");
		}
		return con;
	}

   
	public Usuario obtenerUsuario(Usuario usu){
		
		Usuario usuario = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		
			con = ConexionMySQL.getConexion();
		
			String sql = "select*from usuario where dni = ? and contraseña =  ? ";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getContraseña());
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));			
			}
			
			System.out.println("Se ha obtenido el usuario correctamente");
			
		} catch (Exception e) {
			System.out.println("Error en obtener usuario");
		}
		return usuario;
	}
	
	public Usuario registrarUsuario(Usuario usu){
		
		Usuario usuario3 = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = null;
		
		try {
			con = ConexionMySQL.getConexion();
			st = con.createStatement();
			pst = con.prepareStatement("INSERT INTO usuario (dni, contraseña, nombre, apellido, nif_local)"+ " values(?,?,?,?,?)");
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getContraseña());
			pst.setString(3, usu.getNombre());
			pst.setString(4, usu.getApellidos());
			pst.setString(5, usu.getNif());
			
			pst.executeUpdate();
	
			String sql = "select*from usuario where dni = ? and contraseña =  ? and nombre =  ? and apellido =  ? and nif_local =  ? ";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getContraseña());
			pst.setString(3, usu.getNombre());
			pst.setString(4, usu.getApellidos());
			pst.setString(5, usu.getNif());
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				usuario3 = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));			
			}
			
			System.out.println("Se ha registrado el usuario correctamente");
			
		} catch (Exception e) {
			System.out.println("El usuario ya existe o imposible implementar ese usuario");
		}
		return usuario3;
	}
	
	public Ticket RegistrarTicket(Ticket tic) {
		
		Ticket ticket1=null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement st = null;
		 
		try {
			con = ConexionMySQL.getConexion();	
			st = con.createStatement();
			ps = con.prepareStatement("INSERT INTO ticket(num_trans, fecha, nif_local) VAlUES(?,?,?)");
			 
			ps.setInt(1,tic.getNTransaccion());
			ps.setString(2,tic.getFecha());
			ps.setString(3,tic.getNif_local());
			 
			ps.executeUpdate();
	
			String sql = "select*from ticket where num_trans = ? and fecha =  ? and nif_local =  ?";
				
			ps = con.prepareStatement(sql); 
			 
			ps.setInt(1,tic.getNTransaccion());
			ps.setString(2,tic.getFecha());
			ps.setString(3,tic.getNif_local());
		
			rs = ps.executeQuery();
		 
			while (rs.next()) {
				ticket1 = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3));			
			}
		 
			System.out.println("Se ha creado el ticket correctamente");
		 
		} catch (Exception e) {
			System.out.println("Error en creacion del Ticket");
		}
		return ticket1;
	}
	 
	public Factura RegistrarFactura(Factura fac) {
		
		Factura factura1=null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement st = null;
			 
		try {
			con = ConexionMySQL.getConexion();	
			st = con.createStatement();
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
	 
	public Pedido RegistrarPedidoConDomicilio(Pedido pedi) {
		 
		Pedido Pedido1=null;
		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = null;
			 
		try {
			con = ConexionMySQL.getConexion();	
			st = con.createStatement();
			ps = con.prepareStatement("INSERT INTO pedido(num_trans, tipo, domicilio) VAlUES(?,?,?)");
				 
			ps.setInt(1,pedi.getNTransaccion());
			ps.setString(2,pedi.getTipo());
			ps.setString(3,pedi.getDomicilio());
			
			ps.executeUpdate();

			String sql = "select*from pedido where num_trans = ? and tipo = ? and domicilio = ?";
					
			pst = con.prepareStatement(sql); 
				 
			pst.setInt(1,pedi.getNTransaccion());
			pst.setString(2,pedi.getTipo());
			pst.setString(3,pedi.getDomicilio());

			rs = pst.executeQuery();
			 
			while (rs.next()) {
				Pedido1 = new Pedido(rs.getInt(1), rs.getString(2), rs.getString(3));			
			}
			System.out.println("Se ha creado el pedido correctamente");
			
		} catch (Exception e) {
			System.out.println("Error en creacion del Pedido");
		}
		return Pedido1;
	}

	public Pedido RegistrarPedidoSinDomicilio(Pedido pedi) {
		
		Pedido Pedido1=null;
		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = null;
			 
		try {
			con = ConexionMySQL.getConexion();	
			st = con.createStatement();
			ps = con.prepareStatement("INSERT INTO pedido(num_trans, tipo) VAlUES(?,?)");
				 
			ps.setInt(1,pedi.getNTransaccion());
			ps.setString(2,pedi.getTipo());
		
			ps.executeUpdate();

			String sql = "select*from pedido where num_trans = ? and tipo = ?";
					
			pst = con.prepareStatement(sql); 
				 
			pst.setInt(1,pedi.getNTransaccion());
			pst.setString(2,pedi.getTipo());
			
			rs = pst.executeQuery();
			 
			while (rs.next()) {
				Pedido1 = new Pedido(rs.getInt(1), rs.getString(2));			
			}
			
			System.out.println("Se ha creado el pedido correctamente");
				
		}catch (Exception e) {
			System.out.println("Error en creacion del Pedido");
		}
		return Pedido1;
	}
	
	public Identificacion RegistrarIdentificacion(Identificacion ide) {
		
		Identificacion Identificacion1=null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement st = null;
		
		try {
			 
			con = ConexionMySQL.getConexion();	
			st = con.createStatement();
			ps = con.prepareStatement("INSERT INTO Identificacion(nif, nombre, apellidos) VAlUES(?,?,?)");
			 
			ps.setString(1,ide.getNif());
			ps.setString(2,ide.getNombre());
			ps.setString(3,ide.getApellidos());
			
			ps.executeUpdate();

			String sql = "select*from Identificacion where nif = ?, nombre = ?, apellidos=?";
				
			ps = con.prepareStatement(sql); 
		 
			ps.setString(1,ide.getNif());
			ps.setString(2,ide.getNombre());
			ps.setString(3,ide.getApellidos());
				
			rs = ps.executeQuery();
		 
			while (rs.next()) {
				Identificacion1 = new Identificacion(rs.getString(1), rs.getString(2), rs.getString(3));			
			}
			
			System.out.println("Se ha creado la Identificacion correctamente");
		 
		}catch (Exception e) {
			System.out.println("Error en creacion de la Identificacion");
		}
		return Identificacion1;
	}
	 
	public Incluye RegistrarIncluye(Incluye inc) {
		 Incluye Incluye1=null;

		 Connection con = null;
		 PreparedStatement ps = null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 Statement st = null;

		 try {
			 con = ConexionMySQL.getConexion();
			 st = con.createStatement();
			 ps = con.prepareStatement("INSERT INTO Incluye(nombre_producto, num_trans, cantidad, precio_venta,precio_compra) VAlUES(?,?,?,?,?)");
	
			 ps.setString(1,inc.getNombreProducto());
			 ps.setInt(2,inc.getNtransaccion());
			 ps.setInt(3,inc.getCantidad());
			 ps.setDouble(4,inc.getPrecioVenta());
			 ps.setDouble(5,inc.getPrecioCompra());
	
			 ps.executeUpdate();
	
			 String sql = "select*from Incluye where nombre_producto = ? and num_trans = ? and cantidad = ? and precio_venta = ? and precio_compra = ?";
	
			 pst = con.prepareStatement(sql);
	
			 pst.setString(1,inc.getNombreProducto());
			 pst.setInt(2,inc.getNtransaccion());
			 pst.setInt(3,inc.getCantidad());
			 pst.setDouble(4,inc.getPrecioVenta());
			 pst.setDouble(5,inc.getPrecioCompra());
	
			 rs = pst.executeQuery();
	
			 while (rs.next()) {
				 Incluye1 = new Incluye(rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getDouble(5));
			 }
			 
			 System.out.println("Se ha creado la Incluye correctamente");
			 
		 } catch (Exception e) {
			 System.out.println("Error en creacion de la Incluye");
		 }
		 return Incluye1;
	}
}