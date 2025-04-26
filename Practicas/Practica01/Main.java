import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("CALCULADORA");
        System.out.println("Opciones disponibles:");
        System.out.println("1. Suma");
        System.out.println("2. Multiplicación");
        System.out.println("3. División");
        System.out.println("4. Invertir una cadena de texto (Extra)");
        
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        
        if (opcion == 1) {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            System.out.println("Resultado: " + (num1 + num2));
        } else if (opcion == 2) {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            System.out.println("Resultado: " + (num1 * num2));
        } else if (opcion == 3) {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            if (num2 != 0) {
                System.out.println("Resultado: " + (num1 / num2));
            } else {
                System.out.println("Error: División por cero no permitida.");
            }
        } else if (opcion == 4) {
            scanner.nextLine(); 
            System.out.print("Ingrese una cadena de texto: ");
            String texto = scanner.nextLine();
            String textoInvertido = new StringBuilder(texto).reverse().toString();
            System.out.println("Texto invertido: " + textoInvertido);
        } else {
            System.out.println("Opción no válida.");
        }
        
        scanner.close();
    }
}
