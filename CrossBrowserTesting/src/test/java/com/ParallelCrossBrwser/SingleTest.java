package com.ParallelCrossBrwser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleTest {
           WebDriver driver;
	@BeforeTest
	@Parameters("browser") 
	public void setupBrowser(String browser) throws Exception {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")){
         WebDriverManager.firefoxdriver().setup();
         driver= new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}else{
			//If no browser passed throw exception
		throw new Exception("Browser is not correct");}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void workDayTest() {
		driver.get("https://www.workday.com/");
		System.out.println(driver.getCurrentUrl());
	}
	@Test(priority=2)
	public void test() {
		driver.get("https://www.salesforce.com/");
		System.out.println(driver.getTitle());
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
