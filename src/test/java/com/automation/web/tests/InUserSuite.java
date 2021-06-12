package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
//import org.testng.log4testng.Logger;

/**
 * Class for the in user test.
 * @author camilo.mogollon
 */
public class InUserSuite {

    public Logger log = Logger.getLogger(InUserSuite.class);

    @BeforeSuite
    public void testSetting(){
        log.info("Open Browser: Crhome");
    }

    @BeforeMethod()
    public void TestCaseIngresoPerfilFace() {
        log.info("ingresar a la URL: https://www.facebook.com");
        log.info("Iniciar Sesión: Ingreso de Usuario y Contraseña");
        log.info("Ir a mi perfil: Seleccionar botton de mi perfil");
    }


    @Test(description = "Primer caso")
    public void testCase1EliminarAmigo() {
        log.info("Seleccionar botón de Ver todos mis Amigos para ver listado de amigos");
        log.info("Seleccionar un amigo");
        log.info("Eliminar amigo seleccionado");
    }


    @Test(description = "Segundo caso")
    public void testCase2CambiarFotoPerfil() {
        log.info("Seleccionar foto de perfil");
        log.info("Seleccionar la opción Actualizar foto del perfil");
        log.info("Seleccionar foto existente");
        log.info("Seleccionar Guardar");
    }


    @AfterMethod()
    public void TestCaseCerrarSesion () {
        log.info("Seleccionar botón de cuenta: Boton superior derecho");
        log.info("seleccionar opción cerrar sesión");
    }
}
