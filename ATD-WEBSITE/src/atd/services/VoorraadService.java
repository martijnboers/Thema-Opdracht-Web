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

	public boolean updateOnderdeel(String id, String aantal) {
		if (id.isEmpty() || id == null && aantal.isEmpty() || aantal == null) {
			return false;
		} else {
			try {
				if (onderdelenDAO.updateOnderdeel(
						onderdelenDAO.getOnderdeel(Integer.parseInt(id)),
						Integer.parseInt(aantal)) == StatusDB.SUCCESS) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	public boolean bestelOnderdeel(String id, String aantal) {
		if (id.isEmpty() || id == null && aantal.isEmpty() || aantal == null) {
			return false;
		} else {
			try {
				int nieuwAantal = onderdelenDAO.getOnderdeel(
						Integer.parseInt(id)).getVoorraad()
						+ Integer.parseInt(aantal);
				if (onderdelenDAO.updateOnderdeel(
						onderdelenDAO.getOnderdeel(Integer.parseInt(id)),
						nieuwAantal) == StatusDB.SUCCESS) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	public boolean addOnderdeel(String naam, String type, String aantal,
			String prijs) {
		if (naam.isEmpty() || naam == null && type.isEmpty() || type == null
				&& aantal.isEmpty() || aantal == null && prijs.isEmpty()
				|| prijs == null) {
			return false;
		} else {

			double doublePrijs = Double.parseDouble(prijs);
			int intAantal = Integer.parseInt(aantal);
			Onderdeel onderdeel = new Onderdeel(naam, type, intAantal,
					doublePrijs);
			if (onderdelenDAO.setOnderdeel(onderdeel) == StatusDB.SUCCESS) {
				System.out.println("onderdeel is er");
				return true;
			}
			return false;
		}
	}
}
