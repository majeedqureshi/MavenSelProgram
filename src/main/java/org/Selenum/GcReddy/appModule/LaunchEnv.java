package org.Selenum.GcReddy.appModule;

import org.Selenum.GcReddy.BaseClass.BaseClass;
import org.Selenum.GcReddy.Constants.Constant;
import org.Selenum.GcReddy.Report.Log;
import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.Utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LaunchEnv extends BaseClass{
	// launch class extend base class it is test ng becuase base class always stroe config and locator proerties files
	public static boolean flag;
	public static WebDriver driver;

	public static boolean BrowserInvocation(String Browser) {
		flag = false;
		System.out.println(Browser);
		try {
			if (Browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constant.chrome_path);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				Utility.waitImplicit();

			} else if (Browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "");
				driver = new FirefoxDriver();
			}
			flag = true;
			Log.info(Browser + "invoked successfully");
			Reports.pass("Browser Invocaiton", Browser + "invoked successfully");
		} catch (Exception e) {
			Log.info(Browser + " failed to invoke due to " + e.fillInStackTrace().toString());
			Reports.fail("Browser Invocation", Browser + "invocation failed due to " + e.toString(), "");
		}

		return flag;
	}
	//--------------------------------------------------------
	
	public static  boolean  invokeUrl(String Url) {
			flag= false;
		System.out.println(" Present applicaiton url is "+ Url);
		try {
		driver.get(Url);
			flag=true;
		Log.info(Url +"invoked successfully");
		Reports.pass("Appliation Invocaiton", Url+ "invoked successfully");
		}catch(Exception e) {
		Log.info(Url +" failed to invoke due to "+ e.fillInStackTrace().toString()); // this will use to print into log file
		Reports.fail("Applicaoitn  Invocation", Url + "invocation failed due to "+e.toString(), ""); // this will use to add in report files
		}

		return flag;
		} 
	
	//-----------------------------------------------------------------------------------------------
	public static void closeBrowser() {
		try {
			driver.close();
			Log.info("Browser closed successfully");
			Reports.info("Browser closing ", "Browser closed successfully");
		} catch (Exception e) {
			Log.info("Broser closkng is  failed due to " + e.fillInStackTrace().toString());
			Reports.fail("Browser closing", "Browser closing failed due to " + e.toString(), "");
		}
	}

	
}
