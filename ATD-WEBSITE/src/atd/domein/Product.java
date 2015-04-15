package atd.domein;

import java.io.Serializable;

public class Product implements Serializable{
	
	private int artikelNummer;
	private String naam;
	private String type;
	private int minimumVoorraad;
	private int voorraad;
	private double prijs;
	
	public Product(int artikelNummer, String naam, String type,
			int minimumVoorraad, int voorraad, double prijs) {
		this.artikelNummer = artikelNummer;
		this.naam = naam;
		this.type = type;
		this.minimumVoorraad = minimumVoorraad;
		this.voorraad = voorraad;
		this.prijs = prijs;
	}


	public int getArtikelNummer() {
		return artikelNummer;
	}

	public void setArtikelNummer(int artikelNummer) {
		this.artikelNummer = artikelNummer;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMinimumVoorraad() {
		return minimumVoorraad;
	}

	public void setMinimumVoorraad(int minimumVoorraad) {
		this.minimumVoorraad = minimumVoorraad;
	}

	public int getVoorraad() {
		return voorraad;
	}

	public void setVoorraad(int voorraad) {
		this.voorraad = voorraad;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public String toString(){
		return "artnr: "+artikelNummer + "\nnaam: "+naam+"\ntype: "+type+"\nminvrd: "+minimumVoorraad+"\nvrd: "+voorraad+"\nprijs: "+prijs;
	}
	
	

}
