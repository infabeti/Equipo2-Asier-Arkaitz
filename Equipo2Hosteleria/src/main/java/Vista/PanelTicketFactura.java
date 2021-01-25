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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelTicketFactura extends JPanel implements ChangeListener {

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JButton btnPagar;
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
	private JPanel contentPane;
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
		lblTicketFactura.setBounds(38, 11, 368, 14);
		add(lblTicketFactura);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(293, 235, 113, 23);
		add(btnPagar);
		
		lblTransaccion = new JLabel("N\u00BA Transaccion:");
		lblTransaccion.setBounds(38, 48, 89, 20);
		add(lblTransaccion);
		
		textPane_Fecha = new JTextPane();
		textPane_Fecha.setBounds(92, 101, 119, 20);
		add(textPane_Fecha);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(38, 101, 62, 20);
		add(lblFecha);
		
		lblLocal = new JLabel("Local:");
		lblLocal.setBounds(38, 126, 51, 20);
		add(lblLocal);
		
		textPane_NºTransaccion = new JTextPane();
		textPane_NºTransaccion.setBounds(38, 70, 173, 20);
		add(textPane_NºTransaccion);
		
		textPane_Local = new JTextPane();
		textPane_Local.setBounds(92, 126, 119, 20);
		add(textPane_Local);
		
		lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(38, 153, 89, 19);
		add(lblProductos);
		
		grupoBotones = new ButtonGroup();
		
		rdbtnTicket = new JRadioButton("Ticket");
		rdbtnTicket.setSelected(true);
		rdbtnTicket.setBounds(246, 38, 71, 23);
		rdbtnTicket.addChangeListener(this);
		add(rdbtnTicket);
		grupoBotones.add(rdbtnTicket);
		
		rdbtnFactura = new JRadioButton("Factura");
		rdbtnFactura.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFactura.setBounds(325, 38, 81, 23);
		rdbtnFactura.addChangeListener(this);
		add(rdbtnFactura);
		grupoBotones.add(rdbtnFactura);
		
		lblNif = new JLabel("NIF:");
		lblNif.setEnabled(false);
		lblNif.setBounds(221, 76, 62, 20);
		add(lblNif);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setEnabled(false);
		lblNombre.setBounds(221, 101, 62, 20);
		add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setEnabled(false);
		lblApellidos.setBounds(221, 126, 62, 20);
		add(lblApellidos);
		
		textPane_NIF = new JTextPane();
		textPane_NIF.setEnabled(false);
		textPane_NIF.setBounds(287, 76, 119, 20);
		add(textPane_NIF);
		
		textPane_Nombre = new JTextPane();
		textPane_Nombre.setEnabled(false);
		textPane_Nombre.setBounds(287, 101, 119, 20);
		add(textPane_Nombre);
		
		textPane_Apellidos = new JTextPane();
		textPane_Apellidos.setEnabled(false);
		textPane_Apellidos.setBounds(287, 126, 119, 20);
		add(textPane_Apellidos);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(303, 153, 45, 19);
		add(lblTotal);
		
		textPane_Total = new JTextPane();
		textPane_Total.setBounds(343, 152, 63, 20);
		add(textPane_Total);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 177, 368, 47);
		add(scrollPane);
		
		textPane_Productos = new JTextPane();
		scrollPane.setViewportView(textPane_Productos);
		
		JLabel lblNewLabel = new JLabel("<html><body style=\"text-align:center\"><img src=\"https://i0.wp.com/www.silocreativo.com/wp-content/uploads/2015/03/patron-geometrico-gratis.jpg?resize=600%2C370&quality=100&strip=all&ssl=1\" width=\"700\"/></body></html>");
		lblNewLabel.setBounds(0, 0, 450, 330);
		add(lblNewLabel);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTicketFactura));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelTicketFactura));
		this.btnPagar.addActionListener(listenerBotonPagar(this.controladorPanelTicketFactura));
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
	
	private ActionListener listenerBotonPagar(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new JPanel();
				contentPane.setBackground(new Color(0, 153, 255));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				if (rdbtnTicket.isSelected() && !textPane_NºTransaccion.getText().equals("") && !textPane_Fecha.getText().equals("") && !textPane_Local.getText().equals("") && !textPane_Total.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pagar");
					controladorPanelTicketFactura.accionadoBottonPagarPanelTicketFactura();
				}else if (rdbtnFactura.isSelected() && !textPane_NºTransaccion.getText().equals("") && !textPane_Fecha.getText().equals("") && !textPane_Local.getText().equals("") && !textPane_Total.getText().equals("") && !textPane_NIF.getText().equals("") && !textPane_Nombre.getText().equals("") && !textPane_Apellidos.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pagar");
					controladorPanelTicketFactura.accionadoBottonPagarPanelTicketFactura();
				}else {
					JOptionPane.showMessageDialog(contentPane,"Rellene todos los campos pertinentes.");
				}
			}

			private void setContentPane(JPanel contentPane) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
