package com.automation.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
/**
 * Class for identify the locator in Herokuapp pge.
 * @author jonathan.triana
 */
public class Herokuapp {

    String paragraph = "By.css .container p:nth-child(3)";

    String jukkaLink = "By.css .container address:nth-child(6) > a:nth-child(1)";

    String listThree = "By.css .container ul:nth-child(8) > li:nth-child(3)";

    String menuListOne = "By.css .container menu:nth-child(10) > li:nth-child(1)";

    String dirListThree = "By.css .container dir:nth-child(12) > li:nth-child(3)";

    String coolButton = "By.css #but";

    String resetButton = "By.css #f0";

    String legendRadio = "By.css #f3";

    String listBoxThree = "By.css #f11 option:nth-child(3)";

    String tablesIcelandLandArea = "By.css .container tbody:nth-child(2) tr:nth-child(4) > td:nth-child(3)";

    String hyphenationParagraph = "By.css .container p:nth-child(23)";

    String characterOmegaNotes = ".container tbody:nth-child(1) tr:nth-child(5) > td:nth-child(3)";

    String javaScriptDrivenHyphenation = ".container h3:nth-child(26)";
}