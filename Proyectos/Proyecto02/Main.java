/**@author:Juan Diego Hernández Becerril
 * 03/06/2025
 */

import java.util.Scanner;

    /**
     * Método main con menú para probar los métodos.
     */
    public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Esteganografia esteg = new Esteganografia();

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Descifrar cifrado nulo (con índice)");
            System.out.println("2. Descifrar cifrado nulo (con espacios finales)");
            System.out.println("3. Buscar nombre oculto");
            System.out.println("4. Descifrar palabras marcadas");
            System.out.println("5. Descifrar letras marcadas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                System.out.println("Mensaje original:");
                String original = sc.nextLine();
                System.out.print("Índice n: ");
                int n = Integer.parseInt(sc.nextLine());
                System.out.println("Resultado: " + esteg.descifraNulo(original, n));
            } else if (opcion == 2) {
                System.out.println("Mensaje original con espacios al final:");
                String original = sc.nextLine();
                System.out.println("Resultado: " + esteg.descifraNulo(original));
            } else if (opcion == 3) {
                System.out.println("Mensaje:");
                String mensaje = sc.nextLine();
                System.out.print("Nombre a buscar: ");
                String nombre = sc.nextLine();
                System.out.println("Resultado: " + esteg.contieneNombre(mensaje, nombre));
            } else if (opcion == 4) {
                System.out.println("Texto M:");
                String m = sc.nextLine();
                System.out.println("Texto E:");
                String e = sc.nextLine();
                System.out.println("Resultado: " + esteg.descifraPalabrasMarcadas(m, e));
            } else if (opcion == 5) {
                System.out.println("Texto M:");
                String m = sc.nextLine();
                System.out.println("Texto E:");
                String e = sc.nextLine();
                System.out.println("Resultado: " + esteg.descifraLetrasMarcadas(m, e));
            } else if (opcion == 6) {
                System.out.println("Proceso Finalizado.");
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}