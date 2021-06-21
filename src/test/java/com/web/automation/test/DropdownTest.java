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
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dropdownPage.reload(url);
    }

    @Test(description = "Selecting Monday from a dropdown by index")
    public void selectOptionByIndex(){
        log.info("Opening homePage");
        dropdownPage = getHomePage();
        log.info("Selecting the option for \"Monday\" by index");
        Assert.assertEquals(dropdownPage.selectOptionByIndex(),"Day selected :- Monday");
        log.info("The selected day by index is: \"Monday\"");



    }

    @Test(description = "Selecting Saturday from a dropdown by value")
    public void selectOptionByValue(){
        log.info("Opening homePage");
        dropdownPage = getHomePage();
        log.info("Selecting the option for \"Saturday\" by value");
        Assert.assertEquals(dropdownPage.selectOptionByValue(),"Day selected :- Saturday");
        log.info("The selected day by index is: \"Saturday\"");
    }

    @Test(description = "Selecting Wednesday from a dropdown  by visible text")
    public void selectOptionByVisibleText(){
        log.info("Opening homePage");
        dropdownPage = getHomePage();
        log.info("Selecting the option for \"wednesday\" by visible text");
        Assert.assertEquals(dropdownPage.selectOptionByVisibleText(),"Day selected :- Wednesday");
        log.info("The selected day by index is: \"wednesday\"");
    }
}
