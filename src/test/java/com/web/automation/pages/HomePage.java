package com.web.automation.pages;

import com.web.automation.test.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Class for interact with the home page.
 * @author fabio.alarcon
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
    private WebElement clickInputText;

    @FindBy(css = "input[name=\"submit\"]")
    private WebElement submitButton;

    /**
     * Click in the box text
     */
    public void clickInTheTextBox(){
        clickOnElement(this.clickInputText);
    }

    /**
     * Insert text
     * @param text
     */
    public void insertData(String text){
        this.clickInputText.sendKeys(text);
    }

    /**
     * Click on submit button
     */
    public void clickOnSubmitButton(){
        clickOnElement(this.submitButton);
    }

    /**
     * Get the text of the alert
     * @return
     */
    public String getTextOfAlert(){
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }

    /**
     * Click on "Accept" button of the alert
     */
    public void clickOkInTheAlertButton(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    /**
     * Assert the availability of the submit button
     * @return
     */
    public WebElement isSubmitButtonAvailable(){
        return this.submitButton;
    }


}
