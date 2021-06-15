package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(css = "div.fop5sh7t.fv0vnmcu.j83agx80")
    private WebElement profile_button;

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
