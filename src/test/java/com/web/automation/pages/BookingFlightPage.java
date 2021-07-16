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

    /**
     * WebElements are defined
     */

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

    @FindBy(css = "[id=\"phone-number[0]\"]")
    private WebElement phoneNumberTraveler;

    /**
     * Desired WebElement is displayed
     * @return boolean
     */

    public boolean preferencesSectionIsDisplayed() {
        waitElementVisibility(preferencesSection);
        return preferencesSection.isDisplayed();
    }

    /**
     * Desired WebElement is displayed
     * @return boolean
     */

    public boolean insuranceSectionIsDisplayed(){
        waitElementVisibility(insuranceSection);
        return insuranceSection.isDisplayed();
    }

    /**
     * Desired WebElement is displayed
     * @return boolean
     */

    public boolean paymentsSectionIsDisplayed(){
        waitElementVisibility(paymentsSection);
        return paymentsSection.isDisplayed();
    }

    /**
     * Desired WebElement is displayed
     * @return boolean
     */

    public boolean emailSectionIsDisplayed(){
        waitElementVisibility(emailSection);
        return emailSection.isDisplayed();
    }

    /**
     * Desired WebElement is displayed
     * @return boolean
     */

    public boolean completeSectionIsDisplayed(){
        waitElementVisibility(completeSection);
        return completeSection.isDisplayed();
    }

    /**
     * Desired WebElement is displayed
     * @return boolean
     */

    public boolean summarySectionIsDisplayed(){
        waitElementVisibility(summarySection);
        return summarySection.isDisplayed();
    }

    /**
     * Send keys to spotted WebElement by given String
     */

    public void enterFirstNameTraveler(){
        sendKeysOnElement(firstNameTraveler, "Juan");
    }

    /**
     * Send keys to spotted WebElement by given String
     */

    public void enterMiddleNameTraveler(){
        sendKeysOnElement(middleNameTraveler, "Daniel");
    }

    /**
     * Send keys to spotted WebElement by given String
     */

    public void enterLastNameTraveler(){
        sendKeysOnElement(lastNameTraveler, "Castano");
    }

    /**
     * Send keys to spotted WebElement by given String
     */

    public void enterPhoneNumberTraveler(){
        sendKeysOnElement(lastNameTraveler, "019-007-2021");
    }


}
