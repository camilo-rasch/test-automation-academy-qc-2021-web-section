package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interacting with the Facebook login page.
 * @author Lina Gallego
 */
public class LoginPage extends BasePage {

    //My Profile icon
    @FindBy(css = "a[href='/me/']")
    private WebElement myProfileIcon;
    //

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */

    public LoginPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Get Text title
     * @return String text title
     */

    /*
    public String getTitle() {
        log.info("Get Text title");
        waitElementVisibility(title);
        return title.getText();
    }
    */


}
