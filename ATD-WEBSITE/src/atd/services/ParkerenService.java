package atd.services;

import java.util.Date;

import atd.domein.Reservering;
import atd.domein.User;

public class ParkerenService {
	Date huidige_datum = new Date();

	// TODO reserveer DAO maken
	public boolean reserveerParkeerplaats(Reservering reservering) {

		if (reservering.getAankomst().compareTo(reservering.getVertrek()) > 0
				|| reservering.getAankomst().compareTo(huidige_datum) < 0) {
			System.out.println("aakomst is na vertrek.. dat kan niet of reservering voor de huidige dag");
			// error
			return false;
		}
		System.out.println("de aankomst datum "
				+ reservering.getAankomst().toString());
		System.out.println("de vertrek datum "
				+ reservering.getVertrek().toString());
		System.out.println("gereserveerd door "
				+ reservering.getKlant().getId());
		System.out.println("datum vandaag is " + huidige_datum.toString());
		return true;

	}

}
