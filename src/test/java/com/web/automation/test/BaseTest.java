package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginIframePage;
import com.web.automation.pages.SignUpPage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 * @author norma.losada
 */
public class BaseTest {

	private Driver driver;
	
	private HomePage Home;
	private LoginIframePage login;
	private SignUpPage signUpPage;
	public Logger log = Logger.getLogger(BaseTest.class);

	@BeforeSuite()
	public void beforeSuite() {
		log.info("Have an ESPN account");
	}
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		Home= new HomePage(driver.getDriver(), url);
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
