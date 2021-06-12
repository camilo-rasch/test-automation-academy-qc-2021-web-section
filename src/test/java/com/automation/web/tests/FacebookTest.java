package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the facebook page test.
 * @author harvey.yepes
 */
public class FacebookTest {

    public Logger log = Logger.getLogger(FacebookTest.class);

    @BeforeSuite
    public void preconditions(){
        log.info("\n*******************************************************************************" +
                "\nTaller 1: Pasos para eliminar un amigo de Facebook y cambiar la foto de perfil" +
                "\n*******************************************************************************");
        log.info("Tener una cuenta creada en Facebook");
        log.info("Tener al menos un amigo agregado en tu perfil");
        log.info("Tener foto de perfil");
    }

    @BeforeTest
    public void goToFacebook(){
        log.info("Abrir navegador");
        log.info("Ingresar la url: \"http://www.facebook.com\" y Enter");
    }

    @BeforeClass
    public void logIn(){
        log.info("Ingresa correo electrónico o número de teléfono");
        log.info("Ingresa tu contraseña");
        log.info("Click en el botón \"Iniciar sesión\"");
    }

    @BeforeMethod
    public void goToMyProfile(){
        log.info("Click en mi nombre para ir a Mi Perfil");
    }

    @Test(description = "Eliminar amigo")
    public void deleteFriend() {
        log.info("Click en la etiqueta \"Amigos\"");
        log.info("Click en el nombre del amigo que quieres eliminar");
        log.info("Click en el botón \"Amigos\"");
        log.info("Click en la opción \"Eliminar de mis amigos\"");
        log.info("Click en el botón \"Confirmar\"");
    }

    @Test(description = "Cambiar foto de perfil")
    public void profilePicture() {
        log.info("Click en mi foto de perfil");
        log.info("Click en la opción \"Actualizar foto del perfil\"");
        log.info("Seleccionar una foto de la galería");
        log.info("Click en el botón \"Guardar\"");
    }

    @AfterTest
    public void logOut(){
        log.info("Click en el botón \"Cuenta\"");
        log.info("Click en \"Cerrar sesión\"");
    }

    @AfterSuite
    public void closeBrowser(){
        log.info("Cerrar el navegador");
    }
}
