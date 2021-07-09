package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DepartingFlightPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public DepartingFlightPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "select[data-test-id=\"sortDropdown\"]")
    private WebElement sortByPriceDropDown;

    @FindBy(css = "li button.uitk-card-link")
    private List<WebElement> departureFlightResultList;


    public void sortByPriceDropDown(){
        selectOptionOnDropDown(sortByPriceDropDown, 2);
    }

    public DepartureDetailPage clickOnDepartureFlight(){
        getDriver().navigate().refresh();
        clickOnElement(departureFlightResultList.get(0));
        return new DepartureDetailPage(getDriver());
    }

}
