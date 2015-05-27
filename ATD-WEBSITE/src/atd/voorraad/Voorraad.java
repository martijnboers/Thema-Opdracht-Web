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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
