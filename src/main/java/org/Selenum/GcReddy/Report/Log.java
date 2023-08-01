package org.Selenum.GcReddy.Report;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	
	public static Logger logger = Logger.getLogger(Log.class.getName()); // create object behalf of class 
	
	// every test case has t ostart and end the another test case need to write
	
	public static void startTest(String TestCaseName) { // this was use t ostart of test case 
		// the word static use to call anywhere it is manadate to use static always in every method
		//src/main/java this cant execute because it contain only  java class and require main mthod to execute // it is resuable component
		//src/test/java this is testNG class it can execute by calling java methods as well 
		// configuring the log4j.xml file to this fiel which is reusable component
		DOMConfigurator.configure("Log4j.xml"); // this code need to use to configure log4j file to the java class
		logger.info("                                                                     "); // this space was before test case starts
		logger.info("----------------------"+TestCaseName +"------------------------------"); // this is use to define case case name bwfire it execute
		logger.info("*********************************************************************");  // before execution starts 
		// the above three line genrally use to define testcase name in understable format  when we see log file 	
	}
	
	public static void info(String description) {
		logger.info(description);
	}
	public static void pass(String description) {
		logger.info(description);
	}
	public static void fail(String description) {
		logger.info(description);
	}
	public static void warn(String description) {
		logger.info(description);
	}
	public static void fatal(String description) {
		logger.info(description);
	}
	
	public static void endTest() { // this need to sue to end the test case 
		logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"); // this is used at the end of test case
	}
}
