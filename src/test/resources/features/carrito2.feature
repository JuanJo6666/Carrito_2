# language: es

Característica: Funcionalidad del carrito de compra version 2
@smoke
  Escenario: Compra de un productoversion 2
    Dado  que la web esta operativa
    Cuando se generar el numero de tarjeta
    Y selecciona la cantidad "1"
    Y realiza la compra del producto
    E ingresa los datos de la targeta
    Y paga el producto
    Entonces validar el mensaje de pago "Payment successfull!"
@regre
  Esquema del escenario: Compra de un producto con varias cantidades version 2
    Dado  que la web esta operativa
    Cuando se generar el numero de tarjeta
    Y selecciona la cantidad "<cantidad>"
    Y realiza la compra del producto
    E ingresa los datos de la targeta
    Y paga el producto
    Entonces validar el mensaje de pago "<mensaje>"
    Ejemplos: Tabla de cantidades
      | cantidad | mensaje              |
      | 2        | Payment successfull! |
      | 3        | Payment successfull! |
      | 7        | Payment successfull! |