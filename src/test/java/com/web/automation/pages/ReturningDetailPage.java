package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

/**
 * Class Returning Detail Page.
 * @author juandaniel.castano@globant.com
 */

public class ReturningDetailPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ReturningDetailPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "footer span.uitk-lockup-price")
    private WebElement totalPrice;

    @FindBy(css = "div[data-test-id=\"show-details-link\"] > button")
    private WebElement showDetailButton;

    @FindBy(css = "[data-test-id=\"journey-section-0\"]")
    private WebElement flightDetailsInfoSection;

    @FindBy(css = "footer .uitk-price-subtext:last-child")
    private WebElement priceGuaranteeText;

    @FindBy(css = "[data-test-id=\"flight-summary\"] h3 span")
    private WebElement returnTimeText;

    public String returnEstimatedTime(){
        try {
            waitElementVisibility(returnTimeText);
        }catch (Exception e){
            waitElementVisibility(returnTimeText);
        }
        return returnTimeText.getText();
    }


    public ReviewTripPage clickOnContinueButton(){
        clickOnElement(continueButton);
        String currentWindowHandle = getDriver().getWindowHandle();

        Set<String> windowHandles = getDriver().getWindowHandles();

        for (String childWindowHandle : windowHandles) {
            if (!currentWindowHandle.equalsIgnoreCase(childWindowHandle)) {
                getDriver().switchTo().window(childWindowHandle);
            }
        }
        return new ReviewTripPage(getDriver());
    }



}
