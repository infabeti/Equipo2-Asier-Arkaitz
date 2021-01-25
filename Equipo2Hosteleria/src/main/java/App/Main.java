package App;
import Controlador.Controlador;
import Modelo.*;
import Modelo.Modelo;
import POO.Producto;
import Vista.Vista;

public class Main {
	
	private static Modelo modelo;
	private static Vista vista;
	@SuppressWarnings("unused")
	private static Controlador controlador;
	
	public static void main(String[] args) {
		modelo = new Modelo();    
		vista = new Vista();
                
		controlador = new Controlador(modelo, vista);
	}

	Producto Producto1 = new Producto("Garbanzos","Comida","30-01-2021",5,5);	
	Producto Producto2 = new Producto("Paella","Comida","31-01-2021",5,5);	
	Producto Producto3 = new Producto("Bacalao","Comida","02-02-2021",5,5);	
	Producto Producto4 = new Producto("Hamburguesa","Comida","30-01-2021",5,5);	
	Producto Producto5 = new Producto("Cerveza","Bebida","01-02-2021",5,5);	
	
}
