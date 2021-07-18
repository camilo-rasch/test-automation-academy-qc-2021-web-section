package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
/**
 * Customer payment page class.
 * @author Jonathan.Triana.
 */
public class CustomerPaymentPage extends BasePage{

    private String customerCountrySelector = "country_code[0]";
    Select customerCountry;

    //Locator to find the title "Who's traveling?"
    @FindBy(css = "h2.faceoff-module-title")
    private WebElement whoIsTravelingText;

    //Locator to find the country code text
    @FindBy(css = ".select.primaryCountryCode>span")
    private WebElement countryCodeText;

    //Locator to find text "Roundtrip flight"
    @FindBy(css = "h2.product-title")
    private WebElement roundTripText;

    //Locator to find name on card field
    @FindBy(css = ".text.cc-cardholder-name>input")
    private WebElement nameOnCardField;

    //Locator to find phone number field
    @FindBy(css = ".product-description")
    private WebElement numberOfTicketsAndAdultsText;

    //Locator to find the name field of the first adult
    @FindBy(id = "firstname[0]")
    private WebElement nameFieldAdult1;

    //Locator to find the last name field of the first adult
    @FindBy(id = "lastname[0]")
    private WebElement lastNameFieldAdult1;

    //Locator to find the phone number field of the first adult
    @FindBy(id = "phone-number[0]")
    private WebElement phoneNumberFieldAdult1;

    //Locator to find the gender option of the first adult
    @FindBy(css = "[for='gender_male[0]']")
    private WebElement genderOptionAdult1;

    //Locator to find the name field of the second adult
    @FindBy(id = "firstname[1]")
    private WebElement nameFieldAdult2;

    //Locator to find the last name field of the second adult
    @FindBy(id = "lastname[1]")
    private WebElement lastNameFieldAdult2;

    //Locator to find the gender option of the second adult
    @FindBy(css = "[for='gender_female[1]']")
    private WebElement genderOptionAdult2;

    Select myDropDown;
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CustomerPaymentPage(WebDriver pDriver) {
        super(pDriver);
        this.customerCountry = new Select(getDriver().findElement(By.id(this.customerCountrySelector)));
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait, check if the element countryCodeText is displayed and control exceptions
     * @return existsElement(this.countryCodeText) boolean
     */
    public boolean isCountryPresent(){
        return existsElement(this.countryCodeText);
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait, check if the element nameOnCardField is displayed and control exceptions
     * @return existsElement(this.nameOnCardField) boolean
     */
    public boolean isNameOnCardPresent(){
        return existsElement(this.nameOnCardField);
    }
    /**
     * Method wait the element numberOfTicketsAndAdultsText and get the text
     * @return numberOfTicketsAndAdultsText.getText() String
     */
    public String matchNumberOfTicketsAndAdultsText(){
        waitElementVisibility(this.numberOfTicketsAndAdultsText);
        return numberOfTicketsAndAdultsText.getText();
    }
    /**
     * Method wait the element roundTripText and get the text
     * @return roundTripText.getText() String
     */
    public String matchRoundTripText(){
        waitElementVisibility(this.roundTripText);
        return roundTripText.getText();
    }
    /**
     * Method wait the element whoIsTravelingText and get the text
     * @return whoIsTravelingText.getText() String
     */
    public String matchWhoIsTravelingText(){
        waitElementVisibility(this.whoIsTravelingText);
        return this.whoIsTravelingText.getText();
    }
    /**
     * Method to fill the information of the first adult
     */
    public void informationAdult1(String nameAdult1,String lastnameAdult1, String codeAdult1, String phoneAdult1
    ,String monthBirthAdult1,String dayBirthAdult1,String yearBirthAdult1){

        clickOnElement(this.nameFieldAdult1);
        this.nameFieldAdult1.sendKeys(nameAdult1);
        clickOnElement(this.lastNameFieldAdult1);
        this.lastNameFieldAdult1.sendKeys(lastnameAdult1);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[name*='[0].phoneCountryCode']")));
        this.myDropDown.selectByValue(codeAdult1);
        clickOnElement(this.phoneNumberFieldAdult1);
        this.phoneNumberFieldAdult1.sendKeys(phoneAdult1);
        clickOnElement(this.genderOptionAdult1);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='month[0]']")));
        this.myDropDown.selectByValue(monthBirthAdult1);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='day[0]']")));
        this.myDropDown.selectByValue(dayBirthAdult1);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='year[0]']")));
        this.myDropDown.selectByValue(yearBirthAdult1);
    }
    /**
     * Method to fill the information of the second adult
     */
    public void informationAdult2(String nameAdult2,String lastnameAdult2,String monthBirthAdult2
    ,String dayBirthAdult2,String yearBirthAdult2){

        clickOnElement(this.nameFieldAdult2);
        this.nameFieldAdult2.sendKeys(nameAdult2);
        clickOnElement(this.lastNameFieldAdult2);
        this.lastNameFieldAdult2.sendKeys(lastnameAdult2);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='month[1]']")));
        this.myDropDown.selectByValue(monthBirthAdult2);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='day[1]']")));
        this.myDropDown.selectByValue(dayBirthAdult2);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='year[1]']")));
        this.myDropDown.selectByValue(yearBirthAdult2);
        clickOnElement(this.genderOptionAdult2);
    }
}