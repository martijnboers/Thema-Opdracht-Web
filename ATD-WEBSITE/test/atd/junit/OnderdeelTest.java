package atd.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import atd.domein.Onderdeel;

public class OnderdeelTest {

	@Test
	public void OnderdeelTest(){
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
