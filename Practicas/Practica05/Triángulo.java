/**
 * @author: Juan Diego Hernández Becerril
 * 
 * Clase que representa un triángulo.
 */
public class Triángulo extends FiguraGeometrica {

    private double lado1, lado2, lado3;

    /**
     * Crea un triángulo con tres lados, base y altura.
     * @param lado1 primer lado.
     * @param lado2 segundo lado.
     * @param lado3 tercer lado.
     * @param base la base del triángulo.
     * @param altura la altura del triángulo.
     */
    public Triángulo(double lado1, double lado2, double lado3, double base, double altura) {
        super(base, altura);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    /**
     * Calcula el área del triángulo.
     * @return área del triángulo.
     */
    @Override
    public double getArea() {
        return (base * altura) / 2;
    }

    /**
     * Calcula el perímetro del triángulo.
     * @return perímetro del triángulo.
     */
    @Override
    public double getPerimetro() {
        return lado1 + lado2 + lado3;
    }

    /*
     * PUNTO EXTRA
     * 
     * Representación en texto del triángulo con sus lados y dimensiones.
     * @return cadena con los lados, base y altura del triángulo.
     */
    @Override
    public String toString() {
        return String.format("Triángulo [lados: %.2f, %.2f, %.2f, base: %.2f, altura: %.2f]", 
                              lado1, lado2, lado3, base, altura);
    }
}
