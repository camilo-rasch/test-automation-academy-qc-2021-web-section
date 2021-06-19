package com.web.automation.test;

import com.web.automation.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Parent of the other classes of pages.
 * @author Alejandro.Giraldo
 */

public class OptionListTest extends BaseTest {

    private HomePage homePage;

   @Test(description = "Test to verify a selected dropDown Option")
    public void selectOption(){
       String day="Tuesday";
       homePage=getHomePage();
       log.info("Day sent to Select: "+ day);
       log.info("Selecting Option From DropDownList");
       WebElement elementPicked = homePage.selectOptionList(day);
       log.info("Option Selected: "+ elementPicked.getText());
       log.info("Assertion, Day Picked = Day sent? ");
       Assert.assertTrue(homePage.isDayPicked(elementPicked, day), "Assert label day corresponds to Day sent");
    }

}
