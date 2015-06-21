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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atd.domein.Klant;
import atd.services.AfspraakService;
import atd.services.ServiceProvider;

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
		Klant klant = (Klant) req.getSession().getAttribute("username");
		String omschrijving = req.getParameter("omschrijving");
		String datum = req.getParameter("datum");
		String run = req.getParameter("run");

		if (run == null) {

		} else if (run.equals("bevestig")) {
			if (datum == null || datum.isEmpty() && omschrijving == null
					|| omschrijving.isEmpty()) {
				update = false;
			} else {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date date;
				try {
					date = df.parse(datum);
					service.nieuweAfspraak(klant, klant.getDeAuto().getId(),
							date, omschrijving);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				update = true;
			}
		}

		if (update) {
			req.setAttribute(
					"msg",
					"<div class=\"alert alert-success\" role=\"alert\"> <span class=\"sr-only\">Gelukt:</span>We hebben uw afspraak ontvangen!</div>");
			rd = req.getRequestDispatcher("/afspraak/afspraak.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute(
					"msg",
					"<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Fout:</span> Zorg dat u de datum en een omschrijving opgeeft!</div>");
			rd = req.getRequestDispatcher("/afspraak/afspraak.jsp");
			rd.forward(req, resp);
		}
	}
}
