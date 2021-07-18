package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerPaymentPage extends BasePage{
	
	@FindBy (id = "preferences")
	private WebElement whoIsTravelingSection;
	
	@FindBy (id = "insurance")
	private WebElement protectYourFlightSection;
	
	@FindBy (id = "payments")
	private WebElement customerPaymentSection;
	
	@FindBy (id = "email")
	private WebElement customerSendConfirmationFlightSection;
	
	@FindBy(id = "complete")
	private WebElement customerCompleteBookingSection;
	
	@FindBy (id = "firstname[0]")
	private WebElement firstName;
	
	@FindBy (id = "lastname[0]")
	private WebElement lastName;
	
	@FindBy (id = "phone-number[0]")
	private WebElement phoneNumber;
	
	@FindBy (id = "gender_male[0]")
	private WebElement genderMale;
	
	@FindBy (id = "gender_female[0]")
	private WebElement genderFemale;

	private String customerCountrySelector = "country_code[0]";
    Select customerCountry;
    
    private String customerMonthSelector = "date_of_birth_month0";
    Select customerMonth;
    
    private String customerDaySelector = "date_of_birth_day[0]";
    Select customerDay;
    
    private String customerYearSelector = "date_of_birth_year[0]";
    Select customerYear;
    
    /**
     * Constructor
     * @param pDriver
     */
	public CustomerPaymentPage(WebDriver pDriver) {
		super(pDriver);
		this.customerCountry = new Select(getDriver().findElement(By.id(this.customerCountrySelector)));
		this.customerMonth = new Select(getDriver().findElement(By.id(this.customerMonthSelector)));
		this.customerDay = new Select(getDriver().findElement(By.id(this.customerDaySelector)));
		this.customerYear = new Select(getDriver().findElement(By.id(this.customerYearSelector)));
	}
	
	/**
	 * Verify if Who is traveling section is displayed
	 * @return
	 */
	public boolean isWhoIsTravelingSectionPresent() {
		waitElementVisibility(this.whoIsTravelingSection);
		return this.whoIsTravelingSection.isDisplayed();
	}
	
	/**
	 * Verify is protect your flight section is displayed
	 * @return
	 */
	public boolean isProtectYourFlightSectionPresent() {
		waitElementVisibility(this.protectYourFlightSection);
		return this.protectYourFlightSection.isDisplayed();
	}
	
	/**
	 * Verify if customer payment section is present
	 * @return
	 */
	public boolean isCustomerPaymentSectionPresent() {
		waitElementVisibility(this.customerPaymentSection);
		return this.customerPaymentSection.isDisplayed();
	}
	
	/**
	 * Verify if customer send flight confirmation is present
	 * @return
	 */
	public boolean isCustomerSendConfirmationSectionPresent() {
		waitElementVisibility(this.customerSendConfirmationFlightSection);
		return this.customerSendConfirmationFlightSection.isDisplayed();
	}
	
	/**
	 * Verify if Customer complete booking section is visible
	 * @return
	 */
	public boolean isCustomerCompleteBookingSectionPresent() {
		waitElementVisibility(this.customerCompleteBookingSection);
		return this.customerCompleteBookingSection.isDisplayed();
	}
	
	/**
	 * Verify if first name field is present
	 * @return
	 */
	public boolean isFirstNamePresent() {
		waitElementVisibility(this.firstName);
		return this.firstName.isDisplayed();
	}
	
	/**
	 * Click on First name field
	 */
	public void clickOnFirstNameField() {
		waitElementVisibility(this.firstName);
		clickOnElement(this.firstName);
	}
	
	/**
	 * Fill first name field
	 * @param fName
	 */
	public void fillFirstNameField(String fName) {
		waitElementVisibility(this.firstName);
		this.firstName.sendKeys(fName);
		
	}
	
	/**
	 * Verify if last name field is present
	 * @return
	 */
	public boolean isLastNamePresent() {
		waitElementVisibility(this.lastName);
		return this.lastName.isDisplayed();
	}
	
	/**
	 * Click on last name field
	 */
	public void clickOnLastNameField() {
		waitElementVisibility(this.lastName);
		clickOnElement(this.lastName);
	}
	
	/**
	 * Fill last name field
	 * @param lName
	 */
	public void fillLastNameField(String lName) {
		waitElementVisibility(this.lastName);
		this.lastName.sendKeys(lName);
		
	}
	
	/**
	 * Verify if phone number is present
	 * @return
	 */
	public boolean isPhoneNumberPresent() {
		waitElementVisibility(this.phoneNumber);
		return this.phoneNumber.isDisplayed();
	}
	
	/**
	 * Click on phone number field
	 */
	public void clickOnPhoneNumberField() {
		waitElementVisibility(this.phoneNumber);
		clickOnElement(this.phoneNumber);
	}
	
	/**
	 * Fill phone number field
	 * @param pNumber
	 */
	public void fillPhoneNumberField(String pNumber) {
		waitElementVisibility(this.phoneNumber);
		this.phoneNumber.sendKeys(pNumber);
		
	}
	
	/**
	 * Verify if female gender is present
	 * @return
	 */
	public boolean isFemaleGenderPresent() {
		waitElementVisibility(this.genderFemale);
		return this.genderFemale.isDisplayed();
	}
	
	/**
	 * Click on female gender option
	 */
	public void clickOnFemaleGenderOption() {
		waitElementVisibility(this.genderFemale);
		clickOnElement(this.genderFemale);
	}
	
	/**
	 * Select customer birth month by index
	 * @param index
	 */
	public void selectOptionCustomerBirthMonthByIndex(int index){
        this.customerMonth.selectByIndex(index);
        log.info("Selected option: " + this.customerMonth.getFirstSelectedOption().getText());
    }
	
	/**
	 * Select customer country by index
	 * @param index
	 */
	public void selectOptionInCustomerTitleSelectByIndex(int index){
        this.customerCountry.selectByIndex(index);
        log.info("Selected option: " + this.customerCountry.getFirstSelectedOption().getText());
    }
	
	/**
	 * Select customer birth day by index
	 * @param index
	 */
	public void selectOptionCustomerBirthDayByIndex(int index){
        this.customerDay.selectByIndex(index);
        log.info("Selected option: " + this.customerDay.getFirstSelectedOption().getText());
    }
	
	/**
	 * Select customer birth year by index
	 * @param index
	 */
	public void selectOptionCustomerBirthYearByIndex(int index){
        this.customerYear.selectByIndex(index);
        log.info("Selected option: " + this.customerYear.getFirstSelectedOption().getText());
    }
	
	/**
	 * Complete customer basic information
	 * @param fName
	 * @param lName
	 * @param cCountry
	 * @param pNumber
	 * @param cMonth
	 * @param cDay
	 * @param cYear
	 */
	public void completeCustomerBasicInformation(String fName, String lName, int cCountry, String pNumber, int cMonth, int cDay, int cYear) {
		log.info("fill first name field");
        clickOnFirstNameField();
        fillFirstNameField(fName);
        log.info("fill last name field");
        clickOnLastNameField();
        fillLastNameField(lName);
        log.info("Select by index on Customer title Select");
        selectOptionInCustomerTitleSelectByIndex(cCountry);
        log.info("fill phone number field");
        clickOnPhoneNumberField();
        fillPhoneNumberField(pNumber);
        log.info("Select Female Gender");
        clickOnFemaleGenderOption();
        log.info("Select by index on Customer month Select");
        selectOptionCustomerBirthMonthByIndex(cMonth);
        log.info("Select by index on Customer day Select");
        selectOptionCustomerBirthDayByIndex(cDay);
        log.info("Select by index on Customer year Select");
        selectOptionCustomerBirthYearByIndex(cYear);
	}
}
