package com.web.automation.test;

import com.web.automation.pages.HomePage;
import com.web.automation.pages.LoginPage;
import com.web.automation.pages.TwitterNewsFeed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExample extends BaseTest {

    String text = "El nombre de usuario y la contraseña que ingresaste no coinciden con " +
            "nuestros registros. Por favor, revisa e inténtalo de nuevo.";

    @AfterMethod
    @Parameters({"url"})
    public void reload(String url) {
        reload_page(url);
    }

    @Test(description = "Verify wrong credentials Twitter login")
    public void login_test() {
        log.info("Opening Twitter Home Page");
        HomePage homePage = getHomePage();
        log.info("Clicking on login button");
        LoginPage loginPage = homePage.clickOnLoginButton();
        log.info("Login in Twitter");
        loginPage.login("blalbla", "blbalal");
    }

    @Test(description = "Verify wrong credentials Twitter login")
    public void wrong_creds_test() {
        log.info("Opening Twitter Home Page");
        HomePage homePage = getHomePage();
        log.info("Clicking on login button");
        LoginPage loginPage = homePage.clickOnLoginButton();
        log.info("Login in Twitter");
        loginPage.login("blalbla", "blbalal");
        log.info("Assert aler error is displayed");
        Assert.assertTrue(loginPage.verify_alert_text_is_displayed(), "Verify Alert text is displayed");
        log.info("Assert alert error text matches");
        Assert.assertEquals(loginPage.get_alert_wrong_creds_text(),text, "Verify alert text matches");

    }
}
