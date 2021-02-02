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
import Controlador.ControladorPanelRegistro;
import Modelo.Producto;
import Controlador.ControladorPanelAprovisionamiento;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class PanelRegistro extends JPanel{
	
	private JLabel lblProductos;	
	private JTextField textUsuario;
	private JTextField textContraseña1;
	private JTextField textContraseña2;
	private JButton btnCrear;
	private JButton btnVolver;

	private ControladorPanelRegistro controladorPanelRegistro;
	
	
	
	
	public PanelRegistro(ControladorPanelRegistro controladorPanelRegistro) {
		
		setBackground(new Color(102, 153, 255));
		this.controladorPanelRegistro = controladorPanelRegistro;
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 600, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce un nombre de usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(85, 83, 450, 14);
		add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(230, 108, 159, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduce tu contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(184, 160, 251, 14);
		add(lblNewLabel_2);
		
		textContraseña1 = new JTextField();
		textContraseña1.setBounds(230, 185, 159, 20);
		add(textContraseña1);
		textContraseña1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Repetir contrase\u00F1a");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(230, 226, 159, 14);
		add(lblNewLabel_3);
		
		textContraseña2 = new JTextField();
		textContraseña2.setBounds(230, 251, 159, 20);
		add(textContraseña2);
		textContraseña2.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(54, 354, 89, 23);
		add(btnCrear);
		
		btnVolver = new JButton("Volver");	
		btnVolver.setBounds(487, 354, 89, 23);
		add(btnVolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bar", "Cafeteria"}));
		comboBox.setBounds(262, 321, 96, 22);
		add(comboBox);
		
		JLabel lblNewLabel_2_1 = new JLabel("Selecciona tu tipo de negocio");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(184, 296, 251, 14);
		add(lblNewLabel_2_1);
		
		
		
		
		
		
		initializeEvents();
	}
	
	private void initializeEvents() {
	
		this.btnVolver.addActionListener(listenerbtnVolver(this.controladorPanelRegistro)); 
		this.btnCrear.addActionListener(listenerbtnCrear(this.controladorPanelRegistro));
		
			}
	
	private ActionListener listenerbtnCrear(ControladorPanelRegistro controladorPanelRegistro) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrarse");
				controladorPanelRegistro.accionadoBottonMostrarPanelOperatividad();
			}
		};
	}
	private ActionListener listenerbtnVolver(ControladorPanelRegistro controladorPanelRegistro) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				
				controladorPanelRegistro.mostrarPanelBienvenida();
			}
		};
	}
}

