package Vista;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;

public class Ent_SorView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textClient;
	private JTextField textGimnas;
	private JTextField textData;

	
	public static void main(String[] args) {
		try {
			
			Ent_SorView dialog = new Ent_SorView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Ent_SorView() {
		setBounds(100, 100, 625, 445);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 365, 306);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Moviment", "Gimnas", "Client", "Data", "Tipus"
			}
		));
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 742, 21);
		contentPanel.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmClients = new JMenuItem("Clients");
		mnMenu.add(mntmClients);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(387, 28, 70, 15);
		contentPanel.add(lblDesde);
		
		JLabel lblNewLabel = new JLabel("Hasta:");
		lblNewLabel.setBounds(387, 97, 70, 15);
		contentPanel.add(lblNewLabel);
		
		textClient = new JTextField();
		textClient.setColumns(10);
		textClient.setBounds(451, 209, 114, 19);
		contentPanel.add(textClient);
		
		textGimnas = new JTextField();
		textGimnas.setColumns(10);
		textGimnas.setBounds(451, 178, 114, 19);
		contentPanel.add(textGimnas);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(451, 240, 114, 19);
		contentPanel.add(textData);
		
		JDateChooser dateDesde = new JDateChooser();
		dateDesde.setBounds(397, 52, 153, 19);
		contentPanel.add(dateDesde);
		
		JDateChooser dateHasta = new JDateChooser();
		dateHasta.setBounds(397, 125, 153, 19);
		contentPanel.add(dateHasta);
		
		JLabel lblGimnas = new JLabel("Gimnas");
		lblGimnas.setBounds(387, 180, 70, 15);
		contentPanel.add(lblGimnas);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(387, 209, 70, 15);
		contentPanel.add(lblClient);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(387, 240, 70, 15);
		contentPanel.add(lblData);
		
		JLabel lblTipus = new JLabel("Tipus");
		lblTipus.setBounds(387, 271, 70, 15);
		contentPanel.add(lblTipus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entrada", "Sortida"}));
		comboBox.setBounds(451, 271, 92, 24);
		contentPanel.add(comboBox);
		
		
		
		{//Panel botones bajo
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNuevo = new JButton("Nuevo");
			btnNuevo.setActionCommand("OK");
			buttonPane.add(btnNuevo);
			
			JButton btnInserta = new JButton("Inserta");
			btnInserta.setActionCommand("OK");
			buttonPane.add(btnInserta);
			
			JButton btnModifica = new JButton("Modifica");
			btnModifica.setActionCommand("OK");
			buttonPane.add(btnModifica);
			{
				JButton okButton = new JButton("Elimina");
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
