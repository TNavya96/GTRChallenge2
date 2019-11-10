package com.gtr.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FifthTC {
	
	
    @Test
    public void bannerSlider() throws InterruptedException {
    	ChromeDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        driver.get("https://www.shoppersstop.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        for(int s=0;s<6;s++) {
        	
        
        driver.findElement(By.xpath("//div[@class='dy-slick-arrow dy-next-arrow slick-arrow'][1]")).click();
        }
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.xpath("//a[@title='MEN']"));
        actions.moveToElement(target).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("/html/body/main/nav/div[2]/div/ul/li[4]/div/div/ul/li[6]/a"))).perform();
        Thread.sleep(5000);
        List<WebElement> allElements=driver.findElements(By.xpath("//a[contains(@href,'/beauty-fragrance-for-men')]"));
        for(int k=0;k<=allElements.size()-1;k++) {
        	System.out.println(allElements.get(k).getText());
        	System.out.println();
        }
        /*
         * WebElement target1 = driver.findElement(By.xpath(""));
         * actions.moveToElement(target1).perform();
         * //(//a[contains(text(),"Men's Fragrance")])[3]
         */
        
      
      
        driver.findElement(By.xpath("(//a[contains(text(),\"All Stores\")])[1]")). click();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.id("city-name")));
        List<WebElement> options = dropdown.getOptions();
        int count = options.size();
        for(int i=0;i<count;i++) {
        System.out.println( options.get(i).getText());
        }
        System.out.println("Printing the page title" +driver.getTitle());
        driver.close();
      }
}
