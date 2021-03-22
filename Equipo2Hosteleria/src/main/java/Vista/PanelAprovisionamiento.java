package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelAprovisionamiento;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class PanelAprovisionamiento extends JPanel{

	private JButton btnVolver;
	private JButton btnDesconectarse;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_6;
	
	public PanelAprovisionamiento(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		setBackground(new Color(102, 153, 255));
		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;
		setLayout(null);
		
		JLabel lblAprovisionamiento = new JLabel("Aprovisionamiento");
		lblAprovisionamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAprovisionamiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAprovisionamiento.setBounds(129, 24, 362, 23);
		add(lblAprovisionamiento);
		
		btnDesconectarse = new JButton("Desconectarse");
		btnDesconectarse.setBounds(139, 366, 146, 23);
		add(btnDesconectarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(40, 366, 89, 23);
		add(btnVolver);
		
		textField = new JTextField();
		textField.setBounds(74, 76, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Pedido:");
		lblNewLabel.setBounds(20, 78, 51, 14);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 107, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setBounds(38, 110, 33, 14);
		add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(74, 138, 86, 20);
		add(textField_2);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(40, 138, 28, 20);
		add(lblLocal);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(336, 366, 89, 23);
		add(btnPagar);
		
		JLabel lblProductos_1 = new JLabel("Productos:");
		lblProductos_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductos_1.setBounds(196, 58, 170, 22);
		add(lblProductos_1);
		
		JComboBox comboBox_Productos = new JComboBox();
		comboBox_Productos.setBounds(196, 89, 173, 22);
		add(comboBox_Productos);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(196, 119, 102, 22);
		add(lblCantidad);
		
		JComboBox comboBox_Cantidad = new JComboBox();
		comboBox_Cantidad.setBounds(479, 106, 60, 22);
		add(comboBox_Cantidad);
		
		JButton btnAadirAlCarro = new JButton("A\u00F1adir al carro");
		btnAadirAlCarro.setBounds(412, 137, 172, 23);
		add(btnAadirAlCarro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 169, 574, 147);
		add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("Producto\r\n");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Producto", "Cantidad", "Precio", "Total"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(494, 328, 45, 19);
		add(lblTotal);
		
		textField_6 = new JTextField();
		textField_6.setText("0.0");
		textField_6.setEditable(false);
		textField_6.setBounds(531, 327, 63, 20);
		add(textField_6);
		
		JButton btnBorrarLista = new JButton("Borrar lista");
		btnBorrarLista.setBounds(435, 366, 146, 23);
		add(btnBorrarLista);
		

		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAprovisionamiento));
		this.btnDesconectarse.addActionListener(listenerBotonDesconectarse(this.controladorPanelAprovisionamiento));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAprovisionamiento.accionadoBottonVolverPanelAprovisionamiento();
			}
		};
	}
	
	private ActionListener listenerBotonDesconectarse(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectarse");
				controladorPanelAprovisionamiento.accionadoBottonDesconectarsePanelAprovisionamiento();
			}
		};
	}
}
