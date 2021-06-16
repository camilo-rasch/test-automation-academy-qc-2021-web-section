package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators of the Facebook page.
 * @author Harvey.Yepes
 */
public class FacebookProfilePage extends BasePage{
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
    public FacebookProfilePage(WebDriver pDriver) {
        super(pDriver);
    }


    /**Ir a mis amigos**/
    @FindBy(css = "div[role='tablist'] > div > div > a:nth-child(4)")
    private WebElement myFriendsButton;


    /**Lista de amigos**/
    //Se da click en el botón "Todos los amigos"
    @FindBy(css = "div[role='tablist'] > div > div:nth-child(2) > a:nth-child(2)")
    private WebElement allFriendsButton;


    //Muestra la lista de amigos
    @FindBy(css = "div[data-pagelet = 'ProfileAppSection_0'] > div > div > div > div > div:last-child")
    private WebElement friendsList;

    //Selecciono el primer amigo de la lista
    @FindBy(css = "div[role='main'] > div:last-child > div > div > div > div > div > div > div > div > div:last-child > div:nth-child(1) > div > a")
    private WebElement selectFirstFriendLink;



    /**Cerrar sesión**/
    //Click en el botón "Cuenta" en la parte superior derecha del perfil
    @FindBy(css = "div[role='navigation'] > span > div > div:first-child")
    private WebElement accountButton;

    //Click en la opción "Cerrar Sesión"
    @FindBy(css = "div[role='dialog'] div > div:nth-child(4) > div > div:nth-child(1)")
    private WebElement logoutButton;


}
