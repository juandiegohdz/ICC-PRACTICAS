/**
 * Author:Juan Diego Hernández Becerril
 * 16/03/2025
 */

/**
 * Los servicios que debe ofrecer un Recipiente.
 */
public interface ServiciosRecipiente {

    /**
     * Calcula y devuelve la cantidad máxima de líquido que cabe en
     * el recipiente.
     *
     * @return La capacidad total.
     */
    public double capacidad();

    /**
     * Calcula y devuelve la diferencia entre la capacidad total y
     * la cantidad actual del recipiente.
     *
     * @return La capacidad restante.
     */
    public double capacidadRestante();

    /**
     * Indica si el recipiente está vacío, es decir, la cantidad
     * de líquido que contiene es cero.
     *
     * @return true si está vacío, false en otro caso.
     */
    public boolean estaVacio();

    /**
     * Indica si el recipiente está lleno, es decir, la cantidad
     * de líquido que contiene es igual a la de su capacidad.
     *
     * @return true si está lleno, false en otro caso.
     */
    public boolean estaLleno();

    /**
     * Agrega una nueva cantidad de líquido al recipiente, respetando
     * la capacidad máxima del mismo. En caso de que no quepa todo
     * el líquido, deberá devolver la cantidad excedente.
     *
     * @param cantidad La cantidad de líquido a agregar.
     * @return La cantidad excedente. Puede ser cero si cabía todo.
     */
    public double rellena(double cantidad);

    /**
     * Resetea la cantidad actual a cero.
     *
     * @return La cantidad de líquido que poseía.
     */
    public double vacia();

    /**
     * Vierte el contenido del recipiente en otro respetando su
     * capacidad máxima.
     *
     * @param otro El recipiente donde se verterá el líquido actual.
     */
    public void vierte(Recipiente otro);

    /**
     * Indica si el recipiente tiene exactamente las mismas
     * dimensiones que otro. Solo revisamos las dimensiones, la
     * cantidad de líquido puede variar.
     *
     * @param otro El recipiente con que se comparará.
     * @return true si tienen las mismas dimensiones, false en otro
     * caso.
     */
    public boolean mismasDimensiones(Recipiente otro);

    /**
     * Indica si el recipiente tiene exactamente la misma
     * capacidad total que otro. Solo revisamos la capacidad total,
     * las dimensiones pueden variar.
     *
     * @param otro El recipiente con que se comparará.
     * @return true si tienen la misma capacidad total, false en otro
     * caso.
     */
    public boolean mismaCapacidad(Recipiente otro);

    /**
     * Indica si el recipiente tiene mayor cantidad actual que otro.
     *
     * @param otro El recipiente con que se comparará.
     * @return true si tiene mayor cantidad, false en otro caso.
     */
    public boolean contieneMas(Recipiente otro);

    /**
     * Indica si el recipiente tiene mayor capacidad restante que
     * otro.
     *
     * @param otro El recipiente con que se comparará.
     * @return true si tiene mayor capacidad restante, false en otro
     * caso.
     */
    public boolean cabeMas(Recipiente otro);

    /**
     * Crea un nuevo recipiente vacío cuya capacidad total es igual
     * a la cantidad actual del recipiente invocante.
     *
     * @return Un nuevo recipiente vacío con capacidad total igual a
     * la cantidad actual del recipiente invocante.
     */
    public Recipiente creaContenedorJusto();

    /**
     * Devuelve una cadena que exhiba con buen formato las
     * dimensiones, capacidad y cantidad actual del recipiente.
     *
     * @return La cadena correspondiente al recipiente.
     */
    public String muestra();
}

