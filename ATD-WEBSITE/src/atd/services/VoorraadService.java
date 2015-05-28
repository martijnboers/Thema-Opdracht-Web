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

import atd.database.OnderdelenDAO;
import atd.domein.Onderdeel;
import atd.domein.StatusDB;

public class VoorraadService {
	OnderdelenDAO onderdelenDAO = new OnderdelenDAO();

	public boolean updateOnderdeel(int id, int aantal) {
		try {
			if (onderdelenDAO.updateOnderdeel(onderdelenDAO.getOnderdeel(id),
					aantal) == StatusDB.SUCCESS) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean addOnderdeel(String naam, String type, int aantal,
			double prijs) {

		Onderdeel onderdeel = new Onderdeel(naam, type, aantal, prijs);
		if (onderdelenDAO.setOnderdeel(onderdeel) == StatusDB.SUCCESS) {
			System.out.println("onderdeel is er");
			return true;
		}
		return false;

	}
}
