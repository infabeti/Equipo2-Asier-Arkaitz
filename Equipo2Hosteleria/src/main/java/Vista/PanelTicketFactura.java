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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controlador.ControladorPanelTicketFactura;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.time.LocalDate;

@SuppressWarnings({ "rawtypes", "unchecked" , "serial" , "deprecation"})
public class PanelTicketFactura extends JPanel implements ChangeListener {

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JButton btnPagar;
	private JButton btnBorrarLista;
	private JButton btnAadirAlCarro;
	private JComboBox comboBox_Productos;
	private JComboBox comboBox_Cantidad;
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
	private JLabel lblProductos_1;
	private JLabel lblCantidad;
	private JTextField textField_Fecha;
	private JTextField textField_NTransaccion;
	private JTextField textField_Local;
	private JTextField textField_NIF;
	private JTextField textField_Nombre;
	private JTextField textField_Apellidos;
	private JTextField textField_Total;
	private JTextPane textPane_Productos;
	private JScrollPane scrollPane;
	private ButtonGroup grupoBotones;
	
	private ControladorPanelTicketFactura controladorPanelTicketFactura;
	
	public static int ControlarCaja=0;
	public static String ListaCompra="";
	public static String ListaCompraTotal="";
	private int factura=0;

	static String LocalP="Freddy Fazbear's Pizza";
	LocalDate date = LocalDate.now();
	String fecha = date.toString();
	
	public PanelTicketFactura(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		setBackground(new Color(102, 153, 255));
		this.controladorPanelTicketFactura = controladorPanelTicketFactura;
		setLayout(null);
		
		ListaCompra = controladorPanelTicketFactura.obtenerListaCompra();
		ListaCompraTotal = ""+controladorPanelTicketFactura.obtenerTotalCarro();
		
		btnAadirAlCarro = new JButton("A\u00F1adir al carro");
		btnAadirAlCarro.setBounds(419, 187, 172, 23);
		add(btnAadirAlCarro);
		
		btnBorrarLista = new JButton("Borrar lista");
		btnBorrarLista.setBounds(433, 396, 158, 23);
		add(btnBorrarLista);
		
		comboBox_Cantidad = new JComboBox();
		comboBox_Cantidad.setBounds(531, 150, 60, 22);
		add(comboBox_Cantidad);
		
		int numbers_to_add_max = 99;
		for (int i = 1; i <= numbers_to_add_max; i++) {
			comboBox_Cantidad.addItem(new Integer(i));
		}
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(419, 150, 102, 22);
		add(lblCantidad);
		
		comboBox_Productos = new JComboBox();
		comboBox_Productos.setBounds(419, 117, 173, 22);
		add(comboBox_Productos);
		
		String arrayNombresProducto[] = controladorPanelTicketFactura.obtenerNombresProductos();
		
		for(int i = 0;i<arrayNombresProducto.length;i++)
		{
			comboBox_Productos.addItem(arrayNombresProducto[i]);
		}
		
		lblProductos_1 = new JLabel("Productos:");
		lblProductos_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductos_1.setBounds(419, 84, 170, 22);
		add(lblProductos_1);
		
		lblTicketFactura = new JLabel("Ticket o Factura");
		lblTicketFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTicketFactura.setBounds(126, 11, 368, 14);
		add(lblTicketFactura);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(127, 396, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(28, 396, 89, 23);
		add(btnVolver);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(283, 396, 139, 23);
		add(btnPagar);
		
		lblTransaccion = new JLabel("N\u00BA Transaccion:");
		lblTransaccion.setBounds(28, 59, 89, 20);
		add(lblTransaccion);
		
		textField_Fecha = new JTextField();
		textField_Fecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_Fecha.setEditable(false);
		textField_Fecha.setText(fecha);
		textField_Fecha.setBounds(70, 119, 131, 20);
		add(textField_Fecha);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(28, 119, 62, 20);
		add(lblFecha);
		
		lblLocal = new JLabel("Local:");
		lblLocal.setBounds(28, 150, 51, 20);
		add(lblLocal);
		
		textField_NTransaccion = new JTextField();
		textField_NTransaccion.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_NTransaccion.setEditable(false);
		textField_NTransaccion.setBounds(28, 89, 173, 20);
		add(textField_NTransaccion);
		textField_NTransaccion.setText(""+ controladorPanelTicketFactura.mostrarNumeroTransaccion());
		
		textField_Local = new JTextField();
		textField_Local.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_Local.setEditable(false);
		textField_Local.setBounds(70, 150, 131, 20);
		add(textField_Local);
		textField_Local.setText(LocalP);
		
		
		lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(28, 195, 89, 19);
		add(lblProductos);
		
		grupoBotones = new ButtonGroup();
		
		rdbtnTicket = new JRadioButton("Ticket");
		rdbtnTicket.setSelected(true);
		rdbtnTicket.setBounds(236, 56, 71, 23);
		rdbtnTicket.addChangeListener(this);
		add(rdbtnTicket);
		grupoBotones.add(rdbtnTicket);
		
		rdbtnFactura = new JRadioButton("Factura");
		rdbtnFactura.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFactura.setBounds(315, 56, 81, 23);
		rdbtnFactura.addChangeListener(this);
		add(rdbtnFactura);
		grupoBotones.add(rdbtnFactura);
		
		lblNif = new JLabel("NIF:");
		lblNif.setEnabled(false);
		lblNif.setBounds(211, 89, 62, 20);
		add(lblNif);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setEnabled(false);
		lblNombre.setBounds(211, 119, 62, 20);
		add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setEnabled(false);
		lblApellidos.setBounds(211, 150, 62, 20);
		add(lblApellidos);
		
		textField_NIF = new JTextField();
		textField_NIF.setEnabled(false);
		textField_NIF.setBounds(277, 89, 119, 20);
		add(textField_NIF);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setEnabled(false);
		textField_Nombre.setBounds(277, 119, 119, 20);
		add(textField_Nombre);
		
		textField_Apellidos = new JTextField();
		textField_Apellidos.setEnabled(false);
		textField_Apellidos.setBounds(277, 150, 119, 20);
		add(textField_Apellidos);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(293, 192, 45, 19);
		add(lblTotal);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTicketFactura));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelTicketFactura));
		this.btnPagar.addActionListener(listenerBotonPagar(this.controladorPanelTicketFactura));
		this.btnAadirAlCarro.addActionListener(listenerBotonAadirAlCarro(this.controladorPanelTicketFactura));
		this.btnBorrarLista.addActionListener(listenerBotonBorrarLista(this.controladorPanelTicketFactura));
		this.generarListaCompra();
	}
	
	public void stateChanged(ChangeEvent e){
        
		if (rdbtnTicket.isSelected()) {
			lblNif.setEnabled(false);
			lblNombre.setEnabled(false);
			lblApellidos.setEnabled(false);
			textField_NIF.setEnabled(false);
			textField_Nombre.setEnabled(false);
			textField_Apellidos.setEnabled(false);
			factura=0;
		}
		if (rdbtnFactura.isSelected()) {
			lblNif.setEnabled(true);
			lblNombre.setEnabled(true);
			lblApellidos.setEnabled(true);
			textField_NIF.setEnabled(true);
			textField_Nombre.setEnabled(true);
			textField_Apellidos.setEnabled(true);
			factura=1;
		}
	}
	
	public void generarListaCompra(){
		//textField_Total.remove(textField_Total);
		//textField_Total.remove(textPane_Productos);
		
		textField_Total = new JTextField();
		textField_Total.setEditable(false);
		textField_Total.setBounds(333, 191, 63, 20);
		add(textField_Total);
		textField_Total.setText(ListaCompraTotal);
		
		/*
		textArea_Productos = new JTextArea();
		textArea_Productos.setEditable(false);
		textArea_Productos.setBounds(28, 225, 563, 69);
		add(textArea_Productos);
		textArea_Productos.setText(ListaCompra);
		*/
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 225, 563, 69);
		add(scrollPane);
		
		textPane_Productos = new JTextPane();
		textPane_Productos.setEditable(false);
		scrollPane.setViewportView(textPane_Productos);
		textPane_Productos.setText(ListaCompra);
		
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				ControlarCaja=0;
				controladorPanelTicketFactura.accionadoBottonVolverPanelTicketFactura();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				ControlarCaja=0;
				controladorPanelTicketFactura.accionadoBottonDesconectarsePanelTicketFactura();
			}
		};
	}
	
	private ActionListener listenerBotonPagar(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ControlarCaja==1) {
					if (rdbtnTicket.isSelected() && !textField_Fecha.getText().equals("") && !textField_Local.getText().equals("") && !textField_Total.getText().equals("")) {
						System.out.println("Ejecutando evento Boton Pagar");
						ControlarCaja=0;
						controladorPanelTicketFactura.accionadoBottonPagarPanelTicketFactura(factura, null, null, null);	
					}else if (rdbtnFactura.isSelected() && !textField_Fecha.getText().equals("") && !textField_Local.getText().equals("") && !textField_Total.getText().equals("") && !textField_NIF.getText().equals("") && !textField_Nombre.getText().equals("") && !textField_Apellidos.getText().equals("")) {
						System.out.println("Ejecutando evento Boton Pagar");
						ControlarCaja=0;
						controladorPanelTicketFactura.accionadoBottonPagarPanelTicketFactura(factura, textField_NIF.getText(), textField_Nombre.getText(), textField_Apellidos.getText());	
					}else {
						JOptionPane.showMessageDialog(null,"Rellene todos los campos pertinentes.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Añade productos.");
				}
			}
		};
	}
	
	private ActionListener listenerBotonBorrarLista(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Borrar");
				controladorPanelTicketFactura.accionadoBottonBorrarListaPanelTicketFactura();
				
				ControlarCaja=1;
				
				ListaCompra = controladorPanelTicketFactura.obtenerListaCompra();
				ListaCompraTotal = ""+controladorPanelTicketFactura.obtenerTotalCarro();
				
				generarListaCompra();
			}
		};
	}
	
	private ActionListener listenerBotonAadirAlCarro(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir Al Carro");
				
				int cantidad = Integer.parseInt(comboBox_Cantidad.getSelectedItem().toString());
				String nomProducto = (comboBox_Productos.getSelectedItem().toString());
				
				controladorPanelTicketFactura.accionadoBottonAadirAlCarroPanelTicketFactura(nomProducto, cantidad);
				
				ControlarCaja=1;
				
				ListaCompra = controladorPanelTicketFactura.obtenerListaCompra();
				ListaCompraTotal = ""+controladorPanelTicketFactura.obtenerTotalCarro();
				
				generarListaCompra();
			}
		};
	}
}
