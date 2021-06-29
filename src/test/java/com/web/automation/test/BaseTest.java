package com.web.automation.test;

import com.web.automation.driver.Driver;
import com.web.automation.pages.CancelAccountPage;
import com.web.automation.pages.CreateUserPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LogInIframePage;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

/**
 * Parent of the other classes of test.
 * @author Jonathan.Triana
 */
public class BaseTest {
	public Logger log = Logger.getLogger(BaseTest.class);
	private Driver driver;
	private HomePage Home;
	private LogInIframePage Login;
	private CreateUserPage Signup;
	private CancelAccountPage Profile;


	@BeforeMethod(alwaysRun=true)

	@Parameters({"browser", "url"})
	public void beforeMethod(String browser, String url) throws InterruptedException {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		Home= new HomePage(driver.getDriver(), url);
		Login= new LogInIframePage(driver.getDriver(), url);
		Signup= new CreateUserPage(driver.getDriver(), url);
		Profile= new CancelAccountPage(driver.getDriver(), url);

		log.info("Click on user option to log in");
		getHomePage().clickOnUserIcon();
		log.info("Click on Log in option");
		getHomePage().clickOnLogIn();
		log.info("Switch to Log in - Iframe");
		getLogInIframePage().switchToIframeLogIn();
		log.info("");
		sleep(1000);
		log.info("Click on sign up button");
		getCreateUserPage().clickOnSignUp();
		log.info("Click on first name (Create Account)");
		getCreateUserPage().clickOnFirstNameField();
		log.info("Input the first name (Create Account) ");
		getCreateUserPage().inputOnFirstNameField();
		log.info("Click on last name (Create Account)");
		getCreateUserPage().clickOnLastNameField();
		log.info("Input the last name (Create Account) ");
		getCreateUserPage().inputOnLastNameField();
		log.info("Click on email (Create Account)");
		getCreateUserPage().clickOnEmailField();
		log.info("Input the email (Create Account) ");
		getCreateUserPage().inputOnEmailField();
		log.info("Click on password (Create Account)");
		getCreateUserPage().clickOnPasswordField();
		log.info("Input the password (Create Account) ");
		getCreateUserPage().inputOnPasswordField();
		log.info("Click on sign up button (Create Account)");
		getCreateUserPage().clickOnSignUpButton();
		sleep(5000);
	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		Home.dispose();
	}

	/**
	 * Get the home page.
	 * @return {@link HomePage}
	 */
	public HomePage getHomePage() {
		return Home;
	}
	/**
	 * Get the Log in page.
	 * @return {@link LogInIframePage}
	 */
	public LogInIframePage getLogInIframePage() {
		return Login;
	}
	/**
	 * Get the Sign Up page.
	 * @return {@link LogInIframePage}
	 */
	public CreateUserPage getCreateUserPage() {
		return Signup;
	}
	/**
	 * Get the Sign Up page.
	 * @return {@link LogInIframePage}
	 */
	public CancelAccountPage getCancelAccountPage() {
		return Profile;
	}

}
