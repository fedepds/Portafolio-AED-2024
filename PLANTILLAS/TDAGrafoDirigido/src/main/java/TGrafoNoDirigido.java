import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public  class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {
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

    /**
     * Este método implementa el algoritmo de búsqueda en anchura (BFS) en un grafo a partir de un vértice específico.
     * Primero marca todos los vértices como no visitados. Luego, comienza el recorrido BFS desde el vértice con la etiqueta dada.
     * Si hay algún vértice que no se ha visitado después del primer recorrido BFS, continúa el recorrido BFS para cada vértice no visitado.
     *
     * @param etiquetaOrigen La etiqueta del vértice donde comienza el recorrido BFS.
     * @return Una colección de vértices que han sido visitados durante el recorrido BFS.
     */
    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        // Marca todos los vértices como no visitados
        desvisitarVertices();

        // Comienza el recorrido BFS desde el vértice con la etiqueta dada
        TVertice vertice = this.getVertices().get(etiquetaOrigen);
        Collection<TVertice> visitados = new LinkedList<>();
        vertice.bea(visitados);

        // Continúa el recorrido BFS para cada vértice no visitado
        for (TVertice v : this.getVertices().values()){
            if(!v.getVisitado()){
                v.bea(visitados);
            }
        }

        // Devuelve la colección de vértices visitados
        return visitados;
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
    @Override
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


    @Override
    public boolean conectados(TVertice origen, TVertice destino) {
        return false;
    }

    /**
     * Este método implementa el algoritmo de búsqueda en anchura (BFS) en todo el grafo.
     * Primero marca todos los vértices como no visitados. Luego, comienza el recorrido BFS para cada vértice en el grafo.
     * Si un vértice no ha sido visitado, comienza un recorrido BFS desde ese vértice.
     *
     * @return Una colección de vértices que han sido visitados durante el recorrido BFS.
     */
    @Override
    public Collection<TVertice> bea(){
        // Marca todos los vértices como no visitados
        desvisitarVertices();

        // Inicializa la colección de vértices visitados
        Collection<TVertice> visitados = new LinkedList<>();

        // Comienza el recorrido BFS para cada vértice en el grafo
        for (TVertice v : this.getVertices().values()){
            // Si un vértice no ha sido visitado, comienza un recorrido BFS desde ese vértice
            if(!v.getVisitado()){
                v.bea(visitados);
            }
        }

        // Devuelve la colección de vértices visitados
        return visitados;
    }
    /**
     * Este método calcula el número de Bacon para un actor dado.
     * El número de Bacon de un actor es el número de grados de separación que tienen del actor Kevin Bacon, según lo define el juego "Six Degrees of Kevin Bacon".
     * El método primero recupera el vértice correspondiente al actor dado del grafo.
     * Si el actor no existe en el grafo, devuelve -1.
     * Luego, recupera el vértice correspondiente a Kevin Bacon y calcula el número de Bacon para todos los actores en el grafo.
     * Finalmente, devuelve el número de Bacon del actor dado.
     *
     * @param actor El nombre del actor para el cual calcular el número de Bacon.
     * @return El número de Bacon del actor, o -1 si el actor no existe en el grafo.
     */
    @Override
    public int numBacon(Comparable actor) {
        // Obtiene el vértice correspondiente al actor dado
        TVertice actorBuscado = getVertices().get(actor);

        // Si el actor no existe en el grafo, devuelve -1
        if (actorBuscado == null){
            return -1;
        }

        // Obtiene el vértice correspondiente a Kevin Bacon
        TVertice kevin = getVertices().get("Kevin_Bacon");

        // Calcula el número de Bacon para todos los actores en el grafo
        kevin.numBacon();

        // Devuelve el número de Bacon del actor dado
        return actorBuscado.getBacon();
    }

}
