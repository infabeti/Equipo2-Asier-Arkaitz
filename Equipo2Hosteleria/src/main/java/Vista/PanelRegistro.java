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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 450, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce un nombre de usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 50, 450, 14);
		add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(186, 75, 86, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduce tu contrase\u00F1a");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 118, 189, 14);
		add(lblNewLabel_2);
		
		textContraseña1 = new JTextField();
		textContraseña1.setBounds(54, 143, 86, 20);
		add(textContraseña1);
		textContraseña1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Repetir contrase\u00F1a");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(281, 118, 159, 14);
		add(lblNewLabel_3);
		
		textContraseña2 = new JTextField();
		textContraseña2.setBounds(312, 143, 86, 20);
		add(textContraseña2);
		textContraseña2.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(92, 255, 89, 23);
		add(btnCrear);
		
		JButton btnVolver = new JButton("Volver");	
		btnVolver.setBounds(272, 255, 89, 23);
		add(btnVolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bar", "Cafeteria"}));
		comboBox.setBounds(203, 199, 96, 22);
		add(comboBox);
		
		
		initializeEvents();
	}
	
	private void initializeEvents() {
	
		this.btnVolver.addActionListener(listenerbtnVolver(this.controladorPanelRegistro)); 
		this.btnCrear.addActionListener(listenerbtnCrear(this.controladorPanelRegistro));
		
			}
	
	private ActionListener listenerbtnCrear(ControladorPanelRegistro controladorPanelRegistro2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrarse");
				controladorPanelRegistro.mostrarPanelBienvenida();
			}
		};
	}
	private ActionListener listenerbtnVolver(ControladorPanelRegistro controladorPanelRegistro2) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrarse");
				controladorPanelRegistro.accionadoBottonMostrarPanelAceptar();
			}
		};
	}



		
	
}

