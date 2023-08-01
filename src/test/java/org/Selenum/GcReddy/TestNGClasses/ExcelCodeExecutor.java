package org.Selenum.GcReddy.TestNGClasses; 

import java.io.IOException;

import org.Selenum.GcReddy.Utility.ExcelUtils;
import org.testng.annotations.Test;

public class ExcelCodeExecutor {
  @Test
  public void ExcelCodeexecution() throws IOException {
	  
	  ExcelUtils.invokeExcel("ExcelData.xlsx");
	  ExcelUtils.getData("abcd");
	  ExcelUtils.setData("asdfg.xlsx", "Success", 6, 5);
  }
}
