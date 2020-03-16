package Model;

public class Gimnas  {

	String gimnas;
	String nom;
	String telf;
	String adresa;
	String correu;
	
	public Gimnas (String dni, String nom, String telf, String adresa, String correu) {
		this.gimnas = dni;
		this.nom = nom;
		this.telf = telf;
		this.adresa = adresa;
		this.correu = correu;
	}
	
	public Gimnas(String dni) {
		this.gimnas = dni;
	}

	public String getGimnas() {
		return gimnas;
	}

	public void setGimnas(String gimnas) {
		this.gimnas = gimnas;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getadresa() {
		return adresa;
	}

	public void setadresa(String adresa) {
		this.adresa = adresa;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}
}