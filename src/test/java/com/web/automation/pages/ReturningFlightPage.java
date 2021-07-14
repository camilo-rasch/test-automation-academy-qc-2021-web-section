package com.web.automation.pages;

import org.openqa.selenium.By;
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

    @FindBy(css = "#listings-sort")
    private WebElement sortByPriceDropDown;

    @FindBy(css = "li button.uitk-card-link")
    private List<WebElement> returningFlightResultList;

    @FindBy(css = ".uitk-loading-bar-container")
    private WebElement loadingStatusBar;


    public void sortByPriceDropDown(){

        try{
            selectOptionOnDropDown(sortByPriceDropDown, 2);
        }catch (Exception e){
            selectOptionOnDropDown(sortByPriceDropDown, 2);
        }
    }

    public ReturningDetailPage clickOnReturningFlight() throws InterruptedException {
        Thread.sleep(10000);
        clickOnElement(returningFlightResultList.get(2));
        return new ReturningDetailPage(getDriver());
    }
}
