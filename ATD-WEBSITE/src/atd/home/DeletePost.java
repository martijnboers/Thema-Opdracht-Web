package atd.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import atd.database.dbBerichten;
import atd.domein.User;

/**
 * @author martijn
 *
 */
public class DeletePost extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		dbBerichten.removeBericht(id);
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
}
