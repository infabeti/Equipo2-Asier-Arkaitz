package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelOperatividad;

@SuppressWarnings("serial")
public class PanelComandas extends JPanel{

	private JButton btnOperatividad;
	private JLabel lblBienvenida;
	private ControladorPanelComandas controladorPanelComandas;
	
	public PanelComandas(ControladorPanelComandas controladorPanelComandas) {
		this.controladorPanelComandas = controladorPanelComandas;
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
		this.btnOperatividad.addActionListener(listenerBotonOperatividad(this.controladorPanelComandas));
	}
	
	private ActionListener listenerBotonOperatividad(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Operatividad");
				controladorPanelComandas.accionadoBottonMostrarPanelPedidos();
			}
		};
	}
}
