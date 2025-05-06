/**
 * @author: Juan Diego Hernández Becerril
 * 
 * Clase abstracta que representa una figura geométrica con base y altura.
 */
public abstract class FiguraGeometrica {

    protected double base;
    protected double altura;

    /**
     * Crea una figura con base y altura.
     * @param base la base de la figura.
     * @param altura la altura de la figura.
     */
    public FiguraGeometrica(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /**
     * Regresa el área de la figura.
     * @return el área.
     */
    public abstract double getArea();

    /**
     * Regresa el perímetro de la figura.
     * @return el perímetro.
     */
    public abstract double getPerimetro();

    /**
     * PUNTO EXTRA
     *
     * Representación en cadena de la figura con sus dimensiones.
     * @return la representación.
     */
    @Override
    public String toString() {
        return String.format("Base: %.2f, Altura: %.2f", base, altura);
    }
}
