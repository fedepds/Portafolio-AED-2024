import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T> implements IVertice, IVerticeKevinBacon {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int numBacon=0;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        datos = null;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public T getDatos() {
        return datos;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    /**
     * Este método se utiliza para encontrar todos los caminos desde el vértice actual hasta el vértice de destino.
     * Utiliza un enfoque de búsqueda en profundidad para recorrer el grafo.
     *
     * @param etVertDest La etiqueta del vértice de destino.
     * @param caminoPrevio El camino previo que se ha recorrido.
     * @param todosLosCaminos Una colección de todos los caminos encontrados hasta ahora.
     * @return Una colección de todos los caminos desde el vértice actual hasta el vértice de destino.
     */
    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        // Marcar el vértice actual como visitado
        setVisitado(true);
        // Iterar sobre todos los vértices adyacentes
        for (TAdyacencia adyacente : getAdyacentes()) {
            TVertice destino = adyacente.getDestino();
            // Si el vértice adyacente no ha sido visitado
            if (!destino.getVisitado()) {
                // Si el vértice adyacente es el destino
                if (adyacente.getDestino().getEtiqueta().equals(etVertDest)) {
                    // Copiar el camino previo y agregar la adyacencia actual a él
                    TCamino caminoCopia = caminoPrevio.copiar();
                    caminoCopia.agregarAdyacencia(adyacente);
                    // Agregar el nuevo camino a la colección de todos los caminos
                    todosLosCaminos.getCaminos().add(caminoCopia);
                } else {
                    // Si el vértice adyacente no es el destino, agregar la adyacencia al camino previo
                    caminoPrevio.agregarAdyacencia(adyacente);
                    // Llamar recursivamente al método para el vértice adyacente
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    // Eliminar la adyacencia actual del camino previo
                    caminoPrevio.eliminarAdyacencia(adyacente);
                }
            }
        }
        // Marcar el vértice actual como no visitado
        setVisitado(false);
        // Devolver la colección de todos los caminos
        return todosLosCaminos;
    }
    /**
     * Este método implementa el algoritmo de búsqueda en anchura (BFS) en un grafo.
     * BFS es un algoritmo de recorrido donde debes comenzar a recorrer desde un nodo seleccionado (nodo fuente o inicial)
     * y recorrer el grafo por capas, explorando así los nodos vecinos (nodos que están directamente conectados al nodo fuente).
     * Luego debes moverte hacia los nodos vecinos del siguiente nivel.
     *
     * @param visitados Esta es una colección de vértices que han sido visitados por el algoritmo BFS.
     */
    @Override
    public void bea(Collection<TVertice> visitados) {
        // Marca el nodo actual como visitado y lo encola
        this.setVisitado(true);
        LinkedList<TVertice> queue = new LinkedList<>();
        queue.addLast(this);
        visitados.add(this);

        while (!queue.isEmpty()) {
            // Desencola un vértice de la cola y lo imprime
            TVertice x = queue.removeFirst();
            LinkedList<TAdyacencia> xAdyacentes = x.getAdyacentes();

            // Obtiene todos los vértices adyacentes del vértice desencolado x
            // Si un adyacente no ha sido visitado, entonces lo marca como visitado y lo encola
            for (TAdyacencia v : xAdyacentes) {
                if (!v.getDestino().getVisitado()) {
                    v.getDestino().setVisitado(true);
                    queue.addLast(v.getDestino());
                    visitados.add(v.getDestino());
                }
            }
        }
    }

    @Override
    public int getBacon() {
        return this.numBacon;
    }

    @Override
    public void setBacon(int newBacon) {
        this.numBacon = newBacon;
    }

    public void numBacon() {
        // Marca el nodo actual como visitado y lo encola
        setVisitado(true);
        LinkedList<TVertice> queue = new LinkedList<>();
        queue.addLast(this);
        this.setBacon(0);

        while (!queue.isEmpty()) {
            // Desencola un vértice de la cola y lo imprime
            TVertice x = queue.removeFirst();
            LinkedList<TAdyacencia> xAdyacentes = x.getAdyacentes();

            int baconActual=x.getBacon();

            // Obtiene todos los vértices adyacentes del vértice desencolado x
            // Si un adyacente no ha sido visitado, entonces lo marca como visitado y lo encola
            for (TAdyacencia v : xAdyacentes) {
                TVertice destino=v.getDestino();
                if (!destino.getVisitado()) {
                    destino.setVisitado(true);
                    queue.addLast(v.getDestino());                    
                    destino.setBacon(baconActual+1);
                    
                    
                }
            }
        }
        
    }


}
