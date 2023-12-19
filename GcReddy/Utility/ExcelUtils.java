package org.Selenum.GcReddy.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.Selenum.GcReddy.Report.Log;
import org.Selenum.GcReddy.Report.Reports;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fis; // i make them instant variaable so i can call in class 
	public static XSSFWorkbook rwb;
	public static XSSFCell cell;
	public static XSSFSheet sheet;
	public static FileOutputStream fout;
	
	//----------------------------------
	/**
	 * 
	 * @param Filepath
	 * @author mohdm
	 * @throws IOException 
	 * @this method is invoking the provided excel sheet and verfiy whether the provided file is excel file or not  
	 */
	
	public static void invokeExcel(String Filepath) throws IOException {
	// the reason i use try and catch becuase it is reusable componemt if pass next line will go if fail it will go to catch 

	/*try {
		fis = new FileInputStream(Filepath);
		Log.info(Filepath + " the excel is inoved successfully"); /// its store in log file only if pass if fail it will go to catch section
		Reports.info("Excel Invocation", Filepath+ " invoke success"); // it ask two parameter so define in that way  // its stores in reports
	} catch (FileNotFoundException e) {
		e.printStackTrace(); // print to console
		Log.fail(Filepath + " due to file is not available excel not invoked" + e.fillInStackTrace()); // print to the log file
		Reports.fail("Excel invocation" ,Filepath+ "the browser is not invoked" +e.toString() , "error.png"); // print to the reports as well	
	}
	
	// working with xlsx file
	 try {
		rwb = new XSSFWorkbook(fis);
		Log.info("the xssfworkbook is recognised"); // if this is fail then it will go to catch section or else it wont go 
		
	} catch (IOException e) {
		e.printStackTrace(); // prints to console
		Log.info("the XSSFWorkbook is not due to"  + e.fillInStackTrace()); // to print to log file 
	} */
	
		FileInputStream fis = new FileInputStream(Filepath);
		rwb = new XSSFWorkbook(fis);
		
	}	
	
	//----------------------------------------
	/**
	 * 
	 * @param RowNum
	 * @param ColNum
	 * @return String
	 * @author mohdm
	 * @this method is pickignthe value either string or non string type using data formatter and stores into the String type
	 * @it will return string value 
	 */
	public static String getSpecificCellValue(int RowNum, int ColNum) { // use string isntead of void because it i asking return value so it is mandate ot use
		String value = null; // this line has t o use after you throw tht part this is mandate to use
		try {
		cell = sheet.getRow(RowNum).getCell(ColNum); // this will return string only to use intiger need to use data formatter
		value = cell.getStringCellValue();
		}catch(Exception e) {
			cell = sheet.getRow(RowNum).getCell(ColNum);
			DataFormatter format = new DataFormatter();
			value = format.formatCellValue(cell);
		}
		return value;  
	}
	//-----------------------------------
	/**
	 * 
	 * @param Sheet
	 * @return Object[][]
	 * @author mohdm
	 * @this method is demanding the sheetName and generating the Object[nur-1][nuc] and transferring the data from excel sheet and store into Object[][] and return into Object[][]
	 */
	
	public static Object[][] getData(String sheetName){ // the object called as double dimension array
	//data type	name of array
		Object[][] excelData = null;
		sheet = rwb.getSheet(sheetName);
		int nur = sheet.getPhysicalNumberOfRows();
		int nuc = sheet.getRow(0).getPhysicalNumberOfCells(); // if you select getrow of0 means it will select 1 row 
		// generating Object[][] using sheet data for[nur-1] [nuc].....
		excelData = new Object[nur-1][nuc];
		// defing the for loop to read the entire excel data
		// i and j represent excel sheet numbers
		//ci and cj represent double dimension array rows and column
		 int ci =0;
		 int i =1;
		 // I loop representing the number of rows
		for ( i=1; i<nur; i++ , ci++) {
			int cj=0;
			int j=0;
			// J loop representing no of column 
			for ( j=0; j<nuc; j++, cj++) {
				excelData [ci][cj]= getSpecificCellValue(i,j);
				System.out.println("Data store at index-- " + "Data[" + ci + "]" + "[" + cj + "]==>>" + "[" + i
						+ "]" + "[" + j + "]" + "--->" + excelData[ci][cj]);	
			}
		}
		
		return excelData;
	}
//---------------------------------------------------
	/**
	 * 
	 * 
	 */
	
	// ifyou want to write soemthin in excel in new colum this need to use //setData
	public static void setData(String Filepath, String value, int RowNum, int ColNum) {
		cell = sheet.getRow(RowNum).createCell(ColNum);
		cell.setCellValue(value);
		
	 try {
		fout = new FileOutputStream(Filepath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		rwb.write(fout);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
