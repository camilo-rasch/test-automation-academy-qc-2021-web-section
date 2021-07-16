package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class Review Trip Page.
 * @author juandaniel.castano@globant.com
 */

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

    @FindBy(css = "[data-test-id=\"price-summary\"]")
    private WebElement priceSummarySection;

    @FindBy(css = "[data-test-id=\"trip-total\"]")
    private WebElement tripTotalPriceText;

    @FindBy(css = "[data-test-id=\"flight-review-0\"]")
    private WebElement departureReviewSection;

    @FindBy(css = "[data-test-id=\"flight-review-0\"] div[data-test-id=\"fare-summary\"] h3")
    private WebElement departureFlightFareText;

    @FindBy(css = "[data-test-id=\"flight-review-1\"]")
    private WebElement returnReviewSection;

    @FindBy(css = "[data-test-id=\"flight-review-1\"] div[data-test-id=\"fare-summary\"] h3")
    private WebElement returnFlightFareText;

    public boolean departureReviewSectionIsDisplayed(){
        waitElementVisibility(departureReviewSection);
        return departureReviewSection.isDisplayed();
    }

    public boolean returnReviewSectionIsDisplayed(){
        waitElementVisibility(returnReviewSection);
        return returnReviewSection.isDisplayed();
    }

    public boolean priceSummarySectionIsDisplayed() {
        waitElementVisibility(priceSummarySection);
        return priceSummarySection.isDisplayed();
    }

    public boolean tripTotalPriceTextIsDisplayed() {
        waitElementVisibility(tripTotalPriceText);
        return tripTotalPriceText.isDisplayed();
    }

    public BookingFlightPage clickOnGoToCheckOutButton() {
        waitClickableElement(goToCheckOutButton);
        clickOnElement(goToCheckOutButton);
        return new BookingFlightPage(getDriver());
    }





}
