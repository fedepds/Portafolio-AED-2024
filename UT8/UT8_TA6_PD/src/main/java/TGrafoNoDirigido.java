import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

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
        if(lasAristas != null && tempbool){ //Se modifico para que cuando se inserte una arista en un grafo no dirigido, tambien se inserte en "lasAristas".
            lasAristas.add(arista);
            lasAristas.add(arInv);
        }
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    /**
     * Este método implementa el algoritmo de Prim para encontrar el árbol de expansión mínima de un grafo.
     * El algoritmo de Prim es un algoritmo de árbol de expansión mínima que encuentra una arista de menor peso posible que conecta cualquier árbol en el bosque.
     * Es un algoritmo codicioso en teoría de grafos ya que encuentra un árbol de expansión mínima para un grafo ponderado conectado agregando arcos de costo creciente en cada paso.
     * El algoritmo comienza con un solo vértice y sigue agregando la arista mínima que conecta el árbol con un vértice que no está en el árbol.
     * El método devuelve el árbol de expansión mínima como una nueva instancia de TGrafoNoDirigido.
     *
     * @return TGrafoNoDirigido - El árbol de expansión mínima del grafo como una nueva instancia de TGrafoNoDirigido.
     */
    @Override
    public TGrafoNoDirigido Prim() {
        // Crea una lista de vértices e inicialízala con los vértices del grafo.
        LinkedList<Comparable> verticesArista = new LinkedList(getVertices().keySet());

        // Crea una lista para almacenar las aristas del árbol de expansión mínima.
        LinkedList<TArista> aristasAAM = new LinkedList<>();

        // Crea una lista para almacenar los vértices del árbol de expansión mínima e inicialízala con el primer vértice del grafo.
        LinkedList<Comparable> verticesAAM = new LinkedList<>();
        verticesAAM.add(verticesArista.removeFirst());

        // Mientras haya vértices que no estén en el árbol, sigue agregando la arista mínima que conecta el árbol con un vértice que no está en el árbol.
        while (!verticesArista.isEmpty()){
            // Encuentra la arista mínima que conecta el árbol con un vértice que no está en el árbol.
            TArista aristaAux = lasAristas.buscarMin(verticesAAM, verticesArista);

            // Agrega la arista mínima a la lista de aristas del árbol de expansión mínima.
            aristasAAM.add(aristaAux);

            // Agrega el vértice conectado por la arista mínima a la lista de vértices del árbol de expansión mínima.
            verticesAAM.add(aristaAux.getEtiquetaDestino());

            // Elimina el vértice conectado por la arista mínima de la lista de vértices que no están en el árbol.
            verticesArista.remove(aristaAux.getEtiquetaDestino());
        }

        // Devuelve el árbol de expansión mínima como una nueva instancia de TGrafoNoDirigido.
        return new TGrafoNoDirigido(new LinkedList(getVertices().values()), aristasAAM);
    }

    /**
     * Este método implementa el algoritmo de Kruskal para encontrar el árbol de expansión mínima de un grafo.
     * El algoritmo de Kruskal es un algoritmo de árbol de expansión mínima que encuentra una arista de menor peso posible que conecta dos árboles en el bosque.
     * Es un algoritmo codicioso en teoría de grafos ya que encuentra un árbol de expansión mínima para un grafo ponderado conectado agregando arcos de costo creciente en cada paso.
     *
     * @return TGrafoNoDirigido - El árbol de expansión mínima del grafo como una nueva instancia de TGrafoNoDirigido. Si el grafo no está conectado, devuelve null.
     */
    @Override
    public TGrafoNoDirigido Kruskal() {
        // Comprueba si el grafo está conectado. Si no lo está, devuelve null.
        if(!esConexo()) //O(A)
            return null; //O(1)

        // Crea un nuevo grafo con los mismos vértices que el grafo original pero sin aristas.
        TGrafoNoDirigido grafoAAM = new TGrafoNoDirigido(new LinkedList(getVertices().values()), new LinkedList<>()); //O(1)

        // Clona las aristas del grafo original.
        TAristas aristasAux = (TAristas) getLasAristas().clone();//O(1)

        // Mientras el nuevo grafo no esté conectado, sigue añadiendo la arista mínima que conecta dos árboles diferentes en el bosque.
        do{
            // Encuentra la arista mínima que conecta dos árboles diferentes en el bosque.
            TArista aritasMinAux = aristasAux.buscarMin(getVertices().keySet(), getVertices().keySet()); //O(A)

            // Si los dos vértices conectados por la arista mínima no están ya conectados en el nuevo grafo, añade la arista al nuevo grafo.
            if(!grafoAAM.estanConectados(aritasMinAux.getEtiquetaOrigen(), aritasMinAux.getEtiquetaDestino())) //Se obtiene si ya hay una conexion entre los dos vertices. O(A)
                grafoAAM.insertarArista(aritasMinAux); //Lo inserta si no hay una conexion. //O(1)

            // Elimina la arista mínima de la lista de aristas.
            aristasAux.remove(aritasMinAux); //O(A)

            // Elimina la arista con vértices invertidos de la lista de aristas.
            aristasAux.remove(aristasAux.buscar(aritasMinAux.getEtiquetaDestino(), aritasMinAux.getEtiquetaOrigen())); //O(A)
        }while (!grafoAAM.esConexo());  //O(A)

        // Devuelve el árbol de expansión mínima.
        return grafoAAM; //O(1)
    }

    /**
     * Este método implementa una variante del algoritmo de Kruskal para encontrar el árbol de expansión mínima de un grafo.
     * A diferencia del algoritmo de Kruskal original, esta variante ordena las aristas primero y luego agrega la arista más pequeña que no forma un ciclo.
     * El algoritmo verifica si el grafo está conectado al principio y devuelve null si no lo está.
     * Luego crea un nuevo grafo con los mismos vértices que el grafo original pero sin aristas.
     * Las aristas del grafo original se clonan y se ordenan en orden ascendente de sus pesos.
     * Luego, el algoritmo sigue agregando la arista más pequeña que conecta dos árboles diferentes en el bosque hasta que el nuevo grafo está conectado.
     * Si los dos vértices conectados por la arista más pequeña no están ya conectados en el nuevo grafo, la arista se agrega al nuevo grafo.
     * Luego se elimina la arista más pequeña de la lista de aristas.
     * El proceso continúa hasta que el nuevo grafo está conectado.
     * El método devuelve el árbol de expansión mínima como una nueva instancia de TGrafoNoDirigido.
     *
     * @return TGrafoNoDirigido - El árbol de expansión mínima del grafo como una nueva instancia de TGrafoNoDirigido. Si el grafo no está conectado, devuelve null.
     */
    public TGrafoNoDirigido Kruskal2() {
        // Comprueba si el grafo está conectado. Si no lo está, devuelve null.
        if(!esConexo()) //O(A)
            throw new IllegalStateException("El grafo no es conexo.");

        // Crea un nuevo grafo con los mismos vértices que el grafo original pero sin aristas.
        TGrafoNoDirigido grafoAAM = new TGrafoNoDirigido(new LinkedList(getVertices().values()), new LinkedList<>()); //O(1)

        // Clona las aristas del grafo original y las ordena en orden ascendente de sus pesos.
        TAristas aristasAux = (TAristas) getLasAristas().clone(); //O(A)
        Collections.sort(aristasAux, (TArista a, TArista b) -> Double.compare(a.getCosto(), b.getCosto())); //O(A^2)

        // Mientras el nuevo grafo no esté conectado, sigue agregando la arista más pequeña que conecta dos árboles diferentes en el bosque.
        while (!grafoAAM.esConexo()){ //O(A^2)
            // Obtiene la arista más pequeña.
            TArista aritasMinAux = aristasAux.removeFirst(); //O(1)

            // Si los dos vértices conectados por la arista más pequeña no están ya conectados en el nuevo grafo, agrega la arista al nuevo grafo.
            if(!grafoAAM.estanConectados(aritasMinAux.getEtiquetaOrigen(), aritasMinAux.getEtiquetaDestino())) //O(A)
                grafoAAM.insertarArista(aritasMinAux); //Lo inserta si no hay una conexion. //O(1)
        }

        // Devuelve el árbol de expansión mínima.
        return grafoAAM; //O(1)
    }

    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        desvisitarVertices();
        TVertice vertice = this.getVertices().get(etiquetaOrigen);
        Collection<TVertice> visitados = new LinkedList<>();
        vertice.bea(visitados);
        for (TVertice v : this.getVertices().values()){
            if(!v.getVisitado()){
                v.bea(visitados);
            }
        }
        return visitados;
    }
	 
    @Override
    public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean esConexo(){
        desvisitarVertices();
        LinkedList<TVertice> verticesAux = new LinkedList<>(getVertices().values());
        verticesAux.getFirst().bpf(new LinkedList());
        for (TVertice v : verticesAux){
            if(!v.getVisitado())
                return false;
        }
        return true;
    }
}
