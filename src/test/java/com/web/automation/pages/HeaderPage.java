package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    @FindBy(css = "li[class='user hover'] > a")
    private WebElement loginOption;

    @FindBy(css = ".user a[class='small']")
    private WebElement logoutOption;

    @FindBy(css = ".user a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfileOption;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public HeaderPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if login option is displayed in the container
     * @return boolean
     */
    public boolean isTheLoginPresentInContainer(){
        explicitWait(loginOption, 50);
        waitElementVisibility(this.loginOption);
        return this.loginOption.isDisplayed();
    }

    /**
     * Verify if logout option is displayed in the container
     * @return boolean
     */
    public boolean isTheLogoutPresentInContainer(){
        explicitWait(logoutOption, 30);
        waitElementVisibility(this.logoutOption);
        return this.logoutOption.isDisplayed();
    }

    /**
     * Verify if ESPN Profile option is displayed in the container
     * @return boolean
     */
    public boolean isTheESPNProfilePresentInContainer(){
        explicitWait(espnProfileOption, 30);
        waitElementVisibility(this.espnProfileOption);
        return this.espnProfileOption.isDisplayed();
    }

    /**
     * Verify if Login option is displayed in the container after the Logout
     * @return String
     */
    public String loginOptionisDisplayedAfterLogout(){
        waitElementVisibility(loginOption);
        waitElementVisibility(this.loginOption);
        return this.loginOption.getText();
    }

}
