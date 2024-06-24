import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
                "src/vert2.txt",
                "src/ari2.txt",
                false, TGrafoNoDirigido.class);

      
    
 
      TGrafoNoDirigido grafoPrim = gnd.Prim();
       System.out.println("Cantidad de vertices del grafo por prim:"  + grafoPrim.getVertices().size());
        /*
        mostrar las aristas del AAM por Prim y el costo total
       */
        double contador = 0.0;
        for(TArista a : grafoPrim.getLasAristas()){
            contador += a.getCosto();
        }
        System.out.println("Costo total del grafo por prim:"  + contador/2);
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoPrim.getVertices()), grafoPrim.getVertices(), "GRAFO PRIM");
     
        
  
        TGrafoNoDirigido grafoKruskal = gnd.Kruskal();
        System.out.println("cantidad de vertices del grafo por kruskal:"  + grafoKruskal.getVertices().size());
        /*
        mostrar las aristas del AAM por Kruskal y el costo total
       */
        contador = 0.0;
        for(TArista a : grafoKruskal.getLasAristas()){
            contador += a.getCosto();
        }
        System.out.println("Costo total grafo por kruskal:"  + contador/2);
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoKruskal.getVertices()), grafoKruskal.getVertices(), "GRAFO KRUSKAL");
       
       
    }
}
