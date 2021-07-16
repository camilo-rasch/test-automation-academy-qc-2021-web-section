package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class Departure Detail Page.
 * @author juandaniel.castano@globant.com
 */

public class DepartureDetailPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public DepartureDetailPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * WebElements are defined
     */

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "[data-test-id=\"flight-summary\"] h3 span")
    private WebElement departureTimeText;

    /**
     * Get the text from specific WebElement
     * @return String
     */

    public String departureEstimatedTime(){
        try {
            waitElementVisibility(departureTimeText);
        }catch (Exception e){
            waitElementVisibility(departureTimeText);
        }
        return departureTimeText.getText();
    }

    /**
     *
     * @return ReturningFlightPage object
     */

    public ReturningFlightPage clickOnContinueButton(){
        clickOnElement(continueButton);
        return new ReturningFlightPage(getDriver());
    }



}
