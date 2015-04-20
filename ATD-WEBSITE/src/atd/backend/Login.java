package atd.backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import atd.database.dbUsers;

public class Login extends HttpServlet {
	private String adminUser;
	private String adminPwd;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		adminUser = config.getInitParameter("adminUser");
		adminPwd = config.getInitParameter("adminPwd");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		try {
			Class.forName("org.apache.commons.codec.digest.DigestUtils");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(req.getParameter("password"));
		RequestDispatcher rd = null;
		
		if (dbUsers.authUser(username, pass) || (username.equals(adminUser)) && req.getParameter("password").equals(adminPwd)) {
			rd = req.getRequestDispatcher("/voorraad/voorraad.jsp");
			req.getSession().setAttribute("username", username);
			resp.addCookie(new Cookie("username", username));
			rd.forward(req, resp);
		} else {
			rd = req.getRequestDispatcher("/login/login.jsp");
			req.setAttribute("error", "<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> ongeldige inlog gegevens </div>");
			rd.forward(req, resp);
		}
	}
}
