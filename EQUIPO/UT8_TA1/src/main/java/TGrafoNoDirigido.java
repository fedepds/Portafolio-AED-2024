
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
protected TAristas lasAristas = new TAristas() ;
       /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
       super(vertices, aristas);     
      lasAristas.insertarAmbosSentidos(aristas);
       
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }
public TAristas getLasAristas() {
        return lasAristas;
    }

    /**
     * Este método implementa el algoritmo de Prim para encontrar el árbol de expansión mínima de un grafo.
     * El algoritmo comienza seleccionando un vértice arbitrario y añadiéndolo al árbol de expansión mínima (MST).
     * Luego, añade repetidamente la arista más pequeña que conecta un vértice en el MST con un vértice fuera del MST.
     * El proceso continúa hasta que todos los vértices están incluidos en el MST.
     *
     * @return Una nueva instancia de TGrafoNoDirigido que representa el árbol de expansión mínima del grafo original.
     * Si el grafo no está conectado, el método devuelve null.
     */
    @Override
    public TGrafoNoDirigido Prim() {
        // Comprueba si el grafo está conectado. Si no lo está, devuelve null.
        if(!esConexo())
            return null;

        // Crea una lista de vértices del grafo.
        LinkedList<Comparable> verticesAux = new LinkedList(getVertices().keySet());

        // Crea una lista para almacenar las aristas del árbol de expansión mínima.
        LinkedList<TArista> aristasAAM = new LinkedList<>();

        // Crea una lista para almacenar los vértices del árbol de expansión mínima.
        LinkedList<Comparable> verticesAAM = new LinkedList<>();

        // Añade el primer vértice al árbol de expansión mínima.
        verticesAAM.add(verticesAux.removeFirst());

        // Mientras todavía haya vértices fuera del árbol de expansión mínima...
        while (!verticesAux.isEmpty()){
            // Encuentra la arista más pequeña que conecta un vértice en el MST con un vértice fuera del MST.
            TArista aristaAux = lasAristas.buscarMin(verticesAAM, verticesAux);

            // Añade la arista a la lista de aristas en el MST.
            aristasAAM.add(aristaAux);

            // Añade el vértice de destino de la arista a la lista de vértices en el MST.
            verticesAAM.add(aristaAux.getEtiquetaDestino());

            // Elimina el vértice de destino de la lista de vértices fuera del MST.
            verticesAux.remove(aristaAux.getEtiquetaDestino());
        }

        // Devuelve un nuevo grafo que representa el árbol de expansión mínima.
        return new TGrafoNoDirigido(new LinkedList(getVertices().values()), aristasAAM);
    }



    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Este método verifica si el grafo está conectado.
     * Comienza marcando todos los vértices como no visitados.
     * Luego, realiza una búsqueda en profundidad (BPF) a partir del primer vértice.
     * Si todos los vértices son visitados después de la BPF, significa que el grafo está conectado.
     * Si hay algún vértice que no se visita después de la BPF, significa que el grafo no está conectado.
     *
     * @return verdadero si el grafo está conectado, falso en caso contrario.
     */
    public boolean esConexo(){
        // Marca todos los vértices como no visitados
        desvisitarVertices();

        // Crea una lista de vértices del grafo
        LinkedList<TVertice> verticesAux = new LinkedList<>(getVertices().values());

        // Realiza una BPF a partir del primer vértice
        verticesAux.getFirst().bpf(new LinkedList());

        // Verifica si todos los vértices son visitados
        for (TVertice v : verticesAux){
            // Si hay algún vértice que no se visita, devuelve falso
            if(!v.getVisitado())
                return false;
        }

        // Si todos los vértices son visitados, devuelve verdadero
        return true;
    }
}
