package com.web.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Home page.
 *
 * @author jonathan.triana
 */
public class HomePage extends BasePage {
    @FindBy(css = "p.selected-value")
    private WebElement label_day;

    Select myDropDown;
    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        this.myDropDown = new Select(getDriver().findElement(By.id("select-demo")));
    }

    /**
     * Page Constructor
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage selectDropdownValue(String value) {
        this.myDropDown.selectByValue(value);
        return new HomePage(getDriver());
    }

    public String getTextLabelDropdownValue() {
        waitElementVisibility(this.label_day);
        String label_text = this.label_day.getText();
        return label_text;
    }
}
