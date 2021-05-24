package log4demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jdemo {
	public static Logger Log1=LogManager.getLogger(Log4jdemo.class.getName());
	public static void main(String[] args)
	{
		System.out.println("starting");
		Log1.trace("Starting to trace");
		Log1.info("information");
		Log1.error("error");
		Log1.warn("warning");
		Log1.fatal("fatal");
	}

}
