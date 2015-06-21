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

import atd.domein.User;
import atd.services.ServiceProvider;
import atd.services.WerkplaatsService;

public class Werkplaats extends HttpServlet {
	RequestDispatcher rd = null;

	/**
	 * Alle Strings worden opgehaald en pas omgezet in de service naar het
	 * gewenste format
	 * */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		WerkplaatsService service = ServiceProvider.getWerkplaatsService();

		boolean update = false;
		User user = (User) req.getSession().getAttribute("username");

		String run = req.getParameter("run");
		String aanmelden = req.getParameter("aanmelden");

		if (run == null) {
			// niks
		} else if (run.equals("inbehandeling")) {
			req.setAttribute("inbehandelingAfspraak",
					service.getAfsprakenMonteur(user));
			update = true;

			// nieuwe klussen ophalen waar een monteur zich op kan aanmelden
		} else if (run.equals("nieuw")) {
			req.setAttribute("nieuweAfspraak", service.getNieuwAfspraken());
			update = true;

			// alle klussen ophalen die afgerond zijn
		} else if (run.equals("afgerond")) {
			req.setAttribute("afgerondeAfspraak",
					service.getAfgerondeAfspraken());
			update = true;
		} else if (run.equals("bestellen")) {

		} else if (run.equals("afronden")) {

			System.out.println("afronden");
		}

		// aanmelden bij een klus
		if (aanmelden != null) {
			
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
