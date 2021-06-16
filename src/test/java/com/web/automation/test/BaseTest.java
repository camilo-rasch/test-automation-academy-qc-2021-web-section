package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver(), url );
    }

    @AfterTest(alwaysRun=true)
    public void afterTest() {
        homePage.dispose();
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
