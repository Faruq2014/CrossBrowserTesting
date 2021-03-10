package com.DesiredCapabilitiesChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * how to handle SSL certificate in chrome options
 * @author Faruq
 *
 */
public class SSLcertificate {
	WebDriver driver;

	@Test(priority = 1)
	public void accepctFalseByCapabilities() {
		WebDriverManager.chromiumdriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		// desired capabilities is common class from org.openqa.selenium.remote
		// it is deprecated because after 3.6 version all the browser
		// has their own options such as ChromeOptions. And all the
		// browser has more flexibilities or methods than capabilities.
		
		caps.setAcceptInsecureCerts(false);
		driver = new ChromeDriver(caps);
		driver.get("https://www.cacert.com/");
	}

	@Test(priority = 2)
	public void accepctFalseByOptions() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		// Chrome has it own ChromeOptions. And all the
		// browser has more flexibilities or methods than capabilities.
		options.setAcceptInsecureCerts(false);
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
	}

	@Test(priority = 3)
	public void accepctTrueByOptions() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
	}
}
