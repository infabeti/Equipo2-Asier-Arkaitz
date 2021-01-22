package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelAprovisionamiento;
import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelOperatividad;

@SuppressWarnings("serial")
public class PanelComandas extends JPanel{

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private ControladorPanelComandas controladorPanelComandas;
	
	public PanelComandas(ControladorPanelComandas controladorPanelComandas) {
		this.controladorPanelComandas = controladorPanelComandas;
		setLayout(null);
		
		JLabel lblComandas = new JLabel("Comandas");
		lblComandas.setHorizontalAlignment(SwingConstants.CENTER);
		lblComandas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComandas.setBounds(38, 24, 362, 14);
		add(lblComandas);
		
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
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelComandas));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelComandas));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelComandas.accionadoBottonVolverPanelComandas();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelComandas.accionadoBottonDesconectarsePanelComandas();
			}
		};
	}
}
