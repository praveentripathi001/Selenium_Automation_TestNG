package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {

	static WebDriver driver = null;
	
	
	public static void initializeBrowser (String browserName) {	
		
		//boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
		System.out.println("Initializing browser: " + browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	
}
