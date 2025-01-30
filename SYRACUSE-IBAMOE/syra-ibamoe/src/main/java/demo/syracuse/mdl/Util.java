package demo.syracuse.mdl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Util {
	private static Logger LOGGER = LoggerFactory.getLogger(Util.class);

	public static void debug(String s) {
		LOGGER.debug(s);
	}
	public static void debug(Object s) {
		LOGGER.debug(s.toString());
	}
    
}
