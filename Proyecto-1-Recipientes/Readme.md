# Proyecto 1 - Recipientes

## Integrante:
- Juan Diego Hernández Becerril-322178481

## Estructura del Proyecto

Este proyecto tiene como objetivo implementar una clase "Recipiente" que modela un cilindro para almacenar líquidos. 

### Componentes principales:
1. **Interfaz "ServiciosRecipiente" **: Define los métodos esenciales para manipular el recipiente.
Es la base que define las acciones que un recipiente debe poder realizar, como calcular su capacidad, llenar, vaciar, transferir líquido y comparar con otros recipientes.

2. **Clase "Recipiente" **: Implementa la interfaz y se encarga de manejar las operaciones principales, como agregar líquido, vaciar, verter en otro recipiente y realizar comparaciones. 
Además, incluye algunos métodos auxiliares para asegurar que la cantidad de líquido siempre esté dentro de los límites del recipiente.

3. **Clase "UsoRecipiente" **: Contiene el método "main" para probar las funcionalidades del recipiente.
Es una clase de prueba que, a través del método main, verifica que todas las funcionalidades del Recipiente funcionan correctamente. 
Aquí se crean diferentes recipientes y se realizan operaciones como rellenar, vaciar, transferir y comparar.

## Incovenientes Presentados:
- Problemas al ejecutar el programa debido a la versión de Java (se solucionó especificando "--release 17").
- Algunos ajustes en la lógica para vaciar y transferir líquidos entre recipientes.

## ¿Cómo ejecutar el programa?

1. Abre la terminal en la carpeta del proyecto.
2. Compila el código con:

javac --release 17 UsoRecipiente.java

3. Ejecuta el programa:

java UsoRecipiente

## Entorno de desarrollo
- Visual Studio Code
- JDK 17
