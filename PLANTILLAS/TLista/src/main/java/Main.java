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
        Nodo nodoBuscado = lista.buscar(2);
        if (nodoBuscado != null) {
            System.out.println("Nodo encontrado: " + nodoBuscado.getDato());
        } else {
            System.out.println("Nodo no encontrado");
        }

        // Eliminar un nodo de la lista
        boolean eliminado = lista.eliminar(1);
        if (eliminado) {
            System.out.println("Nodo eliminado");
        } else {
            System.out.println("Nodo no encontrado para eliminar");
        }

        // Imprimir la lista después de la eliminación
        lista.listar();
    }
}