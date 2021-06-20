package com.web.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 * @modified by alejandro.giraldo
 */
public class HomePage extends BasePage {


    @FindBy(css="input[name=cusid]") //Selects CostumerId input
    private WebElement inputCostumerId;

    @FindBy(css="input[name=submit]")//Selects submitButton
    private WebElement submitButton;


    @FindBy(css="h2.barone")//Selects Home Label
    private WebElement homeLabel;

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
     * Click on CostumerId input
     *
     * @return
     */
    public void selectCostumerIdInput(){
        clickOnElement(inputCostumerId);
    }

    /**
     * Send Costumer Id to Input
     * @param cosId String
     * @return
     */
    public void fillCostumeridInput(String cosId){
        inputCostumerId.sendKeys(cosId);
    }

    /**
     * Click on Submit Button
     * @return
     */
    public void clickOnSubmitButton(){
        clickOnElement(submitButton);
    }

    /**
     * Change to Alert
     * @return
     */
    public Alert changeAlertFocus(){
        return getDriver().switchTo().alert();
    }

    /**
     * Click on CostumerId input
     * @return
     */
    public boolean verifyHomePage(){
        if (homeLabel.getText().contains("Guru99 Bank")){
            return true;
        }else return false;

    }

}
