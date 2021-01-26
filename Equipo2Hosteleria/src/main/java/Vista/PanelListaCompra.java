package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelOperatividad;
import Controlador.ControladorPanelPedidos;
import Controlador.ControladorPanelTicketFactura;
import Controlador.ControladorPanelListaCompra;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelListaCompra extends JPanel {

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JLabel lblTicketFactura;
	private JLabel lblProductos;
	private JLabel lblTotal;
	private JPanel contentPane;
	private JTextPane textPane_Total;
	private JTextPane textPane_Productos;
	private JScrollPane scrollPane;
	private ButtonGroup grupoBotones;
	
	private ControladorPanelListaCompra controladorPanelListaCompra;
	
	static String ListaCompra="";
	static String ListaCompraTotal="";
	
	public PanelListaCompra(ControladorPanelListaCompra controladorPanelListaCompra) {
		this.controladorPanelListaCompra = controladorPanelListaCompra;
		setLayout(null);
		
		lblTicketFactura = new JLabel("Lista de la compra");
		lblTicketFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTicketFactura.setBounds(38, 11, 368, 14);
		add(lblTicketFactura);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		
		lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(38, 36, 89, 19);
		add(lblProductos);
		
		grupoBotones = new ButtonGroup();
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(305, 237, 45, 19);
		add(lblTotal);
		
		textPane_Total = new JTextPane();
		textPane_Total.setBounds(343, 238, 63, 20);
		add(textPane_Total);
		//textPane_Productos.setText(ListaCompra);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 61, 368, 163);
		add(scrollPane);
		
		textPane_Productos = new JTextPane();
		scrollPane.setViewportView(textPane_Productos);
		textPane_Productos.setText(ListaCompra);
		
		
		JLabel lblNewLabel = new JLabel("<html><body style=\"text-align:center\"><img src=\"https://i0.wp.com/www.silocreativo.com/wp-content/uploads/2015/03/patron-geometrico-gratis.jpg?resize=600%2C370&quality=100&strip=all&ssl=1\" width=\"700\"/></body></html>");
		lblNewLabel.setBounds(0, 0, 450, 330);
		add(lblNewLabel);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelListaCompra));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelListaCompra));
	}
	
	
	private ActionListener listenerBotonVolver(ControladorPanelListaCompra controladorPanelListaCompra) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelListaCompra.accionadoBottonVolverPanelListaCompra();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelListaCompra controladorPanelListaCompra) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelListaCompra.accionadoBottonDesconectarsePanelListaCompra();
			}
		};
	}
}
