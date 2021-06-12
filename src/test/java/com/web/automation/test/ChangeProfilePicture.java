package com.web.automation.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class ChangeProfilePicture {
    public Logger log = Logger.getLogger("");

    @BeforeTest()
    public void openBrowser() {
        log.info("Open the Browser");
    }

    @BeforeTest()
    public void openFacebookWebsite() {
        log.info("Go to the url www.facebook.com");
    }

    @BeforeMethod()
    public void enterEmail() {
        log.info("Enter a correct email");
    }

    @BeforeMethod()
    public void enterPassword() {
        log.info("Enter a correct password");
    }

    @Test()
    public void login() {
        log.info("Click on the button 'Iniciar Sesion' ");
    }

    @Test()
    public void profile() {
        log.info("Click on the profile picture");
    }

    @BeforeMethod()
    public void selectPicture() {
        log.info("Select a picture displayed on the list");
    }

    @Test()
    public void ChangeProfilePicture() {
        log.info("Click on the picture selected");
    }

    @Test()
    public void saveTheNewPicture() {
        log.info("Click on the button 'Guardar'");
    }

    @Test()
    public void goToFacebookLanding() {
        log.info("Click on the facebook icon");
    }

    @BeforeMethod()
    public void openArrowButton() {
        log.info("Click on arrow icon");
    }

    @Test()
    public void logOut() {
        log.info("Click on the option 'Cerrar Sesion'");
    }

    @AfterTest()
    public void closeBrowser() {
        log.info("Close the browser");
    }
}
