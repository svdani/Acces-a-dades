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

import Dades.ClientsSQL;
import Dades.E_SSQL;
import Model.Client;
import Model.E_S;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class UserView extends JDialog {
	
	private static DefaultTableModel model;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	static Client cli;
	static E_SSQL conE_S = new E_SSQL();
	static ClientsSQL conCli = new ClientsSQL();
	
	public UserView(Client cli) {
		
		this.cli = cli;
		
		setBounds(100, 100, 559, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		//Scroll Panel para tabla 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 59, 352, 65);
		contentPanel.add(scrollPane);
		
		//----CREA TAULA MOVIMENT USUARI
		table = new JTable();
		
		//----IMPIDE EDITAR LAS CASILLAS		
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row,int column) {
				//Todas las celdas en false
				return false;
			}
		};
		
		//----INTRODUCE NOMBRE COLUMNAS TABLA DESDE SQL
			
		model.addColumn("Data");
		model.addColumn("Gimnas");
		model.addColumn("Entrada o salida");
				
		table.setModel(model);
		
		//---FUNCIONES TABLA 
		updateTable();
		
		scrollPane.setViewportView(table);
		
		
		//TITULO
		titelText();
		//BOTONES
		btnFichar();
		btnPagar();

		
		panelInferior();
		
		
	}//------------------------------------------------------------UserView()-------------------------------------------------------------------
	
	
	//-------------------------------------------------------------FUNCIONES TABLA 
	public static void updateTable(){ //---Informacion tablas
		
		try {
			
			
			model.setRowCount(0);
								
			//----RELLENA TABLA
			for (E_S e_s:conE_S.consultaUltimMovimentClient(cli)) {
				model.addRow(new Object[] {
					e_s.getData(),
					e_s.getGimnas(),
					e_s.getTipus()
				});	
			}			
			
		} catch (Exception e) {
			
		}
		
		
	}//updateTable()--------	
	
	
	public void titelText() {
		
		//TITULO ULTIMO REGISTRO
		JLabel lblUltimRegistre = new JLabel("Ultim Registre");
		lblUltimRegistre.setBounds(22, 32, 230, 15);
		contentPanel.add(lblUltimRegistre);
	}
	
	//-------------------------------------------------------------BOTONES
	
	public void btnFichar() {
		JButton btnFichar = new JButton("Fichar ");
		btnFichar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					
				} catch (Exception e) {
					System.out.println("Error al fichar ");
				}
			}
		});
		btnFichar.setBounds(402, 43, 131, 25);
		contentPanel.add(btnFichar);
	}
	
	public void btnPagar() {
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Cambia estado deutor objeto
					cli.setDeutor(0);
					//Modfica la base de datos
					conCli.modificaClients(cli);
					
				} catch (SQLException e) {
					System.out.println("Error al cambiar Deutor en btnPaga");
					e.printStackTrace();
				}
			}
			
		});
		

		btnPagar.setBounds(402, 89, 131, 25);
		contentPanel.add(btnPagar);
		}
	
	
	public void panelInferior() {
		//PANEL INFERIOR CONTIENE BOTTON OK & CANCELAR
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
