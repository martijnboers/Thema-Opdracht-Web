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
import atd.database.dbBerichten;
import atd.domein.User;

/**
 * @author martijn
 *
 */
public class BlogPost extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.apache.commons.lang3");
		} catch (ClassNotFoundException e) {
			Logger.getLogger("atd.log").warning("Kan niet lib importeren");
			e.printStackTrace();
		}
		String bericht = req.getParameter("bericht");
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		User user = (User) req.getSession().getAttribute("username");
		dbBerichten.setBericht(StringEscapeUtils.escapeHtml4(bericht), currentTime, user);
		RequestDispatcher rd = null;

		Logger.getLogger("atd.log").info("Bericht: " + bericht + " door " + user.getNaam() + " is geplaatst");

		rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
}
