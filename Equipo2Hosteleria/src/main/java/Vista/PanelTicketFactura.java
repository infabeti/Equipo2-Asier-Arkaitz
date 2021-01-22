package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
	private ControladorPanelTicketFactura controladorPanelTicketFactura;
	
	public PanelTicketFactura(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		this.controladorPanelTicketFactura = controladorPanelTicketFactura;
		setLayout(null);
		
		JLabel lblTicketFactura = new JLabel("Ticket o Factura");
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
		
		JLabel lblTransaccion = new JLabel("N\u00BATransaccion");
		lblTransaccion.setBounds(10, 42, 89, 14);
		add(lblTransaccion);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(49, 76, 129, 20);
		add(textPane);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 76, 89, 14);
		add(lblFecha);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(10, 110, 89, 14);
		add(lblLocal);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(101, 36, 129, 20);
		add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(49, 107, 129, 20);
		add(textPane_2);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBounds(10, 152, 89, 14);
		add(lblProductos);
		
		JRadioButton rdbtnTicket = new JRadioButton("Ticket");
		rdbtnTicket.setBounds(246, 38, 71, 23);
		add(rdbtnTicket);
		
		JRadioButton rdbtnFactura = new JRadioButton("Factura");
		rdbtnFactura.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFactura.setBounds(319, 38, 81, 23);
		add(rdbtnFactura);
		
		JLabel lblNif = new JLabel("NIF");
		lblNif.setBounds(202, 76, 89, 14);
		add(lblNif);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(202, 101, 63, 14);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(202, 126, 89, 14);
		add(lblApellidos);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(227, 76, 129, 20);
		add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(256, 101, 129, 20);
		add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(266, 126, 129, 20);
		add(textPane_6);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(311, 239, 45, 14);
		add(lblTotal);
		
		JTextPane textPane_6_1 = new JTextPane();
		textPane_6_1.setBounds(343, 238, 63, 20);
		add(textPane_6_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 408, 47);
		add(scrollPane);
		
		JTextPane textPane_2_1 = new JTextPane();
		scrollPane.setViewportView(textPane_2_1);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTicketFactura));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelTicketFactura));
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
