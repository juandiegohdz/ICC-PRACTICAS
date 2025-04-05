/**
 * @author:Juan Diego Hernández Becerril
 * 
 * Clase de prueba para la estructura ListaLigada.
 * Ejecuta un escenario donde se insertan y eliminan elementos, mostrando los resultados en consola.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Declarar una lista
        ListaLigada lista = new ListaLigada();

        // 2. Imprimir la lista vacía
        System.out.println("Lista inicial:");
        System.out.println(lista);

        // 3. Insertar 5 elementos
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);
        lista.insertar(40);
        lista.insertar(50);

        // 4. Imprimir la lista
        System.out.println("\nDespués de insertar 5 elementos:");
        System.out.println(lista);

        // 5. Eliminar la cabeza (10)
        lista.eliminar(10);

        // 6. Imprimir la lista
        System.out.println("\nDespués de eliminar la cabeza (10):");
        System.out.println(lista);

        // 7. Eliminar un elemento intermedio (30)
        lista.eliminar(30);

        // 8. Imprimir la lista
        System.out.println("\nDespués de eliminar un nodo intermedio (30):");
        System.out.println(lista);

        // 9. PUNTO EXTRA: insertar en un índice (insertar 25 en el índice 1)
        lista.insertarIndice(25, 1);

        // 10. Imprimir la lista final
        System.out.println("\nDespués de insertar 25 en el índice 1:");
        System.out.println(lista);

        // 11. Intentar insertar en un índice inválido
        lista.insertarIndice(999, 10); // Índice fuera de rango

        // 12. Imprimir la lista (debe permanecer igual)
        System.out.println("\nDespués de intentar insertar en índice inválido (10):");
        System.out.println(lista);

    }
}
