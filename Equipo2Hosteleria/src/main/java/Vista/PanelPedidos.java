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
	private JPanel contentPane;
	private JRadioButton rdbtnRecogerEnEstablecimiento;
	private JRadioButton rdbtnEntregaADomicilio;
	private ButtonGroup grupoBotones;
	private JTextPane textPane_Direccion;
	private ControladorPanelPedidos controladorPanelPedidos;
	
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPedidos.setBounds(38, 24, 362, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 235, 89, 23);
		add(btnVolver);
		
		comboBox_Productos = new JComboBox();
		comboBox_Productos.setBounds(38, 84, 173, 22);
		add(comboBox_Productos);
		
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
		
		rdbtnRecogerEnEstablecimiento = new JRadioButton("Recoger en establecimiento");
		rdbtnRecogerEnEstablecimiento.setBounds(38, 166, 197, 23);
		rdbtnRecogerEnEstablecimiento.addChangeListener(this);
		add(rdbtnRecogerEnEstablecimiento);
		grupoBotones.add(rdbtnRecogerEnEstablecimiento);
		
		rdbtnEntregaADomicilio = new JRadioButton("Entrega a domicilio");
		rdbtnEntregaADomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnEntregaADomicilio.setBounds(254, 166, 146, 23);
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
				controladorPanelPedidos.accionadoBottonVolverPanelPedidos();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelPedidos.accionadoBottonDesconectarsePanelPedidos();
			}
		};
	}
	
	private ActionListener listenerBotonPasarACaja(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new JPanel();
				contentPane.setBackground(new Color(0, 153, 255));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				if (rdbtnEntregaADomicilio.isSelected() && !textPane_Direccion.getText().equals("")) {
					System.out.println("Ejecutando evento Boton Pasar A Caja");
					controladorPanelPedidos.accionadoBottonPasarACajaPanelPedidos();
				}else if (rdbtnRecogerEnEstablecimiento.isSelected()) {
					System.out.println("Ejecutando evento Boton Pasar A Caja");
					controladorPanelPedidos.accionadoBottonPasarACajaPanelPedidos();
				}else {
					JOptionPane.showMessageDialog(contentPane,"Añade una dirección.");
				}
			}

			private void setContentPane(JPanel contentPane) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	private ActionListener listenerBotonAadirAlCarro(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir Al Carro");
				controladorPanelPedidos.accionadoBottonAadirAlCarroPanelPedidos();
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
