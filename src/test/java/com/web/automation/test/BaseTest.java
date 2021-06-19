package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 * @author camilo.mogollon
 */
public class BaseTest {

	private Driver driver;
	
	private HomePage home;
	public Logger log = Logger.getLogger(BaseTest.class);
	
	
	@BeforeTest(alwaysRun=true)

	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		home= new HomePage(driver.getDriver(), url);
	}


	@AfterTest(alwaysRun=true)
	public void afterTest() {
		home.dispose();
	}


	/**
	 * Get the home page.
	 * @return {@link HomePage}
	 */
	public HomePage getHomePage() {
		return home;
	}

}
