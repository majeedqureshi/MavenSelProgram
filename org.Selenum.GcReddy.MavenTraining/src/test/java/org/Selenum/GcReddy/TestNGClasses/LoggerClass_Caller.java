package org.Selenum.GcReddy.TestNGClasses;

import org.Selenum.GcReddy.Report.Log;
import org.testng.annotations.Test;

public class LoggerClass_Caller {
  @Test
  public void TestCase1() {
	  Log.startTest("TestCase 1 "); // taking input from src/main/java  where Log is class name and start test method define inside that class 
	  	Log.info("General message is printing");
	  	Log.pass("Chrome browser is invoking succesfully");
	  	Log.fail("the exepcted value is not executing");
	  	Log.warn(" the alue whic is using is not valid, hence need t ouse correct value to execute");
	  	Log.fatal(" the database is full hence unable to execute the further line");
	  Log.endTest();
  }
  @Test
  public void TestCase2() {
	  Log.startTest("TestCase 2 ");
	  	Log.info("General message is publishing");
	  	Log.pass("Chrome browser is invoking succesfully and showing default page ");
	  	Log.fail("the exepcted value is not executing so it is failed");
	  	Log.warn(" the alue whic is using is not valid, hence need t ouse correct value to execute");
	  	Log.fatal(" the database is full hence unable to execute the further line");
	  Log.endTest();
  }
  
  @Test
  public void UserIdFileValidation() {
	  Log.startTest("UserIdFileValidation"); 
	  	Log.info("Chrome browser is invoking succesfully");
	  	Log.info(" navigate to gmail by url https:// gmail.com ");
	  	Log.info("enter  valid username in the text box and click ok");
	  	Log.pass(" the username is  correct and homepage of gmail is opened");
	  	Log.info("enter  valid username in the text box and click ok");
	  	Log.fail("the exepcted home page is not appearing, hence the test case if failed");
	  Log.endTest();
  } 
}
