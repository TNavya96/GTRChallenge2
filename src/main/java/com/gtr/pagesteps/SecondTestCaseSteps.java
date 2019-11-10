package com.gtr.pagesteps;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gtr.commonsteps.BasePage;
import com.gtr.constants.GtrConstants;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecondTestCaseSteps {
	public WebDriver chromeDriver;
	public void driverSetUp(){
		Properties prop=new Properties();
	 System.setProperty("webdriver.chrome.driver",GtrConstants.chromeDriverPath);
	 chromeDriver=new ChromeDriver();
	 chromeDriver.get(GtrConstants.NSE_INDIA_URL);
	 chromeDriver.manage().window().maximize();
	}
	
	@Step("fetch all values using find elements")
	public List<WebElement> fetchValues() {
		
		
		return chromeDriver.findElements(By.xpath("(//ul[@class='advanceTab']/li/span)"));
		
	}

	public void closeBrowser(){
		chromeDriver.close();
	}
}
