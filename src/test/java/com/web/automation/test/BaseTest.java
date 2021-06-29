package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.BasePage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.NewAccount;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 * @author camilo.mogollon
 */
public class BaseTest {

	private Driver driver;
	
	private HomePage Home;
	public Logger log = Logger.getLogger(BaseTest.class);
	private AccountManagement accounts;
	private BasePage base;
	
	@FindBy(css = "a[name=\"&lpos=sitenavdefault&lid=sitenav_main-logo\"]")
	private WebElement webpage;

	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		Home= new HomePage(driver.getDriver(), url);
	}

	@BeforeTest(alwaysRun=true)
	public void creatingOneAccount() {
		log.info("Opening homePage");
		Home = getHomePage();
		log.info("Click to Sign Up button");
		NewAccount newAccount = Home.clickToSignUp();
		log.info("Insert data to registration");
		newAccount.signUpData();
		log.info("Check if the drive is in the right iframe");
		Assert.assertTrue(newAccount.isCreateAccountTitleVisible(), "Checking the iframe title");
		log.info("Click to create the new account");
		newAccount.clickToFinishRegistration();
		log.info("Confirmation of the account created");
		Assert.assertTrue(Home.confirmationOfTheAccount(),"Checking the account profile");
		log.info("Log out");
		Home.clickToSignOut();

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

	public Driver getDriver() {
		return driver;
	}
}
