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
import Modelo.Usuario;

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
	private JButton btnPruebaConexion;
	private JLabel lblOperatividad;
	private ControladorPanelOperatividad controladorPanelOperatividad;
	
	
	
	
	/*public void Usuario(String Negocio) {
		this.negocio=Negocio;
		
		if(negocio =="bar") {
			btnPedidos.setEnabled(false);
		}
		if(negocio =="bar" || negocio =="cafeteria") {
			btnComandas.setEnabled(false);
		}
	}
	*/
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
		
		btnPruebaConexion = new JButton("Conexi\u00F3n MySQL");
		btnPruebaConexion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPruebaConexion.setBounds(264, 244, 157, 29);
		add(btnPruebaConexion);
		
		initializeEvents();
	
	}
	
	private void initializeEvents() {
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelOperatividad));
		this.btnPedidos.addActionListener(listenerBotonPedidos(this.controladorPanelOperatividad));
		this.btnComandas.addActionListener(listenerBotonComandas(this.controladorPanelOperatividad));
		this.btnAprovisionamiento.addActionListener(listenerBotonAprovisionamiento(this.controladorPanelOperatividad));
		this.btnTicketfactura.addActionListener(listenerBotonTicketfactura(this.controladorPanelOperatividad));
		this.btnPruebaConexion.addActionListener(listenerBotonPruebaConexion(this.controladorPanelOperatividad));
		
	
		
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelOperatividad.accionadoBottonVolverPanelOperatividad();
			}
		};
	}
	
	private ActionListener listenerBotonPruebaConexion(ControladorPanelOperatividad controladorPanelOperatividad) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Prueba Conexion");
				//controladorPanelOperatividad.accionadoBottonPruebaConexionPanelOperatividad();
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
