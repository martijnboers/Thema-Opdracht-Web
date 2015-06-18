package atd.services;

import java.util.ArrayList;

import atd.database.AfspraakDAO;
import atd.database.GebruikteOnderdelenDAO;
import atd.domein.Afspraak;
import atd.domein.AfspraakStatus;
import atd.domein.Klant;
import atd.domein.Onderdeel;
import atd.domein.User;

public class AfspraakService {
	private GebruikteOnderdelenDAO gebruikteOnderdelenDAO = new GebruikteOnderdelenDAO();
	private AfspraakDAO afspraakDAO = new AfspraakDAO();
	private ArrayList<Afspraak> afspraken = new ArrayList<>();

	public ArrayList<Afspraak> getAlleAfspraken() {
		return afspraakDAO.getAlleAfspraken();
	}

	public ArrayList<Afspraak> getAfsprakenMonteur(User user) {
		return afspraakDAO.getAfsprakenMonteur(user);
	}

	public void onderdeelToevoegen(Onderdeel onderdeel, Klant klant, int aantal) {
		gebruikteOnderdelenDAO.setOnderdeel(onderdeel, klant, aantal);
	}

	public ArrayList<Onderdeel> getOnderdelenAfspraak(Afspraak afspraak) {
		return gebruikteOnderdelenDAO.getOnderdelen(afspraak);

	}

	public void afspraakInBehandeling(Afspraak afspraak) {

	}

	public void afspraakAfgerond(Afspraak afspraak) {

	}
}
