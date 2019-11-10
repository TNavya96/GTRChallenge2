package com.gtr.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SixthTC {
	String url = "",j,gainersDate,losersDate;
    HttpURLConnection huc = null;
    int i, columnCount;
    List<Integer> l;
    WebDriver driver;
    Actions actions;
    Row newRow;
    Row row;
    XSSFSheet sheet; 
    Date date;
    SimpleDateFormat formatter;
    SoftAssert softAssert;
    List<Double> gainersList=new ArrayList<Double>();
    List<Double> losersList=new ArrayList<Double>();
    List<Double> list1 =new ArrayList<Double>();
    
	@Test(priority=1)
	public void basic() {
		try 
		{ 
			l= new ArrayList<Integer>();
			
		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");

         driver = new ChromeDriver();
         actions=new Actions(driver);
		driver.manage().window().maximize();
		Thread.sleep(5000);
    driver.get("https://www.nseindia.com/");
    Thread.sleep(3000);
   actions.moveToElement(driver.findElement(By.xpath("//a[text()='Live Market']"))).moveToElement(driver.findElement(By.xpath("//li[@id='main_liveany_ttg']//a"))).click().build().perform();
     gainersDate=driver.findElement(By.xpath("//span[@id='dataTime']")).getText(); 
     
     date = new Date();  
     formatter = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");  
     softAssert = new SoftAssert();
     
		}
  catch(Exception j) 
		{
	  
	  j.printStackTrace();
  }
		gainersData(driver);
		for(int i=1;i<sheet.getLastRowNum();i++) {
		gainersList.add(Double.parseDouble(getCellValue("./testdata/SixthQuestionExcelSheet.xlsx", "Gainers", i, 2)));
		losersList.add(Double.parseDouble(getCellValue("./testdata/SixthQuestionExcelSheet.xlsx", "Losers", i, 2)));
		}
		list1.addAll(gainersList);
		Collections.sort(gainersList, Collections.reverseOrder());
		softAssert.assertEquals(gainersList, list1,"% change of Gainers data retrieved from table is not from high to low");
		list1.removeAll(list1);
		list1.addAll(losersList);
		Collections.sort(losersList, Collections.reverseOrder());
		softAssert.assertEquals(losersList, list1, "% change of losers data retrieved from table is not from high to low");
		
		}
	
	public  void gainersData(WebDriver driver)
{
		try {
			System.out.println("gainers");
			
		File f=new File("./testdata/SixthQuestionExcelSheet.xlsx");
		
		FileInputStream fileInput = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
	    sheet = workbook.getSheet("Gainers");
		
		Thread.sleep(5000);
		   int rowCount=driver.findElements(By.xpath("//table[@id='topGainers']/tbody/tr")).size();
		   System.out.println("row count ::  "+rowCount);
		   columnCount=driver.findElements(By.xpath("//table[@id='topGainers']/tbody/tr[1]/th")).size();
		   System.out.println("column count ::   "+columnCount);
		   for(int i=1;i<=rowCount;i++)
		   {
			   newRow = sheet.createRow(i-1);
			  
			   for(int j=1;j<=columnCount;j++) {
				  
		 
				   if(i==1) {

			
					   newRow.createCell(j-1).setCellValue(driver.findElement(By.xpath("//table[@id='topGainers']/tbody/tr["+i+"]/th["+j+"]")).getText());
				   }
					   else {
					   newRow.createCell(j-1).setCellValue(driver.findElement(By.xpath("//table[@id='topGainers']/tbody/tr["+i+"]/td["+j+"]")).getText());
				   }
				   
			   }
			       
		   }
		   fileInput.close();
		   FileOutputStream outputStream = new FileOutputStream(f);
		   workbook.write(outputStream);
		   outputStream.close();
		
		}
		catch(Exception h) {
			
			
			
		}
		losersData(driver);
		
	}
	
	public  void losersData(WebDriver driver) {
		try {
			System.out.println("losers");
			
			driver.findElement(By.xpath("//a[@id='tab8']")).click();
			
			Thread.sleep(5000);
			losersDate=driver.findElement(By.xpath("//span[@id='dataTime']")).getText(); 
								
		    
		
		File f=new File("./testdata/SixthQuestionExcelSheet.xlsx");
		
		FileInputStream fileInput = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("Losers");
		
		Thread.sleep(5000);
		   int rowCount=driver.findElements(By.xpath("//table[@id='topLosers']/tbody/tr")).size();
		   System.out.println("row count ::  "+rowCount);
		   columnCount=driver.findElements(By.xpath("//table[@id='topLosers']/tbody/tr[1]/th")).size();
		   System.out.println("column count ::   "+columnCount);
		   for(int i=1;i<=rowCount;i++)
		   {
			   newRow = sheet.createRow(i-1);
			  
			   for(int j=1;j<=columnCount;j++) {
				  
		 
				   if(i==1) {

			
					   newRow.createCell(j-1).setCellValue(driver.findElement(By.xpath("//table[@id='topLosers']/tbody/tr["+i+"]/th["+j+"]")).getText());
					  
				   }
					   else {
					   newRow.createCell(j-1).setCellValue(driver.findElement(By.xpath("//table[@id='topLosers']/tbody/tr["+i+"]/td["+j+"]")).getText());
					  
					   }
				   
			   }
			       
		   }
		   fileInput.close();
		   FileOutputStream outputStream = new FileOutputStream(f);
		   workbook.write(outputStream);
		   outputStream.close();
		
		}
		catch(Exception h) {
			
			
			
		}
		
		
	}
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
	@Test(priority=2)
	public void compareGainersDate() {
		
	
	softAssert.assertEquals(gainersDate.substring(6,27).replace(",", "").trim(), formatter.format(date).trim(),"Gainers data from NSE retrieved is not matching with system date");
    softAssert.assertAll();
	}
	@Test(priority=3)
	public void compareLosersDate() {
		
	     System.out.println("losers date is"+losersDate);
	     date = new Date();  
	     formatter = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");  
	    
	    assertEquals(losersDate.substring(6,27).replace(",", "").trim(), formatter.format(date).trim(),"losers data from NSE retrieved is not matching with system date");
	}
	

}
