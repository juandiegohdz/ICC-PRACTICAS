/**
 * @author: Juan Diego Hernández Becerril
 * 
 * Clase que representa un rectángulo.
 */
public class Rectángulo extends FiguraGeometrica {

    /**
     * Crea un rectángulo con base y altura.
     * @param base la base.
     * @param altura la altura.
     */
    public Rectángulo(double base, double altura) {
        super(base, altura);
    }

    /**
     * Calcula el área del rectángulo.
     * @return área del rectángulo.
     */
    @Override
    public double getArea() {
        return base * altura;
    }

    /**
     * Calcula el perímetro del rectángulo.
     * @return perímetro del rectángulo.
     */
    @Override
    public double getPerimetro() {
        return 2 * (base + altura);
    }
 
    /**
     * PUNTO EXTRA
     * 
     * Representación en texto del rectángulo con su base y altura.
     * @return cadena con las dimensiones del rectángulo.
     */
    @Override
    public String toString() {
        return String.format("Rectángulo [base: %.2f, altura: %.2f]", base, altura);
    }
}

