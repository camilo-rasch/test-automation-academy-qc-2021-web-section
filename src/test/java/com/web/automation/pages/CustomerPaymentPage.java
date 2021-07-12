package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerPaymentPage extends BasePage{

    private String customerCountrySelector = "country_code[0]";
    Select customerCountry;

    @FindBy(css = "h2.faceoff-module-title")
    private WebElement whoIsTravelingText;
    @FindBy(css = "label.select.primaryCountryCode")
    private WebElement country;
    @FindBy(css = "h2.product-title")
    private WebElement roundTripText;
    @FindBy(css = "label.text.cc-cardholder-name>input")
    private WebElement nameOnCard;
    @FindBy(css = "label.text.phone-number.primary-phone >input")
    private WebElement phoneNumber;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CustomerPaymentPage(WebDriver pDriver) {
        super(pDriver);
        this.customerCountry = new Select(getDriver().findElement(By.id(this.customerCountrySelector)));
    }

    public void selectOptionInCustomerTitleSelectByIndex(int index){
        this.customerCountry.selectByIndex(index);
        log.info("Selected option: " + this.customerCountry.getFirstSelectedOption().getText());
    }

    public boolean isWhoIsTravelingPresent(){
        waitElementVisibility(this.whoIsTravelingText);
        return this.whoIsTravelingText.isDisplayed();
    }

    public boolean isCountryPresent(){
        waitElementVisibility(this.country);
        return this.country.isDisplayed();
    }

    public boolean isRoundTripPresent(){
        waitElementVisibility(this.roundTripText);
        return this.roundTripText.isDisplayed();
    }

    public boolean isNameOnCardPresent(){
        waitElementVisibility(this.nameOnCard);
        return this.nameOnCard.isDisplayed();
    }

    public boolean isPhoneNumberPresent(){
        waitElementVisibility(this.phoneNumber);
        return this.phoneNumber.isDisplayed();
    }

}