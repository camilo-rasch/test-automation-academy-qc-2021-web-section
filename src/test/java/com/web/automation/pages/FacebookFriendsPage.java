package com.automation.web.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the friends page.
 * @author silvana.perez
 */

public class FacebookFriendsPage {

    @FindBy(css = "div[data-pagelet='ProfileAppSection_0'] div:nth-child(3) > div:first-child > div:nth-child(1)")
    private WebElement Friends_List;

    @FindBy(css = "div[data-pagelet='ProfileAppSection_0'] div:nth-child(3) > div:first-child > div:nth-child(1) >div:nth-child(3) > div:nth-child(1)")
    private WebElement Friend_element;

    @FindBy(css = "div[class='k4urcfbm'] div[aria-label='Mensaje']")
    private WebElement SendMessage_Button;


}