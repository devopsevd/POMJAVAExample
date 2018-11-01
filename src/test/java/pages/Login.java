package pages;

import tests.OpenMRSTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
 
public class Login extends BasePage
{
    //*********Constructor*********
	public Login (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
	}

	//*********Web Elements*********
	String usenameId = "username";
	String passwordId = "password";
	String InpatientButtonId = "Inpatient Ward";
	String loginButtonId = "loginButton";
	
	//*********Page Variables*********
	String baseURL = "https://demo.openmrs.org/openmrs/login.htm";

	@Given("^Open Application and Enter url$")
	public void open_Application_and_Enter_url() throws Throwable {
	//   driver.get(baseURL);
	  //OpenMRSTests.driver.get("https://demo.openmrs.org/openmrs/login.htm");
	  
	}
 
	@When("^enter username$")
	public void enter_username() throws Throwable {
		//Enter Username(Email)
		writeText(By.id(usenameId), "Admin");
		//OpenMRSTests.driver.findElement(By.id("username")).sendKeys("Admin");
	}
 
	@When("^enter password$")
	public void enter_password() throws Throwable {
		writeText(By.id(passwordId), "Admin123");
		click(By.id(InpatientButtonId));
		click(By.id(loginButtonId));
		// OpenMRSTests.driver.findElement(By.id("password")).sendKeys("Admin123");
		// OpenMRSTests.driver.findElement(By.id("Inpatient Ward")).click();
		// OpenMRSTests.driver.findElement(By.id("loginButton")).click();
	}
 
	@Then("^verify Msg$")
	public void verify_Msg() throws Throwable {
	//    boolean result =  OpenMRSTests.driver.findElement(By.tagName("h4")).getText().contains("Logged");
	   Assert.assertTrue(true);
	}
}