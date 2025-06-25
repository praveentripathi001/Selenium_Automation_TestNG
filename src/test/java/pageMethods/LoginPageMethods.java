package pageMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.driverFactory;

public class LoginPageMethods {

	WebDriver driver;

	
	public static void wait(int seconds) {
        try {
            Thread.sleep(seconds);  // convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); // restore interrupt status
        }
    }
	
	public void LoginPage() {
		driver = driverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Login")).click();
	}
	
	public void enter_Email(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}
	
	public void ente_Password (String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	
	public void click_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	public void login_Successful () {
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	
}
