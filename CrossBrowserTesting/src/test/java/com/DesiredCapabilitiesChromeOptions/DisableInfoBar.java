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
public class DisableInfoBar {
    WebDriver driver;
	@Test(priority = 1)
	public void disableInformationBar() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);	
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars"); // it does not work.
		
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
		
	}
}
