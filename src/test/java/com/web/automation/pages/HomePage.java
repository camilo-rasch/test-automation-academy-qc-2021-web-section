package com.web.automation.pages;

import com.web.automation.data.Data;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
     * Input a customer ID and get the first alert text
     * @return alert.getText()
     */
    public String getConfirmationAlert(){
        waitElementVisibility(customerIdTextBox);
        customerIdTextBox.sendKeys("12345");
        submitButton.click();
        Alert alert = getDriver().switchTo().alert();
        getDriver().switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        return alert.getText();
    }

    /**
     * Click on OK get the second alert text
     * @return alert.getText()
     */
    public String getDeletionAlert(){
        Alert alert = getDriver().switchTo().alert();
        getDriver().switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        alert.accept();
        return alert.getText();
    }

    public boolean returnToMainPage(){
        Alert alert = getDriver().switchTo().alert();
        getDriver().switchTo().alert();
        alert.accept();
        return customerIdTextBox.isDisplayed();
    }

}
