package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTabSample extends BasePage{

    @FindBy(id = "zen_cs_desc_with_promo_dynamic")
    private WebElement zen_container_element;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public NewTabSample(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Verify if zen container is displayed
     * @return boolean
     */
    public boolean is_zen_container_present(){
        waitElementVisibility(this.zen_container_element);
        return this.zen_container_element.isDisplayed();
    }

    /**
     * Switch to parent window
     * @param handle
     */
    public void switchToMainPage(String handle){
        getDriver().close();
        getDriver().switchTo().window(handle);
    }
}
