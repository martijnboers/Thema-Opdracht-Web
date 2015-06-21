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


public class Klant extends AccountWrapper {
	private Auto deAuto;
	private String email;
	private String postcode;


	public Klant(int id, String volledigeNaam, String username, String postcode, String email, Auto deAuto, Privilege priv) {
		super(id, volledigeNaam, username, priv);
		this.deAuto = deAuto;
		this.email = email;
		this.postcode = postcode;

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

	public Auto getDeAuto() {
		return deAuto;
	}

	public void setDeAuto(Auto deAuto) {
		this.deAuto = deAuto;
	}
}
