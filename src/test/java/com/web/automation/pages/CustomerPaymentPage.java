package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Class for interact with the Customer payment page.
 * @author norma.losada
 */

public class CustomerPaymentPage extends BasePage {

    private String customerCountrySelector = "country_code[0]";
    Select customerCountry;

    private String customerMonthBirthdaySelector = "date_of_birth_month0";
    Select customerMonthBirthday;

    private String customerDayBirthdaySelector = "date_of_birth_day[0]";
    Select customerDayBirthday;

    private String customerYearBirthdaySelector = "date_of_birth_year[0]";
    Select customerYearBirthday;

    private String customerMonthBirthdaySecondTravelerSelector = "date_of_birth_month1";
    Select customerMonthBirthdaySecondTraveler;

    private String customerDayBirthdaySecondTravelerSelector = "date_of_birth_day[1]";
    Select customerDayBirthdaySecondTraveler;

    private String customerYearBirthdaySecondTravelerSelector = "date_of_birth_year[1]";
    Select customerYearBirthdaySecondTraveler;

    @FindBy(css = "input[id*='firstname']")
    private WebElement firstNameFieldFirstTraveler;

    @FindBy(css = "input[id*='lastname']")
    private WebElement lastNameFieldFirstTraveler;

    @FindBy(css = "input[id='phone-number[0]']")
    private WebElement phoneNumberFieldFirstTraveler;

    @FindBy(css = "input[id='gender_female[0]']")
    private WebElement genderRadioButtonFirstTraveler;

    @FindBy(css = "input[id='firstname[1]']")
    private WebElement firstNameFieldSecondTraveler;

    @FindBy(css = "input[id='lastname[1]']")
    private WebElement lastNameFieldSecondTraveler;

    @FindBy(css = "input[id='gender_male[1]']")
    private WebElement genderRadioButtonSecondTraveler;

    @FindBy(css = "h1[class='flights generic-header']")
    private WebElement pageTitle;

    @FindBy(css = "h2[class='faceoff-module-title']")
    private WebElement formTravelerDetailTile;

    @FindBy(css = "legend[class=\"traveler-title\"]")
    private List<WebElement> travelersInformation;

    @FindBy(id = "payments")
    private WebElement paymentDetails;

    @FindBy(id = "email")
    private WebElement confirmationDetails;

    @FindBy(id = "complete")
    private WebElement reviewDetails;

    @FindBy(id = "summary-container")
    private WebElement summaryDetails;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CustomerPaymentPage(WebDriver pDriver) {
        super(pDriver);
        this.customerCountry = new Select(getDriver().findElement(By.id(this.customerCountrySelector)));
        this.customerMonthBirthday = new Select(getDriver().findElement(By.id(this.customerMonthBirthdaySelector)));
        this.customerDayBirthday = new Select(getDriver().findElement(By.id(this.customerDayBirthdaySelector)));
        this.customerYearBirthday = new Select(getDriver().findElement(By.id(this.customerYearBirthdaySelector)));
        this.customerMonthBirthdaySecondTraveler = new Select(getDriver().findElement(By.id(this.customerMonthBirthdaySecondTravelerSelector)));
        this.customerDayBirthdaySecondTraveler = new Select(getDriver().findElement(By.id(this.customerDayBirthdaySecondTravelerSelector)));
        this.customerYearBirthdaySecondTraveler = new Select(getDriver().findElement(By.id(this.customerYearBirthdaySecondTravelerSelector)));
    }

    /**
     * Click on firstName field first traveler and fill it
     * @param pName
     */
    public void fillFirstName(String pName) {
        clickOnElement(this.firstNameFieldFirstTraveler);
        typeOnElement(firstNameFieldFirstTraveler, pName);
    }

    /**
     * Click on lastName field first traveler and fill it
     * @param pLastName
     */
    public void fillLastName(String pLastName) {
        clickOnElement(this.lastNameFieldFirstTraveler);
        typeOnElement(lastNameFieldFirstTraveler, pLastName);
    }

    /**
     * Click on firstName field second traveler and fill it
     * @param pName
     */
    public void fillFirstNameSecondTraveler(String pName) {
        clickOnElement(this.firstNameFieldSecondTraveler);
        typeOnElement(firstNameFieldSecondTraveler, pName);
    }

    /**
     * Click on lastName field second traveler and fill it
     * @param pLastName
     */
    public void fillLastNameSecondTraveler(String pLastName) {
        clickOnElement(this.lastNameFieldSecondTraveler);
        typeOnElement(lastNameFieldSecondTraveler, pLastName);
    }

    /**
     * Click on phone number field and fill it
     * @param pPhoneNumber
     */
    public void fillPhoneNumber(String pPhoneNumber) {
        clickOnElement(this.phoneNumberFieldFirstTraveler);
        typeOnElement(phoneNumberFieldFirstTraveler, pPhoneNumber);
    }

    /**
     * Click on gender radio button first traveler and select it
     */
    public void selectGender() {
        clickOnElement(this.genderRadioButtonFirstTraveler);
    }

    /**
     * Click on gender radio button second traveler and select it
     */
    public void selectGenderSecondTraveler() {
        clickOnElement(this.genderRadioButtonSecondTraveler);
    }

    /**
     * Select country for the traveler
     * @param index
     */
    public void selectCountryByIndex(int index) {
        this.customerCountry.selectByIndex(index);
        log.info("Selected option: " + this.customerCountry.getFirstSelectedOption().getText());
    }

    /**
     * Select month of birthday for the first traveler
     * @param index
     */
    public void selectMonthBirthdayByIndex(int index) {
        this.customerMonthBirthday.selectByIndex(index);
        log.info("Selected option: " + this.customerMonthBirthday.getFirstSelectedOption().getText());
    }

    /**
     * Select day of birthday for the first traveler
     * @param index
     */
    public void selectDayBirthdayByIndex(int index) {
        this.customerDayBirthday.selectByIndex(index);
        log.info("Selected option: " + this.customerDayBirthday.getFirstSelectedOption().getText());
    }

    /**
     * Select year of birthday the first traveler
     * @param index
     */
    public void selectYearBirthdayByIndex(int index) {
        this.customerYearBirthday.selectByIndex(index);
        log.info("Selected option: " + this.customerYearBirthday.getFirstSelectedOption().getText());
    }

    /**
     * Select month of birthday for the second traveler
     * @param index
     */
    public void selectMonthBirthdaySecondTravelerByIndex(int index) {
        this.customerMonthBirthdaySecondTraveler.selectByIndex(index);
        log.info("Selected option: " + this.customerMonthBirthdaySecondTraveler.getFirstSelectedOption().getText());
    }

    /**
     * Select day of birthday for the second traveler
     * @param index
     */
    public void selectDayBirthdaySecondTravelerByIndex(int index) {
        this.customerDayBirthdaySecondTraveler.selectByIndex(index);
        log.info("Selected option: " + this.customerDayBirthdaySecondTraveler.getFirstSelectedOption().getText());
    }

    /**
     * Select year of birthday for the second traveler
     * @param index
     */
    public void selectYearBirthdaySecondTravelerByIndex(int index) {
        this.customerYearBirthdaySecondTraveler.selectByIndex(index);
        log.info("Selected option: " + this.customerYearBirthdaySecondTraveler.getFirstSelectedOption().getText());
    }

    /**
     * Set the first traveler basic information
     * @param firstName, pLastName, pPhoneNumber
     */
    public void setFirstTravelersBasicInformation(String firstName, String lastName, String pPhoneNumber) {
        fillFirstName(firstName);
        fillLastName(lastName);
        selectCountryByIndex(1);
        fillPhoneNumber(pPhoneNumber);
        selectGender();
        selectMonthBirthdayByIndex(3);
        selectDayBirthdayByIndex(15);
        selectYearBirthdayByIndex(30);
    }

    /**
     * Set the second traveler basic information
     * @param pFirstName, pLastName
     */
    public void setSecondTravelersBasicInformation(String pFirstName, String pLastName) {
        fillFirstNameSecondTraveler(pFirstName);
        fillLastNameSecondTraveler(pLastName);
        selectGenderSecondTraveler();
        selectMonthBirthdaySecondTravelerByIndex(4);
        selectDayBirthdaySecondTravelerByIndex(10);
        selectYearBirthdaySecondTravelerByIndex(30);
    }

    /**
     * Verify if the title page is displayed
     * @return boolean
     */
    public boolean isTheTitlePageDisplayed() {
        waitElementVisibility(this.pageTitle);
        return this.pageTitle.isDisplayed();
    }


    /**
     * @description: return Traveler Detail form title from the page.
     * return String
     */
    public String getTravelerDetailTitle() {
        String travelerDetailFormTitle = formTravelerDetailTile.getText();
        return travelerDetailFormTitle;
    }

    /**
     * Verify if traveler one and second information is displayed
     * @return boolean
     */
    public boolean isTheTravelerOneAndTravelerSecondInformationDisplayed() {
        int traveler = travelersInformation.size();
        boolean isPresent = false;
        int count = 0;
        for (int i = 0; i < traveler; i++) {
            if (travelersInformation.get(i).getText().contains("Traveler")) {
                isPresent = true;
            } else {
                isPresent = false;
            }
        }
        return isPresent;
    }

    /**
     * Verify if payment details is displayed
     * @return boolean
     */

    public boolean isPaymentDetailsDisplayed(){
        waitElementVisibility(paymentDetails);
        return paymentDetails.isDisplayed();
    }

    /**
     * Verify if confirmation details is displayed
     * @return boolean
     */

    public boolean isConfirmationDetailsDisplayed(){
        waitElementVisibility(confirmationDetails);
        return confirmationDetails.isDisplayed();
    }

    /**
     * Verify if review and book details is displayed
     * @return boolean
     */

    public boolean isReviewAndBookDisplayed(){
        waitElementVisibility(reviewDetails);
        return reviewDetails.isDisplayed();
    }

    /**
     * Verify if summary details is displayed
     * @return boolean
     */

    public boolean isSummaryDetailsDisplayed(){
        waitElementVisibility(summaryDetails);
        return summaryDetails.isDisplayed();
    }


}
