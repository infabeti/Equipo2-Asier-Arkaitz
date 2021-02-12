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

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{

	private JButton btnOperatividad;
	private JLabel lblBienvenida;
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
		btnOperatividad.setBounds(250, 218, 120, 23);
		add(btnOperatividad);
		
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
				JOptionPane.showMessageDialog(null, "Conectado a la base de datos");
			}else {
				JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
				System.exit(0);
			}
	}
}
