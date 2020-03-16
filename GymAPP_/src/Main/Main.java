package Main;

import Dades.*;
import Model.*;
import Vista.*;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;


public class Main{
	public static void main(String[] args) throws SQLException {
			/*	
		ClientsSQL conector = new ClientsSQL();
		conector.conectar();	
			 */
	
		Client cli = new Client("77749301d","1234");
	/*
		System.out.println("-->" + conector.buscaNomClients(cli));	
		System.out.println(conector.consultaClients());
	*/
		E_SSQL con = new E_SSQL();
		con.conectar();
		E_S mov = new E_S("dani","fit","E");

		//con.insertaMoviment(mov);
		System.out.println(con.consultaMovimentClient(cli));
		
		System.out.println(con.consultaUltimMovimentClient(cli));
	}
}