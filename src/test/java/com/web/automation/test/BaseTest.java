package com.web.automation.test;

import com.web.automation.driver.Driver;
import com.web.automation.pages.CreateUserPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LogInIframePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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


	@BeforeTest(alwaysRun=true)

	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		Home= new HomePage(driver.getDriver(), url);
		Login= new LogInIframePage(driver.getDriver(), url);
		Signup= new CreateUserPage(driver.getDriver(), url);


	}

	@AfterTest(alwaysRun=true)
	public void afterTest() {
		//Home.dispose();
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

}
