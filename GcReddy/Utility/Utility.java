package org.Selenum.GcReddy.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.Selenum.GcReddy.Report.Log;
import org.Selenum.GcReddy.Report.Reports;
import org.Selenum.GcReddy.appModule.LaunchEnv;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends LaunchEnv {
	
	// it is extenting LaunchEnv because launch ev contain broswr invoke close methos so here that will get used becoase of that it extends
	// bascially utility class contain multiple methods
	// load config fil/ load proerties both are same e& file locator & element
	// highlight.......
	public static Properties prop;
	public static FileInputStream fis;
	public static WebElement element;
	public static Properties locator_prop;
	public static String filepath;

	/**
	 * 
	 * @param Filepath
	 * @return Properties
	 * @author mohdm @ this method is demanding the Filepath, if provided filepath
	 * invoked an create an objectfor properties data type and loading the entrie
	 * type @ in key and value pair and storing in prop variable and return the
	 * properties as data type
	 */
	
	// combination of getLocator and loadProperties is called  Object Repository Model
	public static Properties LoadProperties(String Filepath) { // define method return all the properties 
		prop = null;
		// notr if ttry catch doesnt work change the line to throw and see to it
		try {
			fis = new FileInputStream(Filepath); // define file path
		//	Log.info(Filepath + " invoked Successfully");
			//Reports.info("Properties file invocation ", Filepath + "invoke succesfully");
		} catch (FileNotFoundException e) {
		//	Log.info(Filepath + "not invoked successfully due to:" + e.fillInStackTrace().toString()); // to print error
																										// to the log
																										// file
		//	Reports.fail("Properties file not invocation",
				//	Filepath + "unable to invoke due to:" + e.fillInStackTrace().toString(), "");

		//	Reports.info("Properties file not invocation",
				//	Filepath + "unable to invoke due to:" + e.fillInStackTrace().toString() + " unable to invoked");
			e.printStackTrace();
		}
		prop = new Properties(); // defining the object to load the fis file
		// loading the file path if try catch not work use throw
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	} 
	
	// the order way it was happened in class as he is having exception handling issue 
	
/*	public static Properties loadProperty(String Filepath) throws FileNotFoundException {
		prop = null;
		fis = new FileInputStream(Filepath);
		prop = new Properties();
		try {
		prop.load(fis);
		} catch (IOException e) {
		e.printStackTrace();
		}
		return prop;
		} */
	// ------------------------------------

	public static WebElement getLocator(String key) throws InterruptedException { // to define locator and its parameter
																					// it basically ask give me the key
																					// i will find the web element
		element = null;
		locator_prop = Utility.LoadProperties("C:\\Users\\mohdm\\eclipse-workspace\\org.Selenum.GcReddy.MavenTraining\\src\\test\\resources\\Repository\\Locator.properties"); // define the locator to take file from class and read it
		
		String value = locator_prop.getProperty(key); // define value to store locator data in it
		System.out.println("value of the :" +key +" is = "+value);

		// differnt type of locators there are 8 locators maybe
		// i have commented becuase it shows error for the same
		if(key.endsWith("_id")) {
			element = driver.findElement(By.id(value));
			// highlight the element
			elementHighLight(element);
		} else if(key.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(value));
			elementHighLight(element);
		} else if(key.endsWith("_name")) {
			element = driver.findElement(By.name(value));
			elementHighLight(element);
		} else if(key.endsWith("_className")) {
			element = driver.findElement(By.className(value));
			elementHighLight(element);
		}

		return element;

	}
	public static void elementHighLight(WebElement element2) throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(300);
		js.executeScript("arguments[0].setAttribute('style','background:green; border 2px dotted yellow');", element);
		
	} 
	//--------------------------------------------------------------------------------------------

	/***************************************************************************************
	 * This function will close the current session in browser
	 *
	 * @throws IOException
	 **************************************************************************************/
	public static void closeBrowser() {
		try {
			driver.quit();
			Log.info("Closing Browser successfully... "); //saving in log file

		} catch (Exception e) {
			Reports.fail("Closing Browser", e.toString(), ""); // save in reports file if its fail
			Log.info("Closing the browser is failed..... due to :"+e.fillInStackTrace()); // saving in log file as well if its fail 
	}

	}
	//------------------------------------------------------------------------------
	// if multiple elements on the same locator then if you want to work with one element
	// provide the index and make it unique to work with it.
	// this method will  return List<WebElement>
	public static List<WebElement> ElementCollection(String xpath){
	
	List<WebElement> collections = driver.findElements(By.xpath(xpath));
	return collections;
	}	
	
	//-------------------------------------------------------------------------------------------------------------------
	// by default data and time format (default format) will return...
	// i.e. Fri May 27 19:48:53 IST 2022 // as per system time and date it will return
	public static void getCurrentDate() {
	Date date = new Date();
	System.out.println(date);
	}
	/***************************************************************************************
	 * This function will give you System date time in string format
	 *
	 * @return This function will return date time in String format.
	 **************************************************************************************/
	// 07-13-2022
	public static String getDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // coverting as defined fromat 
	Date date = new Date(); // default format it will take
	// Fri July 14 12:01:53 IST 2023
	String founddate = dateFormat.format(date); // covert them into as define above in simple data format type 
	//  2023/07/14(part 0) 12:01:53 (part 1)

	String[] parts = founddate.split(" "); // spillitng them by space
	String[] appenderpart1 = parts[0].split("/"); // splitting first date type using / button
	String appender = appenderpart1[1] + "-" + appenderpart1[2] + "-" + appenderpart1[0];
	return appender;
	//07-14-2023
	}
	
	/***************************************************************************************
	 * This function will give you System date time in string format
	 *
	 * @return This function will return date time in String format.
	 **************************************************************************************/
	// 0714130123
	public static String getDatetime() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String founddate = dateFormat.format(date);
	Log.info(dateFormat.format(date));    // 2023/07/14 13:01:48
	// String[] return for data format
	String[] parts = founddate.split(" "); // separtign them by space in parts
	// String part1 = parts[0]; // 004
	String[] appenderpart1 = parts[0].split("/"); // date is divinding in parts/
	String[] appenderpart2 = parts[1].split(":"); // time is dividing in parts 
	String appender = appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];
	Log.info(appender);
	return appender;
	//0714130148
	}
	/*****************************************************************************************
	 * This function wait implicitly for mentioned time duration.
	 *
	 * @exception Exception
	 ****************************************************************************************/
	public static void waitImplicit() {
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // use implicitly wait for 15 sec and making it as a resuable component
	}
	/*****************************************************************************************
	 * This function will dynamically wait for pageload. using explicit wait(fluent wait method define polling every 2 sec)
	 *
	 * @exception Exception
	 ****************************************************************************************/
	public static void Elementwait() throws Exception {
	    Log.info("Waiting for page load");
	WebDriverWait explicitwait = new WebDriverWait(driver, 120);
	explicitwait.withTimeout(60, TimeUnit.SECONDS); // overriding 120 sectp 60 sec in this line 
	explicitwait.pollingEvery(2, TimeUnit.SECONDS); // it will chec whether the element got avaiable or not
	explicitwait.ignoring(NoSuchElementException.class);// using within 60 if this error means it will ignore it and find it again 
	// explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img.timer.center-block")));
	}
	//----------------------------------------------------------------------------------------------
	public static void waitForElementClickable(String Key) throws InterruptedException {

	Log.info("Waiting for the Element to be clickable"); // using explicit fluent wait only and asking to wait so we can click on element
	WebDriverWait wait = new WebDriverWait(driver, 120);
	wait.withTimeout(60, TimeUnit.SECONDS);
	wait.pollingEvery(2, TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	wait.ignoring(InvalidSelectorException.class);
	wait.ignoring(WebDriverException.class);
	wait.until(ExpectedConditions.elementToBeClickable(Utility.getLocator("Key")));

	}
	/*****************************************************************************************
	* This function will dynamically wait for text on element to be present and display.
	*
	* @param Key
	* @param text
	* @throws InterruptedException
	* @exception Exception
	****************************************************************************************/
	public static void waitForTextToBeDisplayed(String Key) throws InterruptedException {
	Thread.sleep(1000);
	Log.info("Waiting for the Element to be visible");
	WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.withTimeout(80, TimeUnit.SECONDS);
	wait.pollingEvery(3, TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	wait.ignoring(InvalidSelectorException.class);
	wait.until(ExpectedConditions.visibilityOf(Utility.getLocator("Key")));
	}
	/*************************************************************************************
	* This function will get screenshot on Success of executed Test Cases.
	*
	* @return Filepath This function will return the String path of the
	*         screenshot.
	* @exception IOException
	**************************************************************************************/
	public static String getSuccessScreenshot() {
	try {
	filepath = null;
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	filepath = System.getProperty("user.dir") + "\\Screenshots\\SuccessScreenshots\\"
	+ System.currentTimeMillis() + ".png";
	FileUtils.copyFile(file, new File(filepath));
	} catch (IOException e) {
	Reports.fail("",e.toString(),"");
	e.printStackTrace();
	}
	return filepath;
	}
	/***************************************************************************************
	* This function will take screenshot on faliure of test cases.
	*
	* @return filepath
	* @see Use this function on negative secnarios.
	*
	**************************************************************************************/

	public static String getfailScreenshot() {
	try {
	filepath = null;
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	filepath = System.getProperty("user.dir") + "\\Screenshots\\FaliureScreenshots\\" + System.currentTimeMillis()
	+ ".png";
	FileUtils.copyFile(file, new File(filepath));
	} catch (IOException e) {
	Reports.fail("",e.toString(),"");
	e.printStackTrace();
	}
	return filepath;
	}
	/*******************************************************************************************
	* This function will clean the framework and will delete the files and
	* folder for specific mentioned time duration
	*
	* @param daysBack
	* @param dirWay
	******************************************************************************************/
	public static void FrameworkcleanUp(int daysBack, String dirWay) {

		File directory = new File(dirWay); // using this method to delete older file
		if (directory.exists()) {

			File[] listFiles = directory.listFiles();
			long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000); // purge means tiem define when to delete
																							//  example :if file delete at 9 pm means
																							// before purge is before 9pm
																						// after purge means it will delete means after 9pm																				
			for (File listFile : listFiles) {
				if (listFile.lastModified() < purgeTime) {
					if (!listFile.delete()) {
						System.err.println("Unable to delete file: " + listFile);
					}
				} 
			}
		}
	}

	
	
	

}