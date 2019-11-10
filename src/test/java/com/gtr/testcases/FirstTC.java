package com.gtr.testcases;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
public class FirstTC {
    HttpURLConnection huc = null;
    int respCode;
    WebDriver driver;
    @Test
    public void question1() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("http://agiletestingalliance.org/");
        driver.findElement(By.xpath("//a[text()='Certifications']")).click();
        
        List<WebElement> icons = driver.findElements(By.xpath("//area[@target='_self']"));
        Actions actions=new Actions(driver);
        System.out.println("count of icons is  " + icons.size());
        for (int i = 1; i <= icons.size(); i++) {
            Thread.sleep(5000);
            mouseHover();
            Thread.sleep(4000);
            EventFiringWebDriver event1=new EventFiringWebDriver(driver);
            File f3=event1.getScreenshotAs(OutputType.FILE);
            File f4=new File("./sct5.png");
            FileUtils.copyFile(f3, f4);
            driver.findElement(By.xpath("(//area[@target='_self'])[" + i + "]")).click();
            String url = driver.getCurrentUrl();
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                    EventFiringWebDriver event=new EventFiringWebDriver(driver);
                    File f1=event.getScreenshotAs(OutputType.FILE);
                    File f2=new File("./sc"+i+".png");
                    FileUtils.copyFile(f1, f2);
                } else {
                    System.out.println(url + " is a valid link");
                    
                    
                }
            } catch (MalformedURLException e) {
                
                e.printStackTrace();
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            driver.navigate().back();
        }
    }
    public void mouseHover(){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@shape='rect'])[4]s"))).click().perform();
    }
}
