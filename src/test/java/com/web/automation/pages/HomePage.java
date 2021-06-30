package com.web.automation.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author norma.losada
 */
public class HomePage extends BasePage {

    @FindBy(css = "a#global-user-trigger")
    private WebElement userIcon;

    @FindBy(css = ".user a[data-regformid='espn']")
    private WebElement loginOption;

    @FindBy(css = ".user a[class='small']")
    private WebElement logoutOption;

    @FindBy(css = ".user a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfileOption;

    private String mainPageHandle = "";

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Click on User icon, handle the exception until the icon will be found and switch to it
     * @return HeaderLoginPage
     */

    public HeaderPage clickOnUserIcon(){
        getDriver().switchTo().defaultContent();
        try{
            clickUserIcon(userIcon);
        } catch(StaleElementReferenceException e){
            getDriver().navigate().refresh();
            clickUserIcon(userIcon);
        }
        return new HeaderPage(getDriver());
    }

    /**
     * Click on User icon and scroll to find it
     * @return HeaderLoginPage
     * @param webElement
     */
    public void clickUserIcon(WebElement webElement){
        explicitWait(userIcon, 30);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(userIcon);
        actions.perform();
        clickOnElement(userIcon);
        explicitWait(userIcon, 50);
        log.info("This is the container User Login / Logout");
    }

    /**
     * Click on Login option and switch to it
     * @return LoginIframePage
     */
    public LoginIframePage clickOnLoginOption(){
        explicitWait(loginOption, 30);
        log.info("This is the Login option");
        clickOnElement(loginOption);
        return new LoginIframePage(getDriver());
    }

    /**
     * Click on Logout option
     *
     */
    public void clickOnLogoutOption(){
        explicitWait(logoutOption, 30);
        log.info("This is the Logout option");
        clickOnElement(logoutOption);
    }

    /**
     * Click on ESPN Profile option and switch to it
     * @return EspnProfile
     */
    public EspnProfile clickOnESPNProfileOption(){
        explicitWait(espnProfileOption, 30);
        log.info("This is the ESPN Profile option");
        clickOnElement(espnProfileOption);
        return new EspnProfile(getDriver());
    }

    /**
     * Gets the Main page Handle.
     *
     * @return the main page.
     */
    public String getMainPageHandle() {
        return mainPageHandle;
    }

    /**
     * Sets the Main page Handle.
     *
     * @return
     */

    public void setMainPageHandle(String mainPageHandle) {
        this.mainPageHandle = mainPageHandle;
    }
}
