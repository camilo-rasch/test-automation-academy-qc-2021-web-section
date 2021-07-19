package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Methods of the third windows
 * @author fabio.alarcon
 */
public class SecureBooking extends BasePage{

    @FindBy(css = "input[type=\"text\"]")
    private List<WebElement> inputTravelerInfo;

    @FindBy(css = "select[data-cko-rfrr-id=\"FLT.CKO.Phone.CountryCode\"]")
    private WebElement countryAndTerritoryCode;

    @FindBy(css = "input[data-tealeaf-name=\"phoneNumber\"]")
    private WebElement phoneNumber;

    @FindBy(css = "input[id=\"gender_female[0]\"]")
    private WebElement genderFemale;

    @FindBy(css = "input[id=\"gender_male[1]\"]")
    private WebElement genderMale;

    @FindBy(css = "select[data-cko-blur=\"fieldValidation,validateDateOfBirthOnBlur,trackOmniture\"]")
    private List<WebElement> birthDropDown;

    @FindBy(css = "h2[class=\"faceoff-module-title\"]")
    private WebElement whosTravelingbutton;

    @FindBy(css = "h2[class=\"product-title\"]")
    private WebElement typeOfTravel;

    @FindBy(css = "div[class=\"product-description\"]")
    private WebElement quantityOfTickets;

    @FindBy(css = "button[data-onclick=\"window.logButtonClick()\"]")
    private WebElement completeBookingButton;

    @FindBy(css = "select[data-custom-rules=\"validateStateDropdown\"]")
    private WebElement checkDropDown;

    @FindBy(id = "nav-tool-feedback")
    private WebElement commentsOfWebPage;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public SecureBooking(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Type first traveler name
     * @param name String
     */
    public void firstTravelerName(String name){
        travelerBasicInformation(inputTravelerInfo,1,name);
    }

    /**
     * Type first traveler middle name
     * @param middleName String
     */
    public void firstTravelerMiddleName(String middleName){
        travelerBasicInformation(inputTravelerInfo,2,middleName);
    }

    /**
     * Type first traveler last name
     * @param lastName String
     */
    public void firstTravelerLastName(String lastName){
        travelerBasicInformation(inputTravelerInfo,3,lastName);
    }

    /**
     * Select first traveler country
     * @param country String
     */
    public void firstTravelerCountry (String country) {
        dropDown(this.countryAndTerritoryCode,country);
        }

    /**
     * Type first traveler phone number
     * @param phoneNumber String
     */
    public void firstTravelPhoneNumber(String phoneNumber){
        clickOnElement(this.phoneNumber);
        this.phoneNumber.sendKeys(phoneNumber);
    }

    /**
     * Select first traveler gender
     */
    public void firstTravelGender(){
        clickOnElement(this.genderFemale);
    }

    /**
     * Type first traveler birth month
     * @param month String
     */
    public void firstTravelerBirthMonth(String month){
        WebElement birthMonth = this.birthDropDown.get(0);
        dropDown(birthMonth,month);
    }

    /**
     * Type first traveler birthday
     * @param day String
     */
    public void firstTravelerBirthDay(String day){
        WebElement birthDay = this.birthDropDown.get(1);
        dropDown(birthDay,day);
    }

    /**
     * Type first traveler birth year
     * @param year String
     */
    public void firstTravelerBirthYear(String year){
        WebElement birthYear = this.birthDropDown.get(2);
        dropDown(birthYear,year);
    }

    /**
     * Type second traveler name
     * @param name  String
     */
    public void secondTravelerName(String name){
        travelerBasicInformation(inputTravelerInfo,9,name);
    }

    /**
     * Type second traveler middle name
     * @param middleName String
     */
    public void secondTravelerMiddleName(String middleName){
        travelerBasicInformation(inputTravelerInfo,10,middleName);
    }

    /**
     * Type second traveler last name
     * @param lastName String
     */
    public void secondTravelerLastName(String lastName){
        travelerBasicInformation(inputTravelerInfo,11,lastName);
    }

    /**
     * Select second traveler gender
     */
    public void secondTravelGender(){
        clickOnElement(this.genderMale);
    }

    /**
     * Type second traveler birth month
     * @param month String
     */
    public void secondTravelerBirthMonth(String month){
        WebElement birthMonth = this.birthDropDown.get(3);
        dropDown(birthMonth,month);
    }

    /**
     * Type second traveler birthday
     * @param day String
     */
    public void secondTravelerBirthDay(String day){
        WebElement birthDay = this.birthDropDown.get(4);
        dropDown(birthDay,day);
    }

    /**
     * Type second traveler birth year
     * @param year String
     */
    public void secondTravelerBirthYear(String year){
        WebElement birthYear = this.birthDropDown.get(5);
        dropDown(birthYear,year);
    }

    /**
     * Confirm if "who's traveling" is selected
     * @return boolean
     */
    public boolean whosTraveling(){
        return this.whosTravelingbutton.isDisplayed();
    }

    /**
     * Confirm the type of traveler
     * @return String
     */
    public String typeOfTravel(){
        String typeOfTravel = this.typeOfTravel.getText();
        return typeOfTravel;
    }

    /**
     * Confirm the quantity of tickets booked
     * @return String
     */
    public String quantityOfTickets(){
        String quantityOfTickets = this.quantityOfTickets.getText();
        return quantityOfTickets;
    }

    /**
     * Confirm the last information booking
     * @return boolean
     */
    public boolean bookingButton(){
        return this.completeBookingButton.isEnabled();
    }

    /**
     * Confirm if "state" is a dropdown
     * @return boolean
     */
    public boolean stateDrpDown(){
        return this.checkDropDown.isEnabled();
    }

    /**
     * Confirm if a link is shown
     * @return booelan
     */
    public boolean whatYouThink(){
        return this.commentsOfWebPage.isEnabled();
    }

}
