package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelOperatividad;
import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelAprovisionamiento;
import Controlador.ControladorPanelTicketFactura;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelOperatividad extends JPanel {

	private JButton btnDesconectarse;
	private JButton btnPedidos;
	private JButton btnComandas;
	private JButton btnAprovisionamiento;
	private JButton btnTicketfactura;
	private JLabel lblOperatividad;
	private ControladorPanelOperatividad controladorPanelOperatividad;
	
	public PanelOperatividad(ControladorPanelOperatividad controladorPanelOperatividad)
	{
		this.controladorPanelOperatividad = controladorPanelOperatividad;
		
		setLayout(null);
		
		lblOperatividad = new JLabel("Panel Operatividad");
		lblOperatividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperatividad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOperatividad.setBounds(66, 11, 296, 27);
		add(lblOperatividad);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDesconectarse.setBounds(131, 201, 157, 29);
		add(btnDesconectarse);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPedidos.setBounds(21, 54, 174, 43);
		add(btnPedidos);
		
		btnAprovisionamiento = new JButton("Aprovisionamiento");
		btnAprovisionamiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAprovisionamiento.setBounds(229, 139, 192, 43);
		add(btnAprovisionamiento);
		
		btnComandas = new JButton("Comandas");
		btnComandas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnComandas.setBounds(229, 54, 192, 43);
		add(btnComandas);
		
		btnTicketfactura = new JButton("Ticket / Factura");
		btnTicketfactura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTicketfactura.setBounds(21, 139, 174, 43);
		add(btnTicketfactura);
		
		JLabel lblNewLabel = new JLabel("<html><body style=\"text-align:center\"><img src=\"https://i0.wp.com/www.silocreativo.com/wp-content/uploads/2015/03/patron-geometrico-gratis.jpg?resize=600%2C370&quality=100&strip=all&ssl=1\" width=\"700\"/></body></html>");
		lblNewLabel.setBounds(0, 0, 450, 330);
		add(lblNewLabel);
		
		initializeEvents();
	
	}
	
	private void initializeEvents() {
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelOperatividad));
		this.btnPedidos.addActionListener(listenerBotonPedidos(this.controladorPanelOperatividad));
		this.btnComandas.addActionListener(listenerBotonComandas(this.controladorPanelOperatividad));
		this.btnAprovisionamiento.addActionListener(listenerBotonAprovisionamiento(this.controladorPanelOperatividad));
		this.btnTicketfactura.addActionListener(listenerBotonTicketfactura(this.controladorPanelOperatividad));
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelOperatividad.accionadoBottonVolverPanelOperatividad();
			}
		};
	}
	
	private ActionListener listenerBotonPedidos(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Pedidos");
				controladorPanelOperatividad.accionadoBottonMostrarPanelPedidos();
			}
		};
	}
	
	private ActionListener listenerBotonComandas(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Comandas");
				controladorPanelOperatividad.accionadoBottonMostrarPanelComandas();
			}
		};
	}
	
	private ActionListener listenerBotonAprovisionamiento(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Aprovisionamiento");
				controladorPanelOperatividad.accionadoBottonMostrarPanelAprovisionamiento();
			}
		};
	}
	
	private ActionListener listenerBotonTicketfactura(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Ticket/Factura");
				controladorPanelOperatividad.accionadoBottonMostrarPanelTicketFactura();
			}
		};
	}
}
