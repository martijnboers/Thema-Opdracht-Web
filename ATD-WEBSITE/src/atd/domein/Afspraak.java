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
package atd.domein;

import java.text.ParseException;
import java.util.Date;

public class Afspraak {
	private int id;
	private Klant klant;
	private User monteur;
	private Auto auto;
	private Date datum;
	private String omschrijving;

	public Afspraak(int id, Klant klant, User monteur, Auto auto, String datum, String omschrijving) {
		this.id = id;
		this.klant = klant;
		this.monteur = monteur;
		this.auto = auto;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.datum = sdf.parse(datum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.omschrijving = omschrijving;
	}

	public Klant getKlant() {
		return klant;
	}

	public User getMonteur() {
		return monteur;
	}

	public Auto getAuto() {
		return auto;
	}

	public String getDatum() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(datum);
	}

	public String getOmschrijving() {
		return omschrijving;
	}
}
