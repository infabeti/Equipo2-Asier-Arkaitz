package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelOperatividad;
import Controlador.ControladorPanelAprovisionamiento;

@SuppressWarnings("serial")
public class PanelAprovisionamiento extends JPanel{

	private JButton btnOperatividad;
	private JLabel lblBienvenida;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	
	public PanelAprovisionamiento(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;
		setLayout(null);
		
		lblBienvenida = new JLabel("\u00A1Bienvenido a la aplicaci\u00F3n de hosteleria definitiva!");
		lblBienvenida.setBounds(58, 35, 268, 14);
		add(lblBienvenida);
		
		btnOperatividad = new JButton("Operatividad");
		btnOperatividad.setBounds(58, 116, 120, 23);
		add(btnOperatividad);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnOperatividad.addActionListener(listenerBotonOperatividad(this.controladorPanelAprovisionamiento));
	}
	
	private ActionListener listenerBotonOperatividad(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Operatividad");
				controladorPanelAprovisionamiento.accionadoBottonMostrarPanelPedidos();
			}
		};
	}
}
