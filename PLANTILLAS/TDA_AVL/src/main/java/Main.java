import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        TArbolAVL avl = new TArbolAVL();

        TElementoAVL e1 = new TElementoAVL(57,57);
        TElementoAVL e2 = new TElementoAVL(28,28);
        TElementoAVL e3 = new TElementoAVL(12,12);
        TElementoAVL e4 = new TElementoAVL(35,35);
        TElementoAVL e5 = new TElementoAVL(96,96);
        TElementoAVL e6 = new TElementoAVL(76,76);
        TElementoAVL e7 = new TElementoAVL(42,42);
        TElementoAVL e8 = new TElementoAVL(7,7);
        TElementoAVL e9 = new TElementoAVL(31,31);
        TElementoAVL e10 = new TElementoAVL(53,53);
        TElementoAVL e11 = new TElementoAVL(104,104);
        TElementoAVL e12 = new TElementoAVL(30,30);
        TElementoAVL e13 = new TElementoAVL(20,20);
        TElementoAVL e14 = new TElementoAVL(61,61);
        TElementoAVL e15 = new TElementoAVL(84,84);
        TElementoAVL e16 = new TElementoAVL(87,87);

        avl.insertar(e1);
        avl.insertar(e2);
        avl.insertar(e3);
        avl.insertar(e4);
        avl.insertar(e5);
        System.out.println(avl.obtenerBalance());
        avl.insertar(e6);
        System.out.println(avl.obtenerBalance());
        avl.insertar(e7);
        System.out.println(avl.obtenerBalance());
        System.out.println(avl.obtenerBalance());
        avl.insertar(e8);
        avl.insertar(e9);
        avl.insertar(e10);
        avl.insertar(e11);
        avl.insertar(e12);
        avl.insertar(e13);
        avl.insertar(e14);
        avl.insertar(e15);
        avl.insertar(e16);
        System.out.println(avl.obtenerBalance());







        System.out.println(avl.preOrden());
        System.out.println(avl.inOrden());
        System.out.println(avl.postOrden());
        System.out.println(avl.obtenerAltura());
        System.out.printf(""+avl.obtenerNivel(57));
        System.out.printf("Listar" +avl.listar());


    }
}