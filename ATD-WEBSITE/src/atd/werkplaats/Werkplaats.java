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
		String afspraakId = req.getParameter("toevoegen");
		String afronden = req.getParameter("afronden");

		String uren = req.getParameter("uren");
		String onderdeelId = req.getParameter("nieuwOnderdeel");
		String aantal = req.getParameter("nieuwAantal");

		/**
		 * run voor het zetten van verschillende arraylists met afspraken
		 */
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
		}
		/**
		 * Onderdelen toevoegen aan een afspraak
		 */
		if (afspraakId != null) {
			// values checken
			if (afspraakId == null || afspraakId.isEmpty()
					&& onderdeelId == null || onderdeelId.isEmpty()
					&& aantal == null || aantal.isEmpty()) {
				update = false;
			} else {
				service.onderdeelToevoegen(Integer.parseInt(onderdeelId),
						Integer.parseInt(afspraakId), Integer.parseInt(aantal));
				req.setAttribute("inbehandelingAfspraak",
						service.getAfsprakenMonteur(user));
				update = true;
			}
		}
		/**
		 * Als een monteur op afroden clickt zal de afspraak + het aan uren
		 * worden afgerond.
		 */
		if (afronden != null) {
			// values checken of ze niet leeg zijn.
			if (afronden == null || afronden.isEmpty() && uren == null
					|| uren.isEmpty()) {
				System.out.println("afronden is niet goed ingevuld");
				update = false;
			} else {
				// parsen van de strings en naar de service sturen.
				service.afspraakAfgerond(Integer.parseInt(afronden),
						Integer.parseInt(uren));
				// afgeronden uren laten zien
				req.setAttribute("afgerondeAfspraak",
						service.getAfgerondeAfspraken());
				update = true;
			}
		}
		/**
		 * user id opalen en afspraak ID uit het button veld mee halen hoeft
		 * niet afgevangen te worden want het is een button, als je dat fout kan
		 * doen mag je niet op het internet.
		 */
		if (aanmelden != null) {
			service.setInbehandeling(user.getId(), Integer.parseInt(aanmelden));
			// door sturen naar de monteur zijn taken.

			req.setAttribute("inbehandelingAfspraak",
					service.getAfsprakenMonteur(user));
			update = true;
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
