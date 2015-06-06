package atd.services;

import java.util.Date;

public class ParkerenService {

	// TODO reserveer DAO maken
	public boolean reserveerParkeerplaats(Date aankomst, Date vertrek) {
		if (aankomst.compareTo(vertrek) > 0) {
			System.out.println("aakomst is na vertrek.. dat kan niet");	
			//error
			return false;
		}
		System.out.println("de aankomst datum " + aankomst.toString());
		System.out.println("de vertrek datum " + vertrek.toString());

		return true;

	}
}
