package com.gtr.commonsteps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import com.gtr.constants.GtrConstants;
import com.gtr.pagesteps.SecondTestCaseSteps;

public class BasePage {
	
	
	
	public WebDriver driver;
	public WebDriver getWebDriver() {
		return driver;
	}
	
	public WebDriver driverInitialization(String browser){
		
		
		if(browser.equals("chrome")) {
		
		 System.setProperty("webdriver.chrome.driver",GtrConstants.chromeDriverPath);
		 driver=new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", GtrConstants.geckoDriverPath);
			 System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		     System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "src/main/resources/fireFox.txt");
			 driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
		 
		}
	
}


