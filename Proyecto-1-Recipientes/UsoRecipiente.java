/**
 * Author:Juan Diego Hernández Becerril
 * 16/03/2025
 */

     /**
     * Método principal que crea y manipula varios recipientes para verificar
     * el correcto funcionamiento de los métodos implementados.
     * Implementa el menú interactivo
     */
    import java.util.Scanner;

    public class UsoRecipiente {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Crear primer recipiente
            System.out.println("Creando Recipiente 1:");
            Recipiente r1 = crearRecipiente(scanner);
    
            // Crear segundo recipiente
            System.out.println("Creando Recipiente 2:");
            Recipiente r2 = crearRecipiente(scanner);
    
            // Menú de acciones
            int opcion;
            do {
                System.out.println("\n--- MENÚ DE OPCIONES ---");
                System.out.println("1. Rellenar Recipiente 1");
                System.out.println("2. Vaciar Recipiente 1");
                System.out.println("3. Verter de Recipiente 1 a Recipiente 2");
                System.out.println("4. Comparar dimensiones");
                System.out.println("5. Comparar capacidad");
                System.out.println("6. Mostrar información de ambos recipientes");
                System.out.println("7. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
    
                switch (opcion) {
                    case 1:
                        System.out.print("Cantidad a agregar: ");
                        double cantidad = scanner.nextDouble();
                        double excedente = r1.rellena(cantidad);
                        System.out.println("Excedente: " + excedente);
                        break;
                    case 2:
                        double vaciado = r1.vacia();
                        System.out.println("Cantidad vaciada: " + vaciado);
                        break;
                    case 3:
                        r1.vierte(r2);
                        System.out.println("Contenido transferido.");
                        break;
                    case 4:
                        System.out.println("¿Tienen las mismas dimensiones? " + r1.mismasDimensiones(r2));
                        break;
                    case 5:
                        System.out.println("¿Tienen la misma capacidad? " + r1.mismaCapacidad(r2));
                        break;
                    case 6:
                        System.out.println("Recipiente 1: " + r1.muestra());
                        System.out.println("Recipiente 2: " + r2.muestra());
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 7);
    
            scanner.close();
        }
    
        /**
         * Método para crear un recipiente con datos ingresados por el usuario.
         */
        private static Recipiente crearRecipiente(Scanner scanner) {
            System.out.print("Ingresa la altura del recipiente: ");
            double altura = scanner.nextDouble();
    
            System.out.print("Ingresa el radio del recipiente: ");
            double radio = scanner.nextDouble();
    
            System.out.print("Ingresa la cantidad de líquido inicial: ");
            double cantidad = scanner.nextDouble();
    
            return new Recipiente(altura, radio, cantidad);
        }
    }
     
