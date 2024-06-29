package uy.edu.ucu.aed;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
@SuppressWarnings({"rawtypes", "unchecked"})
public class TCamino<T> {

    private final IVertice<T> origen;
    private final Collection<Comparable> otrosVertices;
    private Double costoTotal;

    /**
     * Imprime las etiquetas de los vértices del camino en la consola.
     */
    public void imprimirEtiquetasConsola() {
        System.out.println(imprimirEtiquetas());
    }

    /**
     * Genera una cadena de texto con las etiquetas de los vértices del camino.
     *
     * @return una cadena de texto con las etiquetas de los vértices del camino
     */
    public String imprimirEtiquetas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Origen: " + getOrigen().getEtiqueta());
        for (Comparable adyacente : getOtrosVertices()) {
            sb.append(" -> " + adyacente);
        }
        return sb.toString();
    }

    /**
     * Constructor de la clase TCamino.
     *
     * @param v el vértice de origen del camino
     */
    public TCamino(IVertice<T> v) {
        this.costoTotal = 0.0d;
        this.origen = v;
        this.otrosVertices = new LinkedList<Comparable>();
    }

    /**
     * Agrega una adyacencia al camino y actualiza el costo total.
     *
     * @param adyacenciaActual la adyacencia a agregar
     * @return true si la adyacencia se agregó con éxito, false en caso contrario
     */
    public boolean agregarAdyacencia(IAdyacencia<T> adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            costoTotal += adyacenciaActual.getCosto();
            return getOtrosVertices().add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    /**
     * Elimina una adyacencia del camino y actualiza el costo total.
     *
     * @param adyacenciaActual la adyacencia a eliminar
     * @return true si la adyacencia se eliminó con éxito, false en caso contrario
     */
    public boolean eliminarAdyacencia(IAdyacencia<T> adyacenciaActual) {
        if (getOtrosVertices().contains(adyacenciaActual.getDestino().getEtiqueta())) {
            costoTotal -= adyacenciaActual.getCosto();
            return getOtrosVertices().remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    /**
     * Devuelve el vértice de origen del camino.
     *
     * @return el vértice de origen del camino
     */
    public IVertice<T> getOrigen() {
        return origen;
    }

    /**
     * Devuelve la colección de vértices del camino, excluyendo el origen.
     *
     * @return la colección de vértices del camino, excluyendo el origen
     */
    public Collection<Comparable> getOtrosVertices() {
        return otrosVertices;
    }

    /**
     * Devuelve el costo total del camino.
     *
     * @return el costo total del camino
     */
    public Double getCostoTotal() {
        return costoTotal;
    }

    /**
     * Establece el costo total del camino.
     *
     * @param costoTotal el nuevo costo total del camino
     */
    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * Crea una copia de este camino.
     *
     * @return una copia de este camino
     */
    public TCamino<T> copiar() {
        IVertice<T> origenCopia = new TVertice<T>(this.getOrigen().getEtiqueta());
        TCamino<T> copia = new TCamino<T>(origenCopia);
        copia.setCostoTotal(this.getCostoTotal());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());

        return copia;
    }

    /**
     * Imprime las etiquetas de los vértices del camino a partir de una clave dada.
     *
     * @param clave la clave a partir de la cual imprimir las etiquetas
     * @return una cadena de texto con las etiquetas de los vértices del camino a partir de la clave dada
     */
    public String imprimirDesdeClave(Comparable clave) {
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        Collection<Comparable> listaDefinitiva = new LinkedList<Comparable>();
        listaDefinitiva.add(this.getOrigen().getEtiqueta());
        listaDefinitiva.addAll(this.getOtrosVertices());

        for (Iterator<Comparable> iterator = listaDefinitiva.iterator(); iterator.hasNext();) {
            Comparable next = iterator.next();
            if (next.compareTo(clave) == 0) {
                start = true;
            }
            if (start) {
                sb.append(" " + next + " ");
            }
        }
        return sb.toString();
    }
}
