import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        Class t = TGrafoDirigido.class;
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/aeropuertos_2.txt", "src/main/java/conexiones_2.txt", false, t);
        TCaminos caminos = grafo.todosLosCaminos("Asuncion", "Montevideo");
        caminos.imprimirCaminosConsola();

    }
}
