package com.automation.web.tests;


public class FacebookLocators {

    /**
     * Class for the in user test.
     * @author Harvey.Yepes
     */

    //locators en CSS del login de Facebook
    //locators: #email, #pass, ._featuredLogin__formContainer div:nth-child(6)>button
    //Log In page:
    String email = "By.id #email";
    String password = "By.id #pass";
    String loginButton = "By.css ._featuredLogin__formContainer div:nth-child(6) > button";


    //Log out:
    //Primero dar Click en “Cuenta” y luego en “Cerrar Sesión”
    //locators: [role="banner"]  > div:nth-child(4) > div > span > div > div:first-child,
    // div:nth-child(4) div:nth-child(2) >div div:last-of-type> div:nth-child(5) > div > div:nth-child(4) > div > div:nth-child(1)

    String clickOnAccount = "By.css [role='banner']  > div:nth-child(4) > div > span > div > div:first-child";
    String clickOnLogOut = "By.css [role='banner'] > div:nth-child(4) div:nth-child(2) > div div:last-of-type > div:nth-child(5) > div > div:nth-child(4) > div > div:nth-child(1)";

    //Mi perfil
    //Dar click en el nombre
    String profile = "By.css [role='banner'] > div:nth-child(4) > div:first-child > div:last-child > a";

    //Mis amigos
    //Primero dar click en “Mi perfil” y luego click en “Amigos”
    //locators: [role="banner"] > div:nth-child(4)>div:first-child>div:last-child>a, [role="tablist"] > div > div >a:nth-child(4)

    String friends = "By.css [role='tablist'] > div > div > a:nth-child(4)";

}
