package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators of the Facebook page.
 * @author Harvey.Yepes
 */
public class FacebookFriendPage extends BasePage{
    /**En la siguiente página:
     https://www.facebook.com
     Inspeccionar y escribir en una clase de Java los locators de los elementos requeridos para:
     ● Iniciar sesión
     ● Cerrar sesión
     ● Ir a mi perfil
     ● Ir a mis amigos
     ● Lista de amigos
     ● En el perfil de un amigo, el botón “enviar mensaje”
     */


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public FacebookFriendPage(WebDriver pDriver) {
        super(pDriver);
    }


    /**En el perfil de un amigo, el botón “enviar mensaje”**/
    @FindBy(css = "div[data-pagelet='ProfileActions'] > div > div > div:nth-child(2)")
    private WebElement sendMessageButton;



    /**Ir a mi perfil**/
    @FindBy(css = "div[role='navigation'] > div:nth-child(5) > a")
    private WebElement profileLink;


    /**Cerrar sesión**/
    //Click en el botón "Cuenta" en la parte superior derecha del perfil
    @FindBy(css = "div[role='navigation'] > span > div > div:first-child")
    private WebElement accountButton;

    //Click en la opción "Cerrar Sesión"
    @FindBy(css = "div[role='dialog'] div > div:nth-child(4) > div > div:nth-child(1)")
    private WebElement logoutButton;

}
