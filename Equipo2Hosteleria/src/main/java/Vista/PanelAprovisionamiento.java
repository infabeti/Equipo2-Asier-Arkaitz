package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelOperatividad;
import Controlador.ControladorPanelPedidos;
import Modelo.Producto;
import Controlador.ControladorPanelAprovisionamiento;
import java.awt.Color;

@SuppressWarnings("serial")
public class PanelAprovisionamiento extends JPanel{

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JComboBox comboBox_Productos;
	private JComboBox comboBox_Cantidad;
	private JButton btnAadirAlCarro;
	private JLabel lblTotal;
	private JTextPane textPane_Total;
	private JTextPane textPane_Productos;
	private JScrollPane scrollPane;
	private JLabel lblProductos;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	
	public PanelAprovisionamiento(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		setBackground(new Color(102, 153, 255));
		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;
		setLayout(null);
		
		JLabel lblAprovisionamiento = new JLabel("Aprovisionamiento");
		lblAprovisionamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAprovisionamiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAprovisionamiento.setBounds(129, 24, 362, 23);
		add(lblAprovisionamiento);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		

		
		comboBox_Productos = new JComboBox();
		comboBox_Productos.setBounds(38, 84, 173, 22);
		add(comboBox_Productos);
		
		Producto Producto1 = new Producto("Garbanzos","Comida","30-01-2021",5,5);	
		Producto Producto2 = new Producto("Paella","Comida","31-01-2021",5,5);	
		Producto Producto3 = new Producto("Bacalao","Comida","02-02-2021",5,5);	
		Producto Producto4 = new Producto("Hamburguesa","Comida","30-01-2021",5,5);	
		Producto Producto5 = new Producto("Cerveza","Bebida","01-02-2021",5,5);	

		comboBox_Productos.addItem(Producto1);
		comboBox_Productos.addItem(Producto2);
		comboBox_Productos.addItem(Producto3);
		comboBox_Productos.addItem(Producto4);
		comboBox_Productos.addItem(Producto5);
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductos.setBounds(38, 49, 115, 14);
		add(lblProductos);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(285, 49, 115, 14);
		add(lblCantidad);
		
		comboBox_Cantidad = new JComboBox();
		comboBox_Cantidad.setBounds(340, 84, 60, 22);
		add(comboBox_Cantidad);
		
		int numbers_to_add_max = 99;
		for (int i = 1; i <= numbers_to_add_max; i++) {
			comboBox_Cantidad.addItem(new Integer(i));
		}
		
		btnAadirAlCarro = new JButton("A\u00F1adir a la lista de aprovisionamiento");
		btnAadirAlCarro.setBounds(38, 116, 258, 23);
		add(btnAadirAlCarro);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(303, 153, 45, 19);
		add(lblTotal);
		
		textPane_Total = new JTextPane();
		textPane_Total.setBounds(343, 152, 63, 20);
		add(textPane_Total);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 177, 368, 47);
		add(scrollPane);
		
		textPane_Productos = new JTextPane();
		scrollPane.setViewportView(textPane_Productos);
		
		lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(38, 153, 89, 19);
		add(lblProductos);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAprovisionamiento));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelAprovisionamiento));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAprovisionamiento.accionadoBottonVolverPanelAprovisionamiento();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelAprovisionamiento.accionadoBottonDesconectarsePanelAprovisionamiento();
			}
		};
	}
	
}
