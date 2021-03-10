package com.DesiredCapabilitiesChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**How to open a window and disable info bar.
 * @author Faruq
 *
 */
public class GetInformation {
    WebDriver driver;
	@Test(priority = 1)
	public void getAllInformation() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);	
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars"); // it does not work.
		System.out.println("Browser name "+options.getBrowserName());
		System.out.println("Version name "+options.getVersion());
		System.out.println("Capability name "+options.getCapabilityNames());
		System.out.println("Platform name "+options.getPlatform());
		
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
		
	}
}
