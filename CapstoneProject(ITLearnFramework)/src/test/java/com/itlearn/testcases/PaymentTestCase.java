package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.DashBoardPage;
import com.itlearn.pages.LoginPage;
import com.itlearn.pages.PaymentPage;
import com.itlearn.utility.ReadExcelFile;

public class PaymentTestCase extends BaseTest{
	
String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	
	@Test(priority =1)
	void testcourses()
	{
		// invoke login page 
		LoginPage lp=new LoginPage(driver);
		
		// fetch the values for Excel sheet
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		
		// pass the values
		lp.loginToPortal(username, password);
		
		// object of DashBoardPage
		DashBoardPage dp = new DashBoardPage(driver);
		
		// calling dashboardClick method
		dp.dashboardClick();
		
		// object of payment page 
		PaymentPage pg= new PaymentPage(driver);
		
		// fetch the values for Excel sheet
		String crdnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 0);
		String expdate=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 1);
		String cvcnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 2);
		
		// calling paymentOption method from Payment Page
		pg.paymentOption(crdnum, expdate, cvcnum);
		
	}

}
