package com.itlearn.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	// create instance of WebDriver
	WebDriver driver;
	//constructor
		public DashBoardPage(WebDriver lDriver) 
		{
			this.driver=lDriver;
			
			PageFactory.initElements(driver,this); //initializes value to element
		}
		
		@FindBy(xpath="//*[@id=\"login-list\"]/li[1]/a") WebElement dashboardclick; 
		
		@FindBy(xpath="//*[@id=\"learn-press-user-profile\"]/ul/li[3]") WebElement offerAcademeis;
		
		@FindBy(xpath="//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button") WebElement subscribeButton;
		
		
		public void dashboardClick()
		{
			// defining, not performing actions here
			dashboardclick.click();
			offerAcademeis.click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",subscribeButton); //forcefully clicks on Subscribe button
		}
}
