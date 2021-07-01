package com.web.automation.pages;

import com.web.automation.data.Data;
import com.web.automation.data.SignInUserData;
import com.web.automation.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage<user> extends BasePage {

    @FindBy(css=".section.section-primary a[class='btn btn-secondary ng-isolate-scope']")
    private WebElement signUpButton;

    @FindBy(css=".tools li[class='display-user'] span")
    private WebElement accountManagementTools;

    @FindBy(css="#global-user-trigger")
    private WebElement menuToolsButton;

    @FindBy(css="#global-header a[data-affiliatename='espn']")
    private WebElement loginButton;

    @FindBy(css="input[name='firstName']")
    private WebElement userFirstNameField;

    @FindBy(css="input[name='lastName']")
    private WebElement userLastName;

    @FindBy(css=".field-group [type='email']")
    private WebElement userNewEmail;

    @FindBy(css=".field-group [type='password']")
    private WebElement userNewPassword;

    @FindBy(css=".section.section-submit button")
    private WebElement signUpFormButton;

    @FindBy(css=".field-group input[type='email']")
    private WebElement userEmail;

    @FindBy(css=".field-group input[type='password']")
    private WebElement userPassword;

    @FindBy(css=".btn-group.touch-print-btn-group-wrapper button")
    private WebElement logInIframeButton;

    @FindBy(css=".tools a[onclick='javascript:espn.memberservices.logout();return false;']")
    private WebElement logOutButton;

    @FindBy(css=".tools li:nth-child(5) a")
    private WebElement profileButton;

    @FindBy(css=".field-group #cancel-account")
    private WebElement deleteAccountLink;

    @FindBy(css=".btn-group button[ng-click='vm.confirm()']")
    private WebElement deleteAccountButton;

    @FindBy(css="#did-ui h2[class='title title-primary ng-isolate-scope']")
    private WebElement accountDeactivatedMessage;

    private String signInName = "";

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
     * wait element to be visible
     * @param element WebElement
     */
    public void waitElementVisibility(WebElement element){getWait().until(ExpectedConditions.visibilityOf(element));}

    /**
     * click on element
     * @param element
     */
    public void clickOnElement(WebElement element){
        waitElementVisibility(element);
        element.click();
    }

    /**
     * Method that allows enter all data that comes from the data provider, into the page
     * @param user
     */
    public void createAccount(User user) {
        try {
            getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        clickOnElement(this.menuToolsButton);
        getWait().until(ExpectedConditions.elementToBeClickable(this.loginButton));
        clickOnElement(this.loginButton);
        getDriver().switchTo().frame("disneyid-iframe");
        clickOnElement(this.signUpButton);
        waitElementVisibility(this.userFirstNameField);
        this.userFirstNameField.sendKeys(user.getFirstName());
        this.userLastName.sendKeys(user.getLastName());
        this.userEmail.sendKeys(user.getEmail());
        this.userPassword.sendKeys(user.getPassword());
        clickOnElement(signUpFormButton);
        getDriver().switchTo().defaultContent();
        waitElementVisibility(this.menuToolsButton);
    }

    /**
     * Method that allows a user that comes from the data provider to sign In to it's account
     * @param user
     */
    public void signIn(User user) {
        try {
            Thread.sleep(3000);

        } catch (WebDriverException | InterruptedException e) {
            e.printStackTrace();
        }
        getWait().until(ExpectedConditions.elementToBeClickable(this.menuToolsButton));
        clickOnElement(this.menuToolsButton);
        getWait().until(ExpectedConditions.elementToBeClickable(this.loginButton));
        clickOnElement(this.loginButton);
        getDriver().switchTo().frame("disneyid-iframe");
        waitElementVisibility(this.userNewEmail);
        this.userNewEmail.sendKeys(user.getEmail());
        this.userNewPassword.sendKeys(user.getPassword());
        clickOnElement(this.logInIframeButton);
    }

    /**
     * Method that allows to verify if a user is sign in to it's account
     * @return
     */
    public boolean verifySignInAccount(){
        try {
            getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        String confirmationSignInName = this.accountManagementTools.getText();
        return confirmationSignInName.equalsIgnoreCase(this.signInName);
    }

    /**
     * Method to sign out from an account
     */
    public void signOut(){
        try {
            Thread.sleep(3000);

        } catch (WebDriverException | InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(this.menuToolsButton);
        getWait().until(ExpectedConditions.elementToBeClickable(this.logOutButton));
        clickOnElement(this.logOutButton);

    }

    /**
     * Method to verify if a user account is correctly deleted
     * @return Boolean
     */
    public boolean verifyLogOutAccount(){
        try {
            getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return this.loginButton.isEnabled();
    }

    /**
     *Method that displays the menu with the user profile options
     */
    public void openUserProfileMenu(){
        try {
            getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        clickOnElement(this.menuToolsButton);
        clickOnElement(this.profileButton);
        getDriver().switchTo().frame("disneyid-iframe");
    }

    /**
     * Method that cancel an user's account
     */
    public void cancelUserAccount(){
        try {
            getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        clickOnElement(this.deleteAccountLink);
        clickOnElement(this.deleteAccountButton);
    }

    /**
     * Method to verify the user account status
     * @return
     */
    public String verifyMessageAccountState(){
        try {
            getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        String confirmationAccountMessage = this.accountDeactivatedMessage.getText();
        return confirmationAccountMessage;
    }

}


