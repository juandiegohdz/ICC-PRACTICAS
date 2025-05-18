/**
 * @author:Juan Diego Hernández Becerril
 * 
 * Implementación propia de una lista ligada simple.
 * Contiene una clase interna Nodo para almacenar elementos.
 * 
 * @param <T> tipo de los elementos en la lista
 */
public class ListaLigada<T> {

    private Nodo cabeza;
    private int tamanio;

    /**
     * Crea una lista vacía.
     */
    public ListaLigada() {
        cabeza = null;
        tamanio = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param elemento dato a agregar
     */
    public void agregarFinal(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }

    /**
     * Inserta un elemento en una posición específica.
     * 
     * @param indice posición donde se inserta (0 ≤ indice ≤ tamaño)
     * @param elemento dato a insertar
     */
    public void insertarEn(int indice, T elemento) {
        if (indice < 0 || indice > tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo nuevo = new Nodo(elemento);

        if (indice == 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo anterior = obtenerNodo(indice - 1);
            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }

        tamanio++;
    }

    /**
     * Devuelve el elemento en la posición dada.
     * 
     * @param indice posición del elemento
     * @return el dato en esa posición
     */
    public T obtener(int indice) {
        return obtenerNodo(indice).elemento;
    }

    /**
     * Devuelve el último elemento de la lista.
     * 
     * @return el dato al final de la lista
     */
    public T obtenerUltimo() {
        return obtener(tamanio - 1);
    }

    /**
     * Elimina el elemento en la posición dada.
     * 
     * @param indice índice del elemento a eliminar
     * @return el elemento eliminado
     */
    public T eliminar(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        T eliminado;

        if (indice == 0) {
            eliminado = cabeza.elemento;
            cabeza = cabeza.siguiente;
        } else {
            Nodo anterior = obtenerNodo(indice - 1);
            Nodo aEliminar = anterior.siguiente;
            eliminado = aEliminar.elemento;
            anterior.siguiente = aEliminar.siguiente;
        }

        tamanio--;
        return eliminado;
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     * 
     * @return el elemento eliminado
     */
    public T eliminarInicio() {
        return eliminar(0);
    }

    /**
     * Limpia todos los elementos de la lista.
     */
    public void limpiar() {
        cabeza = null;
        tamanio = 0;
    }

    /**
     * Devuelve el número de elementos en la lista.
     * 
     * @return tamaño actual
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si no contiene elementos
     */
    public boolean estaVacia() {
        return tamanio == 0;
    }

    /**
     * Devuelve una representación en texto de la lista.
     * 
     * @return cadena con los elementos
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;

        while (actual != null) {
            sb.append(actual.elemento);
            if (actual.siguiente != null) {
                sb.append(" -> ");
            }
            actual = actual.siguiente;
        }

        return sb.toString();
    }

    /**
     * Devuelve el nodo en la posición dada.
     * 
     * @param indice índice del nodo
     * @return el nodo correspondiente
     */
    private Nodo obtenerNodo(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }

        return actual;
    }

    /**
     * Nodo interno que almacena un elemento y apunta al siguiente.
     */
    private class Nodo {
        T elemento;
        Nodo siguiente;

        Nodo(T elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }
}
