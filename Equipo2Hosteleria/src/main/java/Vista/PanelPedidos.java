package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controlador.ControladorPanelPedidos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.time.LocalDate;
import javax.swing.JTable;

@SuppressWarnings({ "rawtypes", "unchecked" , "serial" , "deprecation"})
public class PanelPedidos extends JPanel implements ChangeListener {

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private JButton btnPasarACaja;
	private JButton btnAadirAlCarro;
	private JButton btnBorrarLista;
	private JComboBox comboBox_Productos;
	private JComboBox comboBox_Cantidad;
	private JLabel lblDireccin;
	private JRadioButton rdbtnRecogerEnEstablecimiento;
	private JRadioButton rdbtnEntregaADomicilio;
	private ButtonGroup grupoBotones;
	private JTextField textField_Direccion;
	private JTextField textField_Fecha;
	private JTextField textField_Local;
	private JTextPane textPane_Total;
	private JScrollPane scrollPane;
	private JTable table;
	private ControladorPanelPedidos controladorPanelPedidos;
	
	static String LocalP="Freddy Fazbear's Pizza";
	public static int ControlarCaja=0;
	public static String ListaCompraTotal="";
	private String tipo;
	LocalDate date = LocalDate.now();
	String fecha = date.toString();
	
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		setBackground(new Color(102, 153, 255));
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPedidos.setBounds(38, 24, 555, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(30, 396, 89, 23);
		add(btnVolver);
		
		comboBox_Productos = new JComboBox();
		comboBox_Productos.setBounds(38, 111, 173, 23);
		add(comboBox_Productos);
		
		String arrayNombresProducto[] = controladorPanelPedidos.obtenerNombresProductos();
		for(int i = 0;i<arrayNombresProducto.length;i++)
		{
			comboBox_Productos.addItem(arrayNombresProducto[i]);
		}
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductos.setBounds(38, 80, 173, 23);
		add(lblProductos);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(243, 80, 157, 23);
		add(lblCantidad);
		
		grupoBotones = new ButtonGroup();
		
		rdbtnRecogerEnEstablecimiento = new JRadioButton("Recoger en establecimiento");
		rdbtnRecogerEnEstablecimiento.setBounds(38, 155, 189, 23);
		rdbtnRecogerEnEstablecimiento.addChangeListener(this);
		add(rdbtnRecogerEnEstablecimiento);
		grupoBotones.add(rdbtnRecogerEnEstablecimiento);
		
		rdbtnEntregaADomicilio = new JRadioButton("Entrega a domicilio");
		rdbtnEntregaADomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnEntregaADomicilio.setBounds(263, 155, 137, 23);
		rdbtnEntregaADomicilio.addChangeListener(this);
		add(rdbtnEntregaADomicilio);
		grupoBotones.add(rdbtnEntregaADomicilio);
		
		textField_Direccion = new JTextField();
		textField_Direccion.setEnabled(false);
		textField_Direccion.setBounds(211, 198, 189, 20);
		add(textField_Direccion);
		
		comboBox_Cantidad = new JComboBox();
		comboBox_Cantidad.setBounds(340, 111, 60, 23);
		add(comboBox_Cantidad);
		
		int numbers_to_add_max = 99;
		for (int i = 1; i <= numbers_to_add_max; i++) {
			comboBox_Cantidad.addItem(new Integer(i));
		}
		
		btnAadirAlCarro = new JButton("A\u00F1adir al carro");
		btnAadirAlCarro.setBounds(447, 80, 146, 23);
		add(btnAadirAlCarro);
		
		lblDireccin = new JLabel("Direcci\u00F3n de entrega:");
		lblDireccin.setEnabled(false);
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccin.setBounds(38, 198, 157, 20);
		add(lblDireccin);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(149, 396, 146, 23);
		add(btnDesconectarse);
		
		btnPasarACaja = new JButton("Pagar");
		btnPasarACaja.setEnabled(false);
		btnPasarACaja.setBounds(325, 396, 89, 23);
		add(btnPasarACaja);
		
		JTextField textField_NTransaccion = new JTextField();
		textField_NTransaccion.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_NTransaccion.setText(""+ controladorPanelPedidos.mostrarNumeroTransaccion());
		textField_NTransaccion.setEditable(false);
		textField_NTransaccion.setBounds(420, 136, 173, 20);
		add(textField_NTransaccion);
		
		JLabel lblTransaccion = new JLabel("N\u00BA Transaccion:");
		lblTransaccion.setBounds(420, 114, 89, 20);
		add(lblTransaccion);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(420, 167, 62, 20);
		add(lblFecha);
		
		textField_Fecha = new JTextField();
		textField_Fecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_Fecha.setEditable(false);
		textField_Fecha.setText(fecha);
		textField_Fecha.setBounds(462, 167, 131, 20);
		add(textField_Fecha);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(420, 198, 51, 20);
		add(lblLocal);
		
		textField_Local = new JTextField();
		textField_Local.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_Local.setEditable(false);
		textField_Local.setText(LocalP);
		textField_Local.setBounds(462, 198, 131, 20);
		add(textField_Local);
		
		btnBorrarLista = new JButton("Borrar lista");
		btnBorrarLista.setBounds(444, 396, 146, 23);
		add(btnBorrarLista);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(490, 234, 45, 20);
		add(lblTotal);
		
		JLabel lblProductos_1 = new JLabel("Productos:");
		lblProductos_1.setBounds(30, 234, 89, 19);
		add(lblProductos_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 265, 563, 107);
		add(scrollPane);
		
		textPane_Total = new JTextPane();
		textPane_Total.setEditable(false);
		textPane_Total.setBounds(530, 234, 63, 20);
		add(textPane_Total);
		textPane_Total.setText(""+ListaCompraTotal);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
		new String[] {	"Producto", "Cantidad", "Precio", "Total"	}));
		scrollPane.setViewportView(table);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPedidos));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelPedidos));
		this.btnPasarACaja.addActionListener(listenerBotonPasarACaja(this.controladorPanelPedidos));
		this.btnAadirAlCarro.addActionListener(listenerBotonAadirAlCarro(this.controladorPanelPedidos));
		this.btnBorrarLista.addActionListener(listenerBotonBorrarLista(this.controladorPanelPedidos));
		this.borrarListaCompra();
	}
	
	public void stateChanged(ChangeEvent e){
		if (rdbtnRecogerEnEstablecimiento.isSelected()) {
			lblDireccin.setEnabled(false);
			textField_Direccion.setEnabled(false);
			btnPasarACaja.setEnabled(true);
			tipo="RECOGIDA";
		}else if (rdbtnEntregaADomicilio.isSelected()) {
			lblDireccin.setEnabled(true);
			textField_Direccion.setEnabled(true);
			btnPasarACaja.setEnabled(true);
			tipo="ENTREGA";
		}
	}
	
	public void generarListaCompra(){
		DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
		int rowCount = modeloTabla.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
		Object lista[][] = controladorPanelPedidos.obtenerListaCompra();
		for(int i = 0;i<lista.length;i++)
		{
			Object temp[] = { lista[i][0], lista[i][1], lista[i][2], lista[i][3] };
			modeloTabla.addRow(temp);
		}
		ListaCompraTotal = ""+controladorPanelPedidos.obtenerTotalCarro();
		textPane_Total.setText(""+ListaCompraTotal);
	}
	
	public void borrarListaCompra(){
		controladorPanelPedidos.accionadoBottonBorrarListaPanelPedidos();
		ControlarCaja=0;
		DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
		int rowCount = modeloTabla.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
		ListaCompraTotal = ""+controladorPanelPedidos.obtenerTotalCarro();
		textPane_Total.setText(""+ListaCompraTotal);
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
				String domicilio=textField_Direccion.getText();
				if(ControlarCaja==0) {
					JOptionPane.showMessageDialog(null, "Añade productos.");
				}else if (rdbtnEntregaADomicilio.isSelected() && !textField_Direccion.getText().equals("") && !textField_Fecha.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pasar A Caja");
					ControlarCaja=0;
					controladorPanelPedidos.accionadoBottonPasarACajaPanelPedidos(tipo, domicilio);
				}else if (rdbtnRecogerEnEstablecimiento.isSelected() && !textField_Fecha.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pasar A Caja");
					ControlarCaja=0;
					controladorPanelPedidos.accionadoBottonPasarACajaPanelPedidos(tipo, null);
				}else {
					JOptionPane.showMessageDialog(null,"Rellene todos los campos pertinentes.");
				}
			}
		};
	}
	
	private ActionListener listenerBotonBorrarLista(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Borrar");
				borrarListaCompra();
			}
		};
	}
	
	private ActionListener listenerBotonAadirAlCarro(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir Al Carro");
				int cantidad = Integer.parseInt(comboBox_Cantidad.getSelectedItem().toString());
				String nomProducto = (comboBox_Productos.getSelectedItem().toString());
				controladorPanelPedidos.accionadoBottonAadirAlCarroPanelPedidos(nomProducto, cantidad);
				ControlarCaja=1;
				generarListaCompra();
			}
		};
	}
}