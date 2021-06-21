package com.web.automation.test;

import com.web.automation.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
 * Test class
 * @author harvey.yepes
 */
public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;

    @BeforeMethod
    public void selectListDemo(){
        log.info("Select a day from the dropdown");
        dropdownPage = getHomePage();
    }

    @AfterMethod
    public void daySelectedDisplayed(){
        log.info("The " + dropdownPage.validateDaySelected());
    }

    @Test(description = "Selecting Monday from a dropdown by index")
    public void selectOptionByIndex(){
        log.info("Selecting the option \"Monday\" by index");
        log.info("The option selected is :- " + dropdownPage.selectOptionByIndex());
        Assert.assertEquals(dropdownPage.validateDaySelected(),"Day selected :- Monday");
    }

    @Test(description = "Selecting Saturday from a dropdown by value")
    public void selectOptionByValue(){
        log.info("Selecting the option \"Saturday\" by value");
        log.info("The option selected by value is: "+ dropdownPage.selectOptionByValue());
        Assert.assertEquals(dropdownPage.validateDaySelected(),"Day selected :- Saturday");
    }

    @Test(description = "Selecting Wednesday from a dropdown  by visible text")
    public void selectOptionByVisibleText(){
        log.info("Selecting the option \"Wednesday\" by visible text");
        log.info("The option selected by visible text is: "+ dropdownPage.selectOptionByVisibleText());
        Assert.assertEquals(dropdownPage.validateDaySelected(),"Day selected :- Wednesday");
    }
}
