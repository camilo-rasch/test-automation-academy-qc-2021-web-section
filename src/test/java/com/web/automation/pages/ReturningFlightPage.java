package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class Returning Flight Page.
 * @author juandaniel.castano@globant.com
 */

public class ReturningFlightPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ReturningFlightPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * WebElements are defined
     */

    @FindBy(css = "li button.uitk-card-link")
    private List<WebElement> returningFlightResultList;

    @FindBy(css = ".uitk-loading-bar-container")
    private WebElement loadingStatusBar;

    @FindBy(css = "[data-test-id=\"departure-time\"]")
    private List<WebElement> departureTimeList;

    /**
     *
     * @return ReturningDetailPage object
     */

    public ReturningDetailPage clickOnReturningFlight() {
       try {
           waitClickableElements(returningFlightResultList);
           clickOnElement(returningFlightResultList.get(2));
       }catch (Exception e){
           waitClickableElements(returningFlightResultList);
           clickOnElement(returningFlightResultList.get(2));
       }
        return new ReturningDetailPage(getDriver());
    }

    /**
     * Get the text from specific WebElement
     * @return String
     */

    public String returnEstimatedTime(){
        waitClickableElements(departureTimeList);
        return departureTimeList.get(2).getText();
    }
}
