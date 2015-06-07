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

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Onderdeel object. MAAK HIER GEEN SETTERS, LAAT HET VIA DATABASE PACKAGE
 * LOPEN! updateOnderdeel(Onderdeel, amount)!!
 * 
 * @author Martijn
 *
 */
public class Onderdeel {
	private int id;
	private String naam;
	private String type;
	private int voorraad;
	private double prijs;
	DecimalFormat decimal = new DecimalFormat("#.00");
	NumberFormat formatter = new DecimalFormat("#0.00");

	public Onderdeel(String naam, String type, int voorraad, double prijs) {
		this.naam = naam;
		this.type = type;
		this.voorraad = voorraad;
		this.prijs = prijs;
	}

	public String getNaam() {
		return naam;
	}

	public String getType() {
		return type;
	}

	public int getVoorraad() {
		return voorraad;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}
}
