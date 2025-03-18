/**
 * Author:Juan Diego Hernández Becerril
 * 16/03/2025
 */

/**
 * Clase que representa un recipiente cilíndrico capaz de almacenar líquidos.
 * Implementa la interfaz ServiciosRecipiente.
 */
/**
 * Clase que representa un recipiente cilíndrico capaz de almacenar líquidos.
 * Implementa la interfaz ServiciosRecipiente.
 */
public class Recipiente implements ServiciosRecipiente {
    private double altura;
    private double radio;
    private double cantidadActual;

    /**
     * Constructor para inicializar un recipiente con altura, radio y cantidad de líquido.
     * Asegura que la cantidad inicial no supere la capacidad total.
     */
    public Recipiente(double altura, double radio, double cantidadActual) {
        this.altura = altura;
        this.radio = radio;
        this.cantidadActual = Math.max(0, Math.min(capacidad(), cantidadActual));
    }

    /**
     * Calcula y devuelve la capacidad total del recipiente.
     */
    public double capacidad() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    /**
     * Calcula y devuelve la capacidad restante del recipiente.
     */
    public double capacidadRestante() {
        return capacidad() - cantidadActual;
    }

    /**
     * Verifica si el recipiente está vacío.
     */
    public boolean estaVacio() {
        return cantidadActual == 0;
    }

    /**
     * Verifica si el recipiente está lleno.
     */
    public boolean estaLleno() {
        return cantidadActual == capacidad();
    }

    /**
     * Agrega una nueva cantidad de líquido al recipiente, respetando su capacidad máxima.
     * Devuelve el excedente si la cantidad añadida supera la capacidad disponible.
     */
    public double rellena(double cantidad) {
        double espacioDisponible = capacidadRestante();
        double exceso = Math.max(0, cantidad - espacioDisponible);
        cantidadActual += cantidad - exceso;
        return exceso;
    }

    /**
     * Vacía completamente el recipiente y devuelve la cantidad de líquido que contenía.
     */
    public double vacia() {
        double cantidadVaciada = cantidadActual;
        cantidadActual = 0;
        return cantidadVaciada;
    }

    /**
     * Vierte el contenido de este recipiente en otro, respetando la capacidad del destino.
     */
    public void vierte(Recipiente otro) {
        double excedente = otro.rellena(cantidadActual);
        cantidadActual = excedente;
    }

    /**
     * Compara si dos recipientes tienen las mismas dimensiones.
     */
    public boolean mismasDimensiones(Recipiente otro) {
        return this.altura == otro.altura && this.radio == otro.radio;
    }

    /**
     * Compara si dos recipientes tienen la misma capacidad total.
     */
    public boolean mismaCapacidad(Recipiente otro) {
        return this.capacidad() == otro.capacidad();
    }

    /**
     * Determina si este recipiente tiene más líquido que otro.
     */
    public boolean contieneMas(Recipiente otro) {
        return this.cantidadActual > otro.cantidadActual;
    }

    /**
     * Determina si este recipiente tiene más capacidad restante que otro.
     */
    public boolean cabeMas(Recipiente otro) {
        return this.capacidadRestante() > otro.capacidadRestante();
    }

    /**
     * Crea un nuevo recipiente vacío con capacidad igual a la cantidad actual del recipiente original.
     */
    public Recipiente creaContenedorJusto() {
        return new Recipiente((cantidadActual / capacidad()) * altura, radio, 0);
    }

    /**
     * Devuelve una cadena con la información del recipiente.
     */
    public String muestra() {
        return String.format("Altura: %.2f, Radio: %.2f, Cantidad Actual: %.2f, Capacidad: %.2f", altura, radio, cantidadActual, capacidad());
    }
}
