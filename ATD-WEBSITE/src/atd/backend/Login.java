package atd.backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import atd.database.KlantenDAO;
import atd.database.LogDAO;
import atd.database.UsersDAO;

/**
 * TODO: Klanten login support
 * 
 * Login servlet verantwoordelijk voor het afhandelen van login request voor
 * Users en klanten
 * 
 * @author martijn
 *
 */
public class Login extends HttpServlet {
	private String adminUser;
	private String adminPwd;

	/**
	 * Pakt uit web.xml een admin profiel die altijd beschikbaar is
	 * 
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		adminUser = config.getInitParameter("adminUser");
		adminPwd = config.getInitParameter("adminPwd");
	}

	/**
	 * Vangt het POST request van de login.jsp en controlleerd deze met de
	 * database
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username").toLowerCase();

		try {
			Class.forName("org.apache.commons.codec.digest.DigestUtils");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(req.getParameter("password"));
		RequestDispatcher rd = null;

		if (UsersDAO.authUser(username, pass) || (username.equals(adminUser)) && req.getParameter("password").equals(adminPwd)) {
			// Controlleer of het filter een redirect gezet heeft
			if (req.getAttribute("redirect") == null || req.getAttribute("redirect").equals("")) {
				rd = req.getRequestDispatcher("/index.jsp");
			} else {
				rd = req.getRequestDispatcher((String) req.getAttribute("redirect"));
				req.removeAttribute("redirect");
			}
			req.getSession().setAttribute("username", UsersDAO.searchUser(username));
			resp.addCookie(new Cookie("username", username));
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			LogDAO.setLog(req.getRemoteAddr(), currentTime, UsersDAO.searchUser(username), null);
			rd.forward(req, resp);
		} else if (KlantenDAO.authKlant(username, pass)){
			if (req.getAttribute("redirect") == null || req.getAttribute("redirect").equals("")) {
				rd = req.getRequestDispatcher("/index.jsp");
			} else {
				rd = req.getRequestDispatcher((String) req.getAttribute("redirect"));
				req.removeAttribute("redirect");
			}
			req.getSession().setAttribute("username", KlantenDAO.searchKlant(username));
			resp.addCookie(new Cookie("username", username));
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			
			LogDAO.setLog(req.getRemoteAddr(), currentTime, null, KlantenDAO.searchKlant(username));
			rd.forward(req, resp);
		} else {
			rd = req.getRequestDispatcher("/login/login.jsp");
			req.setAttribute("error", "<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> ongeldige inlog gegevens </div>");
			rd.forward(req, resp);
		}
	}
}