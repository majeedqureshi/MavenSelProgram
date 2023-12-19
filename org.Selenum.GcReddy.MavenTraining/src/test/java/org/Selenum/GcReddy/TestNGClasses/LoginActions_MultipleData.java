package org.Selenum.GcReddy.TestNGClasses;

import org.Selenum.GcReddy.Report.Log;
import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.Utility.ExcelUtils;
import org.Selenum.GcReddy.Utility.Utility;
import org.Selenum.GcReddy.appModule.LaunchEnv;
import org.Selenum.GcReddy.appModule.LoginActions;
import org.Selenum.GcReddy.appModule.LoginActionsMultipleData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginActions_MultipleData extends LoginActions {
	
//prerequisites which follows to login app is launching broswer and opening url and then close	
	@BeforeMethod
	public void Browserinvoked() throws InterruptedException {
		Reports.startTest("Login Actions", "login to the app successfully");
		Log.startTest("Login Actions");
		Assert.assertTrue(LaunchEnv.BrowserInvocation(prop_config.getProperty("Open_Browser")));
		// launching url
		Assert.assertTrue(LaunchEnv.invokeUrl(prop_config.getProperty("App_url")));
	}
	
	
  @Test (dataProvider ="Giddu") // means its tske data from Annotation DataProvider and use it in attribute dataProvider and read the excel for entire data without loop
  public void LoginRunnerUsingMultiData(String rm, String un, String pw, String criteria, String expVal, String result) throws InterruptedException {
	  // assert.assert true we will use to verfy statement true or false like that
		try {
			Assert.assertTrue(LoginActionsMultipleData.LoginUsingMultipleData(rm, un, pw, criteria, expVal, result));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("the runmode is executing when no");
			Log.info("it is executing with error message when rm is no");
			Reports.info("no define in runmode", "it is executing with error message when rm is no");
		}
	}

	@AfterMethod
	public void CloseBrowser() {
		Utility.closeBrowser();
		Reports.endTest();
  }
  
  @DataProvider (name ="Giddu")// we use this to define data t oread form excel and store in one variable we can give any name // DataProvider annotation means it sotre data in one variaable
	public static Object[][] ExcelSheetRead() {
		Object[][] ExcelData = ExcelUtils.getData("UiBank_Login");
		return ExcelData;

	}

}
