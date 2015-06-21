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

public class User {
	private int id;
	private String naam;
	private String username;
	private Privilege priv;
	
	// Dit moet hernoemd worden naar monteur, maar ergens zitten problemen
	
	public User(int id, String naam, String username, Privilege priv){
		this.id = id;
		this.naam = naam;
		this.username = username;
		this.priv = priv;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Privilege getPriv() {
		return priv;
	}

	public void setPriv(Privilege priv) {
		this.priv = priv;
	}

	public int getId() {
		return id;
	}
}
