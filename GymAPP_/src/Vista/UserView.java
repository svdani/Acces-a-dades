package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	
	public static void main(String[] args) {
		try {
			UserView dialog = new UserView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserView() {
		setBounds(100, 100, 418, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		//Scroll Panel para tabla 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 59, 230, 57);
		contentPanel.add(scrollPane);
		
		//Crea Tabla
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Gimnas", "Moviment", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
		//Botones
		JButton btnFichar = new JButton("Fichar ");
		btnFichar.setBounds(264, 42, 131, 25);
		contentPanel.add(btnFichar);
		
		JLabel lblUltimRegistre = new JLabel("Ultim Registre");
		lblUltimRegistre.setBounds(22, 32, 230, 15);
		contentPanel.add(lblUltimRegistre);
		
		JButton btnVerRegistros = new JButton("Pagar");
		btnVerRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnVerRegistros.setBounds(264, 88, 131, 25);
		contentPanel.add(btnVerRegistros);
		
		{//PANEL INFERIOR CONTIENE BOTTON OK & CANCELAR
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ver Registros");
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
