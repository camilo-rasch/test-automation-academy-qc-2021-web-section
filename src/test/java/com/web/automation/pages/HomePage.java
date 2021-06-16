package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Class for interact with the home page.
 * @author camilo.mogollon
 */
public class HomePage extends BasePage {

    @FindBy(id = "openwindow")
    private WebElement openNewWindowButton;

    @FindBy(id = "opentab")
    private WebElement openNewTabButton;
    
    private String mainPageHandle = "";

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
     * Click on open new window button and switch to it
     * @return
     */
    public NewTabSample clickOnOpenNewPageButton(){
        String currentWindowHandle = getDriver().getWindowHandle();

        clickOnElement(this.openNewTabButton);

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while (i1.hasNext()){
            String childWindowHandle = i1.next();
            if(!currentWindowHandle.equalsIgnoreCase(childWindowHandle)){
                getDriver().switchTo().window(childWindowHandle);
            }
        }
        this.mainPageHandle = currentWindowHandle;
        return  new NewTabSample(getDriver());
    }

    /**
     * Click on open new tab button and switch to it
     * @return
     */
    public NewTabSample clickOnOpenNewTabButton(){
        clickOnElement(this.openNewWindowButton);

        String currentWindowHandle = getDriver().getWindowHandle();

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while (i1.hasNext()){
            String childWindowHandle = i1.next();
            if(!currentWindowHandle.equalsIgnoreCase(childWindowHandle)){
                getDriver().switchTo().window(childWindowHandle);
            }
        }
        this.mainPageHandle = currentWindowHandle;
        return  new NewTabSample(getDriver());
    }

    public String getMainPageHandle() {
        return mainPageHandle;
    }

    public void setMainPageHandle(String mainPageHandle) {
        this.mainPageHandle = mainPageHandle;
    }
}
