import java.util.List;

/**
 * La interfaz IArbolTrie define el conjunto de operaciones que debe soportar un árbol Trie, que es una estructura de datos 
 * especializada para manejar un conjunto de strings, permitiendo realizar búsquedas de forma eficiente. Los árboles Trie 
 * son particularmente útiles para tareas como autocompletado y verificación ortográfica.
 */
public interface IArbolTrie {

    /**
     * Inserta una palabra en el árbol Trie. Si la palabra ya está presente en el árbol, puede que no se realice ninguna acción,
     * dependiendo de la implementación específica del Trie.
     *
     * @param palabra La palabra a insertar en el árbol Trie.
     */
    void insertar(String palabra);

    /**
     * Busca una palabra en el árbol Trie y devuelve la cantidad de comparaciones realizadas durante la búsqueda.
     * Esta operación es útil para evaluar la eficiencia de la búsqueda en el Trie.
     *
     * @param palabra La palabra a buscar en el árbol Trie.
     * @return El número de comparaciones realizadas en la búsqueda de la palabra.
     */
    int buscar(String palabra);

    /**
     * Imprime el contenido del árbol Trie. Dependiendo de la implementación, esto puede implicar imprimir todas las palabras
     * almacenadas en el árbol en un orden específico, como orden alfabético.
     */
    void imprimir();

    /**
     * Dado un prefijo, devuelve una lista de todas las palabras almacenadas en el árbol Trie que comienzan con ese prefijo.
     * Esta operación es útil para funciones de autocompletado, donde se ofrecen sugerencias basadas en los caracteres ingresados.
     *
     * @param prefijo El prefijo utilizado para buscar palabras que comiencen con él.
     * @return Una lista que contiene todas las palabras encontradas que comienzan con el prefijo dado.
     */
    List<String> predecir(String prefijo);
}
