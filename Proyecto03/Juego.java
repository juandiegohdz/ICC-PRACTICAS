import java.util.Random;
import java.util.Scanner;

/**
 * @author:Juan Diego Hernández Becerril
 *
 * Controla el flujo principal del juego Pick-a-Perro.
 * Maneja la preparación, las rondas, los turnos y el conteo de puntos.
 */
public class Juego {

    private final Jugador humano;
    private final Jugador ia;
    private final ListaLigada<Carta> mazo;
    private final ListaLigada<Carta> mesa;
    private final Random random;

    /**
     * Crea un juego nuevo con los jugadores y el mazo mezclado.
     * 
     * @param semilla semilla para el generador aleatorio
     */
    public Juego(long semilla) {
        this.humano = new Jugador("Jugador Humano");
        this.ia = new Jugador("Jugador Artificial");
        this.mazo = new ListaLigada<>();
        this.mesa = new ListaLigada<>();
        this.random = new Random(semilla);
        prepararMazo();
    }

    /**
     * Inicia el juego y ejecuta todas las rondas.
     */
    public void jugar() {
        while (prepararRonda()) {
            System.out.println("\n--- Nueva Ronda ---\n");
            turnoJugador();
            turnoIA();
            evaluarRonda();
        }
        mostrarGanador();
    }

    /**
     * Prepara el mazo de 96 cartas y lo mezcla.
     */
    private void prepararMazo() {
        String[] tamanos = { "pequeño", "mediano", "grande" };
        String[] colores = { "rojo", "azul", "verde", "amarillo" };
        int[] brazos = { 1, 2 };
        boolean[] opciones = { true, false };

        for (String t : tamanos) {
            for (String c : colores) {
                for (int b : brazos) {
                    for (boolean g : opciones) {
                        for (boolean p : opciones) {
                            Carta carta = new Carta(t, c, b, g, p);
                            for (int i = 0; i < 3; i++) {
                                insertarAleatoriamente(carta);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Prepara una nueva ronda si hay suficientes cartas.
     * 
     * @return true si puede comenzar la ronda
     */
    private boolean prepararRonda() {
        if (mazo.tamanio() < 2) return false;

        humano.agregarCarta(mazo.eliminarInicio());
        ia.agregarCarta(mazo.eliminarInicio());

        while (mesa.tamanio() < 30 && !mazo.estaVacia()) {
            mesa.agregarFinal(mazo.eliminarInicio());
        }

        return true;
    }

    /**
     * Ejecuta el turno del jugador humano.
     */
    private void turnoJugador() {
        while (true) {
            mostrarEstado(humano);
            System.out.println("¿Deseas tomar una carta (t) o terminar tu turno (f)?");
            String opcion = Entrada.leerLinea();

            if (opcion.equalsIgnoreCase("f")) break;

            System.out.println("Elige el índice de la carta (0 a " + (mesa.tamanio() - 1) + "):");
            int indice = Entrada.leerEntero();
            if (indice < 0 || indice >= mesa.tamanio()) {
                System.out.println("Índice inválido.");
                continue;
            }

            Carta seleccionada = mesa.obtener(indice);
            Carta guia = humano.cartaActual();
            if (guia == null || guia.esCompatible(seleccionada)) {
                humano.agregarCarta(seleccionada);
                mesa.eliminar(indice);
            } else {
                System.out.println("Esa carta no es válida para continuar tu secuencia.");
            }
        }
    }

    /**
     * Ejecuta el turno del jugador artificial.
     */
    private void turnoIA() {
        while (true) {
            Carta actual = ia.cartaActual();
            boolean tomo = false;

            for (int i = 0; i < mesa.tamanio(); i++) {
                Carta c = mesa.obtener(i);
                if (actual != null && actual.esCompatible(c)) {
                    ia.agregarCarta(c);
                    mesa.eliminar(i);
                    tomo = true;
                    break;
                }
            }

            if (!tomo) break;
        }
    }

    /**
     * Evalúa si las secuencias son válidas y asigna puntos.
     */
    private void evaluarRonda() {
        System.out.println("\n--- Evaluando Ronda ---");

        System.out.println("\nSecuencia del jugador:");
        System.out.println(humano.verSecuencia());

        if (humano.secuenciaValida()) {
            int puntos = humano.contarPuntosYRestarSecuencia();
            System.out.println("Secuencia válida. Ganaste " + puntos + " punto(s).");
        } else {
            humano.perderRonda();
            System.out.println("Secuencia inválida. No ganaste puntos.");
        }

        System.out.println("\nSecuencia del jugador artificial:");
        System.out.println(ia.verSecuencia());

        if (ia.secuenciaValida()) {
            int puntos = ia.contarPuntosYRestarSecuencia();
            System.out.println("Secuencia válida. El jugador artificial gana " + puntos + " punto(s).");
        } else {
            ia.perderRonda();
            System.out.println("Secuencia inválida para el jugador artificial.");
        }

        System.out.println("\nPuntajes actuales:");
        System.out.println(humano.getNombre() + ": " + humano.getPuntos());
        System.out.println(ia.getNombre() + ": " + ia.getPuntos());
    }

    /**
     * Inserta una carta en una posición aleatoria del mazo.
     * 
     * @param carta la carta a insertar
     */
    private void insertarAleatoriamente(Carta carta) {
        int pos = random.nextInt(mazo.tamanio() + 1);
        mazo.insertarEn(pos, carta);
    }

    /**
     * Muestra el estado actual del juego.
     * 
     * @param jugador jugador actual
     */
    private void mostrarEstado(Jugador jugador) {
        System.out.println("\nCartas en la mesa:");
        for (int i = 0; i < mesa.tamanio(); i++) {
            System.out.println(i + ": " + mesa.obtener(i));
        }
        System.out.println("\nTu carta actual: " + jugador.cartaActual());
    }

    /**
     * Muestra el resultado final del juego y quién ganó.
     */
    private void mostrarGanador() {
        System.out.println("\n--- Fin del Juego ---\n");
        int puntosHumano = humano.getPuntos();
        int puntosIA = ia.getPuntos();

        System.out.println(humano.getNombre() + ": " + puntosHumano + " puntos.");
        System.out.println(ia.getNombre() + ": " + puntosIA + " puntos.");

        if (puntosHumano > puntosIA) {
            System.out.println("¡Ganaste!");
        } else if (puntosIA > puntosHumano) {
            System.out.println("Ganó el jugador artificial.");
        } else {
            System.out.println("Empate.");
        }
    }
}

   /**
   * Clase auxiliar para leer datos desde la consola.
   * Permite leer líneas y números enteros fácilmente.
   */
    class Entrada {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lee una línea completa ingresada por el usuario.
     * 
     * @return la línea escrita
     */
    public static String leerLinea() {
        return scanner.nextLine();
    }

    /**
     * Lee un número entero desde la entrada.
     * Si la entrada no es válida, lo vuelve a pedir.
     * 
     * @return un número entero válido
     */
    public static int leerEntero() {
        while (true) {
            try {
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número entero válido:");
            }
        }
    }
}