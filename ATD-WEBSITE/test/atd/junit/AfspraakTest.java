package atd.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import atd.database.AfspraakDAO;
import atd.domein.Afspraak;
import atd.domein.AfspraakStatus;


public class AfspraakTest {

	@Before
	public void start() {

	}

	@Test
	public void AfspraakTest() {
		Afspraak Testafspraak = new Afspraak(null, null, null, null, null, null);

		int id = Testafspraak.getID();
		assertNotNull(id);
		assertEquals(id, Testafspraak.getID());

		Object klant = Testafspraak.getKlant();
		assertNotNull(klant);
		assertEquals(klant, Testafspraak.getKlant());

		Object user = Testafspraak.getMonteur();
		assertNotNull(user);
		assertEquals(user, Testafspraak.getMonteur());

		Object auto = Testafspraak.getAuto();
		assertNotNull(auto);
		assertEquals(auto, Testafspraak.getAuto());

		Date datum = (Date) Testafspraak.getDatum();
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
