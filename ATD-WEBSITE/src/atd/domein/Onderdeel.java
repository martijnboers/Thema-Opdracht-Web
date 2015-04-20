package atd.domein;

import java.io.Serializable;

/**
 * Onderdeel object. MAAK HIER GEEN SETTERS, LAAT HET VIA DATABASE PACKAGE LOPEN! updateOnderdeel(Onderdeel, amount)!!
 * 
 * @author Martijn
 *
 */
public class Onderdeel {

	private String naam;
	private String type;
	private int voorraad;
	private double prijs;

	public Onderdeel(String naam, String type, int voorraad, double prijs) {
		this.naam = naam;
		this.type = type;
		this.voorraad = voorraad;
		this.prijs = prijs;
	}

	public String getNaam() {
		return naam;
	}

	public String getType() {
		return type;
	}

	public int getVoorraad() {
		return voorraad;
	}

	public double getPrijs() {
		return prijs;
	}

}
