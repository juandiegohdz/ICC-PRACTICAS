/**
 * Author Juan Diego Hernández Becerril
 */

public class Main {
    public static void main(String[] args) {
        Reloj reloj = new Reloj(23, 59, 50); // Inicializa el reloj cerca del límite

        int segundosASimular = 60; // La cantidad de segundos que debe simular

        System.out.println("Simulación del reloj (Hasta 60s):");
        while (segundosASimular > 0) {
            reloj.incrementarSegundo();
            System.out.println(reloj.obtenerHora());
            esperar();
            segundosASimular--;
        }
    }

    // Método para pausar el programa 1 segundo
    private static void esperar() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

