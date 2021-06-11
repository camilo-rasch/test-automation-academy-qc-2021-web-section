package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "a[data-testid=\"loginButton\"]")
    private WebElement loginButton;
    @FindBy(css = "a[data-testid=\"signupButton\"]")
    private WebElement signUpButton;

    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Page Constructor
     *
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLoginButton() {
        clickOnElement(loginButton);
        return new LoginPage(getDriver());
    }

    public SignUpModal clickOnSignUpButton() {
        clickOnElement(signUpButton);
        return new SignUpModal(getDriver());
    }

    public Boolean isLoginButtonDisplayed() {
        waitElementVisibility(loginButton);
        return loginButton.isDisplayed();
    }
}
