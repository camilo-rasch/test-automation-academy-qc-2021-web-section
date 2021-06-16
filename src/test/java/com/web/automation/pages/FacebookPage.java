package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators of the Facebook page.
 * @author Harvey.Yepes
 */
public class FacebookPage extends BasePage{
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
    public FacebookPage(WebDriver pDriver) {
        super(pDriver);
    }


    /**Iniciar sesión**/
    //Cajón de texto para ingresar email:
    @FindBy(id = "email")
    private WebElement emailInputText;

    //Cajón de texto para ingresar contraseña:
    @FindBy(id = "pass")
    private WebElement passwordInputText;

    //Botón para iniciar sesión
    @FindBy(name = "login")
    private WebElement loginButton;



    /**Ir a mi perfil**/
    @FindBy(css = "div[role='navigation'] > div:nth-child(5) > a")
    private WebElement profileLink;


    /**Ir a mis amigos**/
    @FindBy(css = "div[role='tablist'] > div > div > a:nth-child(4)")
    private WebElement myFriendsButton;


    /**Lista de amigos**/
    @FindBy(css = "div[role='tablist'] > div > div:nth-child(2) > a:nth-child(2)")
    private WebElement allFriendsButton;



    /**En el perfil de un amigo, el botón “enviar mensaje”**/
    //Para seleccionar un amigo de la lista
    @FindBy(css = "div[role='main'] > div:last-child > div > div > div > div > div > div > div > div > div:last-child > div:nth-child(1) > div > a")
    //[data-pagelet = 'ProfileAppSection_0'] > div > div > div > div > div:last-child
    private WebElement selectFriendLink;

    //En el perfil de un amigo se da click al botón "Mensaje"
    @FindBy(css = "div[data-pagelet='ProfileActions'] > div > div > div:nth-child(2)")

    private WebElement sendMessageButton;



    /**Cerrar sesión**/
    //Click en el botón "Cuenta" en la parte superior derecha del perfil
    @FindBy(css = "div[role='navigation'] > span > div > div:first-child")
    private WebElement accountButton;

    //Click en la opción "Cerrar Sesión"
    @FindBy(css = "div[role='dialog'] div > div:nth-child(4) > div > div:nth-child(1)")
    private WebElement logoutButton;


}
