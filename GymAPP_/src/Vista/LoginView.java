package Vista;

import Dades.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUser;
	private JPasswordField passwordField;
	ClientsSQL conector = new ClientsSQL();
	
	/* Main
	public static void main(String[] args) {
		try {
			LoginView dialog = new LoginView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */

	public LoginView() {
		setBounds(100, 100, 304, 164);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Cajas texto Login
		textUser = new JTextField();
		textUser.setBounds(138, 22, 114, 19);
		contentPanel.add(textUser);
		textUser.setColumns(10);
		
		//NOMBRE  CAMPO 
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(37, 24, 83, 15);
		contentPanel.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(37, 54, 83, 15);
		contentPanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 53, 114, 19);
		contentPanel.add(passwordField);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							System.out.println("1 " + textUser.getText().toString());
							System.out.println("2 " + passwordField.getText().toString());
							
							Client cli = new Client("77749301d","1234");
							
							conector.buscaDniClients(cli)
							
							
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
