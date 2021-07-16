package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class Review Trip Page.
 * @author juandaniel.castano@globant.com
 */

public class ReviewTripPage extends BasePage{
    String totalTripPrice;
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */

    public ReviewTripPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * WebElements are defined
     */

    @FindBy(css = "button[data-test-id=\"goto-checkout-button\"]")
    private WebElement goToCheckOutButton;

    @FindBy(css = "[data-test-id=\"price-summary\"]")
    private WebElement priceSummarySection;

    @FindBy(css = ".uitk-table-foot span")
    private WebElement tripTotalPriceText;

    @FindBy(css = "[data-test-id=\"flight-review-0\"]")
    private WebElement departureReviewSection;

    @FindBy(css = "[data-test-id=\"flight-review-0\"] div[data-test-id=\"fare-summary\"] h3")
    private WebElement departingFlightFareText;

    @FindBy(css = "[data-test-id=\"flight-review-1\"]")
    private WebElement returnReviewSection;

    /**
     * Validate if WebElement is displayed
     * @return boolean
     */

    public boolean departureReviewSectionIsDisplayed(){
        waitElementVisibility(departureReviewSection);
        return departureReviewSection.isDisplayed();
    }

    /**
     * Validate if text of WebElement is displayed
     * @return boolean
     */

    public boolean departingFlightFareIsSelected(){
        waitElementVisibility(departingFlightFareText);
        return departingFlightFareText.getText().contains("Economy");
    }

    /**
     * Validate if WebElement is displayed
     * @return boolean
     */

    public boolean returnReviewSectionIsDisplayed(){
        waitElementVisibility(returnReviewSection);
        return returnReviewSection.isDisplayed();
    }

    /**
     * Validate if WebElement is displayed
     * @return boolean
     */

    public boolean priceSummarySectionIsDisplayed() {
        waitElementVisibility(priceSummarySection);
        return priceSummarySection.isDisplayed();
    }

    /**
     * Validate if WebElement is displayed
     * @return boolean
     */

    public boolean tripTotalPriceTextIsDisplayed() {
        waitElementVisibility(tripTotalPriceText);
        totalTripPrice = tripTotalPriceText.getText();
        return tripTotalPriceText.isDisplayed();
    }

    /**
     * Get total flight price text
     * @return String
     */

    public String getTotalFlightPrice(){
        return totalTripPrice;
    }

    /**
     *
     * @return BookingFlightPage object
     */

    public BookingFlightPage clickOnGoToCheckOutButton() {
        waitClickableElement(goToCheckOutButton);
        clickOnElement(goToCheckOutButton);
        return new BookingFlightPage(getDriver());
    }

}
