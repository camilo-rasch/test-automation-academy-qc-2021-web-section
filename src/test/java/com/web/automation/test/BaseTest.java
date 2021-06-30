package com.web.automation.test;

import com.web.automation.driver.Driver;
import com.web.automation.pages.CancelAccountPage;
import com.web.automation.pages.CreateUserPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LogInPage;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

/**
 * Base test class.
 * @author Jonathan.Triana
 */
public class BaseTest {
	public Logger log = Logger.getLogger(BaseTest.class);
	private Driver driver;
	private HomePage Home;
	private LogInPage Login;
	private CreateUserPage Create;
	private CancelAccountPage Profile;


	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser", "url"})

	public void beforeMethod(String browser, String url) throws InterruptedException {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		Home= new HomePage(driver.getDriver(), url);
		Login= new LogInPage(driver.getDriver(), url);
		Create= new CreateUserPage(driver.getDriver(), url);
		Profile= new CancelAccountPage(driver.getDriver(), url);
		createAccount();

	}
	public void createAccount() throws InterruptedException {
		log.info("Click on the user option to log in");
		getHomePage().clickOnUserIcon();
		log.info("Click on the Log in option");
		getHomePage().clickOnLogIn();
		log.info("Switch to Log in - Iframe");
		getHomePage().switchToIframeLogIn();
		log.info("Click on the sign up button");
		getCreateUserPage().clickOnSignUp();
		log.info("Click on the first name (Create Account)");
		getCreateUserPage().clickOnFirstNameField();
		log.info("Input the first name (Create Account) ");
		getCreateUserPage().inputOnFirstNameField();
		log.info("Click on the last name (Create Account)");
		getCreateUserPage().clickOnLastNameField();
		log.info("Input the last name (Create Account) ");
		getCreateUserPage().inputOnLastNameField();
		log.info("Click on the email (Create Account)");
		getCreateUserPage().clickOnEmailField();
		log.info("Input the email (Create Account) ");
		getCreateUserPage().inputOnEmailField();
		log.info("Click on the password (Create Account)");
		getCreateUserPage().clickOnPasswordField();
		log.info("Input the password (Create Account) ");
		getCreateUserPage().inputOnPasswordField();
		log.info("Click on the sign up button (Create Account)");
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
	 * Get the log in page.
	 * @return {@link LogInPage}
	 */
	public LogInPage getLogInPage() {
		return Login;
	}
	/**
	 * Get the create user page
	 * @return {@link CreateUserPage}
	 */
	public CreateUserPage getCreateUserPage() {
		return Create;
	}
	/**
	 * Get the cancel account page
	 * @return {@link CancelAccountPage}
	 */
	public CancelAccountPage getCancelAccountPage() {
		return Profile;
	}

}
