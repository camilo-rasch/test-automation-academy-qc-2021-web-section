package com.web.automation.pages;

import org.openqa.selenium.By;
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

    @FindBy(css = ".uitk-loading-bar-container")
    private WebElement loadingStatusBar;

    @FindBy(css = "section[data-test-id=\"sortBar\"]")
    private WebElement sortByDropDownField;

    @FindBy(css = "div[data-test-id=\"journey-duration\"]")
    private List<WebElement> journeyDurationList;



    public void sortByPriceDropDown() throws InterruptedException {

        Thread.sleep(9000);
        selectOptionOnDropDown(sortByPriceDropDown, 2);
    }

    public DepartureDetailPage clickOnDepartureFlight() throws InterruptedException {
       // waitElementIsNotVisible(loadingStatusBar);
        //Thread.sleep(10000);
        clickOnElement(departureFlightResultList.get(0));
        return new DepartureDetailPage(getDriver());
    }

    public boolean sortByDropDownFieldIsDisplayed(){
        return sortByDropDownField.isDisplayed();
    }

    public boolean selectButtonIsDisplayed() throws InterruptedException {
        Thread.sleep(9000);
        boolean existingTag = true;
        for (WebElement element: departureFlightResultList) {
            if(!element.getAttribute("data-test-id").contains("select-link")){
                existingTag = false;
            }
        }
        return existingTag;
    }

    public boolean journeyDurationIsDisplayed() {
        boolean existingText = true;
        for (WebElement element: departureFlightResultList) {
            if(!element.getAttribute("data-test-id").contains("journey-duration")){
                existingText = false;
            }
        }
        return existingText;
    }


}
