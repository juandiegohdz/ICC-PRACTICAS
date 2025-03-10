/**
 * Author Juan Diego Hernández Becerril
 */

public class Reloj {
    private int horas;
    private int minutos;
    private int segundos; //PUNTO EXTRA

    //Se programa para que funcione como un reloj
    public Reloj(int horas, int minutos, int segundos) {
        this.horas = horas % 24;
        this.minutos = minutos % 60;
        this.segundos = segundos % 60; 
    }

    // Incrementa los segundos y ajusta los minutos y horas si es necesario
    public void incrementarSegundo() {
        segundos++;
        if (segundos == 60) {
            segundos = 0;
            incrementarMinuto();
        }
    }

    // Incrementa los minutos y ajusta las horas si es necesario
    public void incrementarMinuto() {
        minutos++;
        if (minutos == 60) {
            minutos = 0;
            incrementarHora();
        }
    }

    // Incrementa las horas y se reinicia si llega a 24
    public void incrementarHora() {
        horas = (horas + 1) % 24;
    }

    // Devuelve la hora en formato HH:MM:SS
    public String obtenerHora() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);//"%02d:%02d:%02d" le da el formato que tiene la hora 00:00:00 
    }
}
