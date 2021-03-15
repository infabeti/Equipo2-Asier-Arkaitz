package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{

	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	private JLabel lblBienvenida;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextPane textPane_Usuario;
	private JTextPane textPane_Contrasea;
	private JProgressBar progressBar;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	
	public PanelBienvenida(ControladorPanelBienvenida controladorPanelBienvenida) {
		setBackground(new Color(102, 153, 255));
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		setLayout(null);
		
		lblBienvenida = new JLabel("\u00A1Bienvenido a la aplicaci\u00F3n de hosteleria definitiva!");
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(40, 35, 539, 32);
		add(lblBienvenida);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarSesion.setBounds(183, 276, 126, 32);
		add(btnIniciarSesion);
		
		textPane_Usuario = new JTextPane();
		textPane_Usuario.setBounds(215, 131, 189, 22);
		add(textPane_Usuario);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(231, 97, 157, 23);
		add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(231, 190, 157, 23);
		add(lblContrasea);
		
		textPane_Contrasea = new JTextPane();
		textPane_Contrasea.setBounds(215, 224, 189, 22);
		add(textPane_Contrasea);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(309, 276, 126, 32);
		add(btnRegistrarse);
		
		JLabel lblConexion = new JLabel("Estado de la conexi\u00F3n con MySQL:");
		lblConexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConexion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConexion.setBounds(135, 331, 350, 32);
		add(lblConexion);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(1);
		progressBar.setBackground(new Color(255, 0, 0));
		progressBar.setForeground(new Color(0, 204, 0));
		progressBar.setBounds(237, 374, 146, 25);
		add(progressBar);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnIniciarSesion.addActionListener(listenerBotonOperatividad(this.controladorPanelBienvenida));
		this.btnRegistrarse.addActionListener(listenerBotonRegistrarse(this.controladorPanelBienvenida));
		this.establecerConexion();
	}
	
	private ActionListener listenerBotonOperatividad(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String dni = textPane_Usuario.getText();
				String contrasena = textPane_Contrasea.getText();	
				boolean iniciado = controladorPanelBienvenida.accionadoBottonIniciarPanelOperatividad(dni, contrasena);

				if (iniciado == true) {
					controladorPanelBienvenida.obtenerLocal(dni);
					controladorPanelBienvenida.accionadoBottonMostrarPanelOperatividad();
				}else {
					JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos.");
				}
			}
		};
	}
	
	private ActionListener listenerBotonRegistrarse(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrarse");
				controladorPanelBienvenida.accionadoBottonMostrarPanelRegistro();
			}
		};
	}
	
	private void establecerConexion() {
		System.out.println("Ejecutando evento Boton Prueba Conexion");
		boolean conexion = controladorPanelBienvenida.establecerConexion();
		if(conexion==true) {
			progressBar.setValue(1);
		}else {
			JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
			progressBar.setValue(0);
			System.exit(0);
		}
	}
}
