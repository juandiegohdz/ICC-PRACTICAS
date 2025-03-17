/**
 * Author:Juan Diego Hernández Becerril
 * 16/03/2025
 */

     /**
     * Método principal que crea y manipula varios recipientes para verificar
     * el correcto funcionamiento de los métodos implementados.
     */
    public class UsoRecipiente {
        public static void main(String[] args) {
            new UsoRecipiente().ejecutar();
        }
    
        public void ejecutar() {
            // Crear dos recipientes
            Recipiente r1 = new Recipiente(10, 5, 50);
            Recipiente r2 = new Recipiente(15, 5, 0);
    
            // Mostrar información inicial
            System.out.println("Recipiente 1: " + r1.muestra());
            System.out.println("Recipiente 2: " + r2.muestra());
    
            // Llenar recipiente 1
            System.out.println("Excedente al rellenar: " + r1.rellena(200));
            System.out.println("Recipiente 1 después de rellenar: " + r1.muestra());
    
            // Vaciar recipiente 1
            System.out.println("Cantidad vaciada: " + r1.vacia());
            System.out.println("Recipiente 1 después de vaciar: " + r1.muestra());
    
            // Verter líquido en otro recipiente
            r1.rellena(80);
            r1.vierte(r2);
            System.out.println("Recipiente 1 después de verter: " + r1.muestra());
            System.out.println("Recipiente 2 después de recibir: " + r2.muestra());
    
            // Comparar dimensiones
            System.out.println("Mismas dimensiones: " + r1.mismasDimensiones(r2));
    
            // Comparar capacidad total
            System.out.println("Misma capacidad: " + r1.mismaCapacidad(r2));
    
            // Comparar cantidad actual
            System.out.println("Recipiente 1 contiene más: " + r1.contieneMas(r2));
    
            // Comparar capacidad restante
            System.out.println("Recipiente 1 cabe más: " + r1.cabeMas(r2));
    
            // Crear contenedor justo
            Recipiente r3 = r1.creaContenedorJusto();
            System.out.println("Nuevo recipiente justo: " + r3.muestra());
        }
    }
    

