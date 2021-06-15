package com.automation.web.tests;

public class FacebookLocatorPage {
    //LOCATORS LOGIN
    String loginUsername = "by.css #email";
    String loginPassword = "by.css #pass";
    String loginButton = "by.css #u_0_h_jV";

    //LOCATORS LOGOUT
    String logOut = "by.css div[data-nocookies='true'] div[role ='button']";

    //LOCATORS MY PROFILE
    String myProfile = "by.css .buofh1pr:nth-child(1) li:nth-child(1) div a[href='https://www.facebook.com/norma.losada1']";

    //LOCATORS MY FRIENDS
    String elemendFriends = "by.css .buofh1pr:nth-child(1) li:nth-child(2) div a[href='https://www.facebook.com/friends/']";
}
