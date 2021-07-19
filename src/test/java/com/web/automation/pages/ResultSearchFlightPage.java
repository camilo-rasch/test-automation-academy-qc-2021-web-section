package com.web.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class for interact with the ResultSearchFlight page.
 *
 * @author Silvana.Perez
 */
public class ResultSearchFlightPage extends BasePage {

    @FindBy(id = "listings-sort option")
    private List<WebElement> sortByBox;

    @FindBy(css = "div[data-test-id='journey-duration']")
    private List<WebElement> journeyDuration;

    @FindBy(css = "div[data-test-id='airline-info']")
    private List<WebElement> airline;

    @FindBy(css = "div[data-test-id='arrival-departure']")
    private List<WebElement> flightRoute;

    @FindBy(css = "button[class='uitk-card-link']")
    private List<WebElement> fligthDetail;

    @FindBy(css="li:first-child div[data-test-id*='arrival'] span")
    private WebElement departureTime;

    @FindBy(css="li:nth-child(3) div[data-test-id*='arrival'] span")
    private WebElement arrivalTime;

    @FindBy(css="h3[class*='uitk-flex-item'] span")
    private WebElement departureTimeSideBar;

    @FindBy(css = "option[value='DURATION_INCREASING']")
    private WebElement shortestDurationOption;

    @FindBy(css = "li[data-test-id*='listing']:nth-child(1)")
    private WebElement firstFlightList;

    @FindBy(css = "li[data-test-id*='listing']:nth-child(3)")
    private WebElement thirdFlightList;

    @FindBy(css = "button[data-test-id='select-button']")
    private WebElement continueButton;

    @FindBy(css = "a[aria-label*='No Thanks']")
    private WebElement noThanksLink;

    @FindBy(css=".uitk-price-a11y.is-visually-hidden")
    private List<WebElement> flightPriceList;

    private String sortByShortDurationSelector = "select[data-test-id='sortDropdown']";
    Select sortByShortDuration;

    private int value1 = 0;

    /**
     * Constructor.
     *
     * @param driver WebDriver
     */
    public ResultSearchFlightPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Sort by duration.
     *
     * @param shortDuration the short duration
     */
    public void sortByDuration(String shortDuration) {
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(sortByShortDurationSelector)));
        this.sortByShortDuration = new Select(getDriver().findElement(By.cssSelector(sortByShortDurationSelector)));
        this.sortByShortDuration.selectByValue(shortDuration);
    }


    /**
     * Is flight result sorted boolean.
     *
     * @return the boolean
     */
    public boolean isFlightResultSorted(){
        for (int i = 0; i < this.fligthDetail.size(); i++){
            if(i==0) {
                String firstTime = this.journeyDuration.get(0).getText();
                value1 = Integer.parseInt(firstTime.substring(0,1));
            }else if(i==24){
                String lastTime = this.journeyDuration.get(24).getText();
                int value2 = Integer.parseInt(lastTime.substring(0, 1));

                Assert.assertTrue(value2 >value1);
            }
        }

        return true;
    }

    /**
     * Select first departure flight.
     *
     * @return the string
     * @throws InterruptedException the interrupted exception
     */
    public String selectFirstDepartureFlight() throws InterruptedException {
        Thread.sleep(2000);
        getWait().until(ExpectedConditions.elementToBeClickable(this.firstFlightList));
        this.firstFlightList.click();
        return this.departureTime.getText();

    }

    /**
     * Select third departure flight.
     *
     * @return the string
     */
    public String selectThirdDepartureFlight() {
        waitElementVisibility(this.thirdFlightList);
        clickOnElement(this.thirdFlightList);
        return this.arrivalTime.getText();
    }

    /**
     * Is sort by duration present boolean.
     *
     * @return the boolean
     */
    public boolean isSortByDurationPresent() {
        for (WebElement element : this.sortByBox) {
            String elementText = element.getText();
            String expected = ("Price (Lowest), Price (Highest), Duration (Shortest), Duration (Longest), Departure (Earliest), Departure (Latest), Arrival (Earliest), Arrival (Latest)");
            if (!elementText.contains(expected)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Flight time matches string.
     *
     * @return the string
     */
    public String flightTimeMatches(){
        waitElementVisibility(this.departureTimeSideBar);
        return this.departureTimeSideBar.getText();
    }

    /**
     * Continue button.
     */
    public void continueButton(){
        this.clickOnElement(this.continueButton);
    }

    /**
     * Is flight price present.
     *
     * @return the boolean
     */
    public boolean isElementPresent() {
        int cont = 0;
        for (int i = 0; i < this.fligthDetail.size(); i++) {
            if(this.flightPriceList.get(i).isDisplayed()&& this.flightRoute.get(i).isDisplayed() && this.airline.get(i).isDisplayed() && this.journeyDuration.get(i).isDisplayed()){
                cont = cont + 1;
            }else if(!this.flightPriceList.get(i).isDisplayed()){
                System.out.println("Th price isn't present on every result");
            }else if(!this.flightRoute.get(i).isDisplayed()){
                System.out.println("The flight route isn't present on every result");
            }else if(!this.airline.get(i).isDisplayed()){
                System.out.println("The airline isn't present on every result");
            }else if(!this.journeyDuration.get(i).isDisplayed()){
                System.out.println("The journey duration isn't present on every result");
            }
        }
        return cont == this.fligthDetail.size();
    }

    /**
     * Handle popup window.
     *
     * @return the review trip page
     */
    public ReviewTripPage handlePopupWindow() {
        clickOnElement(this.noThanksLink);
        Set<String> windowsHandlesAfterClick = getDriver().getWindowHandles();

        for (String childWindow : windowsHandlesAfterClick) {
            String searchFlightsPageHandle = "";
            if (!searchFlightsPageHandle.equals(childWindow)) {
                getDriver().switchTo().window(childWindow);
            }
        }

        return new ReviewTripPage(getDriver());
    }

}
