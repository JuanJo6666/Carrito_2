package definitions;

import io.cucumber.java.es.*;
import pageobjects.*;

import java.io.IOException;

import static support.util.evidencias;

public class carritoDefinition {
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;
    confirmacionPage confirmacion;

    public carritoDefinition() {
       menu = new menuPage();
       tarjeta = new tarjetaPage();
       carrito = new carritoPage();
       pago = new pagoPage();
       confirmacion = new confirmacionPage();
    }

    @Dado("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
    }

    @Cuando("se generar el numero de tarjeta")
    public void seGenerarElNumeroDeTarjeta() throws IOException {
        menu.clickGenerarTargeta();
        menu.ventanaActica();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenerCVV();
        tarjeta.obtenerFecha();
        evidencias();
        tarjeta.ventanaInicial();
    }

    @Y("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String cant) throws IOException {
        carrito. seleccionarCantidad(cant);
        evidencias();
    }

    @Y("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }

    @E("ingresa los datos de la targeta")
    public void ingresaLosDatosDeLaTargeta() throws IOException {
        pago.escribirNroTarjeta(tarjetaPage.nro_Targeta);
        pago.seleccionarMes(tarjetaPage.mes);
        pago.seleccionarAnio(tarjetaPage.anio);
        pago.escribirCVV(tarjetaPage.cvv);
        evidencias();
    }

    @Y("paga el producto")
    public void pagaElProducto() {
        pago.scrollVertical();
        pago.clickPagar();
    }

    @Entonces("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) throws IOException {
        confirmacion.validarMensaje(mensaje);
        evidencias();
        confirmacion.mostrarCodigo();
    }
}
