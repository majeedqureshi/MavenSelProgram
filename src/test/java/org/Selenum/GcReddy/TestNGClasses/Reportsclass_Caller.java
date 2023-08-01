package org.Selenum.GcReddy.TestNGClasses;

import org.Selenum.GcReddy.Report.Reports;
import org.testng.annotations.Test;

public class Reportsclass_Caller {
  @Test
  public void TestCase1() {
	  Reports.startTest("TestCase 1", "Test case is executing Successfully");
	  Reports.info("Step 1", "Step 1 is working as expected");
	  Reports.pass("Step 2", "Step 2 status is pass ");
	  Reports.endTest();
	  
  }
  @Test
  public void TestCase2() {
	  Reports.startTest("TestCase 2", "Test case 2 is executing Successfully");
	  Reports.info("Step 1", "Step 1 is working as expected");
	  Reports.pass("Step 2", "Step 2 status is pass ");
	  Reports.fail("Step 3", "step 3 is failing ", "error.png");
	  Reports.endTest();
	  
  }
  @Test
  public void TestCase3() {
	  Reports.startTest("TestCase 4", "Test case is executing Successfully");
	  Reports.info("Step 1", "Step 1 is working as expected");
	  Reports.pass("Step 2", "Step 2 status is pass ");
	  Reports.warn("Step 3", " You are not eligilbe hence give correct input");
	  Reports.endTest();
  }
  @Test
  public void TestCase4() {
	  Reports.startTest("TestCase 4", "Test case is executing Successfully");
	  Reports.info("Step 1", "Step 1 is working as expected");
	  Reports.pass("Step 2", "Step 2 status is pass ");
	  Reports.fatal("Step 3", " Database error while adding data");
	  Reports.endTest();
	  Reports.flush();// this line of code is mandate to use at once in one testng class then only extent report will execute 
  }
}
