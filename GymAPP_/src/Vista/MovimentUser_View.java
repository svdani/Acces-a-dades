package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.Font;

public class MovimentUser_View extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovimentUser_View dialog = new MovimentUser_View();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public MovimentUser_View() {
		setBounds(100, 100, 552, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 346, 252);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Moviment", "Gimnas", "Data", "Tipus"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Desde:");
		label.setBounds(370, 27, 70, 15);
		contentPanel.add(label);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(380, 51, 153, 19);
		contentPanel.add(dateChooser);
		
		JLabel label_1 = new JLabel("Hasta:");
		label_1.setBounds(370, 96, 70, 15);
		contentPanel.add(label_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(380, 124, 153, 19);
		contentPanel.add(dateChooser_1);
		
		JLabel lblTiempoEstancia = new JLabel("Tiempo Estancia");
		lblTiempoEstancia.setBounds(376, 188, 137, 15);
		contentPanel.add(lblTiempoEstancia);
		
		JLabel lblTime = new JLabel("15, 30");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTime.setBounds(386, 215, 70, 15);
		contentPanel.add(lblTime);
		{
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
