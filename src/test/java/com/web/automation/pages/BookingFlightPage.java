package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class Booking Flight Page.
 * @author juandaniel.castano@globant.com
 */

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

    @FindBy(css = "#summary-container")
    private WebElement summarySection;

    @FindBy(css = "[id=\"firstname[0]\"]")
    private WebElement firstNameTraveler;

    @FindBy(css = "[id=\"middlename[0]\"]")
    private WebElement middleNameTraveler;

    @FindBy(css = "[id=\"lastname[0]\"]")
    private WebElement lastNameTraveler;


    public boolean preferencesSectionIsDisplayed() {
        waitElementVisibility(preferencesSection);
        return preferencesSection.isDisplayed();
    }

    public boolean insuranceSectionIsDisplayed(){
        waitElementVisibility(insuranceSection);
        return insuranceSection.isDisplayed();
    }

    public boolean paymentsSectionIsDisplayed(){
        waitElementVisibility(paymentsSection);
        return paymentsSection.isDisplayed();
    }

    public boolean emailSectionIsDisplayed(){
        waitElementVisibility(emailSection);
        return emailSection.isDisplayed();
    }

    public boolean completeSectionIsDisplayed(){
        waitElementVisibility(completeSection);
        return completeSection.isDisplayed();
    }

    public boolean summarySectionIsDisplayed(){
        waitElementVisibility(summarySection);
        return summarySection.isDisplayed();
    }

    public void enterFirstNameTraveler(){
        sendKeysOnElement(firstNameTraveler, "Juan");
    }

    public void enterMiddleNameTraveler(){
        sendKeysOnElement(middleNameTraveler, "Daniel");
    }

    public void enterLastNameTraveler(){
        sendKeysOnElement(lastNameTraveler, "Castano");
    }



}
