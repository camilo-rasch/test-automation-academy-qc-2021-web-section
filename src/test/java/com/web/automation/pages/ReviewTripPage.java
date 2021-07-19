package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class for interact with the Review Trip page.
 * @author silvana.perez
 */
public class ReviewTripPage extends BasePage {

    @FindBy(css="table[data-test-id='trip-total']")
    private WebElement tripTotalPrice;

    @FindBy(css="div[data-test-id='flight-review-0']")
    private WebElement departureDetails;

    @FindBy(css="ol[data-test-id='page-notifications'] h2")
    private WebElement returnDetails;

    @FindBy(css="div[data-test-id='fare-summary'] h3")
    private WebElement changeFeesInformation;

    @FindBy(css="button[aria-label='Continue to checkout']")
    private WebElement checkOutButton;

    /**
     * Constructor.
     * @param driver WebDriver
     *
     */
    public ReviewTripPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTripTotalPricePresent(){
        waitElementVisibility(this.tripTotalPrice);
        return this.tripTotalPrice.isDisplayed();
    }

    public boolean isDepartureDetailsPresent(){
        waitElementVisibility(this.departureDetails);
        return this.departureDetails.isDisplayed();
    }

    public String isChangeFeesInformationPresent(){
        waitElementVisibility(this.changeFeesInformation);
        return this.changeFeesInformation.getText();
    }

    public boolean isReturnDetailsPresent(){
        waitElementVisibility(this.returnDetails);
        return this.returnDetails.isDisplayed();
    }

    public WhosTravellingPage clickOnCheckOutButton(){
        getWait().until(ExpectedConditions.elementToBeClickable(this.checkOutButton));
        this.checkOutButton.click();
        return new WhosTravellingPage(getDriver());
    }

}
