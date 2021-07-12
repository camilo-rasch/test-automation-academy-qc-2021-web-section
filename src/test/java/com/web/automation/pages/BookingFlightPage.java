package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingFlightPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public BookingFlightPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "[id=\"preferences\"]")
    private WebElement preferencesSection;

    @FindBy(css = "[id=\"insurance\"]")
    private WebElement insuranceSection;

    @FindBy(css = "[id=\"payments\"]")
    private WebElement paymentsSection;

    @FindBy(css = "[id=\"email\"]")
    private WebElement emailSection;

    @FindBy(css = "[id=\"complete\"]")
    private WebElement completeSection;

    @FindBy(css = "[class=\"segment no-target summary-segment\"]")
    private WebElement summarySection;

    public boolean preferencesSectionIsDisplayed(){
        return preferencesSection.isDisplayed();
    }

    public boolean insuranceSectionIsDisplayed(){
        return insuranceSection.isDisplayed();
    }

    public boolean paymentsSectionIsDisplayed(){
        return paymentsSection.isDisplayed();
    }

    public boolean emailSectionIsDisplayed(){
        return emailSection.isDisplayed();
    }

    public boolean completeSectionIsDisplayed(){
        return completeSection.isDisplayed();
    }

    public boolean summarySectionIsDisplayed(){
        return summarySection.isDisplayed();
    }
}
