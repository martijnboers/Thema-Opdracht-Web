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
package atd.parkeren;

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
import javax.servlet.http.HttpSession;

import atd.domein.Klant;
import atd.domein.Reservering;
import atd.services.ParkerenService;
import atd.services.ServiceProvider;

public class Parkeren extends HttpServlet {
	RequestDispatcher rd = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ParkerenService service = ServiceProvider.getParkerenService();
		String run = req.getParameter("run");
		boolean update = false;

		String datum_aankomst = req.getParameter("datum_aankomst");
		String datum_vertrek = req.getParameter("datum_vertrek");
		Klant klant = (Klant) req.getSession().getAttribute("username");
		if (run.equals("reserveren")) {
			if (datum_aankomst == null || datum_aankomst.isEmpty()
					&& datum_vertrek == null || datum_vertrek.isEmpty()) {
				update = false;
			} else {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {

					Date aankomst = df.parse(datum_aankomst);
					Date vertrek = df.parse(datum_vertrek);
					Reservering reservering = new Reservering(klant, aankomst,
							vertrek);
					if (service.reserveerParkeerplaats(reservering)) {
						update = true;
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		if (update) {
			rd = req.getRequestDispatcher("/parkeren/parkeren.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute(
					"error",
					"<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> Deze datum is niet beschikbaar</div>");
			rd = req.getRequestDispatcher("/parkeren/parkeren.jsp");
			rd.forward(req, resp);
		}
	}
}
