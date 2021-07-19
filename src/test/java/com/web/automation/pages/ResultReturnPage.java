package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Set;

/**
 * Class for interact with the Result return page.
 *
 */
public class ResultReturnPage extends BasePage {

    @FindBy(css = "button[data-test-id=\"select-link\"]")
    private List<WebElement> returnResultList;

    @FindBy(css = "span[data-test-id='departure-time']")
    private List<WebElement> departureArrivalTime;

    @FindBy(css = "div[data-test-id=\"flight-summary\"] h3 span")
    private WebElement departureArrivalTimeDetail;

    @FindBy(css = "button[data-test-id=\"select-button\"]")
    private WebElement continueButton;

    @FindBy(css = "a[data-test-id=\"forcedChoiceNoThanks\"]")
    private WebElement noThanksButton;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ResultReturnPage(WebDriver pDriver) {
        super(pDriver);
    }


    /**
     * Click on the third flight result
     *
     */
    public void clickOnThirdResultList() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(returnResultList.get(2));
    }


    /**
     * Verify if departure and arrival time matches in sidebar flight review
     * @return compareTimeText
     */
    public boolean timeMatchesWithTimeDetail(){
        waitElementsVisibility(this.departureArrivalTime);
        String timeText = this.departureArrivalTime.get(2).getText();
        waitElementVisibility(this.departureArrivalTimeDetail);
        String timeDetailText = this.departureArrivalTimeDetail.getText();

        boolean compareTimeText = timeText.equalsIgnoreCase(timeDetailText);

        return compareTimeText;
    }


    /**
     * Click on continue button
     *
     */
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }


    /**
     * Click on No thanks button
     * @return TripSummaryPage (new tab)
     */
    public TripSummaryPage clickOnNoThanksButton() {

        clickOnElement(noThanksButton);

        String currentWindowHandle = getDriver().getWindowHandle();
        Set<String> windowHandles = getDriver().getWindowHandles();

        for (String childWindow : windowHandles) {
            if (!currentWindowHandle.equals(childWindow)) {
                getDriver().switchTo().window(childWindow);
            }
        }

        return new TripSummaryPage(getDriver());
    }

}