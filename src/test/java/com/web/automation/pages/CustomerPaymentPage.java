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
    
	public CustomerPaymentPage(WebDriver pDriver) {
		super(pDriver);
		this.customerCountry = new Select(getDriver().findElement(By.id(this.customerCountrySelector)));
		this.customerMonth = new Select(getDriver().findElement(By.id(this.customerMonthSelector)));
		this.customerDay = new Select(getDriver().findElement(By.id(this.customerDaySelector)));
		this.customerYear = new Select(getDriver().findElement(By.id(this.customerYearSelector)));
	}
	
	public boolean isWhoIsTravelingSectionPresent() {
		waitElementVisibility(this.whoIsTravelingSection);
		return this.whoIsTravelingSection.isDisplayed();
	}
	
	public boolean isProtectYourFlightSectionPresent() {
		waitElementVisibility(this.protectYourFlightSection);
		return this.protectYourFlightSection.isDisplayed();
	}
	
	public boolean isCustomerPaymentSectionPresent() {
		waitElementVisibility(this.customerPaymentSection);
		return this.customerPaymentSection.isDisplayed();
	}
	
	public boolean isCustomerSendConfirmationSectionPresent() {
		waitElementVisibility(this.customerSendConfirmationFlightSection);
		return this.customerSendConfirmationFlightSection.isDisplayed();
	}
	
	public boolean isCustomerCompleteBookingSectionPresent() {
		waitElementVisibility(this.customerCompleteBookingSection);
		return this.customerCompleteBookingSection.isDisplayed();
	}
	
	public boolean isFirstNamePresent() {
		waitElementVisibility(this.firstName);
		return this.firstName.isDisplayed();
	}
	
	public void clickOnFirstNameField() {
		waitElementVisibility(this.firstName);
		clickOnElement(this.firstName);
	}
	
	public void fillFirstNameField(String fName) {
		waitElementVisibility(this.firstName);
		this.firstName.sendKeys(fName);
		
	}
	
	public boolean isLastNamePresent() {
		waitElementVisibility(this.lastName);
		return this.lastName.isDisplayed();
	}
	
	public void clickOnLastNameField() {
		waitElementVisibility(this.lastName);
		clickOnElement(this.lastName);
	}
	
	public void fillLastNameField(String lName) {
		waitElementVisibility(this.lastName);
		this.lastName.sendKeys(lName);
		
	}
	
	public boolean isPhoneNumberPresent() {
		waitElementVisibility(this.phoneNumber);
		return this.phoneNumber.isDisplayed();
	}
	
	public void clickOnPhoneNumberField() {
		waitElementVisibility(this.phoneNumber);
		clickOnElement(this.phoneNumber);
	}
	
	public void fillPhoneNumberField(String pNumber) {
		waitElementVisibility(this.phoneNumber);
		this.phoneNumber.sendKeys(pNumber);
		
	}
	
	public boolean isFemaleGenderPresent() {
		waitElementVisibility(this.genderFemale);
		return this.genderFemale.isDisplayed();
	}
	
	public void clickOnFemaleGenderOption() {
		waitElementVisibility(this.genderFemale);
		clickOnElement(this.genderFemale);
	}
	
	public void selectOptionCustomerBirthMonthByIndex(int index){
        this.customerMonth.selectByIndex(index);
        log.info("Selected option: " + this.customerMonth.getFirstSelectedOption().getText());
    }
	
	public void selectOptionInCustomerTitleSelectByIndex(int index){
        this.customerCountry.selectByIndex(index);
        log.info("Selected option: " + this.customerCountry.getFirstSelectedOption().getText());
    }
	
	public void selectOptionCustomerBirthDayByIndex(int index){
        this.customerDay.selectByIndex(index);
        log.info("Selected option: " + this.customerDay.getFirstSelectedOption().getText());
    }
	
	public void selectOptionCustomerBirthYearByIndex(int index){
        this.customerYear.selectByIndex(index);
        log.info("Selected option: " + this.customerYear.getFirstSelectedOption().getText());
    }
	
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
