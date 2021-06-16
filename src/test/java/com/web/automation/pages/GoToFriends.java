package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoToFriends {

    //Field to type user email
    @FindBy(css = "#email")
    private WebElement userName;

    //Field to type user password
    @FindBy(css = "#pass")
    private WebElement password;

    //LogIn button
    @FindBy(css = "button[name=\"login\"]")
    private WebElement login_button;

    //Account button
    @FindBy(css = "div[aria-label=\"Cuenta\"]")
    private WebElement accountButton;

    //LogOut button
    @FindBy(css = "div[class=\"knvmm38d\"] > div > div > div > div > div > div > div > div div:nth-child(4)")
    private WebElement logOutButton;

    //Address to 'My Profile'
    @FindBy(css = "div[class=\"knvmm38d\"] > div > div > div > div > div > div > div > div > div")
    private WebElement goToProfileButton;

    //Go to 'View of all friends' link when you are located in profile section
    @FindBy(css = "div[data-pagelet=\"ProfileTilesFeed_{n}\"] > div > div > div > div > div  div > div > div > div > span > div > div > h2 > span > span > a ")
    private WebElement goToFriendsListButton;

    //Select a friend
    @FindBy(css = "div[class=\"sjgh65i0\"] > div > div > div > div:nth-child(3) > div")
    private WebElement selectTheFirstFriend;

    //Send a message to specific friend
    @FindBy(css = "div[data-pagelet=\"ProfileActions\"] > div > div > div:nth-child(2)")
    private WebElement sendMessageToFriendButton;
}
