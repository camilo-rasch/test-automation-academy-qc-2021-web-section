package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerPaymentPage extends BasePage{

    private String customerCountrySelector = "country_code[0]";
    Select customerCountry;

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
}
