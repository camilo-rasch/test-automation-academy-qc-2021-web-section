package com.web.automation.test;


import com.web.automation.driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 * @author camilo.mogollon
 */
public class BaseTest {
	
	Driver driver;

	public Logger log = Logger.getLogger(BaseTest.class);
	
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
	}
}
