package com.ParallelCrossBrwser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome86 {
	// browser and driver compatibility
	//https://support.leapwork.com/hc/en-us/articles/360004941392-Web-Browser-and-Driver-Compatibility-Matrix-LEAPWORK
	WebDriver driver;
	//@Test
	public void m1Test() { 
		//WebDriverManager.chromedriver().setup();//latest 
		//WebDriverManager.chromedriver().driverVersion("87.0.4280.20").setup();//original
		WebDriverManager.chromedriver().driverVersion("81").setup();
		 WebDriverManager.chromedriver().browserVersion("89").setup();
		driver = new ChromeDriver();
		CheckBrowserOS();
		driver.get("https://www.salesforce.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

	//@Test
	public void m2Test() {
		WebDriverManager.chromedriver().driverVersion("86.0.4240.22").setup();
		 WebDriverManager.chromedriver().browserVersion("86").setup();
		driver = new ChromeDriver();
		CheckBrowserOS();
		driver.get("https://www.salesforce.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	//@Test
	public void m3Test() {
		WebDriverManager.chromedriver().driverVersion("85.0.4183.87").setup();
		 WebDriverManager.chromedriver().browserVersion("85").setup();
		driver = new ChromeDriver();
		CheckBrowserOS();
		driver.get("https://www.salesforce.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void m4Test() {
		WebDriverManager.chromedriver().driverVersion("2.46").setup();
		WebDriverManager.chromedriver().browserVersion("71").setup();
		driver = new ChromeDriver();
		CheckBrowserOS();
		driver.get("https://www.salesforce.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	//@Test
	public void m5Test() {
		WebDriverManager.chromedriver().driverVersion("2.44").setup();
		 WebDriverManager.chromedriver().browserVersion("70").setup();
		driver = new ChromeDriver();
		CheckBrowserOS();
		driver.get("https://www.salesforce.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	

	public void CheckBrowserOS() {
		// Get Browser name and version.
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
	

		// Get OS name.
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("OS = " + os + ", Browser = " + browserName + " " + browserVersion);
	}
}
