package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;

import Modelo.ConexionMySQL;
import Modelo.Usuario;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{

	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	private JLabel lblBienvenida;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextPane textPane_Usuario;
	private JTextPane textPane_Contrasea;
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
		btnIniciarSesion.setBounds(183, 337, 126, 32);
		add(btnIniciarSesion);
		
		textPane_Usuario = new JTextPane();
		textPane_Usuario.setBounds(215, 167, 189, 22);
		add(textPane_Usuario);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(231, 133, 157, 23);
		add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(231, 226, 157, 23);
		add(lblContrasea);
		
		textPane_Contrasea = new JTextPane();
		textPane_Contrasea.setBounds(215, 260, 189, 22);
		add(textPane_Contrasea);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(309, 337, 126, 32);
		add(btnRegistrarse);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnIniciarSesion.addActionListener(listenerBotonOperatividad(this.controladorPanelBienvenida));
		this.btnRegistrarse.addActionListener(listenerBotonRegistrarse(this.controladorPanelBienvenida));
	}
	
	private ActionListener listenerBotonOperatividad(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String usuario = textPane_Usuario.getText();
				String contraseña = String.valueOf(textPane_Contrasea.getText());

				ConexionMySQL ConexionMySQLUsuario = new ConexionMySQL();

				Usuario usuario1 = new Usuario();
				usuario1.setUsuario(usuario);
				usuario1.setContraseña(contraseña);

				Usuario usu = ConexionMySQLUsuario.obtenerUsuario(usuario1);

				if (usu != null) {
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
}
