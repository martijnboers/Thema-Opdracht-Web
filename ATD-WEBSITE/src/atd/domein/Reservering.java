package atd.domein;

import java.util.Date;



public class Reservering {
	private Klant klant;
	private Date aankomst;
	private Date vertrek;

	public Reservering(Klant klant, Date aankomst, Date vertrek) {
		this.klant = klant;
		this.aankomst = aankomst;
		this.vertrek = vertrek;

	}

	public Klant getKlant() {
		return klant;
	}

	public Date getVertrek() {
		return vertrek;
	}

	public Date getAankomst() {
		return aankomst;
	}

}
