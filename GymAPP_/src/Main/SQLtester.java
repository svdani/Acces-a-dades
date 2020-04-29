package Main;

import Dades.*;
import Model.*;
import Vista.*;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;

public class SQLtester{
	
	public static void main(String[] args) {
		
		
		
		ClientsSQL conector1 = new ClientsSQL();
		ClientsSQL conector2 = new ClientsSQL();
		ClientsSQL conector3 = new ClientsSQL();
	
		//Client cli = new Client("111111","1234");
		/*
		try {
			System.out.println();
			System.out.println("####################### 1 ####################");
			System.out.println(conector1.consultaClients());		
			conector1.conectar();	
			conector1.insertaClients(cli);
			cli = new Client("111111","1111" );
			conector2.modificaClients(cli);
			System.out.println();
			System.out.println("####################### 2 ####################");
			System.out.println(conector2.consultaClients());
			conector2.deleteClients(cli);
			System.out.println();
			System.out.println("####################### 3 ####################");
			System.out.println(conector3.consultaClients());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		E_SSQL con1 = new E_SSQL();
		E_SSQL con2 = new E_SSQL();
		E_SSQL con3 = new E_SSQL();
		
		/*
		try {
			Client clie = new Client("DNI","PASSWORD");
			conector1.insertaClients(clie);		
			E_S mov = new E_S(clie.getDni(),"fit","E");
			
			System.out.println();
			System.out.println("####################### 1 ####################");
			System.out.println(con1.consultaMoviment());
			con1.insertaMoviment(mov);
			
			System.out.println();
			System.out.println("####################### 2 ####################");
			System.out.println(con2.consultaMovimentClientDesdeHasta(new Client("1"), "2020-04-26",  "2020-04-27"));

			System.out.println();
			System.out.println("####################### 3 ####################");
			System.out.println(con3.consultaTiempo("2020-04-27 00:00:00",  "2020-04-27 00:00:45"));

			System.out.println();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		*/

		GimnasSQL conxio1 = new GimnasSQL();
		GimnasSQL conxio2 = new GimnasSQL();
		GimnasSQL conxio3 = new GimnasSQL();
		
		con1.conectar();
		Gimnas gim = new Gimnas("wwww");
		
		try {
			System.out.println();
			System.out.println("####################### 1 ####################");
			conxio1.insertaGimnas(gim);
			System.out.println(conxio1.consultaGimnas());

			System.out.println();
			System.out.println("####################### 2 ####################");
			gim = new Gimnas("wwww","gim","937785112","sdnfosa","sdkfbakud");
			conxio2.modificaGimnas(gim);
			System.out.println(conxio2.consultaGimnas());
			
			System.out.println();
			System.out.println("####################### 3 ####################");
			conxio3.deleteGimnas(gim);
			System.out.println(conxio3.consultaGimnas());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
			 
	
	
}