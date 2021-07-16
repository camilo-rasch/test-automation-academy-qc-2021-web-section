package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightConfirmationPage extends BasePage{

    @FindBy(css = "button[data-test-id='goto-checkout-button']")
    private WebElement checkOutButton;

    @FindBy(css = ".uitk-table-foot>tr>td>span")
    private WebElement tripTotal;

    @FindBy(css = "[data-test-id='flight-review-0']")
    private WebElement departureInformation;

    @FindBy(css = "[data-test-id='flight-review-1']")
    private WebElement returnInformation;

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

    public boolean isCheckOutButtonPresent(){
        return existsElement(this.checkOutButton);
    }

    public CustomerPaymentPage clickOnCheckOutButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getWait().until(ExpectedConditions.elementToBeClickable(this.checkOutButton));
        this.checkOutButton.click();
        return new CustomerPaymentPage(getDriver());
    }
    public boolean isTripTotalPresent(){
        return existsElement(this.tripTotal);
    }
    public boolean isDepartureInfoPresent(){
        return existsElement(this.departureInformation);
    }
    public boolean isReturnInfoPresent(){
        return existsElement(this.returnInformation);
    }
    public String matchFareEconomyText(){
        waitElementVisibility(fareEconomyText);
        return this.fareEconomyText.getText();
    }
}