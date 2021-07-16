package com.web.automation.pages;

import com.google.gson.JsonElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    public void firstTravelerName(String name){
        travelerBasicInformation(inputTravelerInfo,1,name);
    }

    public void firstTravelerMiddleName(String middleName){
        travelerBasicInformation(inputTravelerInfo,2,middleName);
    }

    public void firstTravelerLastName(String lastName){
        travelerBasicInformation(inputTravelerInfo,3,lastName);
    }

    public void firstTravelerCountry (String country) {
        dropDown(this.countryAndTerritoryCode,country);
        }

    public void firstTravelPhoneNumber(String phoneNumber){
        clickOnElement(this.phoneNumber);
        this.phoneNumber.sendKeys(phoneNumber);
    }

    public void firstTravelGender(){
        clickOnElement(this.genderFemale);
    }

    public void firstTravelerBirthMonth(String month){
        WebElement birthMonth = this.birthDropDown.get(0);
        dropDown(birthMonth,month);
    }

    public void firstTravelerBirthDay(String day){
        WebElement birthDay = this.birthDropDown.get(1);
        dropDown(birthDay,day);
    }

    public void firstTravelerBirthYear(String year){
        WebElement birthYear = this.birthDropDown.get(2);
        dropDown(birthYear,year);
    }

    public void secondTravelerName(String name){
        travelerBasicInformation(inputTravelerInfo,8,name);
    }

    public void secondTravelerMiddleName(String middleName){
        travelerBasicInformation(inputTravelerInfo,9,middleName);
    }

    public void secondTravelerLastName(String lastName){
        travelerBasicInformation(inputTravelerInfo,10,lastName);
    }

    public void secondTravelGender(){
        clickOnElement(this.genderMale);
    }

    public void secondTravelerBirthMonth(String month){
        WebElement birthMonth = this.birthDropDown.get(3);
        dropDown(birthMonth,month);
    }

    public void secondTravelerBirthDay(String day){
        WebElement birthDay = this.birthDropDown.get(4);
        dropDown(birthDay,day);
    }

    public void secondTravelerBirthYear(String year){
        WebElement birthYear = this.birthDropDown.get(5);
        dropDown(birthYear,year);
    }






    public boolean whosTraveling(){
        return this.whosTravelingbutton.isDisplayed();
    }

    public String typeOfTravel(){
        String typeOfTravel = this.typeOfTravel.getText();
        return typeOfTravel;
    }

    public String quantityOfTickets(){
        String quantityOfTickets = this.quantityOfTickets.getText();
        return quantityOfTickets;
    }

    public boolean bookingButton(){
        return this.completeBookingButton.isEnabled();
    }

    public boolean stateDrpDown(){
        return this.checkDropDown.isEnabled();
    }

    public boolean whatYouThink(){
        return this.commentsOfWebPage.isEnabled();
    }



}
