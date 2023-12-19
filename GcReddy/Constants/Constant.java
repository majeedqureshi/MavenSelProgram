package org.Selenum.GcReddy.Constants;

import org.Selenum.GcReddy.Utility.Utility;

public class Constant {
	// this class ocntains all filepath to use as resuable 
	// this is defing  the excel sheet by giving unique name so later it can call 
	// user.div means it conain local path of system by default path before src starts it is same for all 
	public static final String TestData_excel_path = System.getProperty("user.dir")+"//src\\test\\resources\\Test Data\\ExcelData.xlsx";
	
	// this is defing the locator path whic was store in repository folder to read directly if we call this method
	public static final String locators_path = System.getProperty("user.dir")+"\\src\\test\\resources\\Repository\\Locator.properties";
	// to read the config file by using this keyword to call them as it is reusable component
	public static final String config_path = System.getProperty("user.dir")+"\\src\\test\\resources\\Repository\\Config.properties";
	// to call chrome driver we created our own keyword to call them as it is reusable component
	public static final String chrome_path = System.getProperty("user.dir")+"\\Driver\\chromedriver.exe";
	// to read log4j fie we created own keyword to call them as it is reusable component
	public static final String log4jpath = System.getProperty("user.dir")+"\\Log4j.xml";
	// to read reports file we created own keyword to call them as it is reusable component
	public static final String Reportspath = System.getProperty("user.dir")+"\\ExecutionReports\\"+Utility.getDate() +"\\" +Utility.getDatetime()+".html";
	

}
