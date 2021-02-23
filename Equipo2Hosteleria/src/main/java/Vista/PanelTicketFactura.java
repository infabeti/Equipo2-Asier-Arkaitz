package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import Modelo.ConexionMySQL;
import Modelo.Factura;
import Modelo.Identificacion;
import Modelo.Modelo;
import Modelo.Producto;
import Modelo.Ticket;
import Modelo.Usuario;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

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
	private JTextPane textPane_Fecha;
	private JTextPane textPane_NTransaccion;
	private JTextPane textPane_Local;
	private JTextPane textPane_NIF;
	private JTextPane textPane_Nombre;
	private JTextPane textPane_Apellidos;
	private JTextPane textPane_Total;
	private JTextPane textPane_Productos;
	private JScrollPane scrollPane;
	private ButtonGroup grupoBotones;
	
	private ControladorPanelTicketFactura controladorPanelTicketFactura;
	
	public static String ListaCompra="";
	public static String ListaCompraTotal="";
	public static  ArrayList<Ticket> ticket = new ArrayList();

	static String LocalP="El plato caliente";
	private JLabel lblProductos_1;
	private JComboBox comboBox_Productos;
	private JLabel lblCantidad;
	private JComboBox comboBox_Cantidad;
	private JButton btnBorrarLista;
	private JButton btnAadirAlCarro;
	
	public PanelTicketFactura(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		setBackground(new Color(102, 153, 255));
		this.controladorPanelTicketFactura = controladorPanelTicketFactura;
		setLayout(null);
		
		btnAadirAlCarro = new JButton("A\u00F1adir al carro");
		btnAadirAlCarro.setBounds(434, 149, 146, 23);
		add(btnAadirAlCarro);
		
		btnBorrarLista = new JButton("Borrar lista");
		btnBorrarLista.setBounds(443, 235, 158, 23);
		add(btnBorrarLista);
		
		comboBox_Cantidad = new JComboBox();
		comboBox_Cantidad.setBounds(522, 110, 60, 22);
		add(comboBox_Cantidad);
		
		int numbers_to_add_max = 99;
		for (int i = 1; i <= numbers_to_add_max; i++) {
			comboBox_Cantidad.addItem(new Integer(i));
		}
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(391, 114, 115, 14);
		add(lblCantidad);
		
		comboBox_Productos = new JComboBox();
		comboBox_Productos.setBounds(429, 76, 173, 22);
		add(comboBox_Productos);
		
		Producto Producto1 = new Producto("Garbanzos","Comida","30-01-2021",5,5);	
		Producto Producto2 = new Producto("Paella","Comida","31-01-2021",5,5);	
		Producto Producto3 = new Producto("Bacalao","Comida","02-02-2021",5,5);	
		Producto Producto4 = new Producto("Hamburguesa","Comida","30-01-2021",5,5);	
		Producto Producto5 = new Producto("Cerveza","Bebida","01-02-2021",5,5);	

		comboBox_Productos.addItem(Producto1);
		comboBox_Productos.addItem(Producto2);
		comboBox_Productos.addItem(Producto3);
		comboBox_Productos.addItem(Producto4);
		comboBox_Productos.addItem(Producto5);
		
		lblProductos_1 = new JLabel("Productos:");
		lblProductos_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductos_1.setBounds(431, 44, 115, 14);
		add(lblProductos_1);
		
		lblTicketFactura = new JLabel("Ticket o Factura");
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
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(293, 235, 139, 23);
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
		
		textPane_NTransaccion = new JTextPane();
		textPane_NTransaccion.setBounds(38, 70, 173, 20);
		add(textPane_NTransaccion);
		textPane_NTransaccion.setText(""+ controladorPanelTicketFactura.MostrarNumeroTransaccion());
		
		textPane_Local = new JTextPane();
		textPane_Local.setBounds(92, 126, 119, 20);
		add(textPane_Local);
		textPane_Local.setText(LocalP);
		
		
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
		textPane_Total.setEditable(false);
		textPane_Total.setBounds(343, 152, 63, 20);
		add(textPane_Total);
		textPane_Total.setText(ListaCompraTotal);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 177, 573, 47);
		add(scrollPane);
		
		textPane_Productos = new JTextPane();
		scrollPane.setViewportView(textPane_Productos);
		textPane_Productos.setText(ListaCompra);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTicketFactura));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelTicketFactura));
		this.btnPagar.addActionListener(listenerBotonPagar(this.controladorPanelTicketFactura));
		this.btnAadirAlCarro.addActionListener(listenerBotonAadirAlCarro(this.controladorPanelTicketFactura));
		this.btnBorrarLista.addActionListener(listenerBotonBorrarLista(this.controladorPanelTicketFactura));
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
				if (rdbtnTicket.isSelected() && !textPane_NTransaccion.getText().equals("") && !textPane_Fecha.getText().equals("") && !textPane_Local.getText().equals("") && !textPane_Total.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pagar");
					
					
					String textoTransaccion=textPane_NTransaccion.getText();
					int NTransaccion=Integer.parseInt(textoTransaccion);
					
					ConexionMySQL ConexionMySQLTicket = new ConexionMySQL();
					
					Ticket ticket1 = new Ticket();
					
					ticket1.setNTransaccion(NTransaccion);
					ticket1.setFecha(textPane_Fecha.getText());
					ticket1.setNif_local("B78107158");
					
					
					int PosicionArray = NTransaccion-1;
						
					  ticket.add(PosicionArray,new Ticket()); 
					  ticket.get(PosicionArray).setNTransaccion(NTransaccion);
					  ticket.get(PosicionArray).setFecha(textPane_Fecha.getText());
					  ticket.get(PosicionArray).setNif_local("B78107158");

					  System.out.println(ticket.get(PosicionArray).getNTransaccion());
					  System.out.println(ticket.get(PosicionArray).getFecha());
					  System.out.println(ticket.get(PosicionArray).getNif_local());
					
					
					Ticket tic = ConexionMySQLTicket.RegistrarTicket(ticket1);
					
					
					controladorPanelTicketFactura.accionadoBottonPagarPanelTicketFactura();	
				}else if (rdbtnFactura.isSelected() && !textPane_NTransaccion.getText().equals("") && !textPane_Fecha.getText().equals("") && !textPane_Local.getText().equals("") && !textPane_Total.getText().equals("") && !textPane_NIF.getText().equals("") && !textPane_Nombre.getText().equals("") && !textPane_Apellidos.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pagar");
					
					String textoTransacion=textPane_NTransaccion.getText();
					int NTransaccion=Integer.parseInt(textoTransacion);
					
					
					ConexionMySQL ConexionMySQLTicket = new ConexionMySQL();
					
					Factura factura1 = new Factura();
					Ticket ticket1 = new Ticket();
					Identificacion Identificacion1 = new Identificacion();
					
					
					factura1.setNTransaccion(NTransaccion);
					factura1.setNif("F32145634");
					ticket1.setFecha(textPane_Fecha.getText());
					ticket1.setNif_local("B78107158");
					Identificacion1.setNombre(textPane_Nombre.getText());
					Identificacion1.setApellido(textPane_Apellidos.getText());
					Identificacion1.setNif("F32145634");
					

					
					
					Ticket tic = ConexionMySQLTicket.RegistrarTicket(ticket1);
					Identificacion ide=ConexionMySQLTicket.RegistrarIdentificacion(Identificacion1);
					Factura fac = ConexionMySQLTicket.RegistrarFactura(factura1);
					
					 
					  

					
					
					
					controladorPanelTicketFactura.accionadoBottonPagarPanelTicketFactura();	
				}else {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos pertinentes.");
				}
			}
		};
	}
	
	private ActionListener listenerBotonBorrarLista(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Borrar");
				controladorPanelTicketFactura.accionadoBottonBorrarListaPanelTicketFactura();
			}
		};
	}
	
	private ActionListener listenerBotonAadirAlCarro(ControladorPanelTicketFactura controladorPanelTicketFactura) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir Al Carro");
				int Cantidad = Integer.parseInt(comboBox_Cantidad.getSelectedItem().toString());
				String Producto = (comboBox_Productos.getSelectedItem().toString());
				double PrecioVenta = (((Producto) comboBox_Productos.getSelectedItem()).PrecioVenta());
				double Total = PrecioVenta*Cantidad;
				
				PanelListaCompra.ListaCompra=PanelListaCompra.ListaCompra.concat(Producto+" - Cantidad: "+Cantidad+" - Precio: "+PrecioVenta+"€ - Total: "+Total+"€\n");
				PanelTicketFactura.ListaCompra=PanelTicketFactura.ListaCompra.concat(Producto+" - Cantidad: "+Cantidad+" - Precio: "+PrecioVenta+"€ - Total: "+Total+"€\n");
				
				Modelo.TotalProducto=Modelo.TotalProducto+Total;
				
				PanelListaCompra.ListaCompraTotal=PanelListaCompra.ListaCompraTotal.valueOf(Modelo.TotalProducto+"€");
				PanelTicketFactura.ListaCompraTotal=PanelTicketFactura.ListaCompraTotal.valueOf(Modelo.TotalProducto+"€");
				
				System.out.println("Has elegido "+Producto+" - Cantidad: "+Cantidad+" - Precio: "+PrecioVenta+"€ - Total: "+Total+"€");
				controladorPanelTicketFactura.accionadoBottonAadirAlCarroPanelTicketFactura();
				
			}
		};
	}
	
}
