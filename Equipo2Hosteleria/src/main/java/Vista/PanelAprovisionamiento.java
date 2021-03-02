package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelAprovisionamiento;
import java.awt.Color;

@SuppressWarnings("serial")
public class PanelAprovisionamiento extends JPanel{

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	
	public PanelAprovisionamiento(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		setBackground(new Color(102, 153, 255));
		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;
		setLayout(null);
		
		JLabel lblAprovisionamiento = new JLabel("Aprovisionamiento");
		lblAprovisionamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAprovisionamiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAprovisionamiento.setBounds(129, 24, 362, 23);
		add(lblAprovisionamiento);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		

		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAprovisionamiento));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelAprovisionamiento));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAprovisionamiento.accionadoBottonVolverPanelAprovisionamiento();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelAprovisionamiento.accionadoBottonDesconectarsePanelAprovisionamiento();
			}
		};
	}
	
}
