package atd.domein;

import java.util.Date;

public class Reservering {
	private Klant klant;
	private Date aankomst;
	private Date vertrek;
	private boolean betaald = false;

	public Reservering(Klant klant, Date aankomst, Date vertrek, boolean betaald) {
		this.klant = klant;
		this.aankomst = aankomst;
		this.vertrek = vertrek;
		this.betaald = betaald;
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

	public boolean getBetaald() {
		return betaald;
	}
}
