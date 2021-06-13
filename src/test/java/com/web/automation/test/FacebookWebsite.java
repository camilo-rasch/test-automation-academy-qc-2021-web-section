package com.web.automation.test;

import org.openqa.selenium.By;

public class FacebookWebsite {

    //Login
    String inputEmail = "By.id(email)";
    String inputPassword = "By.id(email)";
    String buttonLogin = "By.id(u_0_h_TN)";

    //Logout
    String arrowDropdownMenuNavbar = "By.css(div[aria-label] > span > div[class] div[aria-label])";
    String optionLogoutDropdown = "By.css(div.knvmm38d div[aria-label='Cuenta'] div[data-nocookies] div[role='button'])";

    //MyProfile
    //The user should be logued
    String myProfileButtonNavbar = "By.css(a[href='/me/'])";

    //MyFriends
    //The user must be located on the profile
    String myFriendsOption = "By.css(div[role='tablist']:nth-child(1) a:nth-child(4))";


}
