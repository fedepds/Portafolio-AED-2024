package uy.edu.ucu.aed;

/**
 * Clase Hash que implementa la interfaz IHash.
 */
public class Hash implements IHash{
    // Un array para almacenar los valores hash.
    private int[] tabla = new int[10];

    /**
     * Método para buscar una clave en la tabla hash.
     * @param unaClave La clave a buscar.
     * @return Actualmente devuelve 0, necesita ser implementado.
     */
    @Override
    public int buscar(int unaClave) {
        return 0;
    }

    /**
     * Método para insertar una clave en la tabla hash.
     * @param unaClave La clave a insertar.
     * @return Actualmente devuelve 0, necesita ser implementado.
     */
    @Override
    public int insertar(int unaClave) {
        return 0;
    }

    /**
     * Función hash que genera un hash de una clave tomando el módulo de la clave con la longitud de la tabla hash.
     * @param unaClave La clave a generar hash.
     * @return El valor hash.
     */
    @Override
    public int funcionHashing(int unaClave) {
        return unaClave % tabla.length;
    }

    /**
     * Otra función hash que genera un hash de una clave sumando los dígitos de la clave y luego tomando el módulo con la longitud de la tabla hash.
     * @param unaClave La clave a generar hash.
     * @return El valor hash.
     */
    public int otraFuncionHashing(int unaClave) {
        int resultado = 0;
        for (char c :String.valueOf(unaClave).toCharArray()){
            resultado += Integer.parseInt(String.valueOf(c));
        }
        return resultado % tabla.length;
    }
    public int funcionHashingAgustin(int unaClave) {
        return unaClave % 23;
    }
}
