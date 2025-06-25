package Runner;


import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "C:/Users/praveen.tripathi/eclipse-workspace/Selenium_Automation_TestNG/src/test/resources/Features",
	    glue = {"/stepDefinitions", "hooks"},               // hooks package should be added here
	    dryRun=false,
	    publish=false,
	    plugin= {"pretty","html:target/CucumberReports/CucumberReport.html"},
	    tags="@all"                      // "@regression or @smoke", "@regression and @smoke"
	   // monochrome = true            // This is optional and no need to use in cucumber latest version as we don't get junk text in eclipse output console.
	    )


public class TestRunner extends AbstractTestNGCucumberTests {
	
	@AfterSuite
    public static void renameReport() {
        try {
            String timestamp = new java.text.SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new java.util.Date());
            java.nio.file.Path source = java.nio.file.Paths.get("target/CucumberReports/CucumberReport.html");
            java.nio.file.Path target = java.nio.file.Paths.get("target/CucumberReports/CucumberReport_" + timestamp + ".html");

            java.nio.file.Files.move(source, target, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Report renamed to: " + target.toAbsolutePath());

        } catch (Exception e) {
            System.err.println("Failed to rename report: " + e.getMessage());
        }
    }
	

}
