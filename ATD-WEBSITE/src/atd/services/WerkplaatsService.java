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
	private BerichtenService ber = new BerichtenService();

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
	 * @param onderdeelId
	 * @param afspraakId
	 * @param aantal
	 */
	public void onderdeelToevoegen(int onderdeelId, int afspraakId, int aantal) {
		gebruikteOnderdelenDAO.setOnderdeel(onderdeelId, afspraakId, aantal);

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
			
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String confTime = sdf.format(dt);
			ber.setBericht("Uw afspraak is verwerkt en uw auto wordt gerepareerd door " + user.getNaam() + "", confTime, user, afspraak.getKlant());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * hier word een afspraak afgerond en de uren op de afspraak gezet
	 * 
	 * @param afspraak
	 * @param uren
	 */
	public void afspraakAfgerond(int afspraak, int uren) {
		Afspraak afgerondeAfspraak = afspraakDAO.getAfspraakByID(afspraak);
		afspraakDAO.setAfspraakAfronden(afgerondeAfspraak, uren);
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String confTime = sdf.format(dt);
		ber.setBericht("Uw auto is gemaakt en u kunt hem ophalen", confTime, afgerondeAfspraak.getMonteur(), afgerondeAfspraak.getKlant());
	}
}
