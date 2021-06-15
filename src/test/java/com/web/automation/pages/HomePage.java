package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author jonathan.triana
 */
public class HomePage extends BasePage {

    //My profile option
    @FindBy(css = "div.fop5sh7t.fv0vnmcu.j83agx80")
    private WebElement profile_button;

    //Account option
    @FindBy(css = "div.[role='navigation'] > span > div > div:nth-child(1)")
    private WebElement account_button;

    //Log out button
    @FindBy(css = "div.b20td4e0.muag1w35 div:nth-child(4)")
    private WebElement logout_button;


    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Get Text title
     * @return String text title

    public String getTitle() {
        log.info("Get Text title");
        waitElementVisibility(title);
        return title.getText();
    }*/


}
