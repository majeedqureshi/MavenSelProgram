package org.Selenum.GcReddy.TestNGClasses;

import java.io.FileNotFoundException;

import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.Utility.Utility;
import org.testng.annotations.Test;

public class CallingProperties {
	@Test
	public void LoadingProerties() throws InterruptedException, FileNotFoundException {
	//	Reports.startTest("locator invocation", "located invoked succesfully");
		Utility.getLocator("login_un_textbox_id");
		Utility.getLocator("login_pwd_textbox_id");
		Utility.getLocator("login_submit_button_xpath");
	//	Reports.endTest();
	//	Reports.flush();
	}
}
