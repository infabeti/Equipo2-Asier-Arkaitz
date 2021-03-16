package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import Modelo.ConexionMySQL;


@SuppressWarnings("unused")
public class ConexionMySQLTest {

	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	private static Connection con=null;
	
	@Test
	public void testConectar() {
		boolean resultado=this.conexionMySQL.Conectar();
		assertEquals(true, resultado);
	}
}
