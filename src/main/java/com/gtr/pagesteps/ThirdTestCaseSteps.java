package com.gtr.pagesteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gtr.constants.GtrConstants;
import com.gtr.pageobject.ThirdTestCasePO;

public class ThirdTestCaseSteps {
	public WebDriver fireFoxDriver;

	public void driverSetUp() {
		System.setProperty("webdriver.gecko.driver",GtrConstants.geckoDriverPath);
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "src/main/resources/fireFox.txt");
		fireFoxDriver = new FirefoxDriver();
		fireFoxDriver.get(GtrConstants.NSE_INDIA_URL);
		fireFoxDriver.manage().window().maximize();
	}
	public void enterCompanyName(String companyName) {
		fireFoxDriver.findElement(By.xpath(ThirdTestCasePO.searchBox)).sendKeys(companyName);
		sleep(2000);
		fireFoxDriver.findElement(By.xpath(ThirdTestCasePO.searchBox)).sendKeys(Keys.ENTER);
	}
	public String fetchFaceValue() {
		return fireFoxDriver.findElement(By.xpath(ThirdTestCasePO.faceValue)).getText();
	}
	public String fetchHighWeekValue() {
		return fireFoxDriver.findElement(By.xpath(ThirdTestCasePO.weekHighValue)).getText();
	}
	public String fetchLowWeekValue() {
		return fireFoxDriver.findElement(By.xpath(ThirdTestCasePO.weekLowValue)).getText();
	}
	public void closeBrowser() {
		fireFoxDriver.close();
	}
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
