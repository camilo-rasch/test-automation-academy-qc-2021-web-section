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

    @FindBy(css = "[id=\"lastname[0]\"]")
    private WebElement lastNameTraveler;

    @FindBy(css = "[id=\"phone-number[0]\"]")
    private WebElement phoneNumberTraveler;

    @FindBy(css = "[id=\"totalPriceForTrip\"]")
    private WebElement totalTripPriceText;

    @FindBy(css = "[id=\"country_code[0]\"]")
    private WebElement selectCountryNumberDropDown;

    @FindBy(css = "[id=\"gender_male[0]\"]")
    private WebElement selectMaleGenderRadioButton;

    @FindBy(css = "[id=\"date_of_birth_month0\"]")
    private WebElement selectMonthDropDown;

    @FindBy(css = "[id=\"date_of_birth_day[0]\"]")
    private WebElement selectDayDropDown;

    @FindBy(css = "[id=\"date_of_birth_year[0]\"]")
    private WebElement selectYearDropDown;

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
     * Get total flight price text
     * @return String
     */

    public String getTotalFlightPrice(){
        waitElementVisibility(totalTripPriceText);
        return totalTripPriceText.getText().trim();
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

    public void enterLastNameTraveler(){
        sendKeysOnElement(lastNameTraveler, "Castano");
    }

    /**
     * Send keys to spotted WebElement by given String
     */

    public void enterPhoneNumberTraveler(){
        sendKeysOnElement(phoneNumberTraveler, "399-019-0721");
    }

    /**
     * Select an option from DropDown field by index
     */

    public void selectCountryNumberDropDown() {
        try {
            selectOptionOnDropDown(selectCountryNumberDropDown, 45);
        }catch (Exception e){
            selectOptionOnDropDown(selectCountryNumberDropDown, 45);
        }
    }

    /**
     * Click On action in specific WebElement
     */

    public void clickOnGenderOption(){
        waitElementVisibility(selectMaleGenderRadioButton);
        clickOnElement(selectMaleGenderRadioButton);
    }

    /**
     * Select an option from DropDown field by index
     */

    public void selectBirthDayDateDropDown(){
        selectOptionOnDropDown(selectMonthDropDown, 8);
        selectOptionOnDropDown(selectDayDropDown, 25);
        selectOptionOnDropDown(selectYearDropDown, 30);
    }


}
