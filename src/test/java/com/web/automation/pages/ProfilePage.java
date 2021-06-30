package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author juancarlos.ortiz
 */
public class ProfilePage extends BasePage {

    @FindBy (css = "div[ng-if=\"vm.readOnlyEmailValue\"] > div > span.value span")
    private WebElement emailText;

    @FindBy (id = "cancel-account")
    private WebElement deleteAccountButton;



    @FindBy (css = "button[ng-click=\"vm.confirm()\"]")
    private WebElement deleteConfirmationButton;




    public WebElement getEmailText() {
        return emailText;
    }

    public WebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public WebElement getDeleteConfirmationButton() {
        return deleteConfirmationButton;
    }




    public void deleteAccount(){
        clickOnElement(getDeleteAccountButton());
        clickOnElement(getDeleteConfirmationButton());
    }




    /**
     * Constructor.
     * @param driver WebDriver
     *
     */
    public ProfilePage(WebDriver driver) {
        super(driver);

    }


















}
