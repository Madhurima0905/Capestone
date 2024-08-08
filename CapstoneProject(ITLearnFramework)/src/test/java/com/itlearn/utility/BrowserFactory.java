package com.itlearn.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver, String browser,String url)
	{
		
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver(); // invokes chrome driver setup method
			driver=new ChromeDriver(); // initialized value to driver
		}
		
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
		}
		
		else if(browser.equals("IE"))
		{
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
		
		else
		{
			System.out.println("no browser is supportabe");
		}
		
		// to maximize window
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.quit(); // quit() close all browsers
	}
}