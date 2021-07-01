package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.testng.annotations.*;

/**
 * Parent of the other classes of test.
 * @author juandaniel.castano
 */


public class BaseTest {

	private Driver driver;
	private HomePage Home;

	/**
	 * Open Browser before Test
	 */

	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		Home= new HomePage(driver.getDriver(), url);
	}

	/**
	 * Close Browser after Test
	 */

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
