/**
 * Author:Juan Diego Hernández Becerril
 * 16/03/2025
 */

/**
 * Clase que representa un recipiente cilíndrico capaz de almacenar líquidos.
 * Implementa la interfaz ServiciosRecipiente.
 */
class Recipiente implements ServiciosRecipiente {

    /**
     * Altura del recipiente en centímetros.
     */
    private double altura;

    /**
     * Radio de la base del recipiente en centímetros.
     */
    private double radio;

    /**
     * Cantidad actual de líquido en centímetros cúbicos.
     */
    private double cantidadActual;

    /**
     * Constructor que inicializa un recipiente con altura, radio y cantidad de líquido.
     * La cantidad actual se ajusta para estar entre 0 y la capacidad máxima.
     */
    public Recipiente(double altura, double radio, double cantidadActual) {
        this.altura = altura;
        this.radio = radio;
        this.cantidadActual = Math.max(0, Math.min(capacidad(), cantidadActual));
    }

    /**
     * Calcula la capacidad total del recipiente.
     */
    public double capacidad() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    /**
     * Calcula la cantidad de espacio disponible en el recipiente.
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
     * Agrega líquido al recipiente y devuelve el excedente si no cabe todo.
     */
    public double rellena(double cantidad) {
        double espacioDisponible = capacidadRestante();
        if (cantidad <= espacioDisponible) {
            cantidadActual += cantidad;
            return 0;
        } else {
            cantidadActual = capacidad();
            return cantidad - espacioDisponible;
        }
    }

    /**
     * Vacía el recipiente y devuelve la cantidad de líquido que contenía.
     */
    public double vacia() {
        double cantidadVaciada = cantidadActual;
        cantidadActual = 0;
        return cantidadVaciada;
    }

    /**
     * Vierte el contenido en otro recipiente, respetando su capacidad máxima.
     */
    public void vierte(Recipiente otro) {
        double excedente = otro.rellena(cantidadActual);
        cantidadActual = excedente;
    }

    /**
     * Compara las dimensiones del recipiente con otro.
     */
    public boolean mismasDimensiones(Recipiente otro) {
        return this.altura == otro.altura && this.radio == otro.radio;
    }

    /**
     * Compara la capacidad total del recipiente con otro.
     */
    public boolean mismaCapacidad(Recipiente otro) {
        return this.capacidad() == otro.capacidad();
    }

    /**
     * Compara la cantidad actual de líquido con otro recipiente.
     */
    public boolean contieneMas(Recipiente otro) {
        return this.cantidadActual > otro.cantidadActual;
    }

    /**
     * Compara la capacidad restante con otro recipiente.
     */
    public boolean cabeMas(Recipiente otro) {
        return this.capacidadRestante() > otro.capacidadRestante();
    }

    /**
     * Crea un recipiente vacío con la capacidad equivalente a la cantidad actual.
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