package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class AdminView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDni;
	private JTextField txtNom;
	private JTextField txtCognoms;
	private JTextField txtTelf;
	private JTextField txtAdrea;
	private JTextField txtCorreu;
	private JTextField txtPassword;
	private JTextField textField;
	private JTable table;

	
	public static void main(String[] args) {
		try {
			AdminView dialog = new AdminView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AdminView() {
		
		setBounds(100, 100, 799, 542);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//NOMBRE CAJAS 
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(22, 410, 42, 15);
		contentPanel.add(lblDni);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(22, 445, 42, 15);
		contentPanel.add(lblNom);
		
		JLabel lblCognoms = new JLabel("Cognoms");
		lblCognoms.setBounds(165, 410, 70, 15);
		contentPanel.add(lblCognoms);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(165, 445, 70, 15);
		contentPanel.add(lblPassword);
		
		JLabel lblAdrea = new JLabel("Adreça");
		lblAdrea.setBounds(362, 410, 70, 15);
		contentPanel.add(lblAdrea);
		
		JLabel lblCorreu = new JLabel("Correu");
		lblCorreu.setBounds(362, 445, 70, 15);
		contentPanel.add(lblCorreu);
		
		JLabel lblRol = new JLabel("Rol\n");
		lblRol.setBounds(557, 445, 36, 15);
		contentPanel.add(lblRol);
		
		JLabel lblTelf = new JLabel("Telf");
		lblTelf.setBounds(557, 410, 42, 15);
		contentPanel.add(lblTelf);
		
		//CHECK DEUTOR
		JCheckBox chckbxDeutor = new JCheckBox("Deutor");
		chckbxDeutor.setBounds(697, 445, 94, 23);
		contentPanel.add(chckbxDeutor);
		
		//COMOBOX CLIENTE O ADMIN
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Client", "Admin"}));
		comboBox.setBounds(599, 445, 75, 24);
		contentPanel.add(comboBox);
		
		//CONTENIDO CAJAS 
		txtDni = new JTextField();
		txtDni.setBounds(57, 410, 95, 19);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(57, 445, 95, 19);
		contentPanel.add(txtNom);
		
		txtCognoms = new JTextField();
		txtCognoms.setColumns(10);
		txtCognoms.setBounds(242, 410, 100, 19);
		contentPanel.add(txtCognoms);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(242, 445, 103, 19);
		contentPanel.add(txtPassword);
		
		txtAdrea = new JTextField();
		txtAdrea.setColumns(10);
		txtAdrea.setBounds(422, 410, 114, 19);
		contentPanel.add(txtAdrea);
		
		txtCorreu = new JTextField();
		txtCorreu.setColumns(10);
		txtCorreu.setBounds(422, 445, 114, 19);
		contentPanel.add(txtCorreu);
		
		txtTelf = new JTextField();
		txtTelf.setColumns(10);
		txtTelf.setBounds(599, 410, 100, 19);
		contentPanel.add(txtTelf);
		

		//Creacion de panel para la tabla
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 32, 626, 349);
		contentPanel.add(scrollPane);
		
		//Crea tabla
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		//Botones accion en tabla
		
		textField = new JTextField();
		textField.setBounds(664, 46, 114, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(661, 77, 117, 25);
		contentPanel.add(btnNewButton);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBounds(662, 277, 117, 25);
		contentPanel.add(btnModifica);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setBounds(662, 314, 117, 25);
		contentPanel.add(btnElimina);
		
		JButton btnInserta = new JButton("Inserta\n");
		btnInserta.setBounds(661, 351, 117, 25);
		contentPanel.add(btnInserta);
		
		
		//Botones filtro
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(664, 124, 117, 25);
		contentPanel.add(btnFiltrar);
		
		//radioButton
		
		JRadioButton rdbtnDeutor = new JRadioButton("Deutor");
		rdbtnDeutor.setBounds(686, 158, 81, 23);
		contentPanel.add(rdbtnDeutor);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(686, 191, 81, 23);
		contentPanel.add(rdbtnAdmin);
		
		JRadioButton rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.setBounds(686, 226, 81, 23);
		contentPanel.add(rdbtnTodos);
		

	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnDeutor);
	    group.add(rdbtnAdmin);
	    group.add(rdbtnTodos);
		
		
		
		{ //PANEL INFERIOR CONTIENE BOTTON OK & CANCELAR
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
