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

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "[data-test-id=\"flight-summary\"] h3 span")
    private WebElement departureTimeText;

    public String departureEstimatedTime(){
        try {
            waitElementVisibility(departureTimeText);
        }catch (Exception e){
            waitElementVisibility(departureTimeText);
        }
        return departureTimeText.getText();
    }


    public ReturningFlightPage clickOnContinueButton(){
        clickOnElement(continueButton);
        return new ReturningFlightPage(getDriver());
    }



}
