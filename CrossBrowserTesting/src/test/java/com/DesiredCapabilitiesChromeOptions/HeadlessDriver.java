package com.DesiredCapabilitiesChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


/**How to open a window in headless mode.
 * It is faster than regular mode.
 * There are some disadvantages in disadvantages mode--
 * it can not do some functionalities
 * @author Faruq
 *
 */
public class HeadlessDriver {
    WebDriver driver;
	@Test(priority = 1)
	public void headlessMode() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);	
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	
	}
	
	@Test(priority = 2)
	public void headlessModeAnotherMethod() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);	
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
