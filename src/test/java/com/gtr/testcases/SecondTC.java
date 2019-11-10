package com.gtr.testcases;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.gtr.commonsteps.BasePage;
import com.gtr.pagesteps.SecondTestCaseSteps;

public class SecondTC extends BasePage {

	
	
	
	
	@Test
	public void firstQuestion() {
		SecondTestCaseSteps secondTestCaseSteps=new SecondTestCaseSteps();
		secondTestCaseSteps.driverSetUp();
		List<Integer> list=new ArrayList<Integer>();
	    for(int i=0;i<3;i++) {
	    	
	    	list.add(Integer.parseInt(secondTestCaseSteps.fetchValues().get(i).getText()));
	    }
	    Collections.sort(list);
	    System.out.println("min value is "+ list.get(0));
	    secondTestCaseSteps.closeBrowser();
	    

	    
	   
	}
}
