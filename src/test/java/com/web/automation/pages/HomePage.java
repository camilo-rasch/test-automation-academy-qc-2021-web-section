package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author
 */
public class HomePage extends BasePage {

    @FindBy (name = "cusid")
    private WebElement customerID;

    @FindBy (name = "submit")
    private WebElement submitButton;


    /**
     * Input text in the customerID field.
     * @return
     */
    public void insertDataCustomerID(String text){
     waitElementVisibility(customerID);
     this.customerID.sendKeys(text);
 }

    /**
     * Click on the submit button.
     * @return
     */
    public void clickOnSubmitButton(){
     waitElementVisibility(submitButton);
     this.submitButton.click();
    }

    /**
     * Capture and print alert message.
     * @return
     */
    public void CaptureAndPrintAlertMessage (){
        Alert alert = switchToAlert();
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
    }

    /**
     * Click on the alert OK button.
     * @return
     */
    public void ClickAlertOkButton (){
        Alert alert = switchToAlert();
        alert.accept();
    }

    /**
     * Capture and print alert message.
     * @return
     */
    public void CaptureAndPrintSecondAlertMessage (){
        Alert alert = switchToAlert();
        String alertMessage2 = alert.getText();
        System.out.println(alertMessage2);
    }

    /**
     * Click on the alert OK button.
     * @return
     */
    public void ClickSecondAlertOkButton (){
        Alert alert = switchToAlert();
        alert.accept();
    }

    /**
     * Verify if submit button is displayed.
     * @return boolean
     */
    public boolean isSubmitDisplayed(){
        waitElementVisibility(submitButton);
        return submitButton.isDisplayed();
    }

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
}
