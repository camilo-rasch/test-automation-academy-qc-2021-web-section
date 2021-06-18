package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author juandaniel.castano
 */
public class HomePage extends BasePage {

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    @FindBy(css = "input[name=\"cusid\"]")
    private WebElement inputText;

    @FindBy(css = "input[name=\"submit\"]")
    private WebElement submitButton;

    /**
     * Click on Input Text Field
     */
    public void clickOnTheTextBox(){
        clickOnElement(this.inputText);
    }

    /**
     * Send the text
     * @param text
     */
    public void insertData(String text){
        this.inputText.sendKeys(text);
    }

    /**
     * Click on Submit button
     */
    public void clickOnSubmitButton(){
        clickOnElement(this.submitButton);
    }

    /**
     * Get text from the Alert
     * @return
     */
    public String popupGetText(){
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }

    /**
     * Click on 'Accept' button from the Alert
     */
    public void clickOnAcceptButtonAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    /**
     * Return WebElement
     * @return
     */
    public WebElement isSubmitButtonAvailable(){
        return this.submitButton;
    }
}