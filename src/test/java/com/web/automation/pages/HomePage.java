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

    /**
     * Locators of the home page
     */
    @FindBy (name = "cusid")
    private WebElement customerIdTextBox;

    @FindBy (name = "submit")
    private WebElement submitButton;

    Alert alert;


    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        this.alert = getDriver().switchTo().alert();
    }

    public void insertData(){


    }

    public String getConfirmationAlert(){
        this.alert.getText();
        alert.accept();
        return this.alert.getText();
    }

}
