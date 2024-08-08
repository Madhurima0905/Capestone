package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.DashBoardPage;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class DashBoardTestCase extends BaseTest {
	
	
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	
	@Test(priority =1) //this will execute first 
	void testcourses()
	{
		//Object of LoginPage to perform login
		LoginPage lp=new LoginPage(driver); 
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0); //row 1, column 0
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1); // row 1, column 1
		lp.loginToPortal(username, password); //call method loginToPortal from LoginPage
		
		// create the object of DashBoardPage
		DashBoardPage dp = new DashBoardPage(driver); 
		
		// calling the method from DashBoardPage
		dp.dashboardClick();
		
	}

}
