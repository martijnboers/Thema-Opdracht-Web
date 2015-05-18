package atd.home;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import atd.backend.LogFormatter;
import atd.database.BerichtenDAO;
import atd.domein.User;

/**
 * @author martijn
 *
 */
public class DeletePost extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		BerichtenDAO.removeBericht(id);
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/index.jsp");
		Logger.getLogger("atd.log").info("Bericht: " + id + "  is verwijderd");
		rd.forward(req, resp);
	}
}
