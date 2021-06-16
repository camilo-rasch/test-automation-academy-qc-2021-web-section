package com.automation.web.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author silvana.perez
 */
public class FacebookHomePage {

    @FindBy(css = "a[href='https://www.facebook.com/david.goez']:first-child")
    private WebElement myProfile_Button;

    @FindBy(css = "a[href='https://www.facebook.com/david.goez/friends']:nth-child(4)")
    private WebElement Friends_Button;

    @FindBy(css = "div[aria-label='Cuenta'] i[class='hu5pjgll lzf7d6o1']")
    private WebElement Menu_Button;

    @FindBy(css = "div[data-nocookies='true'] div[role='button']")
    private WebElement signOut_Button;


}