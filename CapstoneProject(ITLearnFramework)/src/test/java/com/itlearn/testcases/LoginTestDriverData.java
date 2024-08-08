package com.itlearn.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class LoginTestDriverData extends BaseTest {
	// fileNames stores the location of file
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	
	@Test(priority =1,dataProvider="LoginDataProvider")
	void verifyLogin(String userEmail,String userPwd) throws IOException
	{
		// Invoked the functionality of login page
		LoginPage lp=new LoginPage(driver);
		// String username="Demo12";
		// String password="Test123456$";
		lp.loginToPortal(userEmail, userPwd);
		
		// validates the credentials from Excel sheet
		if(userEmail.equals("Demo12") && userPwd.equals("Test123456$")) 
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			// call logout method to validate remaining test data
			lp.logout();
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		
		// getRowCount takes two parameter
		int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
		// getColCount takes two parameter
		int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		// iterates the value as per for loop
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}
}
