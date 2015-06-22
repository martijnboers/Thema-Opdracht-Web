package atd.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import atd.database.AfspraakDAO;
import atd.domein.Afspraak;
import atd.domein.AfspraakStatus;
import atd.domein.Auto;
import atd.domein.Klant;
import atd.domein.User;


public class AfspraakTest {

	@Test
	public void AfspraakTest() {
		Klant klant = new Klant(0, null, null, null, null, null, null);
		java.util.Date datum = new Date(0);
		Auto auto = new Auto(0, null, null, null);
		User monteur = new User(0, null, null, null, 0);
		Afspraak Testafspraak = new Afspraak(klant, monteur, auto, datum, "omschrijving", AfspraakStatus.NIEUW);

		int id = Testafspraak.getID();
		assertNotNull(id);
		assertEquals(id, Testafspraak.getID());

		klant = Testafspraak.getKlant();
		assertNotNull(klant);
		assertEquals(klant, Testafspraak.getKlant());

		monteur = Testafspraak.getMonteur();
		assertNotNull(monteur);
		assertEquals(monteur, Testafspraak.getMonteur());

		auto = Testafspraak.getAuto();
		assertNotNull(auto);
		assertEquals(auto, Testafspraak.getAuto());

		datum = (Date) Testafspraak.getDatum();
		assertNotNull(datum);
		assertEquals(datum, Testafspraak.getDatum());

		String omschrijving = Testafspraak.getOmschrijving();
		assertNotNull(omschrijving);
		assertEquals(omschrijving, Testafspraak.getOmschrijving());

		AfspraakStatus status = AfspraakStatus.NIEUW;
		Testafspraak.setStatus(status);
		assertNotNull(status);
		assertEquals(status, Testafspraak.getStatus());

	}

	public void AfspraakTest2() {
		Afspraak Testafspraak = new Afspraak(null, null, null, null, null,
				null);

		AfspraakStatus status = AfspraakStatus.INBEHANDELING;
		Testafspraak.setStatus(status);
		assertNotNull(status);
		assertEquals(status, Testafspraak.getStatus());

	}

	public void AfspraakTest3() {
		Afspraak Testafspraak = new Afspraak(null, null, null, null, null,
				null);

		AfspraakStatus status = AfspraakStatus.AFGEROND;
		Testafspraak.setStatus(status);
		assertNotNull(status);
		assertEquals(status, Testafspraak.getStatus());

	}
}
