package com.automation.web.tests;

public class Facebook {


//Proceso de Log in

//correo electrónico o número de teléfono
String loginelemento1 = "By.css  .inputtext#email";

//contraseña
String loginelemento2 = "By.css .inputtext#pass";

//Botón Iniciar Sesión
String loginelemento3 = "By.css [name=login]";

//Proceso de Log Out

String logoutelemento1 = "By.css [aria-label=Cuenta]";

String logoutelemento2 = "By.css [aria-label=Cuenta] [role=button]";

//Mi perfil

String miperfilelemento1 = "By.css logoutelemento1 [aria-current=page]";

//Mis amigos

String misamigoselemento1 = "By.css [href*='friends']";
//NOTA: Esta última sentencia debería ser "By.css [href*="friends"]"; pero me genera error, entonces debí colocarla como 'friends'
}
