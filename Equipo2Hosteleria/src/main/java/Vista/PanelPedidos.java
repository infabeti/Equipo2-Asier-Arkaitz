package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelPedidos;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelPedidos extends JPanel {

	private JButton btnVolver;
	private JLabel lblGeneros;
	private ControladorPanelPedidos controladorPanelPedidos;
	
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		lblGeneros = new JLabel("Pedidos");
		lblGeneros.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneros.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGeneros.setBounds(58, 35, 328, 14);
		add(lblGeneros);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 246, 89, 23);
		add(btnVolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(58, 95, 173, 22);
		add(comboBox);
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductos.setBounds(58, 60, 115, 14);
		add(lblProductos);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(271, 60, 115, 14);
		add(lblCantidad);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Recoger en establecimiento");
		rdbtnNewRadioButton.setBounds(58, 177, 173, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnEntregaADomicilio = new JRadioButton("Entrega a domicilio");
		rdbtnEntregaADomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnEntregaADomicilio.setBounds(247, 177, 139, 23);
		add(rdbtnEntregaADomicilio);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(213, 207, 173, 22);
		add(textPane_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(326, 95, 60, 22);
		add(comboBox_1);
		
		JButton btnAadirAlCarro = new JButton("A\u00F1adir al carro");
		btnAadirAlCarro.setBounds(58, 147, 173, 23);
		add(btnAadirAlCarro);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n de entrega:");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccin.setBounds(58, 207, 139, 23);
		add(lblDireccin);
		
		JButton btnVerListaDe = new JButton("Ver lista de la compra");
		btnVerListaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerListaDe.setBounds(247, 147, 139, 23);
		add(btnVerListaDe);
		
		JButton btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(170, 246, 103, 23);
		add(btnDesconectarse);
		
		JButton btnPasarACaja = new JButton("Pasar a caja");
		btnPasarACaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPasarACaja.setBounds(295, 246, 91, 23);
		add(btnPasarACaja);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPedidos));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPedidos.accionadoBottonVolverPanelGeneros();
			}
		};
	}
}
