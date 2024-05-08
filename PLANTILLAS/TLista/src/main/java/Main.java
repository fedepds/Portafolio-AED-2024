public class Main {
    public static void main(String[] args) {
        // Crear una nueva lista
        Lista lista = new Lista();

        // Crear e insertar nodos en la lista
        lista.insertar(new Nodo<Integer>(1, 100));
        lista.insertar(new Nodo<Integer>(2, 200));
        lista.insertar(new Nodo<Integer>(3, 300));

        // Imprimir la lista
        lista.listar();

        // Buscar un nodo en la lista
        lista.buscar(2);

        // Eliminar un nodo de la lista
        lista.eliminar(2);

        // Imprimir la lista después de la eliminación
        lista.listar();
    }
}