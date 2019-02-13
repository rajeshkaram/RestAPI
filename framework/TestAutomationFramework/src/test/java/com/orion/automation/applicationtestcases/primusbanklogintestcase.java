package com.orion.automation.applicationtestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orion.automation.applicationpages.primusbankloginpage;
import com.orion.automation.excelreader.ExcelReader;
import com.orion.automation.testbase.Testbase;
import com.relevantcodes.extentreports.LogStatus;


public class primusbanklogintestcase extends Testbase{
	
	
	String sheetName = "test";
	
		primusbankloginpage	 abc;
		
		
		
		 
		 
	      @Test(dataProvider ="getDataExcel")
	      
	      public void loginTest(String us, String pa) throws Exception {
	    	  primusbankloginpage abc=new primusbankloginpage(driver);
	            abc.orion(us, pa);
	            Logger=report.startTest("Login", "verify login page");
	      }

	
	      @DataProvider
	      public Object[][] getDataExcel() throws Exception{
	      Object data[][] = ExcelReader.getTestData(sheetName);
	      return data;
		 }
		 


	}


