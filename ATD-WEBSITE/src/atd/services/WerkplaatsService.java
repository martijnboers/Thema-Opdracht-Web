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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import atd.database.AfspraakDAO;
import atd.database.GebruikteOnderdelenDAO;
import atd.database.OnderdelenDAO;
import atd.domein.Afspraak;
import atd.domein.AfspraakStatus;
import atd.domein.Onderdeel;
import atd.domein.User;

public class WerkplaatsService {
	private GebruikteOnderdelenDAO gebruikteOnderdelenDAO = new GebruikteOnderdelenDAO();
	private AfspraakDAO afspraakDAO = new AfspraakDAO();
	private OnderdelenDAO onderdeelDAO = new OnderdelenDAO();
	private ArrayList<Afspraak> afspraken = new ArrayList<>();

	public ArrayList<Afspraak> getAlleAfspraken() {
		return afspraakDAO.getAlleAfspraken();
	}

	// ophalen van alle afspraken die de monteur heeft openstaan
	public ArrayList<Afspraak> getAfsprakenMonteur(User user) {
		return afspraakDAO.getAfsprakenMonteur(user);
	}

	// ophalen van afgeronde afspraken
	public ArrayList<Afspraak> getAfgerondeAfspraken() {
		return afspraakDAO.getAfgerondeAfspraken();
	}

	// ophalen alle nieuwe afspraken
	public ArrayList<Afspraak> getNieuwAfspraken() {
		return afspraakDAO.getNieuwAfspraken();
	}
	
	public void onderdeelToevoegen(int onderdeelID, Afspraak afspraak,
			int aantal) {
		Onderdeel onderdeel;
		try {
			onderdeel = onderdeelDAO.getOnderdeel(onderdeelID);
			gebruikteOnderdelenDAO.setOnderdeel(onderdeel, afspraak, aantal);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Onderdeel> getOnderdelenAfspraak(Afspraak afspraak) {
		try {
			return gebruikteOnderdelenDAO.getOnderdelen(afspraak);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public void afspraakInBehandeling(Afspraak afspraak) {

	}

	public void afspraakAfgerond(Afspraak afspraak) {
		
	}
}
