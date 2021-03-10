package com.DesiredCapabilitiesChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**How to maximize a window.
 * @author Faruq
 *
 */
public class Maximize {
    WebDriver driver;
	@Test(priority = 1)
	public void howToMaximizeAwindow() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);	
		options.addArguments("--start-maximized");		
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
		
	}
}
