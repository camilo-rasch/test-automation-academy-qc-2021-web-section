package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

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

    public void clickOnShowDetailsButton(){
        clickOnElement(showDetailButton);
    }

    public boolean flightDetailsInfoSectionIsDisplayed(){
        return flightDetailsInfoSection.isDisplayed();
    }

    public boolean totalPriceIsDisplayed(){
        return totalPrice.isDisplayed();
    }

    public boolean priceGuaranteeTextIsDisplayed(){
        return priceGuaranteeText.isDisplayed();
    }

    public ReviewTripPage clickOnContinueButton(){
        clickOnElement(continueButton);
        String currentWindowHandle = getDriver().getWindowHandle();

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while (i1.hasNext()){
            String childWindowHandle = i1.next();
            if(!currentWindowHandle.equalsIgnoreCase(childWindowHandle)){
                getDriver().switchTo().window(childWindowHandle);
            }
        }
        return new ReviewTripPage(getDriver());
    }



}
