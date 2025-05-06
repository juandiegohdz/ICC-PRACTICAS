/**
 * @author: Juan Diego Hernández Becerril
 * 
 * Clase que representa un cuadrado.
 */
public class Cuadrado extends FiguraGeometrica {

    /**
     * Crea un cuadrado con un lado.
     * @param lado longitud del lado.
     */
    public Cuadrado(double lado) {
        super(lado, lado);
    }

    /**
     * Calcula el área del cuadrado.
     * @return área del cuadrado.
     */
    @Override
    public double getArea() {
        return base * base;
    }

    /**
     * Calcula el perímetro del cuadrado.
     * @return perímetro del cuadrado.
     */
    @Override
    public double getPerimetro() {
        return 4 * base;
    }

    /**
     * PUNTO EXTRA
     * 
     * Representación en texto del cuadrado con las medidas de sus lados.
     * @return cadena con los cuatro lados del cuadrado.
     */
    @Override
    public String toString() {
        return String.format("Cuadrado [lados: %.2f, %.2f, %.2f, %.2f]", base, base, base, base);
    }
}

