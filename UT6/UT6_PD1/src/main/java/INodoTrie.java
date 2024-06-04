import java.util.List;

/**
 * La interfaz INodoTrie define la estructura y las operaciones básicas que debe implementar un nodo de un trie no comprimido.
 * Un trie es una estructura de datos de tipo árbol que se utiliza para almacenar un conjunto de strings de manera eficiente 
 * para realizar búsquedas. En particular, esta interfaz contempla las operaciones de búsqueda, inserción, impresión de contenidos 
 * y predicción de palabras basadas en un prefijo dado.
 */
public interface INodoTrie {

    /**
     * Busca una palabra dentro del trie y devuelve el número de comparaciones realizadas durante la búsqueda.
     *
     * @param s La palabra a buscar dentro del trie.
     * @return El número de comparaciones realizadas para determinar si la palabra está o no en el trie.
     */
    int buscar(String s);

    /**
     * Inserta una nueva palabra en el trie. Si la palabra ya existe, no realiza cambios.
     *
     * @param unaPalabra La palabra a ser insertada en el trie.
     */
    void insertar(String unaPalabra);

    /**
     * Imprime el contenido del trie. Generalmente se implementa para mostrar todas las palabras almacenadas en el trie.
     */
    void imprimir();

    /**
     * Genera una lista de todas las palabras que contienen el prefijo dado.
     * Las palabras encontradas se agregan a la lista 'palabras'.
     *
     * @param prefijo El prefijo que se utilizará para buscar palabras en el trie.
     * @param palabras Lista de strings donde se almacenarán las palabras encontradas que coinciden con el prefijo dado.
     */
    void predecir(String prefijo, List<String> palabras);
}
