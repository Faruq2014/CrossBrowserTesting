package com.DesiredCapabilitiesChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**How to merge capabilities and options together, if you have to use both 
 * implementations in the same class at a time.
 * @author Faruq
 *
 */
public class Merge {
    WebDriver driver;
    
	@Test(priority = 1)
	public void merge() {
		WebDriverManager.chromiumdriver().setup();// setting up the bianiary file
		
		DesiredCapabilities caps = new DesiredCapabilities(); // using desired capabilities methods
		caps.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();	// using chrome options method.
		options.addArguments("--start-maximized");
		
		options.merge(caps); // merging both method together.
		
		driver = new ChromeDriver(options);
		driver.get("https://www.cacert.com/");
		
	}
}
