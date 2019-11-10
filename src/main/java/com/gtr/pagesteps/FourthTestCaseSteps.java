package com.gtr.pagesteps;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gtr.constants.GtrConstants;
import com.gtr.pageobject.ThirdTestCasePO;

import io.qameta.allure.Step;

public class FourthTestCaseSteps {
	public WebDriver chromeDriver;
	public void driverSetUp(){
		Properties prop=new Properties();
	 System.setProperty("webdriver.chrome.driver",GtrConstants.chromeDriverPath);
	 chromeDriver=new ChromeDriver();
	 chromeDriver.get(GtrConstants.NSE_INDIA_URL);
	 chromeDriver.manage().window().maximize();
	}
	@Step("get data from excel")
	public static String getCellValue(String path,String sheet,int r,int c)
	{
		String data="";
		try{
			
			data=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public void enterCompanyName(String companyName) {
		chromeDriver.findElement(By.xpath(ThirdTestCasePO.searchBox)).sendKeys(companyName);
		sleep(3000);
		chromeDriver.findElement(By.xpath(ThirdTestCasePO.searchBox)).sendKeys(Keys.ENTER);
	}
	public String fetchFaceValue() {
		return chromeDriver.findElement(By.xpath(ThirdTestCasePO.faceValue)).getText();
	}
	public String fetchHighWeekValue() {
		return chromeDriver.findElement(By.xpath(ThirdTestCasePO.weekHighValue)).getText();
	}
	public String fetchLowWeekValue() {
		return chromeDriver.findElement(By.xpath(ThirdTestCasePO.weekLowValue)).getText();
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
