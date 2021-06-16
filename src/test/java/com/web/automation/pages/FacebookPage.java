package com.web.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author juancarlos.ortiz
 */
public class FacebookPage extends BasePage{

	/**
	 * Contructor for Facebookpage
	 * @param pDriver for the webdriver object
	 */
	public FacebookPage(WebDriver pDriver){
		super(pDriver);
	}


	/**
	 * WebElements for Facebook log in page
	 */
	@FindBy (id = "email")
	private WebElement emailField;

	@FindBy (id = "pass")
	private WebElement passwordField;

	@FindBy (css = "._featuredLogin__formContainer div:nth-child(6) > button")
	private WebElement logInButton;


	/**
	 * WebElements for Facebook log out
	 *
	 */

	@FindBy (css = "[role='banner']  > div:nth-child(4) > div > span > div > div:first-child")
	private WebElement accountButton;


	@FindBy (css = "[role='banner'] > div:nth-child(4) div:nth-child(2) > div div:last-of-type > div:nth-child(5) > div > div:nth-child(4) > div > div:nth-child(1)")
	private WebElement logOutButton;


	/**
	 * WebElements for profile
	 *
	 *
	 */

	@FindBy (css = "a[href='/me/'")
	private WebElement profile;


	/**
	 * WebElements for Friends
	 *
	 *
	 */

	@FindBy (xpath = "//span[contains(text(),'See All Friends')]")
	private WebElement friends;

	@FindBy (css = "[data-pagelet='ProfileAppSection_0'] > div > div > div  > div > div:nth-child(3) > div >div:nth-child(2) > div > a")
	private WebElement friendLink;

	@FindBy (css = "[data-pagelet='ProfileActions'] > div > div > div:nth-child(2) > div > div")
	private WebElement messageFriend;


















}
