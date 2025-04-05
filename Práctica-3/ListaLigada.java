/**
 * @author:Juan Diego Hernández Becerril
 * 
 * Clase que implementa una lista ligada simple.
 * Permite insertar elementos al final, eliminar por valor;
 * Mostrar la lista como cadena y (como PUNTO EXTRA) insertar en un índice específico.
 */
public class ListaLigada {
    /**
     * Referencia al primer nodo de la lista.
     */
    Nodo cabeza;

    /**
     * Contador estático del número de elementos en la lista.
     */
    static int tamaño = 0;

    /**
     * Constructor de la lista ligada.
     * Inicializa la lista como vacía.
     */
    public ListaLigada() {
        cabeza = null;
        tamaño = 0;
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     *
     * @param elemento el valor entero a insertar.
     */
    public void insertar(int elemento) {
        Nodo nuevo = new Nodo();
        nuevo.elemento = elemento;

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        tamaño++;
    }

    /**
     * Elimina el primer nodo que contenga el valor especificado.
     * Si el elemento no está presente, no realiza ninguna acción.
     *
     * @param elemento el valor entero a eliminar.
     */
    public void eliminar(int elemento) {
        if (cabeza == null) return;

        if (cabeza.elemento == elemento) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }

        Nodo aux = cabeza;
        while (aux.siguiente != null && aux.siguiente.elemento != elemento) {
            aux = aux.siguiente;
        }

        if (aux.siguiente != null) {
            aux.siguiente = aux.siguiente.siguiente;
            tamaño--;
        }
    }

    /**
     * Devuelve una representación en cadena de la lista.
     *
     * @return una cadena con los elementos separados por " -> ",
     * o "Lista vacía." si no hay elementos.
     */
    public String toString() {
        if (cabeza == null) return "Lista vacía.";

        Nodo aux = cabeza;
        String cadena = "";
        while (aux != null) {
            cadena += aux.elemento + " -> ";
            aux = aux.siguiente;
        }
        return cadena;
    }

    /**
     * PUNTO EXTRA
     * Inserta un nuevo elemento en el índice especificado de la lista.
     * Si el índice es inválido, no realiza ninguna acción.
     *
     * @param elemento el valor entero a insertar.
     * @param indice el índice en el que se desea insertar.
     */
    public void insertarIndice(int elemento, int indice) {
        if (indice < 0 || indice > tamaño) return;

        Nodo nuevo = new Nodo();
        nuevo.elemento = elemento;

        if (indice == 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                aux = aux.siguiente;
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
        }
        tamaño++;
    }
}