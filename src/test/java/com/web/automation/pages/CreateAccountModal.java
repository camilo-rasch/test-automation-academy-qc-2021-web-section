package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountModal extends BasePage {

    @FindBy(css = "[class *='field field-first-name'] span:nth-child(2) input")
    private WebElement firstName;

    @FindBy(css = "[class *='field field-last-name'] span:nth-child(2) input")
    private WebElement lastName;

    @FindBy(css = "[class *='field field-email'] span:nth-child(2) input")
    private WebElement email;

    @FindBy(css = "[class *='field field-new-password'] span:nth-child(2) input")
    private WebElement password;

    @FindBy(css = "[did-translate ='create.SIGN_UP']")
    private WebElement SignUpButton;


    public CreateAccountModal(WebDriver driver) {
        super(driver);
    }


    /**
     * Input account data and click on sign up button
     * @param firstName String
     * @param lastName String
     * @param email String
     * @param password String
     * @return new HomePage
     */
    public HomePage createAccount(String firstName, String lastName, String email, String password){

        waitElementVisibility(this.firstName);
        this.firstName.sendKeys(firstName);

        waitElementVisibility(this.lastName);
        this.lastName.sendKeys(lastName);

        waitElementVisibility(this.email);
        this.email.sendKeys(email);

        waitElementVisibility(this.password);
        this.password.sendKeys(password);

        clickOnElement(SignUpButton);

        return new HomePage(getDriver());
    }

}
