package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controlador.ControladorPanelPedidos;
import Modelo.Producto;
import Modelo.Ticket;
import Modelo.ConexionMySQL;
import Modelo.Incluye;
import Modelo.Modelo;
import Modelo.Pedido;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelPedidos extends JPanel implements ChangeListener {

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JButton btnPasarACaja;
	private JButton btnAadirAlCarro;
	private JButton btnListaCompra;
	private JComboBox comboBox_Productos;
	private JComboBox comboBox_Cantidad;
	private JLabel lblDireccin;
	private JRadioButton rdbtnRecogerEnEstablecimiento;
	private JRadioButton rdbtnEntregaADomicilio;
	private ButtonGroup grupoBotones;
	private JTextPane textPane_Direccion;
	private ControladorPanelPedidos controladorPanelPedidos;
	private JLabel lblLocal;
	private JTextPane textPane_Local;
	private JTextPane textPane_Fecha;
	private JTextPane textPane_NTransaccion;
	
	public static int ControlarCaja=0;
	
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		setBackground(new Color(102, 153, 255));
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPedidos.setBounds(129, 24, 362, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		
		comboBox_Productos = new JComboBox();
		comboBox_Productos.setBounds(38, 84, 173, 22);
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
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductos.setBounds(38, 49, 115, 14);
		add(lblProductos);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(285, 49, 115, 14);
		add(lblCantidad);
		
		grupoBotones = new ButtonGroup();
		
		rdbtnRecogerEnEstablecimiento = new JRadioButton("RECOGIDA");
		rdbtnRecogerEnEstablecimiento.setBounds(38, 166, 189, 23);
		rdbtnRecogerEnEstablecimiento.addChangeListener(this);
		add(rdbtnRecogerEnEstablecimiento);
		grupoBotones.add(rdbtnRecogerEnEstablecimiento);
		
		rdbtnEntregaADomicilio = new JRadioButton("ENTREGA");
		rdbtnEntregaADomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnEntregaADomicilio.setBounds(263, 166, 137, 23);
		rdbtnEntregaADomicilio.addChangeListener(this);
		add(rdbtnEntregaADomicilio);
		grupoBotones.add(rdbtnEntregaADomicilio);
		
		textPane_Direccion = new JTextPane();
		textPane_Direccion.setEnabled(false);
		textPane_Direccion.setBounds(211, 196, 189, 22);
		add(textPane_Direccion);
		
		comboBox_Cantidad = new JComboBox();
		comboBox_Cantidad.setBounds(340, 84, 60, 22);
		add(comboBox_Cantidad);
		
		int numbers_to_add_max = 99;
		for (int i = 1; i <= numbers_to_add_max; i++) {
			comboBox_Cantidad.addItem(new Integer(i));
		}
		
		btnAadirAlCarro = new JButton("A\u00F1adir al carro");
		btnAadirAlCarro.setBounds(38, 136, 146, 23);
		add(btnAadirAlCarro);
		
		lblDireccin = new JLabel("Direcci\u00F3n de entrega:");
		lblDireccin.setEnabled(false);
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccin.setBounds(38, 196, 157, 23);
		add(lblDireccin);
		
		btnListaCompra = new JButton("Ver lista de la compra");
		btnListaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListaCompra.setBounds(227, 136, 173, 23);
		add(btnListaCompra);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(137, 235, 146, 23);
		add(btnDesconectarse);
		
		btnPasarACaja = new JButton("Pasar a caja");
		btnPasarACaja.setEnabled(false);
		btnPasarACaja.setBounds(293, 235, 107, 23);
		add(btnPasarACaja);
		
		textPane_NTransaccion = new JTextPane();
		textPane_NTransaccion.setText(""+ controladorPanelPedidos.MostrarNumeroTransaccion());
		textPane_NTransaccion.setEditable(false);
		textPane_NTransaccion.setBounds(420, 136, 173, 20);
		add(textPane_NTransaccion);
		
		JLabel lblTransaccion = new JLabel("N\u00BA Transaccion:");
		lblTransaccion.setBounds(420, 114, 89, 20);
		add(lblTransaccion);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(420, 167, 62, 20);
		add(lblFecha);
		
		textPane_Fecha = new JTextPane();
		textPane_Fecha.setBounds(474, 167, 119, 20);
		add(textPane_Fecha);
		
		lblLocal = new JLabel("Local:");
		lblLocal.setBounds(420, 198, 51, 20);
		add(lblLocal);
		
		textPane_Local = new JTextPane();
		textPane_Local.setEditable(false);
		textPane_Local.setText("El plato caliente");
		textPane_Local.setBounds(474, 198, 119, 20);
		add(textPane_Local);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPedidos));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelPedidos));
		this.btnPasarACaja.addActionListener(listenerBotonPasarACaja(this.controladorPanelPedidos));
		this.btnAadirAlCarro.addActionListener(listenerBotonAadirAlCarro(this.controladorPanelPedidos));
		this.btnListaCompra.addActionListener(listenerBotonListaCompra(this.controladorPanelPedidos));
	}
	
	public void stateChanged(ChangeEvent e){
        
		if (rdbtnRecogerEnEstablecimiento.isSelected()) {
			lblDireccin.setEnabled(false);
			textPane_Direccion.setEnabled(false);
			btnPasarACaja.setEnabled(true);
		}
		if (rdbtnEntregaADomicilio.isSelected()) {
			lblDireccin.setEnabled(true);
			textPane_Direccion.setEnabled(true);
			btnPasarACaja.setEnabled(true);
		}
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				ControlarCaja=0;
				controladorPanelPedidos.accionadoBottonVolverPanelPedidos();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				ControlarCaja=0;
				controladorPanelPedidos.accionadoBottonDesconectarsePanelPedidos();
			}
		};
	}
	
	private ActionListener listenerBotonPasarACaja(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ControlarCaja==0) {
					JOptionPane.showMessageDialog(null, "Añade productos.");
				}else if (rdbtnEntregaADomicilio.isSelected() && !textPane_Direccion.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pasar A Caja");
					ControlarCaja=0;
					
					String textoTransacion=textPane_NTransaccion.getText();
					int NTransaccion=Integer.parseInt(textoTransacion);
					
					ConexionMySQL ConexionMySQLTicket = new ConexionMySQL();
					
					Pedido pedido1 = new Pedido();
					Ticket ticket1 = new Ticket();
					Incluye incluye1 = new Incluye();
					
					pedido1.setNTransaccion(NTransaccion);
					pedido1.setTipo(rdbtnEntregaADomicilio.getText());
					pedido1.setDomicilio(textPane_Direccion.getText());

					ticket1.setNTransaccion(NTransaccion);
					ticket1.setFecha(textPane_Fecha.getText());
					ticket1.setNif_local("B78107158");
					
					String Producto = (comboBox_Productos.getSelectedItem().toString());
					int Cantidad = Integer.parseInt(comboBox_Cantidad.getSelectedItem().toString());
					double PrecioVenta = (((Producto) comboBox_Productos.getSelectedItem()).PrecioVenta());
					double PrecioCompra = (((Producto) comboBox_Productos.getSelectedItem()).PrecioCompra());
					
					incluye1.setNombreProducto(Producto);
					incluye1.setNTransaccion(NTransaccion);
					incluye1.setCantidad(Cantidad);
					incluye1.setPrecioVenta(PrecioVenta);
					incluye1.setPrecioCompra(PrecioCompra);
					
					Ticket tic = ConexionMySQLTicket.RegistrarTicket(ticket1);				
					Pedido pedi = ConexionMySQLTicket.RegistrarPedido(pedido1);	
					Incluye incl = ConexionMySQLTicket.RegistrarIncluye(incluye1);
					
					controladorPanelPedidos.accionadoBottonPasarACajaPanelPedidos();
				}else if (rdbtnRecogerEnEstablecimiento.isSelected()) {
					System.out.println("Ejecutando evento Boton Pasar A Caja");
					ControlarCaja=0;
					
					String textoTransacion=textPane_NTransaccion.getText();
					int NTransaccion=Integer.parseInt(textoTransacion);
					
					ConexionMySQL ConexionMySQLTicket = new ConexionMySQL();
					
					Pedido pedido2 = new Pedido();
					Ticket ticket2 = new Ticket();
					Incluye incluye2 = new Incluye();
					
					pedido2.setNTransaccion(NTransaccion);
					pedido2.setTipo(rdbtnRecogerEnEstablecimiento.getText());
					pedido2.setDomicilio(null);
					
					ticket2.setNTransaccion(NTransaccion);
					ticket2.setFecha(textPane_Fecha.getText());
					ticket2.setNif_local("B78107158");
					
					String Producto = (comboBox_Productos.getSelectedItem().toString());
					int Cantidad = Integer.parseInt(comboBox_Cantidad.getSelectedItem().toString());
					double PrecioVenta = (((Producto) comboBox_Productos.getSelectedItem()).PrecioVenta());
					double PrecioCompra = (((Producto) comboBox_Productos.getSelectedItem()).getPrecioCompra());
					
					incluye2.setNombreProducto(Producto);
					incluye2.setNTransaccion(NTransaccion);
					incluye2.setCantidad(Cantidad);
					incluye2.setPrecioVenta(PrecioVenta);
					incluye2.setPrecioCompra(PrecioCompra);
					
					System.out.println(PrecioVenta);
					System.out.println(PrecioCompra);
					
					Ticket tic = ConexionMySQLTicket.RegistrarTicket(ticket2);
					Pedido pedi = ConexionMySQLTicket.RegistrarPedido(pedido2);
					Incluye incl = ConexionMySQLTicket.RegistrarIncluye(incluye2);
										
					controladorPanelPedidos.accionadoBottonPasarACajaPanelPedidos();
				}else {
					JOptionPane.showMessageDialog(null,"Añade una dirección.");
				}
			}
		};
	}
	
	private ActionListener listenerBotonAadirAlCarro(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir Al Carro");
				controladorPanelPedidos.accionadoBottonAadirAlCarroPanelPedidos();
				int Cantidad = Integer.parseInt(comboBox_Cantidad.getSelectedItem().toString());
				String Producto = (comboBox_Productos.getSelectedItem().toString());
				double PrecioVenta = (((Producto) comboBox_Productos.getSelectedItem()).PrecioVenta());
				double PrecioCompra = (((Producto) comboBox_Productos.getSelectedItem()).PrecioCompra());
				double Total = PrecioVenta*Cantidad;
				
				ControlarCaja=1;
				
				PanelListaCompra.ListaCompra=PanelListaCompra.ListaCompra.concat(Producto+" - Cantidad: "+Cantidad+" - Precio: "+PrecioVenta+"€ - Total: "+Total+"€\n");
				PanelTicketFactura.ListaCompra=PanelTicketFactura.ListaCompra.concat(Producto+" - Cantidad: "+Cantidad+" - Precio: "+PrecioVenta+"€ - Total: "+Total+"€\n");
				
				Modelo.TotalProducto=Modelo.TotalProducto+Total;
				
				PanelListaCompra.ListaCompraTotal=PanelListaCompra.ListaCompraTotal.valueOf(Modelo.TotalProducto+"€");
				PanelTicketFactura.ListaCompraTotal=PanelTicketFactura.ListaCompraTotal.valueOf(Modelo.TotalProducto+"€");
				
				System.out.println("Has elegido "+Producto+" - Cantidad: "+Cantidad+" - Precio: "+PrecioVenta+"€ - Total: "+Total+"€");
		
				
			}
		};
	}
	
	private ActionListener listenerBotonListaCompra(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Ver Lista De La Compra");
				controladorPanelPedidos.accionadoBottonListaCompraPanelPedidos();
			}
		};
	}
}
