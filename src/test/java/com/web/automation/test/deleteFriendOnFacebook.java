package com.web.automation.test;

import org.testng.annotations.*;

import java.util.logging.Logger;
public class deleteFriendOnFacebook {
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
        log.info("Click on the button Iniciar Sesion ");
    }

    @Test()
    public void profile() {
        log.info("Click on the profile picture");
    }

    @BeforeMethod()
    public void friends() {
        log.info("Click on the Friends word");
    }

    @BeforeMethod()
    public void searchAFriend() {
        log.info("Select a person on the list");
    }

    @BeforeMethod()
    public void threeDotsMenu() {
        log.info("Open the three dots menu");
    }

    @Test()
    public void deleteAFriend() {
        log.info("Click on the option 'Eliminar de mis amigos'");
    }

    @Test()
    public void confirmDeleteFriend() {
        log.info("Clink on the button 'Confirmar' once the modal is displayed");
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
