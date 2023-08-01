package org.Selenum.GcReddy.TestNGClasses;

import org.Selenum.GcReddy.Report.Log;
import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.Utility.Utility;
import org.Selenum.GcReddy.appModule.LaunchEnv;
import org.Selenum.GcReddy.appModule.LoginActions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginActions_PositiveData extends LoginActions {
	
//prerequisites which follows to login app is launching broswer and opening url and then close	
	@BeforeMethod
	public void Browserinvoked() throws InterruptedException {
		Reports.startTest("Login Actions", "login to the app successfully");
		Log.startTest("Login Actions");
		Assert.assertTrue(LaunchEnv.BrowserInvocation(prop_config.getProperty("Open_Browser")));
		// launching url
		Assert.assertTrue(LaunchEnv.invokeUrl(prop_config.getProperty("App_url")));
	}
	
	
  @Test
  public void LoginActionsTC() throws InterruptedException {
	  // assert.assert true we will use to verfy statement true or false like that
	  
	  Assert.assertTrue(LoginActions.LoginUsingPositiveData("gcreddy1997@gmail.com", "Madhavi@1206"));
	  Reports.endTest();
	  Log.endTest();
  }
  @AfterMethod
  public void CloseBrowser() {
	  Utility.closeBrowser();
  }
  
  
}
