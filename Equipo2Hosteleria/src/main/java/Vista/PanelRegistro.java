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
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings({ "serial", "rawtypes" })
public class PanelRegistro extends JPanel{
	
	private JTextField textDni;
	private JTextField textContrasena1;
	private JTextField textContrasena2;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textField_NIFLocal;
	private JButton btnCrear;
	private JButton btnVolver;
	private JComboBox comboBox_Local;
	
	public static String nombreLocal="";
	
	private ControladorPanelRegistro controladorPanelRegistro;
	
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
		
		textDni = new JTextField();
		textDni.setBounds(82, 75, 153, 20);
		add(textDni);
		textDni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduce tu contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(340, 50, 198, 20);
		add(lblNewLabel_2);
		
		textContrasena1 = new JTextField();
		textContrasena1.setBounds(385, 75, 153, 20);
		add(textContrasena1);
		textContrasena1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Repetir contrase\u00F1a");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(340, 130, 198, 20);
		add(lblNewLabel_3);
		
		textContrasena2 = new JTextField();
		textContrasena2.setBounds(385, 155, 153, 20);
		add(textContrasena2);
		textContrasena2.setColumns(10);
		
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
	
		String arrayNombresLocal[] = controladorPanelRegistro.MostrarNombreLocal();
		for(int i = 0;i<arrayNombresLocal.length;i++)
		{
			comboBox_Local.addItem(arrayNombresLocal[i]);
		}
		nombreLocal=comboBox_Local.getSelectedItem().toString();
				
		JLabel lblNewNifLocal = new JLabel("Selecciona NIF del local");
		lblNewNifLocal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewNifLocal.setBounds(340, 290, 198, 20);
		add(lblNewNifLocal);
		
		textField_NIFLocal = new JTextField();
		textField_NIFLocal.setColumns(10);
		textField_NIFLocal.setBounds(385, 317, 153, 20);
		textField_NIFLocal.setText(""+controladorPanelRegistro.MostrarNifLocal(nombreLocal));
		add(textField_NIFLocal);

		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerbtnVolver(this.controladorPanelRegistro)); 
		this.btnCrear.addActionListener(listenerbtnCrear(this.controladorPanelRegistro));
		this.comboBox_Local.addItemListener(listenerLocal(this.controladorPanelRegistro));
	}
	
	private ActionListener listenerbtnCrear(ControladorPanelRegistro controladorPanelRegistro) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrarse");
				
				if (textDni.getText().equals("") || textContrasena1.getText().equals("") || textNombre.getText().equals("") || textApellidos.getText().equals("") || textField_NIFLocal.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos");
				}else if (!textContrasena2.getText().equals(textContrasena1.getText())) {
					JOptionPane.showMessageDialog(null,"Repita la contraseña correctamente");
				}else {
					boolean creado = controladorPanelRegistro.accionadoBottonCrearPanelRegistro(textDni.getText(), textContrasena1.getText(), textNombre.getText(), textApellidos.getText(), textField_NIFLocal.getText());
				
					if (creado == true) {
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
	
	private ItemListener listenerLocal(ControladorPanelRegistro controladorPanelRegistro) {
		return new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				nombreLocal=comboBox_Local.getSelectedItem().toString();	
				textField_NIFLocal.setText(""+controladorPanelRegistro.MostrarNifLocal(nombreLocal));
			}
		};
	}

}