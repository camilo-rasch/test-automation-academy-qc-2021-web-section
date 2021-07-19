package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Class for interact with the Passenger basic information page.
 *
 */
public class PassengerInfoPage extends BasePage{


    @FindBy(css = "input[id = \"firstname[0]\"]")
    private WebElement firstName;

    @FindBy(css = "input[id = \"middlename[0]\"]")
    private WebElement middleName;

    @FindBy(css = "input[id = \"lastname[0]\"]")
    private WebElement lastName;

    @FindBy(css = "input[id = \"phone-number[0]\"]")
    private WebElement phoneNumber;

    @FindBy(css = "input[id = \"gender_male[0]\"]")
    private WebElement gender;

    @FindBy(css = "input[id = \"firstname[1]\"]")
    private WebElement firstName1;

    @FindBy(css = "input[id = \"middlename[1]\"]")
    private WebElement middleName1;

    @FindBy(css = "input[id = \"lastname[1]\"]")
    private WebElement lastName1;

    @FindBy(css = "input[id = \"gender_female[1]\"]")
    private WebElement gender1;

    @FindBy(css = "fieldset[data-traveler-number=\"0\"]")
    private WebElement traveler1Info;

    @FindBy(css = "fieldset[data-traveler-number=\"1\"]")
    private WebElement traveler2Info;

    @FindBy(id = "flightInsuranceContainer")
    private WebElement flightInsurance;

    @FindBy(css = "div[class=\"card-option\"]")
    private WebElement paymentModeInfo;

    @FindBy(id = "complete-booking")
    private WebElement completeBookingButton;


    private Select countryDropDown;
    private Select monthDropDown;
    private Select dayDropDown;
    private Select yearDropDown;
    private Select monthDropDown1;
    private Select dayDropDown1;
    private Select yearDropDown1;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public PassengerInfoPage(WebDriver pDriver) {
        super(pDriver);
        countryDropDown = new Select(getDriver().findElement(By.cssSelector("select[data-cko-rfrr-id=\"FLT.CKO.Phone.CountryCode\"]")));
        monthDropDown = new Select(getDriver().findElement(By.cssSelector("select[id=\"date_of_birth_month0\"]")));
        dayDropDown = new Select(getDriver().findElement(By.cssSelector("select[id=\"date_of_birth_day[0]\"]")));
        yearDropDown = new Select(getDriver().findElement(By.cssSelector("select[id=\"date_of_birth_year[0]\"]")));
        monthDropDown1 = new Select(getDriver().findElement(By.cssSelector("select[id=\"date_of_birth_month1\"]")));
        dayDropDown1 = new Select(getDriver().findElement(By.cssSelector("select[id=\"date_of_birth_day[1]\"]")));
        yearDropDown1 = new Select(getDriver().findElement(By.cssSelector("select[id=\"date_of_birth_year[1]\"]")));
    }

    /**
     * Input basic information for the first passenger.
     *
     * @param firstName
     * @param middleName
     * @param lastName
     * @param phoneNumber
     */
    public void completePassengerBasicInfo(String firstName, String middleName, String lastName, String phoneNumber) {
        waitElementVisibility(this.firstName);
        this.firstName.sendKeys(firstName);

        waitElementVisibility(this.middleName);
        this.middleName.sendKeys(middleName);

        waitElementVisibility(this.lastName);
        this.lastName.sendKeys(lastName);

        countryDropDown.selectByValue("57");

        waitElementVisibility(this.phoneNumber);
        this.phoneNumber.sendKeys(phoneNumber);

        clickOnElement(gender);

        monthDropDown.selectByValue("08");
        dayDropDown.selectByValue("04");
        yearDropDown.selectByValue("1985");
    }

    /**
     * Input basic information for the second passenger.
     *
     * @param firstName1
     * @param middleName1
     * @param lastName1
     */
    public void completePassenger2BasicInfo(String firstName1, String middleName1, String lastName1) {
        waitElementVisibility(this.firstName1);
        this.firstName1.sendKeys(firstName1);

        waitElementVisibility(this.middleName1);
        this.middleName1.sendKeys(middleName1);

        waitElementVisibility(this.lastName1);
        this.lastName1.sendKeys(lastName1);

        clickOnElement(gender1);

        monthDropDown1.selectByValue("08");
        dayDropDown1.selectByValue("14");
        yearDropDown1.selectByValue("1991");
    }

    /**
     * Verify if the basic information for the first passenger is displayed
     *
     */
    public boolean isTraveler1InfoDisplayed() {
        waitElementVisibility(traveler1Info);
        return traveler1Info.isDisplayed();
    }

    /**
     * Verify if the basic information for the second passenger is displayed
     *
     */
    public boolean isTraveler2InfoDisplayed() {
        waitElementVisibility(traveler2Info);
        return traveler2Info.isDisplayed();
    }

    /**
     * Verify if the flight insurance is displayed
     *
     */
    public boolean isFlightInsuranceDisplayed() {
        waitElementVisibility(flightInsurance);
        return flightInsurance.isDisplayed();
    }

    /**
     * Verify if the payment mode information is displayed
     *
     */
    public boolean isPaymentModeInfoDisplayed() {
        waitElementVisibility(paymentModeInfo);
        return paymentModeInfo.isDisplayed();
    }

    /**
     * Verify if the complete booking button is displayed
     *
     */
    public boolean isCompleteBookingButtonDisplayed() {
        waitElementVisibility(completeBookingButton);
        return completeBookingButton.isDisplayed();
    }
}
