package uy.edu.ucu.aed;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Clase TVertice que implementa IVertice.
 * Esta clase representa un vértice en un grafo.
 * @param <T> El tipo de los datos que se guardan en cada vértice.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class TVertice<T> implements IVertice<T> {
    private Comparable etiqueta;
    private LinkedList<IAdyacencia<T>> adyacentes;
    private boolean visitado;
    protected T datos;

    /**
     * Constructor de la clase TVertice.
     * @param unaEtiqueta La etiqueta del vértice.
     */
    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList<IAdyacencia<T>>();
        visitado = false;
    }

    /**
     * Método para obtener la etiqueta del vértice.
     * @return La etiqueta del vértice.
     */
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * Método para obtener las adyacencias del vértice.
     * @return Las adyacencias del vértice.
     */
    public LinkedList<IAdyacencia<T>> getAdyacentes() {
        return adyacentes;
    }

    /**
     * Método para obtener los datos del vértice.
     * @return Los datos del vértice.
     */
    public T getDatos() {
        return datos;
    }

    /**
     * Método para establecer el estado de visitado del vértice.
     * @param valor El nuevo estado de visitado.
     */
    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    /**
     * Método para obtener el estado de visitado del vértice.
     * @return El estado de visitado del vértice.
     */
    public boolean getVisitado() {
        return this.visitado;
    }

    /**
     * Método para buscar una adyacencia en el vértice.
     * @param verticeDestino El vértice destino de la adyacencia.
     * @return La adyacencia si se encuentra, null en caso contrario.
     */
    @Override
    public IAdyacencia<T> buscarAdyacencia(IVertice<T> verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    /**
     * Método para obtener el costo de una adyacencia.
     * @param verticeDestino El vértice destino de la adyacencia.
     * @return El costo de la adyacencia si se encuentra, Double.MAX_VALUE en caso contrario.
     */
    @Override
    public Double obtenerCostoAdyacencia(IVertice<T> verticeDestino) {
        IAdyacencia<T> ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    /**
     * Método para insertar una adyacencia en el vértice.
     * @param costo El costo de la adyacencia.
     * @param verticeDestino El vértice destino de la adyacencia.
     * @return Verdadero si la adyacencia se insertó correctamente, falso en caso contrario.
     */
    @Override
    public boolean insertarAdyacencia(Double costo, IVertice<T> verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            IAdyacencia<T> ady = new TAdyacencia<T>(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    /**
     * Método para eliminar una adyacencia del vértice.
     * @param nomVerticeDestino El nombre del vértice destino de la adyacencia.
     * @return Verdadero si la adyacencia se eliminó correctamente, falso en caso contrario.
     */
    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        IAdyacencia<T> ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    /**
     * Método para obtener el primer vértice adyacente.
     * @return El primer vértice adyacente si existe, null en caso contrario.
     */
    @Override
    public IVertice<T> primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    /**
     * Método para buscar una adyacencia por su etiqueta de destino.
     * @param etiquetaDestino La etiqueta de destino de la adyacencia.
     * @return La adyacencia si se encuentra, null en caso contrario.
     */
    @Override
    public IAdyacencia<T>buscarAdyacencia(Comparable etiquetaDestino) {
        for (IAdyacencia<T>adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     * Método para realizar una búsqueda en profundidad desde el vértice.
     * @param visitados La colección de vértices visitados.
     */
    @Override
    public void bpf(Collection<IVertice<T>> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (IAdyacencia<T>adyacente : adyacentes) {
            IVertice<T> vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    /**
     * Método que devuelve todos los caminos desde el vértice actual hasta el vértice destino.
     * @param etVertDest La etiqueta del vértice destino.
     * @param caminoPrevio El camino previo.
     * @param todosLosCaminos La colección de todos los caminos.
     * @return La colección de todos los caminos.
     */
    @Override
    public TCaminos<T> todosLosCaminos(Comparable etVertDest, TCamino<T> caminoPrevio, TCaminos<T> todosLosCaminos) {
        this.setVisitado(true);
        for (IAdyacencia<T>adyacencia : this.getAdyacentes()) {
            IVertice<T> destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino<T> copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    /**
     * Método que realiza una búsqueda en amplitud desde el vértice actual.
     * @param visitados La colección de vértices visitados.
     */
    @Override
    public void bea(Collection<IVertice<T>> visitados) {
        this.visitado = true;
        LinkedList<IVertice<T>> lista = new LinkedList<IVertice<T>>();
        lista.add(this);
        visitados.add(this);
        while(!lista.isEmpty()){
            IVertice<T> primero = lista.remove(0);
            LinkedList<IAdyacencia<T>> ady = primero.getAdyacentes();
            for(IAdyacencia<T>t : ady){
                if(!t.getDestino().getVisitado()){
                    t.getDestino().setVisitado(true);
                    lista.add(t.getDestino());
                    visitados.add(t.getDestino());
                }
            }
        }
    }

    /**
     * Método que devuelve el siguiente vértice adyacente al vértice dado.
     * @param w El vértice dado.
     * @return El siguiente vértice adyacente.
     */
    @Override
    public IVertice<T> siguienteAdyacente(IVertice<T> w) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Método que verifica si el vértice tiene un ciclo.
     * @param camino El camino a verificar.
     * @return Verdadero si el vértice tiene un ciclo, falso en caso contrario.
     */
    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        setVisitado(true);
        camino.add(this.getEtiqueta());
        boolean ciclo = false;
        for (IAdyacencia<T>adyacencia : this.getAdyacentes()) {
            IVertice<T> w = adyacencia.getDestino();
            if (!w.getVisitado()) {
                ciclo = w.tieneCiclo(camino);
                if (ciclo) {
                    break;
                }
            } else {
                if (camino.contains(w.getEtiqueta())) {
                    ciclo = true;
                    break;
                }

            }

        }
        camino.remove(this.getEtiqueta());
        return ciclo;
    }

    /**
     * Método que verifica si el vértice está conectado con el vértice destino.
     * @param etVertDest El vértice destino.
     * @return Verdadero si el vértice está conectado con el vértice destino, falso en caso contrario.
     */
    @Override
    public boolean conectadoCon(IVertice<T> etVertDest) {
        this.setVisitado(true);
        
        for (IAdyacencia<T>adyacencia : this.getAdyacentes()) {
            IVertice<T> destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {                    
                    return true;
                } else {                    
                    boolean existe =  destino.conectadoCon(etVertDest);
                    if (existe){
                       return existe;
                    }
                }                
            }
        }

        this.setVisitado(false);
        
        return false;
    }
}
