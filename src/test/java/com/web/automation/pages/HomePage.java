package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "input[name=\"cusid\"]")
    private WebElement inputCustomerID;

    @FindBy(css = "input[name=\"submit\"]")
    private WebElement buttonSubmit;

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
     * Method to click on the input
     */

    public void clickOnTheCustomerIDInput() {
        clickOnElement(this.inputCustomerID);
    }

    /**
     * Method to send the value to the input
     * @param text
     */

    public void sendValueToTheInput(String text) {
        sendKeysToElement(this.inputCustomerID, text);
    }

    public void clickOnButtonSubmit() {
        clickOnElement(this.buttonSubmit);
    }

    public Alert switchToTheAlert() {
        return getDriver().switchTo().alert();
    }

    /**
     * Method to use the assertion and valdiated if the page return to the homepage
     * @return boolean
     */

    public boolean isInputCustomerIDDisplayed() {
        waitElementVisibility(this.inputCustomerID);
        return this.inputCustomerID.isDisplayed();
    }


}
