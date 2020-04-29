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

import Dades.E_SSQL;
import Model.Client;
import Model.E_S;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MovimentUser_View extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	
	static E_SSQL conE_S = new E_SSQL();
	static Client cli;
	JDateChooser dateDesde = new JDateChooser();
	JDateChooser dateHasta = new JDateChooser();
	
	public MovimentUser_View(Client cli) {
		
		this.cli = cli;
		
		setBounds(100, 100, 552, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 346, 252);
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
		
		//---ACCESORIOS VIEW
		btnVerTiempo();
		calendarioDesde();
		calendarioHasta();
		panelInferior();
		
	}//-----------------------------------------------MovimentUser_View
	
	
	//-------------------------------------------------------------FUNCIONES TABLA 
	public static void updateTable(){ 
	//---Actualiza valores que se muestran en la tabla
		
		try {
			
			model.setRowCount(0);
								
			//----RELLENA TABLA
			for (E_S e_s:conE_S.consultaMovimentClient(cli)) {
				model.addRow(new Object[] {
					e_s.getData(),
					e_s.getGimnas(),
					e_s.getTipus()
				});	
			}			
			
		} catch (Exception e) {
			
		}
		
	}//updateTable()--------	
	
	
	public static void updateTableDesdeHasta(String desde, String hasta){ 
	//---Actualiza valores que se muestran en la tabla DESDE una fecha HASTA otra
		
		try {
			
			model.setRowCount(0);
								
			//----RELLENA TABLA
			for (E_S e_s:conE_S.consultaMovimentClientDesdeHasta(cli, desde, hasta)) {
				model.addRow(new Object[] {
					e_s.getData(),
					e_s.getGimnas(),
					e_s.getTipus()
				});	
			}			
			
		} catch (Exception e) {
			
		}
		
	}//updateTableDesdeHasta()--------	
	
	
	public static void cuentaTiempo(ArrayList<E_S> moviments2){ 
		//---Informacion tablas
		
		System.out.println("CUENTA TIEMPO");
		System.out.println(moviments2.size() +" tamaño");
		
		boolean aux = false; 
		int tiempo = 0;
		
		for (int i = 0; i < moviments2.size(); i++) {
			
			if((i+2) <= moviments2.size()) {
				
				if (moviments2.get(0).getTipus().equals("S") && aux == false) {
					
					System.out.println("HAY UNA SALIDA ANTES QUE UNA ENTRADA EN EL ARRAY");
					i++;
					aux = true;
					
					try {
						//CONSULTA TIEMPO TRANSCURRIDO
						tiempo += conE_S.consultaTiempo(moviments2.get(i).getData(), moviments2.get(i+1).getData());
						i++;
						
					} catch (SQLException e) {
						System.out.println("Falla en el IF  que compruva el primer puesto del array e_s");
						e.printStackTrace();
					}
					
				} else {
					
					System.out.println("EMPIEZA POR ENTRADA EN EL ARRAY");
					
					try {
						//CONSULTA TIEMPO TRANSCURRIDO
						tiempo += conE_S.consultaTiempo(moviments2.get(i).getData(), moviments2.get(i+1).getData());
						i++;
						
					} catch (SQLException e) {
						System.out.println("Falla en el ELSE  que compruba el primer puesto del array e_s");
						e.printStackTrace();
					}
				}
			}
			
		}//for END
		
		System.out.println(tiempo);
		
		JOptionPane.showMessageDialog(null, "Hola estos dias has estado un total de: "+ CalcularTiempo(tiempo) +" minutos" );	
		
		
	}//updateTableDesdeHasta()--------
	
	private static String CalcularTiempo(int tsegundos) {
		int horas = (tsegundos / 3600);
	    int minutos = ((tsegundos-horas*3600)/60);
	    int segundos = tsegundos-(horas*3600+minutos*60);
	    
	    return Integer.toString(horas) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);
	}
	
	
	//-------------------------------------------------------------ACCESORIOS VIEW
	public void btnVerTiempo() {
		JButton okButton = new JButton("Ver tiempo");
		okButton.setBounds(400, 167, 103, 23);
		contentPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//sdf.format(dateDesde.getDate()); 
					
				ArrayList<E_S> moviments2 = new ArrayList<E_S>();
				
				try {
						
					moviments2 = conE_S.consultaMovimentClientDesdeHasta(
									cli,
									sdf.format(dateDesde.getDate()).toString(), 
									sdf.format(dateHasta.getDate()).toString()
								);
						
					cuentaTiempo(moviments2);
						
					// ACTUALIZA TABLA  	
					updateTableDesdeHasta(
							sdf.format(dateDesde.getDate()).toString(), 
							sdf.format(dateHasta.getDate()).toString()
							);
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton); 
					
	}
	
	 
	public void panelInferior() {
		//PANEL INFERIOR CONTIENE BOTTON ATRAS & CANCELAR
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}	
			});
			
			JButton cancelButton_1 = new JButton("Atas");
			cancelButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					UserView windowClient = new UserView(cli);																
					windowClient.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					windowClient.setVisible(true);
					dispose();
				}
			});
			cancelButton_1.setActionCommand("Cancel");
			buttonPane.add(cancelButton_1);
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
		
	}
	
	
	public void calendarioDesde() {
		JLabel label = new JLabel("Desde:");
		label.setBounds(370, 27, 70, 15);
		contentPanel.add(label);
			
		dateDesde.setBounds(380, 51, 153, 19);
		contentPanel.add(dateDesde);
	}
	
	
	public void calendarioHasta() {
		JLabel label_1 = new JLabel("Hasta:");
		label_1.setBounds(370, 96, 70, 15);
		contentPanel.add(label_1);
		
		dateHasta.setBounds(380, 124, 153, 19);
		contentPanel.add(dateHasta);
		
		
	}
	
	
}
