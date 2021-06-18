
package com.web.automation.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(name = "cusid")
    private WebElement customerIdField;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(css = ".barone")
    private WebElement homeText;

    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    /**
     * Page Constructor
     *
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnCustomerIdField() {
        waitElementVisibility(this.customerIdField);
        clickOnElement(this.customerIdField);
        return new HomePage(getDriver());
    }
    public HomePage sendKeysCustomerIdField(String id) {
        this.customerIdField.sendKeys(id);
        return new HomePage(getDriver());
    }
    public HomePage clickOnSubmitButton() {
        clickOnElement(this.submitButton);
        return new HomePage(getDriver());
    }
    public Alert switchToAlert() {
        return getDriver().switchTo().alert();
    }
    public String getTextHomeLabel() {
        waitElementVisibility(this.homeText);
        String label_text = this.homeText.getText();
        return label_text;
    }

}