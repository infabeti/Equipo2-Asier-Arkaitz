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
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{

	private JButton btnOperatividad;
	private JLabel lblBienvenida;
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
		
		btnOperatividad = new JButton("Operatividad");
		btnOperatividad.setBounds(214, 208, 192, 43);
		add(btnOperatividad);
		
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
		this.btnOperatividad.addActionListener(listenerBotonOperatividad(this.controladorPanelBienvenida));
		this.establecerConexion();
	}
	
	private ActionListener listenerBotonOperatividad(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Operatividad");
				controladorPanelBienvenida.accionadoBottonMostrarPanelOperatividad();
			}
		};
	}
	
	public void establecerConexion() {
		System.out.println("Ejecutando evento Boton Prueba Conexion");
		boolean conexion = controladorPanelBienvenida.establecerConexion();
			if(conexion==true) {
				//JOptionPane.showMessageDialog(null, "Conectado a la base de datos");
				progressBar.setValue(1);
			}else {
				//JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
				progressBar.setValue(0);
				System.exit(0);
			}
	}
}
