package atd.backend;

import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atd.database.dbAuto;
import atd.database.dbKlanten;
import atd.database.dbUsers;
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
			dbUsers.setUser(new User(0, realName, username, Privilege.ADMIN), wachtwoord);
			req.setAttribute("error", "<div class=\"alert alert-success\" role=\"alert\"> <span class=\"sr-only\">Info:</span> nieuwe gebruiker is aangemaakt </div>");
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

			Auto deAuto = new Auto(0, kenteken, merk, type);
			dbAuto.setAuto(deAuto);
			Klant k = new Klant(0, realName, username, postcode, email, deAuto, Privilege.KLANT);
			dbKlanten.setKlant(k, wachtwoord);
			sendRegMail(k);
			req.setAttribute("error", "<div class=\"alert alert-success\" role=\"alert\"> <span class=\"sr-only\">Info:</span> nieuwe gebruiker is aangemaakt </div>");
			rd = req.getRequestDispatcher("login/login.jsp");
			rd.forward(req, resp);
		}
	}

	public void sendRegMail(Klant k) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.ssl.enable", true);
		Session mailSession = Session.getInstance(props);
		try {
			Logger.getLogger("atd.blog").info("Stuurt mail naar: " + k.getEmail());
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("autototaaldienst.robot@gmail.com", "Auto Totaal Dienst (NO-REPLY)"));
			msg.setRecipients(Message.RecipientType.TO, k.getEmail());
			msg.setSubject("Uw account is aangemaakt");
			msg.setSentDate(Calendar.getInstance().getTime());
			msg.setContent("Beste " + k.getVolledigeNaam() + ", \n\nUw account " + k.getUsername() + " is aangemaakt, U kunt inloggen op de <a href='https://atd.plebian.nl'>ATD website</a>\n", "text/html; charset=utf-8");
			// TODO: Heeft OAUTH nodig, maarja we zijn al niet erg netjes met wachtwoorden
			Transport.send(msg, "autototaaldienst.robot@gmail.com", "autototaaldienst.robot!!");
		} catch (Exception e) {
			Logger.getLogger("sp.lesson5").warning("send failed: " + e.getMessage());
		}
	}
}
