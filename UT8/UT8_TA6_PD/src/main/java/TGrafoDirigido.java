import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                //getLasAristas().add(arista);
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }

        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }


    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Comparable centro = Double.MAX_VALUE;
        Comparable eti = ""; //Si no hay centro, se devuleve vacio.
        for(Comparable c : vertices.keySet()){ 
            Comparable posibleCentro = obtenerExcentricidad(c);
            if(!posibleCentro.equals(-1.0)){ //Cuando el valor devuelto es -1, no se toma porque haria que el prgrama no funcione correctamente.
                if(posibleCentro.compareTo(centro) < 0){ //El centro es el vertice con la menor excentricidad.
                    centro = posibleCentro;
                    eti = c;
                }
            }
        }
        return eti;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrixFloyd = UtilGrafos.obtenerMatrizCostos(getVertices()); //Se obetiene la matriz de adyacencia.
        int i,j,k;
        for (k = 0; k < vertices.size(); k++){
            for (i = 0; i < vertices.size(); i++){
                for (j = 0; j < vertices.size(); j++){
                    if(matrixFloyd[i][k] + matrixFloyd[k][j] < matrixFloyd[i][j]){
                        matrixFloyd[i][j] = matrixFloyd[i][k] + matrixFloyd[k][j];
                    }
                }
            }
        }
        return matrixFloyd;
    }
    
    //Floyd con predecesores.
    public Double[][] floyd(int[][] predecesores) {
        Double[][] matrixFloyd = UtilGrafos.obtenerMatrizCostos(getVertices());
        if(predecesores == null){
            predecesores = new int[matrixFloyd.length][matrixFloyd.length];
        }
        int i,j,k;
        for (k = 0; k < vertices.size(); k++){
            for (i = 0; i < vertices.size(); i++){
                for (j = 0; j < vertices.size(); j++){
                    if(matrixFloyd[i][k] + matrixFloyd[k][j] < matrixFloyd[i][j]){
                        matrixFloyd[i][j] = matrixFloyd[i][k] + matrixFloyd[k][j];
                        predecesores[i][j] = k;
                    }
                }
            }
        }
        return matrixFloyd;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] floyd = floyd();
    
        Set<Comparable> verticesEtiquetas = vertices.keySet();
        
        int posicion = 0; //Se obtiene el indice de la etiqueta del vertice pasado
        for(Comparable c : verticesEtiquetas){
            if(c.equals(etiquetaVertice)){
                break;
            }
            posicion++;
        }
        
        Double mayor = floyd[0][posicion]; //Inicio el mayor como el primero elemento coorespondiente.
        for (int i = 1; i < verticesEtiquetas.size(); i++){ 
            if(floyd[i][posicion].compareTo(mayor) > 0){
                mayor = floyd[i][posicion];
            }
        }
        return (mayor.equals(Double.MAX_VALUE) ? -1 : mayor); //Por letra cuando la excentiricidad es infinita se devuleve -1.
    }

    @Override
    public boolean[][] warshall() {
        Double[][] matrix = UtilGrafos.obtenerMatrizCostos(getVertices());
        boolean[][] matrixWarshall = new boolean[matrix.length][matrix.length];
        
        int i, j, k;    
        for(i = 0; i < matrix.length; i++){
            for(j = 0; j < matrix.length; j++){
                matrixWarshall[i][j] = (matrix[i][j] != Double.MAX_VALUE && i != j);
            }
        }
        for (k = 0; k < vertices.size(); k++){
            for (i = 0; i < vertices.size(); i++){
                for (j = 0; j < vertices.size(); j++){
                    if ((i != k) && (k != j) && (i != j)){
                        if(!matrixWarshall[i][j]){
                            matrixWarshall[i][j] = (matrixWarshall[i][k] & matrixWarshall[k][j]);
                        }
                    }
                }
            }
        }
        return matrixWarshall;
    }
    
    @Override
    public Collection<TVertice> bpf() {
        desvisitarVertices();
        Collection<TVertice> bosqueAbarcador = new LinkedHashSet<>();
        for (TVertice v : vertices.values()){
            if(!v.getVisitado()){
                v.bpf(bosqueAbarcador);
            }
        }
        return bosqueAbarcador;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        Collection<TVertice> bosqueAbarcador = new LinkedHashSet<>();
        TVertice verticeOrigen = vertices.get(etiquetaOrigen);
        if(verticeOrigen != null){
            verticeOrigen.bpf(bosqueAbarcador);
            for (TVertice v : vertices.values()){
                if(!v.getVisitado()){
                    v.bpf(bosqueAbarcador);
                }
            }
        }
        return bosqueAbarcador;
    }
    
    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        Collection<TVertice> bosqueAbarcador = new LinkedHashSet<>();
        if(vertices.containsValue(vertice)){
            vertice.bpf(bosqueAbarcador);
            for (TVertice v : vertices.values()){
                if(!v.getVisitado()){
                    v.bpf(bosqueAbarcador);
                }
            }
        }
        return bosqueAbarcador;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if(v != null){
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }

    @Override
    public boolean tieneCiclo() {
        this.desvisitarVertices();
        for (TVertice v : vertices.values()){
            LinkedList<TVertice> lista = new LinkedList<>();
            lista.add(v);
            if(v.tieneCiclo(lista)){
                return true;
            } 
        }
        return false;
    }
    
    public TCaminos[] caminosCriticos(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        if(tieneCiclo()){
            return null;
        }
        TCaminos todosCaminos = this.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        TCaminos caminosCriticos = new TCaminos();
        TCaminos caminosNoCriticos = new TCaminos();
        double costoMayor = 0.0;
        for(TCamino c : todosCaminos.getCaminos()){
            if(c.getCostoTotal() > costoMayor){
                costoMayor = c.getCostoTotal();
                caminosNoCriticos.getCaminos().addAll(caminosCriticos.getCaminos());
                caminosCriticos.getCaminos().clear();
                caminosCriticos.getCaminos().add(c);
            }else if(c.getCostoTotal() == costoMayor){
                caminosCriticos.getCaminos().add(c);
            }else{
                caminosNoCriticos.getCaminos().add(c);
            }
        }
        TCaminos[] caminosCriYNoCri = new TCaminos[2];
        caminosCriYNoCri[0] = caminosCriticos;
        caminosCriYNoCri[1] = caminosNoCriticos;
        return caminosCriYNoCri;
    }

    @Override
    public Collection<TVertice> bea() {
        desvisitarVertices();
        Collection<TVertice> visitados = new LinkedList<>();
        for (TVertice v : this.getVertices().values()){
            if(!v.getVisitado()){
                v.bea(visitados);
            }
        }
        return visitados;
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean estanConectados(Comparable origen, Comparable destino){
        desvisitarVertices();
        TVertice verticeOrigen = getVertices().get(origen);
        TVertice verticeDestino = getVertices().get(destino);
        if(verticeOrigen == null | verticeDestino == null){
            return false;
        }
        boolean result = verticeOrigen.conectadoCon(verticeDestino);
        desvisitarVertices();
        return result && verticeDestino.conectadoCon(verticeOrigen);
    }
}
