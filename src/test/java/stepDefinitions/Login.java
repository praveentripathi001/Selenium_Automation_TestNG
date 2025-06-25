package stepDefinitions;

import pageMethods.LoginPageMethods;

import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	
	
LoginPageMethods loginPage = new LoginPageMethods();
	

	@Given("user navigates to Login page")
	public void user_navigates_to_login_page() {
		driver = driverFactory.getDriver();
		System.out.println("Driver from Step: " + driver);
		loginPage.LoginPage();
		
	}

	@When("User enters valid email address {string}")
	public void user_enters_valid_email_address(String email) {
		loginPage.enter_Email(email);
	}

	@When("Enters valid password {string}")
	public void enters_valid_password(String password) {
		loginPage.ente_Password(password);
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		loginPage.click_login_button();
		LoginPageMethods.wait(10);
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		loginPage.login_Successful();
		System.out.println("Login success");
	}

	@When("User enters an invalid email address {string}")
	public void user_enters_an_invalid_email_address(String email) {
		//driver.findElement(By.id("input-email")).sendKeys(email);
		System.out.println("Enter invalid Email Address");
	}

	@When("Enters invalid password {string}")
	public void enters_invalid_password(String password) {
	//	driver.findElement(By.id("input-password")).sendKeys(password);
		System.out.println("Enter Password");
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {
		
//		String text = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissibl')]")).getText();
//		System.out.println("Manual Print:"+ text);
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissibl')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		//System.out.println("Login Failed");
	}

	@When("user do not enter any credential")
	public void user_do_not_enter_any_credential() {
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissibl')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		System.out.println("Credentials not entered");
	}
	
	//--------Scenario Outline -----------------------//
	
	
	@When("Enters valid password in password field (.+)$")
	public void enters_valid_password_in_password_field(String password) {
		System.out.println(">> User has entered valid password: "+ password);
	}

	@When("User enters valid email address in email field (.+)$")
	public void user_enters_valid_email_address_in_email_field(String email) {
		System.out.println(">> User has entered valid email address: "+ email);
	}

	
	



}
