/**
 * @author:Juan Diego Hernández Becerril
 * 
 * Representa a un jugador del juego Pick-a-Perro, ya sea humano o artificial.
 * Cada jugador tiene una secuencia de cartas y puntos acumulados.
 */
public class Jugador {

    private final String nombre;
    private final ListaLigada<Carta> secuencia;
    private int puntos;

    /**
     * Crea un jugador con el nombre indicado.
     * 
     * @param nombre nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.secuencia = new ListaLigada<>();
        this.puntos = 0;
    }

    /**
     * Agrega una carta a la secuencia del jugador.
     * 
     * @param carta la carta a agregar
     */
    public void agregarCarta(Carta carta) {
        secuencia.agregarFinal(carta);
    }

    /**
     * Devuelve la última carta de la secuencia.
     * 
     * @return la carta más reciente o null si la secuencia está vacía
     */
    public Carta cartaActual() {
        if (secuencia.estaVacia()) return null;
        return secuencia.obtenerUltimo();
    }

    /**
     * Verifica que toda la secuencia de cartas sea válida según las reglas.
     * 
     * @return true si toda la secuencia cumple con las reglas del juego
     */
    public boolean secuenciaValida() {
        if (secuencia.tamanio() < 2) return true;
        for (int i = 1; i < secuencia.tamanio(); i++) {
            Carta anterior = secuencia.obtener(i - 1);
            Carta actual = secuencia.obtener(i);
            if (!anterior.esCompatible(actual)) return false;
        }
        return true;
    }

    /**
     * Devuelve el número de cartas válidas como puntos y los acumula.
     * 
     * @return puntos obtenidos en la ronda
     */
    public int contarPuntosYRestarSecuencia() {
        int obtenidos = secuencia.tamanio();
        puntos += obtenidos;
        secuencia.limpiar();
        return obtenidos;
    }

    /**
     * Descarta toda la secuencia actual sin sumar puntos.
     */
    public void perderRonda() {
        secuencia.limpiar();
    }

    /**
     * Devuelve el número total de puntos del jugador.
     * 
     * @return puntos acumulados
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Devuelve el nombre del jugador.
     * 
     * @return nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la secuencia de cartas como texto.
     * 
     * @return representación de la secuencia
     */
    public String verSecuencia() {
        return secuencia.toString();
    }
}
