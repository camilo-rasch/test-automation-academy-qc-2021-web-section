package com.web.automation.pages;

import com.google.common.base.CharMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
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
    private WebElement sortByDropDown;

    @FindBy(css = "li button.uitk-card-link")
    private List<WebElement> departureFlightResultList;

    @FindBy(css = ".uitk-loading-bar-container")
    private WebElement loadingStatusBar;

    @FindBy(css = "section[data-test-id=\"sortBar\"]")
    private WebElement sortByDropDownField;

    @FindBy(css = "div[data-test-id=\"journey-duration\"]")
    private List<WebElement> journeyDurationList;



    public void sortByDropDown() {
        try {
            selectOptionOnDropDown(sortByDropDown, 2);
        }catch (Exception e){
            selectOptionOnDropDown(sortByDropDown, 2);
        }
    }

    public DepartureDetailPage clickOnDepartureFlight() {
        try {
            clickOnElement(departureFlightResultList.get(0));
        }catch (Exception e){
            clickOnElement(departureFlightResultList.get(0));
        }
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

    public boolean journeyDurationIsDisplayed(){
        boolean existingText = true;
        for (WebElement element: journeyDurationList) {
            if(!element.getAttribute("data-test-id").contains("journey-duration")){
                existingText = false;
            }
        }
        return existingText;
    }

    public boolean listCorrectlySortedValidation(){
        boolean sortedList = true;
        List<Integer> journeyDurationList2 = new ArrayList<>();
        for (WebElement element : journeyDurationList) {
            String journeyDurationTime = CharMatcher.inRange('0', '9').retainFrom(element.getText());
            int number = Integer.parseInt(journeyDurationTime);
            journeyDurationList2.add(number);
        }

        for (int i = 0; i < journeyDurationList2.size()-1; i++){
            if(journeyDurationList2.get(i) > journeyDurationList2.get(i+1)){
                sortedList = false;
            }
        }
        return sortedList;
    }

}
