package atd.junit;

import java.util.Date;

import atd.domein.Klant;
import atd.domein.Reservering;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import atd.domein.Onderdeel;

public class ParkeergarageTest {

	@Test
	public void ParkeergarageTest(){
		Klant klant = new Klant(0, null, null, null, null, null, null);
		java.util.Date vertrek = new Date(0);
		java.util.Date aankomst = new Date(0);
		boolean betaald = false;
		Reservering Testreservering = new Reservering(klant, vertrek, aankomst, betaald);
		
		klant = Testreservering.getKlant();
		assertNotNull(klant);
		assertEquals(klant, Testreservering.getKlant());
		
		vertrek = (Date) Testreservering.getVertrek();
		assertNotNull(vertrek);
		assertEquals(vertrek, Testreservering.getVertrek());
		
		aankomst = (Date) Testreservering.getAankomst();
		assertNotNull(aankomst);
		assertEquals(aankomst, Testreservering.getAankomst());
		
		betaald = Testreservering.getBetaald();
		assertEquals(betaald, Testreservering.getBetaald());
	}
	public void ParkeergarageTest2(){
		boolean betaald = true;
		Reservering Testreservering = new Reservering(null, null, null, betaald);
		betaald = Testreservering.getBetaald();
		assertEquals(betaald, Testreservering.getBetaald());
	}

}
