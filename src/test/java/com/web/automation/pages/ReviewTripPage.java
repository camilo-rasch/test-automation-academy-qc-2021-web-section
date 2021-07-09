package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewTripPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ReviewTripPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "button[data-test-id=\"goto-checkout-button\"]")
    private WebElement goToCheckOutButton;

    public BookingFlightPage clickOnGoToCheckOutButton(){
        clickOnElement(goToCheckOutButton);
        return new BookingFlightPage(getDriver());
    }

}
