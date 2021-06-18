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

    @FindBy(css = "input[name = 'cusid']")
    private WebElement customerId;

    @FindBy(css = "input[name = 'submit']")
    private WebElement submitButton;

    @FindBy(css = "h2[class = 'barone']")
    private WebElement pageTitle;


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
     * Fill data and Click on button
     * @return
     */

    public void fillData(){
        clickOnElement(this.customerId);
        customerId.sendKeys("2");
        log.info("This is the id");
        clickOnElement(this.submitButton);
    }

    /**
     * Get First alert
     * @return
     */

    public void getFirstAlert(){
        Alert firstAlert = getDriver().switchTo().alert();
        log.info("First Alert Message -  " + firstAlert.getText());
        firstAlert.accept(); //To click on the "Ok" option of the alert
        log.info("Click on OK option in the first Alert");
    }

    /**
     * Get Second alert
     * @return
     */
    public void getSecondAlert(){
        Alert secondAlert = getDriver().switchTo().alert();
        log.info("Second Alert Message - " + secondAlert.getText());
        secondAlert.accept(); //To click on the "Ok" option of the alert
        log.info("Click on OK option in the second the Alert");
    }

    /**
     * Verify if this is the main page
     * @return boolean
     */
    public boolean isThisTheMainPage(){
        waitElementVisibility(this.pageTitle);
        log.info("This is the page title: " + this.pageTitle.getText());
        return this.pageTitle.isDisplayed();
    }
}
