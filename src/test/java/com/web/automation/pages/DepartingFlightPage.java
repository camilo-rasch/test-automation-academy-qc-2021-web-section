package com.web.automation.pages;

import com.google.common.base.CharMatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Departing Flight Page.
 * @author juandaniel.castano@globant.com
 */

public class DepartingFlightPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public DepartingFlightPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * WebElements are defined
     */

    @FindBy(css = "select[data-test-id=\"sortDropdown\"]")
    private WebElement sortByDropDown;

    @FindBy(css = "li button.uitk-card-link")
    private List<WebElement> departureFlightResultList;

    @FindBy(css = "section[data-test-id=\"sortBar\"]")
    private WebElement sortByDropDownField;

    @FindBy(css = "section .uitk-lockup-price")
    private List<WebElement> flightPriceList;

    @FindBy(css = "div[data-test-id=\"journey-duration\"]")
    private List<WebElement> journeyDurationList;

    @FindBy(css = "[data-test-id=\"arrival-departure\"]")
    private List<WebElement> routeFlightList;

    @FindBy(css = "[data-test-id=\"flight-operated\"]")
    private List<WebElement> airLineOperatorList;

    @FindBy(css = "[data-test-id=\"departure-time\"]")
    private List<WebElement> departureTimeList;

    /**
     * Sort By dropdown field is displayed
     * @return boolean
     */

    public boolean sortByDropDownFieldIsDisplayed(){
        try {
            waitElementVisibility(sortByDropDownField);
            return sortByDropDownField.isDisplayed();
        }catch (Exception e){
            getDriver().navigate().refresh();
            waitElementVisibility(sortByDropDownField);
            return sortByDropDownField.isDisplayed();
        }
    }

    /**
     * Select an option from DropDown field by index
     */

    public void sortByDropDown() {
        try {
            selectOptionOnDropDown(sortByDropDown, 2);
        }catch (Exception e){
            selectOptionOnDropDown(sortByDropDown, 2);
        }
    }

    /**
     *
     * @return DepartureDetailPage object
     */

    public DepartureDetailPage clickOnDepartureFlight() {
        try {
            clickOnElement(departureFlightResultList.get(0));
        }catch (Exception e){
            clickOnElement(departureFlightResultList.get(0));

        }
        return new DepartureDetailPage(getDriver());
    }

    /**
     * Get the text from specific WebElement
     * @return String
     */

    public String departureEstimatedTime(){
        return departureTimeList.get(0).getText();
    }

    /**
     * Validate if WebElement attribute is displayed
     * @return boolean
     */

    public boolean selectButtonIsDisplayed() {
        waitClickableElements(departureFlightResultList);
        boolean existingTag = true;
        for (WebElement element: departureFlightResultList) {
            if(!element.getAttribute("data-test-id").contains("select-link")){
                existingTag = false;
            }
        }
        return existingTag;
    }

    /**
     * Validate if WebElement attribute is displayed
     * @return boolean
     */

    public boolean flightPriceIsDisplayed() {
        boolean existingPrice = true;
        for (WebElement element: flightPriceList) {
            if(!element.getAttribute("class").contains("uitk-lockup-price")){
                existingPrice = false;
            }
        }
        return existingPrice;
    }

    /**
     * Validate if WebElement attribute is displayed
     * @return boolean
     */

    public boolean journeyDurationIsDisplayed() {
        boolean existingText = true;
        for (WebElement element: journeyDurationList) {
            if(!element.getAttribute("data-test-id").contains("journey-duration")){
                existingText = false;
            }
        }
        return existingText;
    }

    /**
     * Validate if WebElement attribute is displayed
     * @return boolean
     */

    public boolean routeAndAirLineFlightIsDisplayed() {
        boolean existingRoute = true;
        for (int i = 0; i < departureFlightResultList.size(); i++) {
            if(!(routeFlightList.get(i).getAttribute("data-test-id").contains("arrival-departure") || routeFlightList.get(i).getAttribute("data-test-id").contains("flight-operated"))){
                existingRoute = false;
            }
        }
        return existingRoute;
    }

    /**
     * Validate if data of WebElement list is sorted
     * @return boolean
     */

    public boolean listCorrectlySortedValidation(){
        boolean sortedList = true;
        char validateHour = 'h';
        double timeNumber;
        String journeyDurationTime;
        List<Double> journeyDurationList2 = new ArrayList<>();
        for (WebElement element : journeyDurationList) {
            char validateCharacter = element.getText().charAt(1);
            journeyDurationTime = CharMatcher.inRange('0', '9').retainFrom(element.getText());
            if(validateCharacter != validateHour){
                timeNumber = Double.parseDouble(journeyDurationTime) * 0.01;
            }else{
                timeNumber = Double.parseDouble(journeyDurationTime);
            }
            journeyDurationList2.add(timeNumber);
        }

        for (int i = 0; i < journeyDurationList2.size()-1; i++){
            if(journeyDurationList2.get(i) > journeyDurationList2.get(i+1)){
                sortedList = false;
            }
        }
        return sortedList;
    }

}
