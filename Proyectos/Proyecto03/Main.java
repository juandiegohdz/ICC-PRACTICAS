/**
 * @author:Juan Diego Hernández Becerril
 * 
 * Punto de entrada del juego Pick-a-Perro.
 * Crea una partida y la inicia.
 */
public class Main {
    public static void main(String[] args) {
        // Se puede cambiar la semilla para obtener un mazo diferente cada vez
        Juego juego = new Juego(42);
        juego.jugar();
    }
}
