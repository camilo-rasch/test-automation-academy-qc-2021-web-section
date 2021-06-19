package com.web.automation.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    //Locator to find the customer id filed
    @FindBy(name = "cusid")
    private WebElement customerIdField;
    //Locator to find submit button
    @FindBy(name = "submit")
    private WebElement submitButton;
    //Locator to find a text in the home page
    @FindBy(css = ".barone")
    private WebElement homeText;

    /**
     * Page Constructor with url
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Wait until the element be present.
     * Click in the customer id field
     */
    public HomePage clickOnCustomerIdField() {
        waitElementVisibility(this.customerIdField);
        clickOnElement(this.customerIdField);
        return new HomePage(getDriver());
    }
    /**
     * Input an id in customer id field.
     */
    public HomePage sendKeysCustomerIdField(String id) {
        this.customerIdField.sendKeys(id);
        return new HomePage(getDriver());
    }
    /**
     * Click the submit button.
     */
    public HomePage clickOnSubmitButton() {
        clickOnElement(this.submitButton);
        return new HomePage(getDriver());
    }
    /**
     * With this method I can switch to the alert popup.
     * @return the value with the text of the label
     */
    public Alert switchToAlert() {
        return getDriver().switchTo().alert();
    }
    public String getTextHomeLabel() {
        waitElementVisibility(this.homeText);
        String label_text = this.homeText.getText();
        return label_text;
    }
}