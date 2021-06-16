package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //This banner allows to see the log out button and personal profile
    @FindBy(css = "div[aria-label=\"Cuenta\"]")
    private WebElement accountBanner;

    //This button close the session
    @FindBy(css = "div:nth-child(4) > div > div.ow4ym5g4.auili1gw.rq0escxv.j83agx80.buofh1pr.g5gj957u.i1fnvgqd.oygrvhab.cxmmr5t8.hcukyx3x.kvgmc6g5.nnctdnn4.hpfvmrgz.qt6c0cv9.jb3vyjys.l9j0dhe7.du4w35lb.bp9cbjyn.btwxx1t3.dflh9lhu.scb9dxdr")
    private WebElement logOutButton;

    //This button redirect to the personal profile
    @FindBy(css = "circle[cx=\"30\"]")
    private WebElement personalProfile;


    /**
     * Page Constructor with url
     *
     * @param driver to execute
     * @param url    to get
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Page Constructor
     *
     * @param driver to execute
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }


}
