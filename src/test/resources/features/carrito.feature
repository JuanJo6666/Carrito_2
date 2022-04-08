# language: es
  @primerafuncionalidad
Característica: Funcionalidad del carrito de compra
@smoke
  Escenario: Compra de un producto
    Dado  que la web esta operativa
    Cuando se generar el numero de tarjeta
    Y selecciona la cantidad "5"
    Y realiza la compra del producto
    E ingresa los datos de la targeta
    Y paga el producto
    Entonces validar el mensaje de pago "Payment successfull!"
@regresion
  Esquema del escenario: Compra de un producto con varias cantidades
    Dado  que la web esta operativa
    Cuando se generar el numero de tarjeta
    Y selecciona la cantidad "<cantidad>"
    Y realiza la compra del producto
    E ingresa los datos de la targeta
    Y paga el producto
    Entonces validar el mensaje de pago "<mensaje>"
    Ejemplos: Tabla de cantidades
      | cantidad | mensaje              |
      | 4        | Payment successfull! |
      | 6        | Payment successfull! |
      | 5        | Payment successfull! |