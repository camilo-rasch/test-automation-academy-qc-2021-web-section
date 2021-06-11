package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;

/**
 * Parent of the other classes of test.
 *
 * @author camilo.mogollon
 */
public class BaseTest {

    public Logger log = Logger.getLogger(BaseTest.class);
    public HomePage homePage;
    Driver driver;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver(), "www.twitter.com");
    }

    /**
     * Get Home Page Method
     *
     * @return HomePage class
     */
    public HomePage getHomePage() {
        return homePage;
    }
}
