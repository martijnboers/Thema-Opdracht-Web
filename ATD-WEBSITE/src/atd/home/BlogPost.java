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
package atd.home;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import atd.domein.User;
import atd.services.BerichtenService;

/**
 * @author martijn
 *
 */
public class BlogPost extends HttpServlet {
	private BerichtenService BerichtenService = new BerichtenService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.apache.commons.lang3.StringEscapeUtils");
		} catch (ClassNotFoundException e) {
			Logger.getLogger("atd.log").warning("Kan niet lib importeren");
			e.printStackTrace();
		}
		String bericht = req.getParameter("bericht");
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		User user = (User) req.getSession().getAttribute("username");
		// Deze moet later verwerkt worden in KlantenBinding
		//BerichtenService.setBericht(StringEscapeUtils.escapeHtml4(bericht), currentTime, user);
		RequestDispatcher rd = null;

		Logger.getLogger("atd.log").info("Bericht: " + bericht + " door " + user.getNaam() + " is geplaatst");

		rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
}
