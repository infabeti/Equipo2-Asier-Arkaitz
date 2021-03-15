package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionMySQL {
	
	private static Connection con=null;
	private static PreparedStatement ps = null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	private static Statement st=null;
	static boolean conexion=false;
	
	public final static String URL = "jdbc:mysql://localhost:33060/equipo2hosteleria_dam";
	public final static String USER = "root";
	public final static String PASS = "elorrieta";
	
	public static Connection getConexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(URL, USER, PASS);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Driver no Instalado");
		} catch (SQLException e) {
			System.out.println("Error de conexión con la Base de Datos");
		}
		return con;
	}

	public Usuario obtenerUsuario(Usuario usu){
		
		Usuario usuario = null;
		
		try {
		
			con = ConexionMySQL.getConexion();
		
			String sql = "select*from usuario where dni = ? and contraseña =  ? ";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, usu.getDni());
			pst.setString(2, usu.getContrasena());
			
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
				
		try {
			Conexion();
			
			pst = con.prepareStatement("INSERT INTO usuario (dni, contraseña, nombre, apellido, nif_local)"+ " values(?,?,?,?,?)");		
			pst.setString(1, usu.getDni());	pst.setString(2, usu.getContrasena());	pst.setString(3, usu.getNombre());	pst.setString(4, usu.getApellidos());	pst.setString(5, usu.getNif_local());
			pst.executeUpdate();		
						
		} catch (Exception e) {
			System.out.println("El usuario ya existe o imposible implementar ese usuario");
		}
		return usuario3;
	}
	
	public Usuario comprobarUsuarioRegistrado(Usuario usu){
	
		Usuario usuario3 = null;
				
		try {
			Conexion();		
			String sql = "select*from usuario where dni = ? and contraseña =  ? and nombre =  ? and apellido =  ? and nif_local =  ? ";			
			pst = con.prepareStatement(sql);			
			pst.setString(1, usu.getDni());	pst.setString(2, usu.getContrasena());	pst.setString(3, usu.getNombre());	pst.setString(4, usu.getApellidos());	pst.setString(5, usu.getNif_local());		
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
	
	public Ticket registrarTicket(Ticket tic) {
		
		Ticket ticket1=null;
				 
		try {
			Conexion();
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
			Conexion();
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
	 
	public Pedido registrarPedidoConDomicilio(Pedido pedi) {
		 
		Pedido pedido1=null;
				 
		try {
			Conexion();
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
			Conexion();
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
	
	public Identificacion registrarIdentificacion(Identificacion ide) {
		
		Identificacion Identificacion1=null;
		
		try {
			 
			Conexion();
			ps = con.prepareStatement("INSERT INTO identificacion(nif, nombre, apellidos) VAlUES(?,?,?)");
			 
			ps.setString(1,ide.getNif());
			ps.setString(2,ide.getNombre());
			ps.setString(3,ide.getApellidos());
			
			ps.executeUpdate();

			String sql = "select*from identificacion where nif = ? and nombre = ? and apellidos=?";
				
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
			 Conexion();
			 ps = con.prepareStatement("INSERT INTO Incluye(nombre_producto, num_trans, cantidad, precio) VAlUES(?,?,?,?)");
	
			 ps.setString(1,inc.getNombreProducto());
			 ps.setInt(2,inc.getNtransaccion());
			 ps.setInt(3,inc.getCantidad());
			 ps.setDouble(4,inc.getPrecio());
		
			 ps.executeUpdate();
	
			 String sql = "select*from Incluye where nombre_producto = ? and num_trans = ? and cantidad = ? and precio = ?";
	
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
	
	public String nifLocal(String nombreLocal) {
		Local local=null;
		
	try {
	Conexion();
	
	String sql = "SELECT nif FROM local where nombre='"+nombreLocal+"';";
	
	st = con.createStatement();
	rs = st.executeQuery(sql);
	
	//String nif=rs.getString("nif");
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
		Local local=null;
		String [] registro = new String[3];
		int i=0;
	try {
	Conexion();
	
	String sql = "SELECT nombre FROM local";
	
	st = con.createStatement();
	rs = st.executeQuery(sql);
	
	//String nif=rs.getString("nif");
	
		
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
		Ticket ticket=null;
		
	try {
	Conexion();
	
	String sql = "SELECT num_trans FROM ticket";
	
	st = con.createStatement();
	rs = st.executeQuery(sql);
	
	//String nif=rs.getString("nif_local");
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
 
	public static void Conexion() throws SQLException {
		con = ConexionMySQL.getConexion();	
		st = con.createStatement();
	}
	
	public boolean Conectar(){
		   
		   conexion=true;
	       @SuppressWarnings("unused")
	       Connection link = null;

	       try{
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           link = DriverManager.getConnection(ConexionMySQL.URL, ConexionMySQL.USER, ConexionMySQL.PASS);
	           
	       }catch(Exception ex){
	    	   conexion=false;
	           ex.printStackTrace();
	       }
	       return conexion;
		}
}