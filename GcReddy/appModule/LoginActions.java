package org.Selenum.GcReddy.appModule;

import org.Selenum.GcReddy.Report.Log;
import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.Utility.Utility;

public class LoginActions extends Utility{
	public static boolean flag;
	
	public static boolean LoginUsingPositiveData(String username, String password) throws InterruptedException {
		flag = false;
		try {
			Utility.getLocator("login_un_textbox_id").sendKeys(username);
			Utility.getLocator("login_pwd_textbox_id").sendKeys(password);
			Utility.getLocator("login_submit_button_xpath").click();
			Reports.info("Login Actions", "Login action is success");
			Log.info("Login Actions");
		flag = true;
		}catch (Exception e) {
			Reports.fail("login Actions", "login failed due to: " +e.toString(), "");	
			Log.fail("login action failed due to:" +e.fillInStackTrace().toString());
		}
		 return flag;
		
	}

}
