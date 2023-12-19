package org.Selenum.GcReddy.appModule;

import java.util.Properties;

import org.Selenum.GcReddy.Constants.Constant;
import org.Selenum.GcReddy.Report.Log;
import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.Utility.Utility;
import org.testng.Assert;

public class LoginActionsMultipleData extends Utility{
	public static boolean flag;
	
	public static Properties prop_loct;
	public static String ActVal ;
	
	public static boolean LoginUsingMultipleData(String rm, String un, String pw, String criteria, String expVal, String result) throws InterruptedException {
		flag = false;
		if (rm.equalsIgnoreCase("yes")) {
			try {
				prop_loct = Utility.LoadProperties(Constant.locators_path); // this line was use to load properties and store it and later it is reading 
				Utility.getLocator("login_un_textbox_id").sendKeys(un);
				Utility.getLocator("login_pwd_textbox_id").sendKeys(pw);
				Utility.getLocator("login_submit_button_xpath").click();

				if (criteria.equalsIgnoreCase("valid")) {
				ActVal = Utility.getLocator("Home_sucessmsg_message_xpath").getText(); // defining one string so it can store the vlaue we get
				Assert.assertEquals(ActVal, expVal);
				Log.info("Test Case Passed");
				Reports.pass("Login Actions", "Loggedin successfully with valid data");
				flag = true;
			} else if (criteria.equalsIgnoreCase("invalid") && un == "") { // used equals equals to // where username is equal to null
				ActVal = Utility.getLocator("login_erroremptyUN_message_xpath").getText(); // defining one string so it can store the vlaue we get
				Assert.assertEquals(ActVal, expVal);
				Log.info("Test Case  using invalid data Passed");
				Reports.pass("Login Actions using empty username",
						"Test case passed with invalid data and shows error as expected");
				flag = true;
			} else if (criteria.equalsIgnoreCase("invalid") && un!= "") { // means username is invalid but soemthig is there
				ActVal = Utility.getLocator("login_errorinvalidUN_message_xpath").getText(); // defining one string so it can store the vlaue we get
					Assert.assertEquals(ActVal, expVal);
					Log.info("Test Case invalid username Passed");
					Reports.pass("Login Actions using invalid username",
							"Test case passed with invalid data and shows error as expected");
					flag = true;
				} else
					Log.info("Test Case Passed");
				Reports.pass("Login Actions Tc", "Test case Passed");

			} catch (Exception e) {
				Reports.fail("login Actions", "login failed due to: " + e.toString(), "");
				Log.fail("login action failed due to:" + e.fillInStackTrace().toString());
			}
		} else {
			System.out.println("runmode is no for below data");
		}
		return flag;

	}

}
