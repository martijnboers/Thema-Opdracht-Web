package atd.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import atd.database.ReserveringDAO;
import atd.domein.Klant;
import atd.domein.Reservering;

public class ParkerenService {
	Date huidige_datum = new Date();
	ReserveringDAO reserveringDAO = new ReserveringDAO();
	int overlap = 0;
	int aantalParkeerplaatsen = 10;

	// TODO betaling? wat willen we nog
	public boolean reserveerParkeerplaats(Reservering reservering) {
		if (reservering.getVertrek().before(reservering.getAankomst())
				|| reservering.getAankomst().before(huidige_datum)) {
			System.out.println("ongeldige datum");
			return false;
		}

		try {
			// ophalen allen reserveringen
			ArrayList<Reservering> alleReserveringen = reserveringDAO
					.getAlleReservering();
			// alle resveringen vergelijken met de nieuwe resveringen en als er
			// meer dan 10 zijn is de datum niet beschikbaar..
			// niet geweldig maar het werkt voor nu
			for (Reservering res : alleReserveringen) {
				if (dateOverlap(reservering.getAankomst(),
						reservering.getVertrek(), res.getAankomst(),
						res.getVertrek())) {
					overlap++;
				}
			}
			if (overlap <= aantalParkeerplaatsen) {
				// reservering toevoegen
				reserveringDAO.setReservering(reservering);
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	// overlap functie
	boolean dateOverlap(Date aankomst1, Date vertrek1, Date aankomst2,
			Date vertrek2) throws NullPointerException {
		if ((aankomst1.before(aankomst2) && vertrek1.after(aankomst2))
				|| (aankomst1.before(vertrek2) && vertrek1.after(vertrek2))
				|| (aankomst1.before(aankomst2) && vertrek1.after(vertrek2))) {
			return true;
		} else {
			return false;
		}
	}

	// opvragen aantal gepaarkeerde dagen voor factuur?
	public int getParkeerKosten(Klant klant) {
		try {
			return reserveringDAO.geparkeerdeDagen(klant);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aantalParkeerplaatsen;
	}

	// parkeer kosten betalen (gelijk alles)
	public boolean perkeerKostenBetalen(Klant klant) {
		try {
			return reserveringDAO.parkerenBetalen(klant);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
