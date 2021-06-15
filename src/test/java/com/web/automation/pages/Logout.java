package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout {

    //Expandable frame icon
    @FindBy(css = "[role]>.iyyx5f41:nth-of-type(1) [role]")
    private WebElement expandableFrameIcon;

    //Logout option
    @FindBy(css = "[data-visualcompletion='ignore-dynamic']:nth-of-type(4) [data-visualcompletion='ignore']")
    private WebElement logoutLink;


}
