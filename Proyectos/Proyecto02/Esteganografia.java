/**@author:Juan Diego Hernández Becerril
 * 03/06/2025
 */

import java.util.Scanner;

public class Esteganografia {

    /**
     * Toma la n-ésima letra de cada palabra para obtener el mensaje oculto.
     *
     * @param original El mensaje original.
     * @param n El índice que se tiene que tomar de cada palabra.
     * @return El mensaje oculto , sin espacios.
     */
    public String descifraNulo(String original, int n) {
        String resultado = "";
        int i = 0;
        while (i < original.length()) {
            // Saltar espacios
            while (i < original.length() && Character.isWhitespace(original.charAt(i))) {
                i++;
            }
            // Encontrar inicio y fin de la palabra
            int inicio = i;
            while (i < original.length() && !Character.isWhitespace(original.charAt(i))) {
                i++;
            }
            int fin = i;
            if (fin - inicio > n) {
                resultado += original.charAt(inicio + n);
            }
        }
        return resultado;
    }

    /**
     * Toma la n-ésima letra de cada palabra para obtener el mensaje oculto.
     *
     * @param original El mensaje original con n espacios al final.
     * @return El mensaje oculto , sin espacios.
     */
    public String descifraNulo(String original) {
        int n = 0;
        for (int i = original.length() - 1; i >= 0 && original.charAt(i) == ' '; i--) {
            n++;
        }
        return descifraNulo(original, n);
    }

    /**
     * Busca un nombre oculto en un texto arbitrario ignorando
     * espacios , signos de puntuación y sin hacer distinciones
     * entre mayú́sculas y minú́sculas.
     *
     * @param mensaje Una cadena arbitraria donde se hará la búsqueda.
     * @param nombre El nombre que se buscará en el texto.
     * @return true si el mensaje está contenido , false en otro caso.
     */
    public boolean contieneNombre(String mensaje, String nombre) {
        String limpio = "";
        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            if (Character.isLetter(c)) {
                limpio += Character.toLowerCase(c);
            }
        }
        String objetivo = "";
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (Character.isLetter(c)) {
                objetivo += Character.toLowerCase(c);
            }
        }
        return limpio.contains(objetivo);
    }

    /**
     * Reconstruye el mensaje oculto a partir de las palabras especiales
     * que se obtienen al comparar dos textos.
     *
     * @param m Un texto arbitrario.
     * @param e Un texto similar al primero , pero con algunas palabras especiales.
     * @return El mensaje oculto.
     */
    public String descifraPalabrasMarcadas(String m, String e) {
        String resultado = "";
        Scanner scanM = new Scanner(m);
        Scanner scanE = new Scanner(e);
        while (scanM.hasNext() && scanE.hasNext()) {
            String palabraM = scanM.next();
            String palabraE = scanE.next();
            if (!palabraM.equals(palabraE)) {
                resultado += palabraM + " ";
            }
        }
        scanM.close();
        scanE.close();
        return resultado.trim();
    }

    /**
     * Reconstruye el mensaje oculto a partir de las letras especiales
     * que se obtienen al comparar dos textos.
     *
     * @param m Un texto arbitrario.
     * @param e Un texto similar al primero , pero con algunas letras especiales.
     * @return El mensaje oculto.
     */
    public String descifraLetrasMarcadas(String m, String e) {
        String resultado = "";
        Scanner scanM = new Scanner(m);
        Scanner scanE = new Scanner(e);
        while (scanM.hasNext() && scanE.hasNext()) {
            String palabraM = scanM.next();
            String palabraE = scanE.next();
            if (palabraM.length() == palabraE.length()) {
                for (int i = 0; i < palabraM.length(); i++) {
                    if (palabraM.charAt(i) != palabraE.charAt(i)) {
                        resultado += palabraM.charAt(i);
                    }
                }
            }
        }
        scanM.close();
        scanE.close();
        return resultado;
    }
}
