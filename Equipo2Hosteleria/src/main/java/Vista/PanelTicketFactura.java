package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelOperatividad;
import Controlador.ControladorPanelTicketFactura;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelTicketFactura extends JPanel{

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JRadioButton rdbtnTicket;
	private JRadioButton rdbtnFactura;
	private JLabel lblTicketFactura;
	private JLabel lblTransaccion;
	private JLabel lblFecha;
	private JLabel lblLocal;
	private JLabel lblProductos;
	private JLabel lblNif;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblTotal;
	private JTextPane textPane_Fecha;
	private JTextPane textPane_NºTransaccion;
	private JTextPane textPane_Local;
	private JTextPane textPane_NIF;
	private JTextPane textPane_Nombre;
	private JTextPane textPane_Apellidos;
	private JTextPane textPane_Total;
	private JTextPane textPane_Productos;
	private JScrollPane scrollPane;
	private ButtonGroup grupoBotones;
	
	private ControladorPanelTicketFactura controladorPanelTicketFactura;
	
	public PanelTicketFactura(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		this.controladorPanelTicketFactura = controladorPanelTicketFactura;
		setLayout(null);
		
		lblTicketFactura = new JLabel("Ticket o Factura");
		lblTicketFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTicketFactura.setBounds(38, 11, 362, 14);
		add(lblTicketFactura);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		
		lblTransaccion = new JLabel("N\u00BATransaccion");
		lblTransaccion.setBounds(10, 42, 89, 14);
		add(lblTransaccion);
		
		textPane_Fecha = new JTextPane();
		textPane_Fecha.setBounds(49, 76, 129, 20);
		add(textPane_Fecha);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 76, 89, 14);
		add(lblFecha);
		
		lblLocal = new JLabel("Local");
		lblLocal.setBounds(10, 110, 89, 14);
		add(lblLocal);
		
		textPane_NºTransaccion = new JTextPane();
		textPane_NºTransaccion.setBounds(101, 36, 129, 20);
		add(textPane_NºTransaccion);
		
		textPane_Local = new JTextPane();
		textPane_Local.setBounds(49, 107, 129, 20);
		add(textPane_Local);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setBounds(10, 152, 89, 14);
		add(lblProductos);
		
		rdbtnTicket = new JRadioButton("Ticket");
		rdbtnTicket.setBounds(246, 38, 71, 23);
		add(rdbtnTicket);
		grupoBotones.add(rdbtnTicket);
		
		rdbtnFactura = new JRadioButton("Factura");
		rdbtnFactura.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFactura.setBounds(319, 38, 81, 23);
		add(rdbtnFactura);
		grupoBotones.add(rdbtnFactura);
		
		lblNif = new JLabel("NIF");
		lblNif.setBounds(202, 76, 89, 14);
		add(lblNif);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(202, 101, 63, 14);
		add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(202, 126, 89, 14);
		add(lblApellidos);
		
		textPane_NIF = new JTextPane();
		textPane_NIF.setBounds(227, 76, 129, 20);
		add(textPane_NIF);
		
		textPane_Nombre = new JTextPane();
		textPane_Nombre.setBounds(256, 101, 129, 20);
		add(textPane_Nombre);
		
		textPane_Apellidos = new JTextPane();
		textPane_Apellidos.setBounds(266, 126, 129, 20);
		add(textPane_Apellidos);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(311, 239, 45, 14);
		add(lblTotal);
		
		textPane_Total = new JTextPane();
		textPane_Total.setBounds(343, 238, 63, 20);
		add(textPane_Total);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 408, 47);
		add(scrollPane);
		
		textPane_Productos = new JTextPane();
		scrollPane.setViewportView(textPane_Productos);
		
		grupoBotones = new ButtonGroup();
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTicketFactura));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelTicketFactura));
	}
	
	public void stateChanged(ChangeEvent e){
        
		if (rdbtnTicket.isSelected()) {
			lblNif.setEnabled(false);
			lblNombre.setEnabled(false);
			lblApellidos.setEnabled(false);
			textPane_NIF.setEnabled(false);
			textPane_Nombre.setEnabled(false);
			textPane_Apellidos.setEnabled(false);
		}
		if (rdbtnFactura.isSelected()) {
			lblNif.setEnabled(true);
			lblNombre.setEnabled(true);
			lblApellidos.setEnabled(true);
			textPane_NIF.setEnabled(true);
			textPane_Nombre.setEnabled(true);
			textPane_Apellidos.setEnabled(true);
		}
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelTicketFactura.accionadoBottonVolverPanelTicketFactura();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelTicketFactura.accionadoBottonDesconectarsePanelTicketFactura();
			}
		};
	}
}
