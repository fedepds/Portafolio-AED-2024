public class Main {
    public static void main(String[] args) {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        ListaOrdenada<Integer> lista2 = new ListaOrdenada<>();
        lista.insertar(1, 1);
        lista.insertar(2, 2);
        lista.insertar(3, 3);
        lista.insertar(4, 4);
        lista2.insertar(5, 5);
        lista2.insertar(6, 6);
        lista2.insertar(7, 7);
        lista2.insertar(8, 8);

        System.out.println("Lista 1:");
        lista.imprimir();

        System.out.println("Lista 2:");
        lista2.imprimir();

        ListaOrdenada<Integer> listaMezclada = lista.mezclarCon(lista2);

        System.out.println("Lista mezclada:");
        listaMezclada.imprimir();


        Lista<Integer> lista3 = new Lista<>();
        lista3.insertar(1, 1);
        lista3.insertar(2, 2);
        lista3.insertar(3, 3);
        lista3.insertar(4, 4);
        lista3.insertar(1, 1);

        System.out.println("Lista 3:");
        lista3.imprimir();

        System.out.println("Lista 3 sin duplicados:");
        lista3.eliminarDuplicados();
        lista3.imprimir();

    }
}