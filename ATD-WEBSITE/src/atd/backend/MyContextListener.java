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
		for (Handler handler : Logger.getLogger("atd.blog").getHandlers()) {
			handler.close();
		}		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			FileHandler fh = new FileHandler("/log/atdlog.log");
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
