package com.web.automation.test;


import com.web.automation.driver.Driver;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.IFramesPage;
import com.web.automation.pages.VimeoIFrame;
import com.web.automation.pages.YouTubeIFrame;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 * @author Harvey.Yepes
 */
public class BaseTest {

	private Driver driver;
	
	//private HomePage Home;
	private IFramesPage iFramesPage;
	public Logger log = Logger.getLogger(BaseTest.class);

	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
		iFramesPage = new IFramesPage(driver.getDriver(), url);
	}

	@AfterMethod
	public void returnToTheMainPage(){
		iFramesPage.returnToTheMainPage();
	}

	@AfterTest(alwaysRun=true)
	public void afterTest() {
		iFramesPage.dispose();
	}
	
	/**
	 * Get the home page.
	 * @return {@link HomePage}
	 */
	public IFramesPage getIFramesPage() {
		return iFramesPage;
	}

}
