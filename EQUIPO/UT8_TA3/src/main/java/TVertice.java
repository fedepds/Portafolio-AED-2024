import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
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
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
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

    @Override
    public void bpf(Collection<TVertice> visitados) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
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
    public TVertice siguienteAdyacente(TVertice w) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean conectadoCon(TVertice destino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
