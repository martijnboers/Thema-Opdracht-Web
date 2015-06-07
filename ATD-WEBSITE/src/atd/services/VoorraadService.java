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

public class VoorraadService {
	OnderdelenDAO onderdelenDAO = new OnderdelenDAO();

	public boolean updateOnderdeel(String id, String aantal) {
		if (id.isEmpty() || id == null && aantal.isEmpty() || aantal == null) {
			System.out.println("validatie is fout met" + id + " " + aantal);
			return false;
		} else {
			try {
				int intAantal = Integer.parseInt(aantal);
				int intId = Integer.parseInt(id);

				if (onderdelenDAO.updateOnderdeel(
						onderdelenDAO.getOnderdeel(intId), intAantal)) {
					System.out.println("Gelukt!");
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("helaas");
			return false;
		}
	}

	public boolean bestelOnderdeel(String id, String aantal) {
		if (id.isEmpty() || id == null && aantal == null || aantal.isEmpty()) {
			return false;
		} else {
			try {
				int nieuwAantal = onderdelenDAO.getOnderdeel(
						Integer.parseInt(id)).getVoorraad()
						+ Integer.parseInt(aantal);
				if (onderdelenDAO.updateOnderdeel(
						onderdelenDAO.getOnderdeel(Integer.parseInt(id)),
						nieuwAantal)) {
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
			System.out.println("nieuw onderdeel");
			double doublePrijs = Double.parseDouble(prijs);
			int intAantal = Integer.parseInt(aantal);
			Onderdeel onderdeel = new Onderdeel(naam, type, intAantal,
					doublePrijs);
			if (onderdelenDAO.setOnderdeel(onderdeel)) {
				return true;
			}
			return false;
		}
	}
}
