# Proyecto 3 – Pick-a-Perro

## Integrantes
-Juan Diego Hernández Becerril

## Estructura del proyecto

El proyecto se desarrolló en Java usando estructuras propias, como pide el enunciado. Para organizar mejor la lógica, decidi separar el código en clases específicas, cada una con una responsabilidad clara:

- `Carta`: representa las cartas del juego, cada una con cinco características (tamaño, color, número de brazos, gafas y palomitas). Separarla nos permite manejar fácilmente las comparaciones entre cartas y mantener el código legible.

- `Jugador`: representa tanto al jugador humano como al artificial. Mantiene su secuencia de cartas y puntos, y tiene métodos para validar su secuencia y acumular puntos. Esto nos permitió mantener la lógica del juego separada de la interfaz con el usuario.

- `Juego`: esta clase contiene todo el flujo principal del juego. Prepara el mazo, gestiona los turnos, muestra las cartas y evalúa el resultado de cada ronda. También incluye el método `main()`, así que se puede ejecutar directamente desde aquí. Preferimos centralizar la lógica aquí para que todo el juego pueda seguirse desde un solo punto.

- `ListaLigada`: Use una clase interna `Nodo` para no tener que crear un archivo más. Esta lista se usa para manejar el mazo, las cartas en la mesa y las secuencias de cada jugador.

Decidi no usar clases adicionales como `ZonaDeJuego` o `Mazo`, ya que no eran necesarias. Todo se pudo manejar con listas y con una organización clara entre `Juego` y `Jugador`.

## Inconvenientes

Uno de los desafíos fue validar correctamente si una carta era compatible con la anterior según las reglas: que fuera idéntica o solo con una diferencia. También tuve que ajustar varias veces el turno del jugador artificial para que no tomara cartas incorrectas.

Además, quería mantener el código organizado sin romper los requisitos del proyecto. Por eso preferi hacer pocas clases bien divididas, en lugar de muchas clases pequeñas.

## Instrucciones para ejecutar el proyecto

1. Abre una terminal en la carpeta donde están todos los archivos `.java` del proyecto.  
2. Compila todos los archivos con javac *.java.
3. Luego, ejecuta la clase Main.java del proyecto.
4. por último, igue las instrucciones del código.
