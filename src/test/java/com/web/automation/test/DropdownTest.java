package com.web.automation.test;

import com.web.automation.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
 * Test class
 * @author harvey.yepes
 */
public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;

    @AfterMethod
    @Parameters({"url"})
    public void reloadPage(String url){

        //Sleep added just to slow test flux in order to be more visible
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dropdownPage.reload(url);
    }

    @Test(description = "Selecting Monday from a dropdown by index")
    public void selectOptionByIndex(){
        log.info("Opening homePage");
        dropdownPage = getHomePage();
        log.info("Selecting the option \"Monday\" by index");
        log.info("The option selected is :- " + dropdownPage.selectOptionByIndex());
        Assert.assertEquals(dropdownPage.validateDaySelected(),"Day selected :- Monday");
    }
/*
    @Test(description = "Selecting Saturday from a dropdown by value")
    public void selectOptionByValue(){
        log.info("Opening homePage");
        dropdownPage = getHomePage();
        log.info("Selecting the option \"Saturday\" by value");
        log.info("The option selected by index is: "+ dropdownPage.selectOptionByValue());
        Assert.assertEquals(dropdownPage.validateDaySelected(),"Day selected :- Saturday");
        log.info("The " + dropdownPage.validateDaySelected());
    }

    @Test(description = "Selecting Wednesday from a dropdown  by visible text")
    public void selectOptionByVisibleText(){
        log.info("Opening homePage");
        dropdownPage = getHomePage();
        log.info("Selecting the option \"Wednesday\" by visible text");
        log.info("The option selected by index is: "+ dropdownPage.selectOptionByVisibleText());
        Assert.assertEquals(dropdownPage.validateDaySelected(),"Day selected :- Wednesday");
        log.info("The " + dropdownPage.validateDaySelected());
    }*/
}
