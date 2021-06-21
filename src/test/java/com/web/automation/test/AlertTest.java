package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    private HomePage homePage;
    String firstDisplayedAlert = "Do you really want to delete this Customer?";
    String secondDisplayedAlert = "Customer Successfully Delete!";

    /**
     * Test cases for Alerts
     * @author harvey.yepes
     */

    /**
     * INSERTAR UN DATO VALIDO EN CUSTOMER ID EN EL CAMPO TEXTBOX
     * 4. CLICKEAR SUBMIT
     * 5. CAPTURAR EL ALERT EN EL BROWSER
     * 6. IMPRIMIR EL MENSAJE DEL ALERT EN LA CONSOLA
     */
   /* @Test(dataProviderClass = Data.class, dataProvider = "customerId")
    public void inputData(String customerId){
        log.info("CustomerId :" + customerId);
    }*/

    @Test(description = "Get Confirmation from the first Alert")
    public void clickOnFirstAlert() {
        homePage = getHomePage();
        String firstCapturedAlert = homePage.getConfirmationAlert();
        log.info("The first alert says: " + firstCapturedAlert);
        Assert.assertEquals(firstCapturedAlert, firstDisplayedAlert);
    }

    /**
     * 7. CLICKEAR BOTON "OK" DEL ALERT
     * 8. IMPRIMIR MENSAJE DEL ALERT EN LA CONSOLA
     * 9. CLICKEAR BOTON "OK" DEL ALERT
     * 10. USAR ASSERT PARA VALIDAR QUE LA PÁGINA VUELVE A LA PÁGINA PRINCIPAL
     */
    @Test(description = "Get Confirmation from the second Alert displayed")
    public void clickOnSecondAlert(){
        homePage = getHomePage();
        String secondCaptureAlert = homePage.getDeletionAlert();
        log.info("The second alert says: " + secondCaptureAlert);
        Assert.assertEquals(secondCaptureAlert, secondDisplayedAlert);
    }

    /**
     * 7. CLICKEAR BOTON "OK" DEL ALERT
     * 8. IMPRIMIR MENSAJE DEL ALERT EN LA CONSOLA
     * 9. CLICKEAR BOTON "OK" DEL ALERT
     * 10. USAR ASSERT PARA VALIDAR QUE LA PÁGINA VUELVE A LA PÁGINA PRINCIPAL
     */
    @Test(description = "Click on Alert and return to home page")
    public void returnToMainPage(){
        homePage = getHomePage();
        Assert.assertTrue(homePage.returnToMainPage());
        log.info("The home page is open again");
    }

}

