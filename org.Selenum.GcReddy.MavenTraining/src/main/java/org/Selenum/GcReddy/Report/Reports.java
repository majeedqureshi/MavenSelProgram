package org.Selenum.GcReddy.Report;

import java.util.HashMap;
import java.util.Map;

import org.Selenum.GcReddy.Constants.Constant;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {

	// create variable for extent class

	// uanble to import extent class

	public static ExtentReports report = new ExtentReports(Constant.Reportspath, false); // i define path so it will save create new file and save it autoamtically 
	public static ExtentTest test;

	public static void startTest(String Testcasename, String Description) {
		test = report.startTest(Testcasename, Description);
		addSystemInfo(); // this was used to add timing of system to the console and log file
		test.assignCategory("Regression"); // assign category in extent report
		test.assignAuthor("Majeed Qureshi"); // assign author name i nextent report
	}

	public static void addSystemInfo() {
		// mapping the system time to selenium code
		Map<String, String> sysinfo = new HashMap<String, String>();
		sysinfo.put("Selenium Version", "3.141.0");
		report.addSystemInfo(sysinfo);
	}

	public static void info(String Teststepname, String details) {
		test.log(LogStatus.INFO, Teststepname, details);
	}

	public static void pass(String Teststepname, String details) {
		test.log(LogStatus.PASS, Teststepname, details);
	}

	public static void fail(String Teststepname, String details, String imagePath) {
		test.log(LogStatus.FAIL, Teststepname, details+test.addScreenCapture("imagePath")); // to save sccreenshot we need to us =e this for fail cases
	}

	public static void warn(String Teststepname, String details) {
		test.log(LogStatus.WARNING, Teststepname, "<Span style ='font-Weight:Italic; color:Green'>"+details+"</span>");
	}

	public static void fatal(String Teststepname, String details) {
		test.log(LogStatus.FATAL, Teststepname, details);
	}
	public static void endTest() {
		report.endTest(test);
	}
	public static void flush(){
		report.flush();
		
	}
	
	
	
	
	
	
	
}