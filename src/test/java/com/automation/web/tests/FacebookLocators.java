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
public class FacebookLocators {
    //Log in locators
    String emailField = "By.id email";
    String passwordField = "By.id pass";
    String logInButton = "By.css ._featuredLogin__formContainer div:nth-child(6) > button";

    //Log out locators
    String accountButton = "By.css [role='banner']  > div:nth-child(4) > div > span > div > div:first-child";
    String logOutButton = "By.css ._featuredLogin__formContainer div:nth-child(6) > button";


    //My profile
    String profile = "By.css a[href='/me/']";

    //My friends
    String friends = "By.xpath //span[contains(text(),'See All Friends')]";



}
