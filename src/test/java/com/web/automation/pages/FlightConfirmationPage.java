package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Flight Confirmation page class.
 * @author Jonathan.Triana
 */
public class FlightConfirmationPage extends BasePage{

    //Locator to find the check out button
    @FindBy(css = "[data-test-id*='checkout-button']")
    private WebElement checkOutButton;

    //Locator to find Trip total value
    @FindBy(css = "[data-test-id*='total']>tbody>tr>td~td>span")
    private WebElement tripTotalValue;

    //Locator to find the departure information
    @FindBy(css = "[data-test-id*='review-0']")
    private WebElement departureInformation;

    //Locator to find the return information
    @FindBy(css = "[data-test-id*='review-1']")
    private WebElement returnInformation;

    //Locator to find the fare economy text of the departure information
    @FindBy(css = "[data-test-id*='review-0']>div>div[data-test-id*='fare']>h3")
    private WebElement fareEconomyText;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FlightConfirmationPage(WebDriver pDriver) {
        super(pDriver);
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait and check if the element checkOutButton is displayed
     * @return existsElement(this.checkOutButton) boolean
     */
    public boolean isCheckOutButtonPresent(){
        return existsElement(this.checkOutButton);
    }
    /**
     * Method to click on check out button
     * @return new CustomerPaymentPage(getDriver()) CustomerPaymentPage
     */
    public CustomerPaymentPage clickOnCheckOutButton(){
        this.checkOutButton.click();
        return new CustomerPaymentPage(getDriver());
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait, check if the element tripTotalValue is displayed and control exceptions
     * @return existsElement(this.tripTotalValue) boolean
     */
    public boolean isTripTotalPresent(){
        return existsElement(this.tripTotalValue);
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait, check if the element departureInformation is displayed and control exceptions
     * @return existsElement(this.departureInformation) boolean
     */
    public boolean isDepartureInfoPresent(){
        return existsElement(this.departureInformation);
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait, check if the element returnInformation is displayed and control exceptions
     * @return existsElement(this.returnInformation) boolean
     */
    public boolean isReturnInfoPresent(){
        return existsElement(this.returnInformation);
    }
    /**
     * Method wait the element fareEconomyText and get the text
     * @return fareEconomyText.getText() String
     */
    public String matchFareEconomyText(){
        waitElementVisibility(fareEconomyText);
        return this.fareEconomyText.getText();
    }
}