package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class tarjetaPage extends util {
    public static String nro_Targeta;
    public static String cvv;
    public static String mes;
    public static String anio;

    @FindBy(xpath = "//*[contains(text(),'Card Number:')]") protected WebElement lblnroTarjeta;
    @FindBy(xpath = "//*[contains(text(),'CVV')]]") protected WebElement lblcvvTarjeta;
    @FindBy(xpath = "//*[contains(text(),'Exp:')]") protected WebElement lblexpTarjeta;

    public tarjetaPage() {
        PageFactory.initElements(driver,this);
    }
    public void obtenerNroTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(lblnroTarjeta));
        String texto = lblnroTarjeta.getText();
        nro_Targeta = texto.replace("Card Number:-","");
        System.out.println(nro_Targeta);

    }
    public void obtenerCVV(){
        String texto = lblcvvTarjeta.getText();
        cvv=texto.replace("cvv:-","");
        System.out.println(cvv);
    }
    public void obtenerFecha(){
        String texto = lblexpTarjeta.getText();
        String fecha[]= texto.replace("Exp:-","").split("/");
        mes = fecha[0];
        anio = fecha[1];
        System.out.println(mes);
        System.out.println(anio);
    }
}
