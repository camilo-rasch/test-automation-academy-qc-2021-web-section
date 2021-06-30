package com.web.automation.test;


import com.web.automation.data.User;
import com.web.automation.driver.Driver;
import com.web.automation.pages.AccountPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LogInPage;
import com.web.automation.pages.SignUpPage;
import org.apache.log4j.Logger;
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

	public Driver getDriver() {
		return driver;
	}

	private String accountFirstName;
	private String accountLastName;
	private String accountEmail;
	private String accountPassword;

	/**
	 * Getter for Account First Name
	 * @return String
	 */
	public String getAccountFirstName() {
		return accountFirstName;
	}

	/**
	 * Setter for Account First Name
	 * @param accountFirstName String
	 */
	public void setAccountFirstName(String accountFirstName) {
		this.accountFirstName = accountFirstName;
	}

	/**
	 * Getter for Account Last Name
	 * @return String
	 */
	public String getAccountLastName() {
		return accountLastName;
	}

	/**
	 * Setter for Account Last Name
	 * @param accountLastName String
	 */
	public void setAccountLastName(String accountLastName) {
		this.accountLastName = accountLastName;
	}

	/**
	 * Getter for Account Email
	 * @return String
	 */
	public String getAccountEmail() {
		return accountEmail;
	}

	/**
	 * Setter for Account Email
	 * @param accountEmail String
	 */
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	/**
	 * Getter Account Password
	 * @return String
	 */
	public String getAccountPassword() {
		return accountPassword;
	}

	/**
	 * Setter for Account Password
	 * @param accountPassword String
	 */
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	/**
	 * Method to create account for each test
	 * @param data
	 */
	@BeforeMethod(description = "Account Creation",alwaysRun=true)
	public void createAccount(Object[] data){


		User user = new User();
		getHomePage();
		getHomePage().clickOnElement(getHomePage().getGlobalUserButton());
		log.info("Click on global User Button");
		LogInPage logInPage = getHomePage().clickOnLoginButton();

		log.info("Click on Log In Button");
		SignUpPage signUpPage = logInPage.clickOnSignUpButton();
		setAccountFirstName(user.getFirstName());
		setAccountLastName(user.getLastName());
		setAccountEmail(user.getEmail());
		setAccountPassword(user.getPassword());

		log.info("Click on SignUp Button");
		signUpPage.createUser(getAccountFirstName(),getAccountLastName(),getAccountEmail(),getAccountPassword());
		log.info("Fields filled out");
		AccountPage accountPage = signUpPage.clickOnNewSignInButton();
		log.info("Click on SignUp Button");

		accountPage.clickOnElement(accountPage.getGlobalUserButton());
		Assert.assertEquals(accountPage.getDisplayNameText().getText(),"Welcome"+getAccountFirstName()+"!");

		accountPage.logOutUser();
		log.info("Click on LogOut Button");
		getHomePage().clickOnglobalButton();

		Assert.assertTrue(getHomePage().assertLogOut(),"Log out successful");
	}


}
