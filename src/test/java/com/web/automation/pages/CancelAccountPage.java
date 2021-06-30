package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class with the locator and methods to cancel an account.
 * @author Jonathan.Triana
 */
public class CancelAccountPage extends BasePage{

    //Locator to find Espn Profile option
    @FindBy(css = "div.global-user:nth-child(2) div.global-user-container ul.account-management li:nth-child(5) > a:nth-child(1)")
    private WebElement profile;

    //Locator to find delete account option
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
     * Method to click on ESPN profile
     */
    public void clickOnEspnProfile() {
        clickOnElement(profile);
    }
    /**
     * Method to click on first name field
     */
    public void clickOnCancelAccount() {
        clickOnElement(cancelAccount);
    }
    /**
     * Method to click on confirm button (delete account)
     */
    public void clickOnConfirmButton() {
        clickOnElement(confirm);
    }
    /**
     * Method to confirm if the account was deleted
     */
    public String deleteConfirmation() throws InterruptedException {
        waitElementVisibility(confirmText);
        String label_text = confirmText.getText();
        return label_text;
    }
}
