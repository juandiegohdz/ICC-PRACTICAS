/**
 * @author:Juan Diego Hernández Becerril
 * 
 * Representa una carta del juego Pick-a-Perro.
 * Cada carta tiene cinco características que definen su identidad.
 */
public class Carta {

    private final String tamano;
    private final String color;
    private final int brazos;
    private final boolean gafas;
    private final boolean palomitas;

    /**
     * Crea una carta con sus cinco características.
     * 
     * @param tamano tamaño del animal
     * @param color color del animal
     * @param brazos 1 o 2 brazos
     * @param gafas true si tiene gafas, false si no
     * @param palomitas true si tiene palomitas, false si no
     */
    public Carta(String tamano, String color, int brazos, boolean gafas, boolean palomitas) {
        this.tamano = tamano;
        this.color = color;
        this.brazos = brazos;
        this.gafas = gafas;
        this.palomitas = palomitas;
    }

    /**
     * Compara esta carta con otra y dice si se puede tomar según las reglas:
     * debe ser igual o diferir en solo una característica.
     * 
     * @param otra la carta con la que se compara
     * @return true si es válida para continuar la secuencia
     */
    public boolean esCompatible(Carta otra) {
        int diferencias = 0;
        if (!this.tamano.equals(otra.tamano)) diferencias++;
        if (!this.color.equals(otra.color)) diferencias++;
        if (this.brazos != otra.brazos) diferencias++;
        if (this.gafas != otra.gafas) diferencias++;
        if (this.palomitas != otra.palomitas) diferencias++;
        return diferencias <= 1;
    }

    /**
     * Devuelve una cadena que representa esta carta de forma clara.
     * 
     * @return la representación en texto de la carta
     */
    @Override
    public String toString() {
        return "[" + tamano + ", " + color + ", " + brazos + " brazo(s), " +
               (gafas ? "con gafas" : "sin gafas") + ", " +
               (palomitas ? "con palomitas" : "sin palomitas") + "]";
    }

    /**
     * Verifica si dos cartas son completamente iguales.
     * 
     * @param obj el objeto con el que se compara
     * @return true si todas las características coinciden
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Carta)) return false;
        Carta otra = (Carta) obj;
        return this.tamano.equals(otra.tamano) &&
               this.color.equals(otra.color) &&
               this.brazos == otra.brazos &&
               this.gafas == otra.gafas &&
               this.palomitas == otra.palomitas;
    }

    /**
     * Calcula el código hash de la carta.
     * 
     * @return el valor hash
     */
    @Override
    public int hashCode() {
        int hash = tamano.hashCode();
        hash = 31 * hash + color.hashCode();
        hash = 31 * hash + brazos;
        hash = 31 * hash + (gafas ? 1 : 0);
        hash = 31 * hash + (palomitas ? 1 : 0);
        return hash;
    }
}