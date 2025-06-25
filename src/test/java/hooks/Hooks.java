package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	
	@Before
	public void setup (Scenario scenario)                                               //Hooks - @Before from io.cucumber.java.Before
	{	
		System.out.println("Cucumber @Before Hook triggered");
		driverFactory.initializeBrowser("chrome"); 
		driver = driverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@After                                                             
	public void tearDown (Scenario scenario)                                            //Hooks - @After from io.cucumber.java.After
	{
		driver = driverFactory.getDriver();
		driver.close();
		//System.out.println("++ Browser got Closed.");
		//System.out.println(" ** Execution ended for Scenario: " +scenario.getName());
	}
	
//	// BeforeStep and AfterStep hooks - Runs before and after execution of each step.
//	@BeforeStep
//	public void beforeStepHook() {
//		System.out.println("++ Before Every Step hook");
//	}
//	
//	@AfterStep
//	public void afterStepHook() {
//		System.out.println("++ After Every Step hook");
//	}
//	

	
}
