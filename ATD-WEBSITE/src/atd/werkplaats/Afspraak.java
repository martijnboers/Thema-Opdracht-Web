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
package atd.werkplaats;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atd.services.AfspraakService;
import atd.services.ServiceProvider;
import atd.services.VoorraadService;

public class Afspraak extends HttpServlet {
	RequestDispatcher rd = null;

	/**
	 * Alle Strings worden opgehaald en pas omgezet in de service naar het
	 * gewenste format
	 * */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AfspraakService service = ServiceProvider.getAfspraakService();

		boolean update = false;

		String onderdeelId = req.getParameter("ID");
		String nieuwAantal = req.getParameter("aantal");
		String bestelAantal = req.getParameter("bestelAantal");

		String aantal = req.getParameter("nieuwOnderdeelAantal");
		String naam = req.getParameter("nieuwOnderdeelNaam");
		String type = req.getParameter("nieuwOnderdeelType");
		String prijs = req.getParameter("nieuwOnderdeelPrijs");
		String run = req.getParameter("run");
		System.out.println(run);
		if (run == null) {
			// niks
		} else if (run.equals("aanmelden")) {
			// User object uit de sessie setten op de afspraak
		} else if (run.equals("bestellen")) {
			// onderdelen bestellen (in de option tag staat het ID)
		} else if (run.equals("afronden")) {
			// status van afspraak "afgerond maken"
			System.out.println("afronden");
		}

		if (update) {
			rd = req.getRequestDispatcher("/werkplaats/werkplaats.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute(
					"error",
					"<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> Vul al de velden correct in </div>");
			rd = req.getRequestDispatcher("/werkplaats/werkplaats.jsp");
			rd.forward(req, resp);
		}
	}
}
