public class Main
{
    public static void main( String[] args )
    {
        // Crea un nuevo árbol genérico con "Rectoria" como nodo raíz
        TArbolGenerico<String> arbol = new TArbolGenerico<>(new TNodoArbolGenerico<>("Rectoria"));

        // Inserta nodos en el árbol. Cada nodo se inserta bajo un nodo padre.
        // El nodo padre se identifica por su etiqueta.

        // Inserta "Vicerrectoria del medio universitario" bajo "Rectoria"
        arbol.insertar("Vicerrectoria del medio universitario", "Rectoria");

        // Inserta "Vicerrectoria academica" bajo "Rectoria"
        arbol.insertar("Vicerrectoria academica", "Rectoria");

        // Inserta "Vicerrectoria administrativa" bajo "Rectoria"
        arbol.insertar("Vicerrectoria administrativa", "Rectoria");

        // Inserta "Facultad de ciencias empresariales" bajo "Vicerrectoria academica"
        arbol.insertar("Facultad de ciencias empresariales", "Vicerrectoria academica");

        // Inserta "Facultad de ciencias humanas" bajo "Vicerrectoria academica"
        arbol.insertar("Facultad de ciencias humanas", "Vicerrectoria academica");

        // Inserta "Facultad de ingenieria y tecnologias" bajo "Vicerrectoria academica"
        arbol.insertar("Facultad de ingenieria y tecnologias", "Vicerrectoria academica");

        // Inserta "Facultad de psicologia" bajo "Vicerrectoria academica"
        arbol.insertar("Facultad de psicologia", "Vicerrectoria academica");

        // Inserta "Departamento de informatica y ciencias de la computacion" bajo "Facultad de ingenieria y tecnologias"
        arbol.insertar("Departamento de informatica y ciencias de la computacion", "Facultad de ingenieria y tecnologias");

        // Inserta "Departamento de ingenieria electrica" bajo "Facultad de ingenieria y tecnologias"
        arbol.insertar("Departamento de ingenieria electrica", "Facultad de ingenieria y tecnologias");

        // Inserta "Departamento de matematicas" bajo "Facultad de ingenieria y tecnologias"
        arbol.insertar("Departamento de matematicas", "Facultad de ingenieria y tecnologias");

        // Imprime la estructura del árbol con sangría
        arbol.imprimirIndentado();
    }
}