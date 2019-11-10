package com.gtr.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.gtr.pagesteps.FourthTestCaseSteps;

public class FourthTC extends FourthTestCaseSteps {
	@Test
	public void fourthQuestion() throws IOException {
		driverSetUp();
		for(int i=0;i<4;i++) {
			sleep(2000);
			enterCompanyName(getCellValue("./testdata/ForthTcTestData.xlsx", "Sheet1", i, 0));
			sleep(4000);
			EventFiringWebDriver event1=new EventFiringWebDriver(chromeDriver);
			File f3=event1.getScreenshotAs(OutputType.FILE);
			File f4=new File("./ScreenShots/TestCase4SC"+i+".png");
			FileUtils.copyFile(f3, f4);
			System.out.println(getCellValue("./testdata/ForthTcTestData.xlsx", "Sheet1", i, 0)+" face value is"+fetchFaceValue());
			System.out.println(getCellValue("./testdata/ForthTcTestData.xlsx", "Sheet1", i, 0)+" 52 high week value is"+fetchHighWeekValue());
			System.out.println(getCellValue("./testdata/ForthTcTestData.xlsx", "Sheet1", i, 0)+" 52 Low week value is"+fetchLowWeekValue());
		}
		closeBrowser();
	}


}
