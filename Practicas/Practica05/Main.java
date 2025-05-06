/**
 * @author: Juan Diego Hernández Becerril
 * 
 * Clase principal que prueba las figuras geométricas.
 */
public class Main {
    public static void main(String[] args) {

        // Crear un triángulo usando construcción directa
        Triángulo t1 = new Triángulo(3, 4, 5, 3, 4);

        // Crear un triángulo usando polimorfismo
        FiguraGeometrica t2 = new Triángulo(6, 5, 7, 6, 4);

        // Crear un rectángulo y un cuadrado
        Rectángulo r = new Rectángulo(4, 6);
        Cuadrado c = new Cuadrado(5);

        // Arreglo de figuras para recorrerlas y mostrar sus propiedades
        FiguraGeometrica[] figuras = { t1, t2, r, c };

        // Mostrar área, perímetro y forma de cada figura
        for (FiguraGeometrica f : figuras) {
            System.out.println(f.toString());
            System.out.println("Área: " + f.getArea());
            System.out.println("Perímetro: " + f.getPerimetro());
            System.out.println();
        }
    }
}
