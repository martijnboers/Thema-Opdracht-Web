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
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener{
	private Logger logger = Logger.getLogger("atd.log");
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		for (Handler handler : Logger.getLogger("atd.log").getHandlers()) {
			handler.close();
		}		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			FileHandler fh = new FileHandler("atd.log");
			fh.setFormatter(new LogFormatter());
			System.out.println(11);
			logger.addHandler(fh);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		logger.setLevel(Level.ALL);
		logger.info("Logger initialized");
		
	}
}
