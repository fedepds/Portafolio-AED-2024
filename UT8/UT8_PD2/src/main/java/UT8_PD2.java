

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UT8_PD2 {

    public static void main(String[] args) {
        
        //EJERICIO 1
        
        TGrafoNoDirigido[] grafos = new TGrafoNoDirigido[3];
        grafos[0] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_0.txt", false, TGrafoNoDirigido.class);
        grafos[1] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_1.txt", false, TGrafoNoDirigido.class);
        grafos[2] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_2.txt", false, TGrafoNoDirigido.class); //remplazo con un grafo conexo
        for(int i = 0; i < grafos.length; i++){
            TGrafoNoDirigido grafoKruskal = grafos[i].Kruskal2();
            UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoKruskal.getVertices()), grafoKruskal.getVertices(), "GRAFO " + i +" KRUSKAL");
            System.out.println();
        }
    }
}
