package atd.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import atd.database.ReserveringDAO;
import atd.domein.Reservering;

public class ParkerenService {
	Date huidige_datum = new Date();
	ReserveringDAO reserveringDAO = new ReserveringDAO();

	// TODO heel veel..
	public boolean reserveerParkeerplaats(Reservering reservering) {
		if (reservering.getAankomst().compareTo(reservering.getVertrek()) > 0
				|| reservering.getAankomst().compareTo(huidige_datum) < 0) {
			System.out
					.println("aakomst is na vertrek.. dat kan niet of reservering voor de huidige dag");

			return false;
		}

		try {
			ArrayList<Reservering> alleReserveringen = reserveringDAO
					.getAlleReservering();

			for (Reservering res : alleReserveringen) {

			}

			reserveringDAO.setReservering(reservering);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	public ArrayList<Reservering> alleReservering() {
		try {
			return reserveringDAO.getAlleReservering();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
