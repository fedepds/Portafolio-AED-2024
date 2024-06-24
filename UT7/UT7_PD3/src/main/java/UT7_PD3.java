
import java.util.Collection;

public class UT7_PD3 {

    public static void main(String[] args) {
        Class t = TGrafoDirigido.class;
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/aeropuertos.txt", "src/main/java/conexiones.txt", false, t);
        
        //EJERCICO 1:
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafo.getVertices()), grafo.getVertices(), "EJERCICIO 1 CONEXIONES");
        
        UtilGrafos.imprimirMatrizMejorado(grafo.floyd(), grafo.getVertices(), "EJERCICIO 1 COSTOS MINIMOS");
        
        System.out.println("Los servicios se deberian instalar en: " + grafo.centroDelGrafo());
        
        //EJERCICIO 2:
        
        UtilGrafos.imprimirMatrizDeWarshallMejorado(grafo.warshall(), grafo.getVertices(), "EJERCICIO 2 CONECTIVIDAD ENTRE CIUDADES");
        
        //EJERCICIO 3:
        
        System.out.println();
        System.out.println("EJERCICIO 3 PARTE 1 -BUSQUEDA EN PROFUNDIDAD SIN ETIQUETA ORIGEN ");
        Collection<TVertice> result = grafo.bpf();
        for (TVertice v : result){
            System.out.println(v.getEtiqueta());
        }
        System.out.println();
        System.out.println();
        System.out.println("EJERCICIO 3 PARTE 3 -BUSQUEDA EN PROFUNDIDAD CON 'MONTEVIDEO' COMO ORIGEN ");    
        result = grafo.bpf("Montevideo");
        for (TVertice v : result){
            System.out.println(v.getEtiqueta());
        }
        System.out.println();
        System.out.println();
        System.out.println("EJERCICIO 3 PARTE 4 -OBTENCION DE CAMINOS");    
        for (String s : grafo.caminos(grafo.getVertices().get("Montevideo"), grafo.getVertices().get("Rio_de_Janeiro"))){
            System.out.println(s);
        }
        
        
    }
}
