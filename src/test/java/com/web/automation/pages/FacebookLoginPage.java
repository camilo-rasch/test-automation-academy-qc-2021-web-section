package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators of the Facebook page.
 * @author Harvey.Yepes
 */
public class FacebookLoginPage extends BasePage{
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
    public FacebookLoginPage(WebDriver pDriver) {
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


}
