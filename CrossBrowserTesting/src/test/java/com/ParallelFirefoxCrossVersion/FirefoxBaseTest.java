package com.ParallelFirefoxCrossVersion;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxBaseTest {
WebDriver driver;

@BeforeTest
@Parameters ("FirefoxBrowserVersion")
public void setupBrowser(String FirefoxBrowserVersion) throws Exception {
	if (FirefoxBrowserVersion.equalsIgnoreCase("latest")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		CheckBrowserOS();
	} else if (FirefoxBrowserVersion.equalsIgnoreCase("82.0")){
		WebDriverManager.firefoxdriver().driverVersion("82.0").setup();
		driver=new FirefoxDriver();
		CheckBrowserOS();
	}else {
		throw new Exception("wrong driver version");
	}
	driver.get("https://www.facebook.com/");
}

public void CheckBrowserOS() {
	  //Get Browser name and version.
	  Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	  String browserName = caps.getBrowserName();
	  String browserVersion = caps.getVersion();
	  
	  //Get OS name.
	  String os = System.getProperty("os.name").toLowerCase();
	  System.out.println("OS = " + os + ", Browser = " + browserName + " "+ browserVersion);
	 }

@AfterTest
public void tearDown() {
	if (driver !=null) {
		driver.quit();
	}
}

}
