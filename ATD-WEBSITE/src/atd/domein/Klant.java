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

import java.io.Serializable;

public class Klant implements Serializable {
	private int id;
	private Auto deAuto;
	private String email;
	private String postcode;
	private String volledigeNaam;
	private String username;
	private Privilege priv;

	// TODO: Dit heeft nog heel veel werk nodig

	public Klant(int id, String volledigeNaam, String username,
			String postcode, String email, Auto deAuto, Privilege priv) {
		this.id = id;
		this.postcode = postcode;
		this.volledigeNaam = volledigeNaam;
		this.username = username;
		this.setDeAuto(deAuto);
		this.email = email;
		this.priv = priv;
	}

	public Privilege getPriv() {
		return priv;
	}

	@Override
	public String toString() {
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getVolledigeNaam() {
		return volledigeNaam;
	}

	public void setVolledigeNaam(String volledigeNaam) {
		this.volledigeNaam = volledigeNaam;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPriv(Privilege priv) {
		this.priv = priv;
	}

	public Auto getDeAuto() {
		return deAuto;
	}

	public void setDeAuto(Auto deAuto) {
		this.deAuto = deAuto;
	}

	public int getId() {
		return id;
	}
}
