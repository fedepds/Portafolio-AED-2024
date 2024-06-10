import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        TGrafoNoDirigido grafo = UtilGrafos.cargarGrafo("/Users/federicopizarro/Desktop/UT8_TA3/src/main/java/verticesBEA.txt", "/Users/federicopizarro/Desktop/UT8_TA3/src/main/java/aristasBEA.txt",
                false, TGrafoNoDirigido.class);
        System.out.println("Grafo cargado en memoria");

        System.out.println("Busqueda en amplitud: Sin vertice especificado");
        Iterator<TVertice> it = grafo.bea().iterator();
        while (it.hasNext()) {
            TVertice v = it.next();
            System.out.println(v.getEtiqueta());
        }






    }
}
