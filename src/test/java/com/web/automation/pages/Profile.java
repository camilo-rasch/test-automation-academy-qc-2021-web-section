package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Parent of the other classes of test.
 * @author juandaniel.castano
 */

public class Profile extends BasePage{

    private String confirmAccountCanceledText = "";

    /**
     * Define WebElements
     */

    @FindBy(css = "#cancel-account")
    private WebElement cancelAccountLink;

    @FindBy(css = "button[class=\"btn btn-primary ng-isolate-scope\"]")
    private WebElement confirmCancelAccountButton;

    @FindBy(css = "iframe[id=\"disneyid-iframe\"]")
    private WebElement disneyIFrame;

    @FindBy(css = "h2[class=\"title title-primary ng-isolate-scope\"]")
    private WebElement accountCanceledText;

    @FindBy(css = "button[ng-click=\"vm.close()\"]")
    private WebElement acceptCancelAccountButton;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */

    public Profile(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Method to validate linkButton is within the iFrame
     */

    public void clickOnCancelAccountLink(){
        try {
            clickOnElement(this.cancelAccountLink);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            clickOnElement(this.cancelAccountLink);
        }
    }

    /**
     * Method to click on confirm cancel account button
     */

    public void clickOnConfirmCancelAccountButton(){
        clickOnElement(this.confirmCancelAccountButton);
    }

    /**
     * Method to get the confirmation text
     * @return String value
     */

    public String getConfirmAccountCanceledText(){

        try {
            confirmAccountCanceledText = accountCanceledText.getText();
            clickOnElement(this.confirmCancelAccountButton);
            return confirmAccountCanceledText;
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            confirmAccountCanceledText = accountCanceledText.getText();
            clickOnElement(this.confirmCancelAccountButton);
            return confirmAccountCanceledText;
        }
    }

    /**
     * Method to validate WebElement is displayed
     * @return Boolean value
     */

    public boolean profileWindowIsDisplayed(){
        return cancelAccountLink.isDisplayed();
    }

    /**
     * Method to validate WebElement is displayed
     * @return Boolean value
     */

    public boolean confirmCancelAccountButtonIsDisplayed(){
        return confirmCancelAccountButton.isDisplayed();
    }

}
