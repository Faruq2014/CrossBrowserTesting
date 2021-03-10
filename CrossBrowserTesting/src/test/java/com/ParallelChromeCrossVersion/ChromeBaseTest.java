package com.ParallelChromeCrossVersion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBaseTest {
	WebDriver driver;

	@BeforeClass
	@Parameters("ChromeDriverVersion")
	public void setup(String ChromeDriverVersion) throws Exception {
		
		if (ChromeDriverVersion.equalsIgnoreCase("latest")) {
			WebDriverManager.chromedriver().setup();// 87.0.4280.20
			driver = new ChromeDriver();
			 CheckBrowserOS();

		} else if (ChromeDriverVersion.equalsIgnoreCase("87")) { // it is also the latest version

			WebDriverManager.chromedriver().driverVersion("87.0.4280.20").setup();// 87.0.4280.20
			 WebDriverManager.chromedriver().browserVersion("87").setup();
			driver = new ChromeDriver();
			 CheckBrowserOS();
		} else if (ChromeDriverVersion.equalsIgnoreCase("86")) {
			WebDriverManager.chromedriver().driverVersion("86.0.4240.22").setup();
			 WebDriverManager.chromedriver().browserVersion("86").setup();
			driver = new ChromeDriver();
			 CheckBrowserOS();
		}else if (ChromeDriverVersion.equalsIgnoreCase("85")) {
			WebDriverManager.chromedriver().driverVersion("85.0.4183.87").setup();
			 WebDriverManager.chromedriver().browserVersion("85").setup();
			driver = new ChromeDriver();
			 CheckBrowserOS();
		}else if (ChromeDriverVersion.equalsIgnoreCase("2.46")) {	
			 WebDriverManager.chromedriver().driverVersion("2.46").setup();//2.26.436362
			 WebDriverManager.chromedriver().browserVersion("71").setup();
			 driver = new ChromeDriver();
			 CheckBrowserOS();
		}   else if (ChromeDriverVersion.equalsIgnoreCase("2.44")) {

			 WebDriverManager.chromedriver().driverVersion("2.44").setup();//2.44.609538
			 WebDriverManager.chromedriver().browserVersion("70").setup();
			 driver = new ChromeDriver();
			 CheckBrowserOS();
		}
          
		else {
			// If wrong browser passed throw exception
			throw new Exception("Browser version is not correct");
		}
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ChromeOptions options = new ChromeOptions();
		System.out.println("Browser name "+options.getBrowserName());
		System.out.println("Version name "+options.getVersion());
		System.out.println("Capability name "+options.getCapabilityNames());
		System.out.println("Platform name "+options.getPlatform());
		
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

	@AfterClass
	public void tearDownTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
