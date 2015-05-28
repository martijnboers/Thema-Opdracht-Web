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

import atd.services.ServiceProvider;
import atd.services.VoorraadService;

public class Voorraad extends HttpServlet {
	RequestDispatcher rd = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		VoorraadService service = ServiceProvider.getVoorraadService();
		String run = req.getParameter("run");

		int onderdeelId = Integer.parseInt(req.getParameter("ID"));
		int nieuwAantal = Integer.parseInt(req.getParameter("aantal"));
		boolean update = false;
		System.out.println(onderdeelId + " " + nieuwAantal);

		if (run == null) {
		} else if (run.equals("updaten")) {
			if (service.updateOnderdeel(onderdeelId, nieuwAantal) == true) {
				update = true;
			}
		} else if (run.equals("bestellen")) {
			
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
