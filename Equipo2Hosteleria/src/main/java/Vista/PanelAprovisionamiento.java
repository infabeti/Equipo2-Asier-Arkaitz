package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelOperatividad;
import Controlador.ControladorPanelPedidos;
import Controlador.ControladorPanelAprovisionamiento;

@SuppressWarnings("serial")
public class PanelAprovisionamiento extends JPanel{

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	
	public PanelAprovisionamiento(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;
		setLayout(null);
		
		JLabel lblAprovisionamiento = new JLabel("Aprovisionamiento");
		lblAprovisionamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAprovisionamiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAprovisionamiento.setBounds(38, 24, 362, 14);
		add(lblAprovisionamiento);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("<html><body style=\"text-align:center\"><img src=\"https://i0.wp.com/www.silocreativo.com/wp-content/uploads/2015/03/patron-geometrico-gratis.jpg?resize=600%2C370&quality=100&strip=all&ssl=1\" width=\"700\"/></body></html>");
		lblNewLabel.setBounds(0, 0, 450, 330);
		add(lblNewLabel);
		
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
