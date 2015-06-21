/*******************************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package atd.services;

import java.util.ArrayList;
import java.util.Date;

import atd.database.AfspraakDAO;
import atd.database.AutoDAO;
import atd.database.GebruikteOnderdelenDAO;
import atd.database.OnderdelenDAO;
import atd.domein.Afspraak;
import atd.domein.AfspraakStatus;
import atd.domein.Auto;
import atd.domein.Klant;

public class AfspraakService {
	private GebruikteOnderdelenDAO gebruikteOnderdelenDAO = new GebruikteOnderdelenDAO();
	private AfspraakDAO afspraakDAO = new AfspraakDAO();
	private OnderdelenDAO onderdeelDAO = new OnderdelenDAO();
	private ArrayList<Afspraak> afspraken = new ArrayList<>();

	public void nieuweAfspraak(Klant klant, int autoId, Date datum,
			String omschrijving) {
		Auto auto = AutoDAO.getAutoByID(2);
		System.out.println(auto.getId());
		Afspraak afspraak = new Afspraak(klant, null, auto, datum,
				omschrijving, AfspraakStatus.NIEUW);
		afspraakDAO.setAfspraak(afspraak);
	}
}
