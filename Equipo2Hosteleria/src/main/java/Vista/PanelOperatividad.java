package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelOperatividad;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Color;

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
		setBackground(new Color(102, 153, 255));
		this.controladorPanelOperatividad = controladorPanelOperatividad;
		
		setLayout(null);
		
		lblOperatividad = new JLabel("Panel Operatividad");
		lblOperatividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperatividad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOperatividad.setBounds(162, 11, 296, 27);
		add(lblOperatividad);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDesconectarse.setBounds(214, 286, 192, 43);
		add(btnDesconectarse);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setEnabled(false);
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPedidos.setBounds(78, 104, 192, 43);
		add(btnPedidos);
		
		btnAprovisionamiento = new JButton("Aprovisionamiento");
		btnAprovisionamiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAprovisionamiento.setBounds(348, 189, 192, 43);
		add(btnAprovisionamiento);
		
		btnComandas = new JButton("Comandas");
		btnComandas.setEnabled(false);
		btnComandas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnComandas.setBounds(348, 104, 192, 43);
		add(btnComandas);
		
		btnTicketfactura = new JButton("Ticket / Factura");
		btnTicketfactura.setEnabled(false);
		btnTicketfactura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTicketfactura.setBounds(78, 189, 192, 43);
		add(btnTicketfactura);
		
		initializeEvents();
	
	}
	
	private void initializeEvents() {
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelOperatividad));
		this.btnPedidos.addActionListener(listenerBotonPedidos(this.controladorPanelOperatividad));
		this.btnComandas.addActionListener(listenerBotonComandas(this.controladorPanelOperatividad));
		this.btnAprovisionamiento.addActionListener(listenerBotonAprovisionamiento(this.controladorPanelOperatividad));
		this.btnTicketfactura.addActionListener(listenerBotonTicketfactura(this.controladorPanelOperatividad));
		this.obtenerTipoLocal();
	}
	
	private void obtenerTipoLocal(){
		String tipo = this.controladorPanelOperatividad.obtenerTipoLocal();
		if (tipo.equals("BAR")) {
			this.btnPedidos.setEnabled(true);
		} else if (tipo.equals("CAFETERIA")) {
			this.btnPedidos.setEnabled(true);
			this.btnTicketfactura.setEnabled(true);
		} else if (tipo.equals("RESTAURANTE")) {
			this.btnPedidos.setEnabled(true);
			this.btnTicketfactura.setEnabled(true);
			this.btnComandas.setEnabled(true);
		} 
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
