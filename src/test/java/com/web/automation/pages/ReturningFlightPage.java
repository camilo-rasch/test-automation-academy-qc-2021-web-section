package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReturningFlightPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ReturningFlightPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "select[data-test-id=\"sortDropdown\"]")
    private WebElement sortByPriceDropDown;

    @FindBy(css = "li button.uitk-card-link")
    private List<WebElement> returningFlightResultList;


    public void sortByPriceDropDown(){
        selectOptionOnDropDown(sortByPriceDropDown, 2);
    }

    public ReturningDetailPage clickOnReturningFlight(){
        getDriver().navigate().refresh();
        clickOnElement(returningFlightResultList.get(1));
        return new ReturningDetailPage(getDriver());
    }
}
