package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelComandas;

@SuppressWarnings("serial")
public class PanelComandas extends JPanel {

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JLabel lblTicketFactura;
	
	private ControladorPanelComandas controladorPanelComandas;
	
	public PanelComandas(ControladorPanelComandas controladorPanelComandas) {
		setBackground(new Color(102, 153, 255));
		this.controladorPanelComandas = controladorPanelComandas;
		setLayout(null);
		
		lblTicketFactura = new JLabel("Comandas");
		lblTicketFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTicketFactura.setBounds(126, 11, 368, 14);
		add(lblTicketFactura);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		
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