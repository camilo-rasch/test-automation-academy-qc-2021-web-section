package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Class for interact with the Who's Travelling page.
 *
 * @author Silvana.Perez
 */
public class WhosTravellingPage extends BasePage {

    @FindBy(css="fieldset[data-prefill-enabled='true'] h2")
    private WebElement whosTravelingTitle;

    @FindBy(id="preferences")
    private WebElement preferencesForm;

    @FindBy(css="div[data-lob='flight']")
    private WebElement insuranceFlightForm;

    @FindBy(css="body div article:nth-child(3)")
    private WebElement paymentForm;

    @FindBy(css="div[data-cko-throttle-event='scroll'] section section")
    private WebElement flightSummary;

    @FindBy(id="firstname[0]")
    private WebElement firstPassengerName;

    @FindBy(id="lastname[0]")
    private WebElement firstPassengerLastName;

    @FindBy(id="phone-number[0]")
    private WebElement phoneNumber;

    @FindBy(id="gender_female[0]")
    private WebElement gender;

    @FindBy(id="firstname[1]")
    private WebElement secondPassengerName;

    @FindBy(id="lastname[1]")
    private WebElement secondPassengerLastName;

    @FindBy(id="gender_male[1]")
    private WebElement secondGender;

    private String monthSelector = "date_of_birth_month0";
    private String month2Selector = "date_of_birth_month1";
    Select month;

    private String daySelector = "date_of_birth_day[0]";
    private String day2Selector = "date_of_birth_day[1]";
    Select day;

    private String yearSelector = "select[id='date_of_birth_year[0]']";
    private String year2Selector = "select[id='date_of_birth_year[1]']";
    Select year;

    private String customerCountrySelector = "country_code[0]";
    Select customerCountry;

    /**
     * Constructor.
     *
     * @param driver WebDriver
     */
    public WhosTravellingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * First passenger info.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param phoneNumber the phone number
     * @param countryCode the country code
     * @param month       the month
     * @param day         the day
     * @param year        the year
     */
    public void firstPassengerInfo(String firstName, String lastName, String phoneNumber, int countryCode, int month, int day, String year ) {
        waitElementVisibility(this.firstPassengerLastName);
        this.firstPassengerName.sendKeys(firstName);
        this.firstPassengerLastName.sendKeys(lastName);
        this.customerCountry = new Select(getDriver().findElement(By.id(customerCountrySelector)));
        this.customerCountry.selectByIndex(countryCode);
        this.phoneNumber.sendKeys(phoneNumber);
        clickOnElement(this.gender);
        this.month = new Select(getDriver().findElement(By.id(monthSelector)));
        this.month.selectByIndex(month);
        this.day = new Select(getDriver().findElement(By.id(daySelector)));
        this.day.selectByIndex(day);
        this.year = new Select(getDriver().findElement(By.cssSelector(yearSelector)));
        this.year.selectByValue(year);
    }

    /**
     * Second passenger info.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param month     the month
     * @param day       the day
     * @param year      the year
     */
    public void secondPassengerInfo(String firstName, String lastName, int month, int day, String year ) {
        waitElementVisibility(this.secondPassengerName);
        this.secondPassengerName.sendKeys(firstName);
        this.secondPassengerLastName.sendKeys(lastName);
        clickOnElement(this.secondGender);
        this.month = new Select(getDriver().findElement(By.id(month2Selector)));
        this.month.selectByIndex(month);
        this.day = new Select(getDriver().findElement(By.id(day2Selector)));
        this.day.selectByIndex(day);
        this.year = new Select(getDriver().findElement(By.cssSelector(year2Selector)));
        this.year.selectByValue(year);
    }

    /**
     * Is title present boolean.
     *
     * @return the boolean
     */
    public boolean isTitlePresent(){
        waitElementVisibility(this.whosTravelingTitle);
        return this.whosTravelingTitle.isDisplayed();
    }

    /**
     * Is presence form present boolean.
     *
     * @return the boolean
     */
    public boolean isPresenceFormPresent(){
        waitElementVisibility(this.preferencesForm);
        return this.preferencesForm.isDisplayed();
    }

    /**
     * Is insurance flight form present boolean.
     *
     * @return the boolean
     */
    public boolean isInsuranceFlightFormPresent(){
        waitElementVisibility(this.insuranceFlightForm);
        return this.insuranceFlightForm.isDisplayed();
    }

    /**
     * Is payment form present boolean.
     *
     * @return the boolean
     */
    public boolean isPaymentFormPresent(){
        waitElementVisibility(this.paymentForm);
        return this.paymentForm.isDisplayed();
    }

    /**
     * Is flight summary present boolean.
     *
     * @return the boolean
     */
    public boolean isFlightSummaryPresent(){
        waitElementVisibility(this.flightSummary);
        return this.flightSummary.isDisplayed();
    }

}
