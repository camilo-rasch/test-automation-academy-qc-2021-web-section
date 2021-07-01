package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 * @author fabio.alarcon
 */
public class BaseTest {

	private Driver driver;
	private HomePage homePage;
	public Logger log = Logger.getLogger(BaseTest.class);
	
	@BeforeTest(description = "Open the browser and the url", alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		homePage= new HomePage(driver.getDriver(), url);
	}

	/**
	 * Method to close the webpage
	 */
	@AfterTest(alwaysRun=true)
	public void afterTest() {
		homePage.dispose();
	}
	
	/**
	 * Get the home page.
	 * @return {@link HomePage}
	 */
	public HomePage getHomePage() {
		return homePage;
	}

	/**
	 * Get the driver.
	 * @return {driver}
	 */
	public Driver getDriver() {
		return driver;
	}
}
