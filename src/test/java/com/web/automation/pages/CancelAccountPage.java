package com.web.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.sleep;

/**
 * Class for interact with the home page.
 * @author Jonathan.Triana
 */
public class CancelAccountPage extends BasePage{

    //Locator to find Espn Profile option
    @FindBy(css = "div.global-user:nth-child(2) div.global-user-container ul.account-management li:nth-child(5) > a:nth-child(1)")
    private WebElement profile;

    //Locator to find Espn Profile option
    @FindBy(id = "cancel-account")
    private WebElement cancelAccount;

    //Locator to find confirm button
    @FindBy(css = "[ng-click='vm.confirm()']")
    private WebElement confirm;

    //Locator to find the confirmation
    @FindBy(css = ".title.title-primary.ng-isolate-scope")
    private WebElement confirmText;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public CancelAccountPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public CancelAccountPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Method to click on ESPN profile
     */
    public CancelAccountPage clickOnEspnProfile() {
        clickOnElement(profile);
        return new CancelAccountPage(getDriver());
    }
    /**
     * Method to click on first name field
     */
    public CancelAccountPage clickOnCancelAccount() {
        clickOnElement(cancelAccount);
        return new CancelAccountPage(getDriver());
    }

    /**
     * Method to click on confirm button (delete account)
     */
    public CancelAccountPage clickOnConfirmButton() {
        clickOnElement(confirm);
        return new CancelAccountPage(getDriver());
    }
    /**
     * Method to confirm if the account was deleted
     */
    public String deleteConfirmation() throws InterruptedException {
        waitElementVisibility(confirmText);
        sleep(1000);
        String label_text = confirmText.getText();
        return label_text;
    }
}
