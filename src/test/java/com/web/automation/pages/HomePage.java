package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

/**
 * Class for interact with the home page.
 * @author jessica.cardona
 */
public class HomePage extends BasePage {

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    
    /**
     * Switch to Youtube Iframe
     * @return 
     */
    public YouTubeIframe playsVideoYouTubeIframe(){
    	
    	getDriver().switchTo().frame(0);
    	return  new YouTubeIframe(getDriver());
    }
    
    /**
     * Switch to Vimeo Iframe
     * @return 
     */
    public VimeoIframe playsVimeoIframe(){
    	
    	getDriver().switchTo().frame(1);
    	return  new VimeoIframe(getDriver());
    }
    
    
}
