package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelRegistro;
import Modelo.ConexionMySQL;
import Modelo.Usuario;
import java.awt.Color;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelRegistro extends JPanel{
	
	private JTextField textUsuario;
	private JTextField textContraseña1;
	private JTextField textContraseña2;
	private JButton btnCrear;
	private JButton btnVolver;
	private JComboBox comboBox_Local;
	
	private ControladorPanelRegistro controladorPanelRegistro;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textField_NIFLocal;
	

	public PanelRegistro(ControladorPanelRegistro controladorPanelRegistro) {
		
		setBackground(new Color(102, 153, 255));
		this.controladorPanelRegistro = controladorPanelRegistro;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 11, 456, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce  tu DNI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(82, 50, 198, 20);
		add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(82, 75, 153, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduce tu contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(340, 50, 198, 20);
		add(lblNewLabel_2);
		
		textContraseña1 = new JTextField();
		textContraseña1.setBounds(385, 75, 153, 20);
		add(textContraseña1);
		textContraseña1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Repetir contrase\u00F1a");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(340, 130, 198, 20);
		add(lblNewLabel_3);
		
		textContraseña2 = new JTextField();
		textContraseña2.setBounds(385, 155, 153, 20);
		add(textContraseña2);
		textContraseña2.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(82, 375, 126, 32);
		add(btnCrear);
		
		btnVolver = new JButton("Volver");	
		btnVolver.setBounds(412, 375, 126, 32);
		add(btnVolver);
		
		JLabel lblNewLabel_5 = new JLabel("Introduce tu nombre");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(82, 130, 198, 20);
		add(lblNewLabel_5);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(82, 155, 153, 20);
		add(textNombre);
		
		JLabel lblNewLabel_5_1 = new JLabel("Introduce tu apellido");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(82, 213, 198, 20);
		add(lblNewLabel_5_1);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(82, 238, 153, 20);
		add(textApellidos);
		
		JLabel lblNewLabel_4 = new JLabel("Selecciona el local");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(82, 290, 198, 20);
		add(lblNewLabel_4);
		
		comboBox_Local = new JComboBox();
		comboBox_Local.setBounds(82, 317, 153, 22);
		add(comboBox_Local);
		
		JLabel lblNewNifLocal = new JLabel("Selecciona NIF del local");
		lblNewNifLocal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewNifLocal.setBounds(340, 216, 198, 20);
		add(lblNewNifLocal);
		
		textField_NIFLocal = new JTextField();
		textField_NIFLocal.setColumns(10);
		textField_NIFLocal.setBounds(385, 238, 153, 20);
		add(textField_NIFLocal);
		
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
				
				String usuario = textUsuario.getText();
				String contraseña = textContraseña1.getText();
				String nombre = textNombre.getText();
				String apellidos = textApellidos.getText();
				String Nif = textField_NIFLocal.getText();
				String contrasena1=textContraseña1.getText();
				String contrasena2=textContraseña2.getText();
				
				if (textUsuario.getText().equals("") || textContraseña1.getText().equals("") || textNombre.getText().equals("") || textApellidos.getText().equals("") || textField_NIFLocal.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos");
				}else if (textContraseña2.getText().equals(textContraseña1.getText())) {
					JOptionPane.showMessageDialog(null,"Repita la contraseña correctamente");
				}else {
					ConexionMySQL ConexionMySQLUsuario = new ConexionMySQL();

					Usuario usuario2 = new Usuario();
					usuario2.setUsuario(usuario);
					usuario2.setContraseña(contraseña);
					usuario2.setNombre(nombre);
					usuario2.setApellidos(apellidos);
					usuario2.setNif(Nif);
						
					Usuario usu = ConexionMySQLUsuario.registrarUsuario(usuario2);

					if (usu != null) {
						JOptionPane.showMessageDialog(null,"Usuario creado correctamente");
						controladorPanelRegistro.accionadoBottonMostrarPanelOperatividad();
					}else {
						JOptionPane.showMessageDialog(null,"El usuario ya existe o imposible implementar ese usuario");
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

