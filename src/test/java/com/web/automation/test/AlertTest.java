package com.web.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    /**
     * Test cases for Alerts
     * @author harvey.yepes
     */


    @Test(description = "Selecting Monday from a dropdown by index")
    public void selectOptionByIndex(){
        log.info("Selecting the option \"Monday\" by index");
        log.info("The option selected is :- " + dropdownPage.selectOptionByIndex());
        Assert.assertEquals(dropdownPage.validateDaySelected(),"Day selected :- Monday");
    }

}
