package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelOperatividad;

@SuppressWarnings("serial")
public class PanelOperatividad extends JPanel {

	private JButton btnDesconectarse;
	private JLabel lblOperatividad;
	private ControladorPanelOperatividad controladorPanelOperatividad;
	
	public PanelOperatividad(ControladorPanelOperatividad controladorPanelOperatividad)
	{
		this.controladorPanelOperatividad = controladorPanelOperatividad;
		
		setLayout(null);
		
		lblOperatividad = new JLabel("Panel Operatividad");
		lblOperatividad.setBounds(58, 34, 115, 14);
		add(lblOperatividad);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(53, 217, 120, 23);
		add(btnDesconectarse);
		
		JButton btnAprovisionamiento = new JButton("Aprovisionamiento");
		btnAprovisionamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAprovisionamiento.setBounds(53, 183, 121, 23);
		add(btnAprovisionamiento);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(53, 81, 120, 23);
		add(btnPedidos);
		
		JButton btnComandas = new JButton("Comandas");
		btnComandas.setBounds(53, 115, 120, 23);
		add(btnComandas);
		
		JButton btnTicketfactura = new JButton("Ticket / Factura");
		btnTicketfactura.setBounds(53, 149, 121, 23);
		add(btnTicketfactura);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelOperatividad));
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelOperatividad.accionadoBottonVolverPanelOperatividad();
			}
		};
	}
}
