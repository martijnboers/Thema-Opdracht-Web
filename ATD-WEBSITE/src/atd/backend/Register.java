package atd.backend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atd.database.dbUsers;
import atd.domein.Privilege;
import atd.domein.User;

public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String username = req.getParameter("username");
		String realName = req.getParameter("realname");
		try {
			Class.forName("org.apache.commons.codec.digest.DigestUtils");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String wachtwoord = org.apache.commons.codec.digest.DigestUtils.sha256Hex(req.getParameter("password"));
		dbUsers.setUser(new User(realName, username, Privilege.ADMIN), wachtwoord);
		
		rd = req.getRequestDispatcher("login/login.jsp");
		rd.forward(req, resp);
	}
}
