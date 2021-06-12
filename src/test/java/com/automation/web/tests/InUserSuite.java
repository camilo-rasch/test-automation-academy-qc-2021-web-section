package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Class for the in user test.
 * @author camilo.mogollon
 */
public class InUserSuite {

    public Logger log = Logger.getLogger(InUserSuite.class);

    @AfterTest()
    public void afterTest() {
        log.info("Cerrar el Navegador");
    }


    @Test(description = "Set 1")
    public void testCaseAEliminarAmigo() {

        log.info("Ir a la sección 'Amigos'");
        log.info("Dar click en 'Ver todos los amigos'");
        log.info("Ingresar el nombre del amigo a eliminar en el campo 'Buscar amigos'");
        log.info("Dar click en la imagen o en el nombre del amigo que deseo borrar");
        log.info("Dar click en el botón con tres puntos");
        log.info("Dar click en el icono de persona color azul del amigo que deseo eliminar");
    }


    @Test(description = "Set 2")
    public void testCaseBCambiarFotoPerfil() {
        log.info("Dar click en la foto con icono de cámara");
        log.info("Dar click en Seleccionar nueva foto de perfil y reemplazar");
    }


    @BeforeSuite()
    public void beforeSuite() {
        log.info("Abrir el navegador");

    }

    @BeforeMethod()
    public void beforeMethod() {
        log.info("Ingresar la url: www.facebook.com");
        log.info("Ingresar el correo en el campo 'Email or Phone number'");
        log.info("Ingresar el password en el campo 'Password'");
        log.info("Ir a mi perfil 'Icono con Foto'");
    }

    @AfterMethod()
    public void afterMethod() {
        log.info("Cerrar Sesión");

    }
}
