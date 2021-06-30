package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountModal extends BasePage{

    @FindBy(css = "[name ='vm.update'] [id ='cancel-account']")
    private WebElement deleteAccountLink;

    @FindBy(css = "[class*= 'workflow-deactivate'] [ng-click='vm.confirm()']")
    private WebElement deleteAccountButton;

    @FindBy(css = "[class *='workflow-deactivate'] [ng-click ='vm.close()']")
    private WebElement deletedOKButton;


    /**
     * Constructor.
     * @param pDriver WebDriver
     */
    public DeleteAccountModal(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Method to cancel account, I had to use try/catch cause the element in the DOM wasn't found
     * @return new LoginModal
     */
    public void cancelAccount(){

        try {
            deleteAccountLink.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            deleteAccountLink.click();
        }
        clickOnElement(deleteAccountButton);

    }


    /**
     * Method implemented to validate if deletedOKButton is displayed
     * @return deletedOKButton.isDisplayed()
     */
    public boolean isDeletedOKButtonDisplayed() {
        waitElementVisibility(deletedOKButton);
        return deletedOKButton.isDisplayed();
    }

}
