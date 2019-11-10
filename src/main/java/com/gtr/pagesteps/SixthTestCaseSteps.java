package com.gtr.pagesteps;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gtr.constants.GtrConstants;
import com.gtr.pageobject.SixthTestCasePO;

public class SixthTestCaseSteps {
	public WebDriver chromeDriver;
	public void driverSetUp(){
		Properties prop=new Properties();
	 System.setProperty("webdriver.chrome.driver",GtrConstants.chromeDriverPath);
	 chromeDriver=new ChromeDriver();
	 chromeDriver.get(GtrConstants.NSEURL2);
	 chromeDriver.manage().window().maximize();
	}
	public void moveMouseToLiveMarket() {
		Actions actions=new Actions(chromeDriver);
		actions.moveToElement(chromeDriver.findElement(By.xpath(SixthTestCasePO.liveMarket))).perform();;
	}
	public void moveMouseToTopTenGainersOrLosers() {
		Actions actions=new Actions(chromeDriver);
		actions.moveToElement(chromeDriver.findElement(By.xpath(SixthTestCasePO.topTenGainersOrLosers))).click().perform();
	}
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeBrowser() {
		chromeDriver.close();
	}


}
