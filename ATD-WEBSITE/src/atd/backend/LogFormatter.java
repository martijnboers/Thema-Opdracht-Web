package atd.backend;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	@Override
	public String format(LogRecord record) {
		return record.getLevel() + " log: " + record + LINE_SEPARATOR;
	}
	
	@Override
	public String getHead(Handler h){
		return super.getHead(h);
	}
	
	@Override
	public String getTail(Handler h){
		return super.getTail(h);
	}
}
