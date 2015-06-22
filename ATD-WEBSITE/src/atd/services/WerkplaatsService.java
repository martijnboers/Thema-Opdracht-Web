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
import atd.database.UsersDAO;
import atd.domein.Afspraak;
import atd.domein.AfspraakStatus;
import atd.domein.Onderdeel;
import atd.domein.User;

public class WerkplaatsService {
	private GebruikteOnderdelenDAO gebruikteOnderdelenDAO = new GebruikteOnderdelenDAO();
	private AfspraakDAO afspraakDAO = new AfspraakDAO();
	private UsersDAO userDAO = new UsersDAO();
	private OnderdelenDAO onderdeelDAO = new OnderdelenDAO();
	private ArrayList<Afspraak> afspraken = new ArrayList<>();

	/**
	 * Alle afspraken ophalen
	 * 
	 * @return alle afspraken
	 */
	public ArrayList<Afspraak> getAlleAfspraken() {
		return afspraakDAO.getAlleAfspraken();
	}

	/**
	 * Alle afspraken van de ingelogde monteur ophalen
	 * 
	 * @param user
	 * @return alle afsprakenv an de monteur
	 */
	public ArrayList<Afspraak> getAfsprakenMonteur(User user) {
		return afspraakDAO.getAfsprakenMonteur(user);
	}

	/**
	 * @return afgeronde afspraken
	 */
	public ArrayList<Afspraak> getAfgerondeAfspraken() {
		return afspraakDAO.getAfgerondeAfspraken();
	}

	/**
	 * Alle nieuwe afspraken waar de monteurs zich op kunnen aanmelden
	 * 
	 * @return alle nieuwe Afspraken
	 */
	public ArrayList<Afspraak> getNieuwAfspraken() {
		return afspraakDAO.getNieuwAfspraken();
	}

	/**
	 * 
	 * @param onderdeelID
	 * @param afspraak
	 * @param aantal
	 */
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

	/**
	 * NYI
	 * 
	 * @param afspraak
	 * @return alleGebruikteOnderelen
	 */
	public ArrayList<Onderdeel> getOnderdelenAfspraak(Afspraak afspraak) {
		try {
			return gebruikteOnderdelenDAO.getOnderdelen(afspraak);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Inbehandeling setten van een afspraak door de ID van de monteur te setten
	 * en de status in behandeling te veranderen
	 * 
	 * @param monteurID
	 * @param afspraakID
	 */
	public void setInbehandeling(int monteurID, int afspraakID) {
		try {
			User user = userDAO.getUser(monteurID);
			Afspraak afspraak = afspraakDAO.getAfspraakByID(afspraakID);
			afspraakDAO.setAfspraakInbehandeling(afspraak, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void afspraakAfgerond(Afspraak afspraak) {

	}
}
