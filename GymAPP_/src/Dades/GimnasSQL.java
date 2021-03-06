package Dades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Client;
import Model.E_S;
import Model.Gimnas;

public class GimnasSQL {
	Connection c = null;

	Statement sentencia = null;
	
	String cif;
	String nom;
	String adresa;
	String telf;
	String correu;

	ArrayList<Gimnas> moviments = new ArrayList<Gimnas>();
	
	//Conecta base dades Gimnas
	public Connection conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/gim.db");
			System.out.println("Exito al conectar con base de datos Gimnas");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos Gimnas");

		}
		return c;
	}
	
	//Inserta en tabla Gimnas
	public void insertaGimnas(Gimnas gim) throws SQLException {
	
			try {
				conectar();

				String sqlInsert = "INSERT INTO Gimnas (cif, nom, adresa, telf, correu) "

			            	 + "VALUES (" + "'" + gim.getCif() + "'" + ","
			            	 + "'" + gim.getNom() + "'" + ","
			            	 + "'" + gim.getadresa() + "'" + ","
			            	 + "'" + gim.getTelf() + "'" + ","
			            	 + "'" + gim.getCorreu() + "'" + ");";
				
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlInsert);
				sentencia.close();
				c.close();

				System.out.println("Datos insertados Gimnas");

			} catch (Exception e) {

				System.out.println("Error al insertertar datos en la tabla Gimnas");

			}
		}

	//Modifica taula Gimnas
	public void modificaGimnas(Gimnas gim) throws SQLException {

		try {

			conectar();
		
			String sqlUpdate ="UPDATE Gimnas SET"
								+ " nom='" + gim.getNom() 
								+ "', adresa='" + gim.getadresa()
								+ "', telf='" + gim.getTelf()
								+ "', correu='" + gim.getCorreu() 
								+ "' WHERE cif ='" + gim.getCif()
								+ "';";
			System.out.println(sqlUpdate);
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlUpdate);
			sentencia.close();
			c.close();
		
			System.out.println("Datos actualizados");

		} catch (Exception e) {

				System.out.println("Error al actualizar datos en la tabla E_S");

		}
	}
		
	//Elimina registre taula Gimnas
	public void deleteGimnas(Gimnas gim) throws SQLException {

		try {

			conectar();

			String sqlDelete = "DELETE FROM Gimnas WHERE cif='" + gim.getCif() + "';";
			System.out.println(sqlDelete);
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlDelete);
			sentencia.close();
			c.close();
			System.out.println("Datos eliminados");
		} catch (Exception e) {

			System.out.println("Error al eliminar datos en la tabla Gimnas");

		}

	}
		
	//Muestra Tabla Gimnas
	public ArrayList<Gimnas> consultaGimnas() throws SQLException {

		conectar();

		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM Gimnas ORDER BY nom;";
		
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			while (rs.next()) {
					
				cif = rs.getString("cif");
				nom = rs.getString("nom");
				telf = rs.getString("telf");
				adresa = rs.getString("adresa");
				correu = rs.getString("correu");
						
				//GUARDA EN ARRAY LIST CLIENT
				moviments.add(new Gimnas(
						cif, 
						nom, 
						telf,
						adresa, 
						correu));
			}

			rs.close();
			sentencia.close();
			c.close();

		} catch (Exception e) {

			Talal: 	System.out.println(e.getMessage());

		}
		return moviments;
	}

};