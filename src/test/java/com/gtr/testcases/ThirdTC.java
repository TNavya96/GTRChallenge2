package com.gtr.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.gtr.pagesteps.SecondTestCaseSteps;
import com.gtr.pagesteps.ThirdTestCaseSteps;

public class ThirdTC {
	@Test
	public void thirdQuestion() throws IOException {
		ThirdTestCaseSteps thirdTestCaseSteps=new ThirdTestCaseSteps();
		thirdTestCaseSteps.driverSetUp();
		
		thirdTestCaseSteps.enterCompanyName("Eicher Motors Limited");
		thirdTestCaseSteps.sleep(3000);
		EventFiringWebDriver event1=new EventFiringWebDriver(thirdTestCaseSteps.fireFoxDriver);
		File f3=event1.getScreenshotAs(OutputType.FILE);
		File f4=new File("./ScreenShots/TestCase3SC.png");
		FileUtils.copyFile(f3, f4);
		System.out.println(thirdTestCaseSteps.fetchFaceValue());
		System.out.println(thirdTestCaseSteps.fetchHighWeekValue());
		System.out.println(thirdTestCaseSteps.fetchLowWeekValue());
		thirdTestCaseSteps.closeBrowser();

	}

}
