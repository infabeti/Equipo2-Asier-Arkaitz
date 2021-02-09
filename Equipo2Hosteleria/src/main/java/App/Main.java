package App;
import Controlador.Controlador;
import Modelo.*;
import Vista.Vista;

public class Main {
	
	private static Modelo modelo;
	private static Vista vista;
	@SuppressWarnings("unused")
	private static Controlador controlador;
	private static ConsultasBBDD consultasBBDD;
	private static CarroCompra carroCompra;
	
	public static void main(String[] args) {
		consultasBBDD = new ConsultasBBDD();
		carroCompra = new CarroCompra();
		
		modelo = new Modelo(consultasBBDD, carroCompra);
		vista = new Vista();
                
		controlador = new Controlador(modelo, vista);
	}
	
}
