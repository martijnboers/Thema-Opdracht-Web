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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atd.domein.Onderdeel;
import atd.services.ServiceProvider;
import atd.services.VoorraadService;

public class Voorraad extends HttpServlet {
	RequestDispatcher rd = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		VoorraadService service = ServiceProvider.getVoorraadService();
		String run = req.getParameter("run");
		boolean update = false;

		// get Parameterss
//		int onderdeelId = Integer.parseInt(req.getParameter("ID"));
//		int nieuwAantal = Integer.parseInt(req.getParameter("aantal"));
		int onderdeelId =434;
		int nieuwAantal = 3;

		String aantal = req.getParameter("nieuwOnderdeelAantal");
		String naam = req.getParameter("nieuwOnderdeelNaam");
		String type = req.getParameter("nieuwOnderdeelType");
		String prijs = req.getParameter("nieuwOnderdeelPrijs");

		System.out.println(aantal + " " + naam + " " + type + " " + prijs);
		if (run == null) {
		} else if (run.equals("updaten")) {
			if (service.updateOnderdeel(onderdeelId, nieuwAantal) == true) {
				update = true;
			}
		} else if (run.equals("bestellen")) {

			if (service.updateOnderdeel(onderdeelId, nieuwAantal) == true) {
				update = true;
			}
		} else if (run.equals("nieuwOnderdeel")) {
			System.out.println("onderdeel toevoegen");

			if (service.addOnderdeel(naam, type, Integer.parseInt(aantal), Double.parseDouble(prijs)) == true) {
				update = true;
			}

		}
		if (update) {
			rd = req.getRequestDispatcher("/voorraad/voorraad.jsp");
			rd.forward(req, resp);
		} else {
			rd = req.getRequestDispatcher("/voorraad/voorraad.jsp");
			rd.forward(req, resp);
		}
	}
}
