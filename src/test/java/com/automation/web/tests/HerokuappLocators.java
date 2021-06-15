package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Class for the in user test.
 * @author juancarlos.ortiz
 */
public class HerokuappLocators {
    String firstText = "By.css address a:nth-child(1)";
    String listThree = "By.css ul li:nth-child(3)";
    String menuList = "By.css menu li:nth-child(1)";
    String formButton = "By.id but";
    String resetButton = "By.id f0";
    String radioButtonOne = "By.id f3";
    String selectOption = "By.css select option:nth-child(3)";
    String tableValue = "By.css table tbody:nth-child(2) tr:nth-child(4) td:nth-child(3)";
    String tableValueText = "By.css table tbody:nth-child(1) tr:nth-child(5) td:nth-child(3)";
    String hyphenation = "By.css body:nth-child(2) div.container:nth-child(2) > p:nth-child(23)";
    String getHyphenationTitle = "By.css p.limited ~ h3:nth-of-type(even)";




}
