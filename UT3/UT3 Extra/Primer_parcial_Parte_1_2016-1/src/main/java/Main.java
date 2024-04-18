public class Main
{
    public static void main(String[] args) {
        Conjunto<Integer> conjunto = new Conjunto<>();
        Nodo<Integer> nodo1 = new Nodo<>(1, 1);
        Nodo<Integer> nodo2 = new Nodo<>(2, 2);
        Nodo<Integer> nodo3 = new Nodo<>(3, 3);
        Nodo<Integer> nodo4 = new Nodo<>(4, 4);
        Nodo<Integer> nodo5 = new Nodo<>(5, 5);

        conjunto.insertar(nodo1);
        conjunto.insertar(nodo2);
        conjunto.insertar(nodo3);
        conjunto.insertar(nodo4);
        conjunto.insertar(nodo5);
        System.out.println("Conjunto A");
        System.out.println(conjunto.imprimir());

        Conjunto<Integer> conjunto2 = new Conjunto<>();
        conjunto2.insertar(1, 1);
        conjunto2.insertar(2, 2);
        conjunto2.insertar(9, 9);
        conjunto2.insertar(8, 8);
        conjunto2.insertar(6, 6);

        System.out.println("Conjunto B");
        System.out.println(conjunto2.imprimir());

        System.out.println("Conjunto A Diferencia Simetrica Conjunto B");
        System.out.println(conjunto.diferenciaSimetrica(conjunto2).imprimir());



        Conjunto<Integer> conjuntoUniversal = new Conjunto<>();
        conjuntoUniversal.insertar(1, 1);
        conjuntoUniversal.insertar(2, 2);
        conjuntoUniversal.insertar(3, 3);
        conjuntoUniversal.insertar(4, 4);
        conjuntoUniversal.insertar(5, 5);
        conjuntoUniversal.insertar(6, 6);
        conjuntoUniversal.insertar(7, 7);
        conjuntoUniversal.insertar(8, 8);
        conjuntoUniversal.insertar(9, 9);
        conjuntoUniversal.insertar(10, 10);
        conjuntoUniversal.insertar(11, 11);
        conjuntoUniversal.insertar(12, 12);


        System.out.println("Conjunto Universal");
        System.out.println(conjuntoUniversal.imprimir());


        System.out.println("Conjunto A Complemento ");

        System.out.println(conjunto.complemento(conjuntoUniversal).imprimir());

    }
}
