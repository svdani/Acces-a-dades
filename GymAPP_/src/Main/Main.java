package Main;

import Dades.*;
import Model.*;
import Vista.*;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;


public class Main{
	public static void main(String[] args) throws SQLException {
				
		
		LoginView window = new LoginView();
		window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		window.setVisible(true);
		
		
		
		
		
		
		
	//	ClientsSQL conector = new ClientsSQL();
	//	conector.conectar();	
			 
	
	//	Client cli = new Client("77749301d","1234");
	//	conector.insertaClients(cli);
	
	//	System.out.println("-->" + conector.buscaNomClients(cli));	
	//	System.out.println(conector.consultaClients());
	
		
		//E_SSQL con = new E_SSQL();
		//con.conectar();
		//E_S mov = new E_S("dani","fit","E");

	//	con.insertaMoviment(mov);
		//System.out.println(con.consultaMovimentClient(cli));
		
		//System.out.println(con.consultaUltimMovimentClient(cli));
		
		
		//GimnasSQL con2 = new GimnasSQL();
		//con2.conectar();
		//Gimnas gim = new Gimnas("12345");
		//con2.insertaGimnas(gim);
		//gim = new Gimnas("12345","gim","937785112","sdnfosa","sdkfbakud");
		//con2.modificaGimnas(gim);
		//Gimnas gim2 = new Gimnas("1239");
		//con2.deleteGimnas(gim2);
		//System.out.println(con2.consultaGimnas());
	}
}