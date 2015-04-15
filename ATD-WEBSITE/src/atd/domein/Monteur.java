package atd.domein;

import java.io.Serializable;
import java.util.ArrayList;

public class Monteur implements Serializable{

	private String naam;
	private String adres;
	private double uurloon;
	private ArrayList<Afspraak> alleAfspraken;

	/**
	 * Maakt een nieuwe monteur aan
	 * @param naam	Naam monteur
	 * @param adres	Adres monteur
	 * @param uurloon	Uurloon monteur, belangrijk voor factuur
	 */
	public Monteur(String naam, String adres, double uurloon) {
		super();
		this.naam = naam;
		this.adres = adres;
		this.uurloon = uurloon;
		alleAfspraken = new ArrayList<Afspraak>();
	}

	public boolean isTijdBeschikbaar(Afspraak nieuweAfspraak) {
		boolean b = true;
		// begintijd nieuwe afspraak
		int beginTijd1 = (nieuweAfspraak.getBeginUren() * 100 + nieuweAfspraak.getBeginMinuten());
		// eindtijd nieuwe afspraak
		int eindTijd1 = (nieuweAfspraak.getEindUren() * 100 + nieuweAfspraak.getEindMinuten());

		for (Afspraak a : alleAfspraken) {
			// begintijd bestaande afspraak
			int beginTijd2 = (a.getBeginUren()) * 100 + a.getBeginMinuten();
			int eindTijd2 = (a.getEindUren()) * 100 + a.getEindMinuten();
			// eindtijd bestaande afspraak

			if (nieuweAfspraak.getDatum().equals(a.getDatum())) {
				if (a.getBeginUren() >= 9 && a.getEindUren() <= 17) {

					// als begintijd van nieuweAfspraak groter is dan de
					// begintijd van de bestaande afspraak, en kl
					if ((beginTijd1 >= beginTijd2 && beginTijd1 <= eindTijd2)
							|| (eindTijd1 >= beginTijd2 && eindTijd1 <= eindTijd2)) {
						b = false;
					}
				}
			}
		}

		return b;
	}

	public void voegAfspraakToe(Afspraak a) {
		if (isTijdBeschikbaar(a)) {
			alleAfspraken.add(a);
		}

	}

	public String afspraken() {
		String s = naam + " heeft de volgende afspraken: \n";

		for (Afspraak a : alleAfspraken) {
			s += a + "\n";
		}

		return s;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public double getUurloon() {
		return uurloon;
	}

	public void setUurloon(double uurloon) {
		this.uurloon = uurloon;
	}

	public String toString() {
		return "naam:" + naam + " Uurloon: " + uurloon;
	}

}
