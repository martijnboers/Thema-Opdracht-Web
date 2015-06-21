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

package atd.backend;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atd.database.AutoDAO;
import atd.database.KlantenDAO;
import atd.database.UsersDAO;
import atd.domein.Auto;
import atd.domein.Klant;
import atd.domein.Privilege;
import atd.domein.User;

/**
 * TODO: Register form voor Klant object toevoegen
 * 
 * Register formulier met SHA256 support
 * 
 * @author martijn
 *
 */
public class Register extends HttpServlet {
	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/mail.properties";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		System.out.println(req.getParameter("checkbox"));
		if (req.getParameter("checkbox") != null) {
			String username = req.getParameter("username").toLowerCase();
			String realName = req.getParameter("realname");

			try {
				Class.forName("org.apache.commons.codec.digest.DigestUtils");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String wachtwoord = org.apache.commons.codec.digest.DigestUtils.sha256Hex(req.getParameter("password"));
			if (UsersDAO.searchUser(username) != null) {
				req.setAttribute("errorReg",
						"<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> Username is bezet</div>");
				rd = req.getRequestDispatcher("register/register.jsp");
				rd.forward(req, resp);
				return;
			}
			if (username.equals("") || realName.equals("") || wachtwoord.equals("")) {
				req.setAttribute("errorReg",
						"<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> Er is een veld leeg</div>");
				rd = req.getRequestDispatcher("register/register.jsp");
				rd.forward(req, resp);
				return;
			}

			UsersDAO.setUser(new User(0, realName, username, Privilege.ADMIN), wachtwoord);
			req.setAttribute("error",
					"<div class=\"alert alert-success\" role=\"alert\"> <span class=\"sr-only\">Info:</span> nieuwe gebruiker is aangemaakt </div>");
			rd = req.getRequestDispatcher("login/login.jsp");
			rd.forward(req, resp);
		} else {
			String username = req.getParameter("username").toLowerCase();
			String realName = req.getParameter("realname");

			try {
				Class.forName("org.apache.commons.codec.digest.DigestUtils");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String wachtwoord = org.apache.commons.codec.digest.DigestUtils.sha256Hex(req.getParameter("password"));
			String postcode = req.getParameter("postcode");
			String email = req.getParameter("email");

			String kenteken = req.getParameter("kenteken");
			String merk = req.getParameter("merk");
			String type = req.getParameter("type");

			if (KlantenDAO.searchKlant(username) != null) {
				req.setAttribute("errorReg",
						"<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> Username bestaat al</div>");
				rd = req.getRequestDispatcher("register/register.jsp");
				rd.forward(req, resp);
				return;
			}

			if (username.equals("") || realName.equals("") || wachtwoord.equals("") || postcode.equals("") || email.equals("")
					|| kenteken.equals("") || merk.equals("") || type.equals("")) {
				req.setAttribute("errorReg",
						"<div class=\"alert alert-danger\" role=\"alert\"> <span class=\"sr-only\">Error:</span> Er is een veld leeg</div>");
				rd = req.getRequestDispatcher("register/register.jsp");
				rd.forward(req, resp);
				return;
			}

			Auto deAuto = new Auto(0, kenteken, merk, type);
			AutoDAO.setAuto(deAuto);
			Klant k = new Klant(0, realName, username, postcode, email, deAuto, Privilege.KLANT);
			KlantenDAO.setKlant(k, wachtwoord);
			sendRegMail(k);
			req.setAttribute("error", "<div class=\"alert alert-success\" role=\"alert\"> <span class=\"sr-only\">Info:</span> Gebruiker "
					+ k.getUsername() + " is aangemaakt </div>");
			rd = req.getRequestDispatcher("login/login.jsp");
			rd.forward(req, resp);
		}
	}

	public void sendRegMail(Klant k) throws IOException {
		Properties propMail = new Properties();
		InputStream config = null;
		config = new URL(CONFIG_URL).openStream();
		propMail.load(config);

		Properties props = new Properties();
		props.put("mail.smtp.host", propMail.getProperty("host"));
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.ssl.enable", true);
		Session mailSession = Session.getInstance(props);
		try {
			Logger.getLogger("atd.log").info("Stuurt mail naar: " + k.getEmail());
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(propMail.getProperty("email"), propMail.getProperty("mailName")));
			msg.setRecipients(Message.RecipientType.TO, k.getEmail());
			msg.setSubject("Uw account is aangemaakt");
			msg.setSentDate(Calendar.getInstance().getTime());
			msg.setContent("Beste " + k.getNaam() + ", \n\nUw account " + k.getUsername()
					+ " is aangemaakt, U kunt inloggen op de <a href='https://atd.plebian.nl'>ATD website</a>\n",
					"text/html; charset=utf-8");
			// TODO: Heeft OAUTH nodig, maarja we zijn al niet erg netjes met
			// wachtwoorden
			Transport.send(msg, propMail.getProperty("email"), propMail.getProperty("password"));
		} catch (Exception e) {
			Logger.getLogger("atd.log").warning("send failed: " + e.getMessage());
		}
	}
}
