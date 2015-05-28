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
package atd.voorraad;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atd.services.ServiceProvider;
import atd.services.VoorraadService;

public class Voorraad extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// blog service ophalen
		VoorraadService service = ServiceProvider.getVoorraadService();
		// kijken welke button gebruikt is
		String run = req.getParameter("run");
		// ophalen ID van de update/bestel aantal
		String nieuwAantal = req.getParameter("ID");

		if (run == null) {
			// geen button is gebruikt?
		} else if (run.equals("updaten")) {
			// updaten van de de onderdelen

			System.out.println("Updaten!" + nieuwAantal);
		} else if (run.equals("bestellen")) {
			// bestellen van de onderdelen
			System.out.println("Bestellen!");

		}
	}

}
