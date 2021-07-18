package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
     * wait and check if the element countryCodeText is displayed
     * @return existsElement(this.countryCodeText) boolean
     */
    public boolean isCountryPresent(){
        return existsElement(this.countryCodeText);
    }
    /**
     * Method to send the element to existsElement method, there we
     * wait and check if the element nameOnCardField is displayed
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
     *
     *
     */
    public void informationAdult1(){
        clickOnElement(this.nameFieldAdult1);
        this.nameFieldAdult1.sendKeys("Name Adult uno");
        clickOnElement(this.lastNameFieldAdult1);
        this.lastNameFieldAdult1.sendKeys("Last name Adult uno");
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[name*='[0].phoneCountryCode']")));
        this.myDropDown.selectByValue("57");
        clickOnElement(this.phoneNumberFieldAdult1);
        this.phoneNumberFieldAdult1.sendKeys("3244566554");
        clickOnElement(this.genderOptionAdult1);
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='month[0]']")));
        this.myDropDown.selectByValue("09");
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='day[0]']")));
        this.myDropDown.selectByValue("30");
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='year[0]']")));
        this.myDropDown.selectByValue("1987");
    }
    /**
     *
     *
     */
    public void informationAdult2(){
        clickOnElement(this.nameFieldAdult2);
        this.nameFieldAdult2.sendKeys("Name Adult dos");
        clickOnElement(this.lastNameFieldAdult2);
        this.lastNameFieldAdult2.sendKeys("Last name Adult dos");
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='month[1]']")));
        this.myDropDown.selectByValue("07");
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='day[1]']")));
        this.myDropDown.selectByValue("17");
        this.myDropDown = new Select(getDriver().findElement(By.cssSelector("[data-tealeaf-name*='year[1]']")));
        this.myDropDown.selectByValue("1994");
        clickOnElement(this.genderOptionAdult2);
    }
}