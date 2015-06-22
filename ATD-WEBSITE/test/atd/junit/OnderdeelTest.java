package atd.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import atd.database.OnderdelenDAO;
import atd.domein.Onderdeel;

public class OnderdeelTest {

	@Test
	public void OnderdeelTest() throws SQLException {
		Onderdeel Testonderdeel = new Onderdeel("testonderdeel", "testtype", 0, 0);
		
		String naam = Testonderdeel.getNaam();
		assertNotNull(naam);
		assertEquals(naam, Testonderdeel.getNaam());
		
		String type = Testonderdeel.getType();
		assertNotNull(type);
		assertEquals(type, Testonderdeel.getType());
		
		int voorraad = Testonderdeel.getVoorraad();
		assertNotNull(voorraad);
		assertEquals(voorraad, Testonderdeel.getVoorraad());
		
		double prijs = Testonderdeel.getPrijs();
		assertNotNull(prijs);
		assertEquals(prijs, Testonderdeel.getPrijs(), 0);
		
	}

}
