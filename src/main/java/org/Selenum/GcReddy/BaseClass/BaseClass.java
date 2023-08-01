package org.Selenum.GcReddy.BaseClass;

import java.io.IOException;
import java.util.Properties;

import org.Selenum.GcReddy.Constants.Constant;
import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.Utility.ExcelUtils;
import org.Selenum.GcReddy.Utility.Utility;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	
	public static Properties prop_config;
	public static Properties prop_locator;
	
	// in src/,sin/java it contains all java classes but base class is only one testNg class we need to create mandate to remember  
  @BeforeSuite
  public void initiliaseFiles() throws IOException {
	  
	  DOMConfigurator.configure(Constant.log4jpath);
	  prop_config = Utility.LoadProperties(Constant.config_path);
	  prop_locator = Utility.LoadProperties(Constant.locators_path);
	  ExcelUtils.invokeExcel(Constant.TestData_excel_path);
	  
  }
  
  @AfterTest
  public void FlushReports() {
	  Reports.flush();
  }
}
//Note: indrectly we care all calling all classes which was added in src/main/java as resuable component