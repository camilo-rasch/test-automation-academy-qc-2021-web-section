package com.web.automation.pages;

import com.web.automation.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for signup user page.
 * @author harvey.yepes
 */
public class SignupPage extends BasePage {


        /**
         * Locators of the login page
         */
        @FindBy(css = "section.main")
        private WebElement createAccountSection;

        @FindBy(name = "firstName")
        private WebElement firstNameTextBox;

        @FindBy(name = "lastName")
        private WebElement lastNameTextBox;

        @FindBy(name = "email")
        private WebElement emailTextBox;

        @FindBy(name = "newPassword")
        private WebElement newPasswordTextBox;

        @FindBy(css = "div .btn-group")
        private WebElement signupButton;


        /**
         * Constructor
         * @param pDriver
         */
        public SignupPage(WebDriver pDriver) {
            super(pDriver);
        }



        /**
         * Method to log in
         */
        public void signupUser(User user){
            //wait while the new frame is displayed
            //switchToFrame();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //waitForVisibilityOf(this.createAccountSection);
            this.firstNameTextBox.sendKeys(user.getFirstName());
            this.lastNameTextBox.sendKeys(user.getLastName());
            this.emailTextBox.sendKeys(user.getEmail());
            this.newPasswordTextBox.sendKeys(user.getPassword());
            this.signupButton.click();
        }

}


