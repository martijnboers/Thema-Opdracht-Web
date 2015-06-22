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

import atd.database.BerichtenDAO;
import atd.domein.Bericht;
import atd.domein.Klant;
import atd.domein.StatusDB;
import atd.domein.User;

public class BerichtenService {
	private BerichtenDAO berichtenDAO = new BerichtenDAO();

	public BerichtenService() {
		//
	}

	public StatusDB setBericht(String bericht, String tijd, User user, Klant klant) {
		if (!bericht.equals("") && !tijd.equals("") && user != null) {
			return berichtenDAO.setBericht(bericht, tijd, user, klant);
		} else {
			return StatusDB.INCORRECT;
		}
	}

	public StatusDB removeBericht(int id) {
		return berichtenDAO.removeBericht(id);
	}

	public ArrayList<Bericht> getAlleBerichten() throws SQLException{
		return berichtenDAO.getAllBerichten();
	}
	
	public ArrayList<Bericht> getAlleBerichtenUser(int id) throws SQLException{
		System.out.println(id);
		return berichtenDAO.getAllBerichtenUser(id);
	}
}
