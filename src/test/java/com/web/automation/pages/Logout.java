package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout {

    //Expandable frame icon
    @FindBy(css = "div[aria-label=Account]")
    private WebElement expandableFrameIcon;

    //Logout option
    @FindBy(css = "[data-visualcompletion='ignore-dynamic']:nth-of-type(4) [role]")
    private WebElement logoutLink;


}
