package com.automation.web.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the friends page.
 * @author silvana.perez
 */

public class FacebookFriendsPage {

    @FindBy(css = "[data-pagelet = 'ProfileAppSection_0'] > div > div > div > div > div:last-child")
    private WebElement Friends_List;

    @FindBy(css = "[data-pagelet = 'ProfileAppSection_0'] > div > div > div > div > div:last-child >div:first-child")
    private WebElement Friend_element;

    @FindBy(css = "div[class='k4urcfbm'] div[aria-label='Mensaje']")
    private WebElement SendMessage_Button;


}