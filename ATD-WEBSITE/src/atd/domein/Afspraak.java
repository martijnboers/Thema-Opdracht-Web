package atd.domein;

import java.sql.Date;

public class Afspraak {
	private Klant klant;
	private User monteur;
	private Auto auto;
	private Date datum;
	private String omschrijving;

	public Afspraak(Klant klant, User monteur, Auto auto, Date datum, String omschrijving) {
		this.klant = klant;
		this.monteur = monteur;
		this.auto = auto;
		this.datum = datum;
		this.omschrijving = omschrijving;
	}

	public Klant getKlant() {
		return klant;
	}

	public User getMonteur() {
		return monteur;
	}

	public Auto getAuto() {
		return auto;
	}

	public Date getDatum() {
		return datum;
	}

	public String getOmschrijving() {
		return omschrijving;
	}
}
