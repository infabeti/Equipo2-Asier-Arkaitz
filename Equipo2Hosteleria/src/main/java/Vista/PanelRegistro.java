package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textField;
	
	
	
	
	public PanelRegistro(ControladorPanelRegistro controladorPanelRegistro) {
		
		setBackground(new Color(102, 153, 255));
		this.controladorPanelRegistro = controladorPanelRegistro;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 11, 450, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce  tu DNI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(54, 50, 189, 14);
		add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(79, 75, 102, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduce tu contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(328, 50, 206, 14);
		add(lblNewLabel_2);
		
		textContraseña1 = new JTextField();
		textContraseña1.setBounds(370, 75, 153, 20);
		add(textContraseña1);
		textContraseña1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Repetir contrase\u00F1a");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(370, 130, 159, 14);
		add(lblNewLabel_3);
		
		textContraseña2 = new JTextField();
		textContraseña2.setBounds(370, 155, 153, 20);
		add(textContraseña2);
		textContraseña2.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(79, 375, 126, 32);
		add(btnCrear);
		
		btnVolver = new JButton("Volver");	
		btnVolver.setBounds(409, 375, 126, 32);
		add(btnVolver);
		
		JLabel lblNewLabel_5 = new JLabel("Introduce tu nombre");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(79, 130, 198, 14);
		add(lblNewLabel_5);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(79, 155, 132, 20);
		add(textNombre);
		
		JLabel lblNewLabel_5_1 = new JLabel("Introduce tu apellido");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(76, 213, 201, 14);
		add(lblNewLabel_5_1);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(79, 238, 132, 20);
		add(textApellidos);
		
		JLabel lblNewLabel_6 = new JLabel("Introduce el Nombre del local");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(287, 213, 250, 14);
		add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(397, 238, 126, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Selecciona un tipo de local");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(76, 290, 225, 14);
		add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(79, 317, 148, 22);
		add(comboBox);
		
		
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
				
				
				
				
				
				if (textUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Introduce un usuario por favor");
				} else {
				
					// Expresion regular
					if (textUsuario.getText().matches("[a-z][0-9]+") && textContraseña1.getText().equals(textContraseña2.getText())) {
						controladorPanelRegistro.accionadoBottonMostrarPanelOperatividad();
					} else {
						
						
						JOptionPane.showMessageDialog(null,"La contraseña es incorrecta.");
					}
				}
				
				
				
				
					
					
				
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

