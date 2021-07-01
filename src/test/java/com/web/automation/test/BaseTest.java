package com.web.automation.test;


import com.web.automation.data.Data;
import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.RegisterPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


/**
 * Parent of the other classes of test.
 * @author camilo.mogollon
 */
public class BaseTest {

	private Driver driver;
	private WebDriver signUpDriver;
	private HomePage Home;
	public Logger log = Logger.getLogger(BaseTest.class);
	private User user;
	
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		Home= new HomePage(driver.getDriver(), url);
	}

	@BeforeTest(alwaysRun=true)
	public void createAccount() {
		user = new User();
		Home=getHomePage();
		log.info("Focus on Register Button");
		Home.clickOnRegisterButton();
		log.info("Change to Iframe focus");
		signUpDriver = Home.changeToIframe();
		RegisterPage signUpPage= new RegisterPage(signUpDriver);
		log.info("Fill User Name");
		signUpPage.fillNameInput();
		log.info("Fill User Last Name");
		signUpPage.fillLastNameInput();
		log.info("Fill User email");
		signUpPage.fillEmailInput();
		log.info("Fill User Password");
		signUpPage.fillPassInput();
		log.info("Click on SignUp Button");
		signUpPage.clickOnConfirmRegister();
		Home.changeToHomeFocus();

	}

	@AfterTest(alwaysRun=true)
	public void afterTest() {
		Home.dispose();
	}
	
	/**
	 * Get the home page.
	 * @return {@link HomePage}
	 */
	public HomePage getHomePage() {
		return Home;
	}

}
