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

public class ServiceProvider {
	private static VoorraadService voorraadService = new VoorraadService();
	private static AuthenticatieService authenticatieService = new AuthenticatieService();
	private static WerkplaatsService werkplaatsService = new WerkplaatsService();
	private static ParkerenService parkeerService = new ParkerenService();

	public static VoorraadService getVoorraadService() {
		return voorraadService;
	}

	public static AuthenticatieService getAuthenticatieService() {
		return authenticatieService;
	}

	public static WerkplaatsService getWerkplaatsService() {
		return werkplaatsService;
	}

	public static ParkerenService getParkerenService() {
		return parkeerService;
	}
}
