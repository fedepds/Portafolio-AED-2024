import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Clase TGrafoNoDirigido que extiende de TGrafoDirigido e implementa IGrafoNoDirigido.
 * Esta clase representa un grafo no dirigido.
 * @param <T> El tipo de los datos que se guardan en cada vértice.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class TGrafoNoDirigido<T> extends TGrafoDirigido<T> implements IGrafoNoDirigido<T> {
    protected TAristas lasAristas = new TAristas();

    /**
     * Constructor de la clase TGrafoNoDirigido.
     * @param vertices Colección de vértices del grafo.
     * @param aristas Colección de aristas del grafo.
     */
    public TGrafoNoDirigido(Collection<IVertice<T>> vertices, Collection<IArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    /**
     * Método para insertar una arista en el grafo.
     * @param arista La arista a insertar.
     * @return Verdadero si la arista se insertó correctamente, falso en caso contrario.
     */
    @Override
    public boolean insertarArista(IArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    /**
     * Método para obtener las aristas del grafo.
     * @return Las aristas del grafo.
     */
    public TAristas getLasAristas() {
        return lasAristas;
    }

    /**
     * Método para obtener el árbol de expansión mínima del grafo utilizando el algoritmo de Prim.
     * @return El árbol de expansión mínima del grafo.
     */
    @Override
    public IGrafoNoDirigido<T> Prim() {
        IGrafoNoDirigido<T> arbolPrim = new TGrafoNoDirigido(this.getVertices().values(), new LinkedList<>());
        double costoTotal = 0.0d;

        if (this.getVertices().isEmpty()) {
            return arbolPrim;
        }

        TAristas aristas = this.getLasAristas();
        LinkedList<Comparable> vertices = new LinkedList<>();
        for (IVertice<T> vertice : this.getVertices().values()) {
            vertices.add(vertice.getEtiqueta());
        }

        Collection<Comparable> U = new LinkedList<>();

        U.add(vertices.removeFirst());
        while (!vertices.isEmpty()) {
            IArista a = aristas.buscarMin(U, vertices);
            IVertice<T> v = this.getVertices().get(a.getEtiquetaDestino());
            vertices.remove(v.getEtiqueta());
            U.add(v.getEtiqueta());
            arbolPrim.insertarArista(a);
            costoTotal += a.getCosto();
        }
        System.out.println(costoTotal);
        return arbolPrim;
    }

    /**
     * Método para obtener el árbol de expansión mínima del grafo utilizando el algoritmo de Kruskal.
     * @return El árbol de expansión mínima del grafo.
     */
    @Override
    public IGrafoNoDirigido<T> Kruskal() {
        LinkedList<IArista> aristasKruskal = new LinkedList<IArista>(); //Aqui se almacenaran las aristas seleccionadas.
        Map<Comparable, IVertice<T>> vertices = getVertices();

        if (!vertices.isEmpty()) {
            desvisitarVertices();
            HashMap<Comparable, LinkedList<IVertice<T>>> colecciones = new HashMap(vertices.size());
            LinkedList<IVertice<T>> colTemp;

            //Creamos una "coleccion" para cada arista
            for (IVertice<T> v : vertices.values()) {
                colTemp = new LinkedList<IVertice<T>>();
                colTemp.add(v);
                colecciones.put(v.getEtiqueta(), colTemp);
            }

            //Ordenamos todas las aristas del grafo de menor costo a mayor
            LinkedList<IArista> aristasOrdenadas = new LinkedList<IArista>();
            forAristas:
            for (IArista a : lasAristas) {
                if (aristasOrdenadas.isEmpty() || aristasOrdenadas.getFirst().getCosto() > a.getCosto()) {
                    aristasOrdenadas.addFirst(a);
                    continue;
                }
                for (int i = 1; i < aristasOrdenadas.size(); i++) {
                    if (aristasOrdenadas.get(i).getCosto() > a.getCosto()) {
                        aristasOrdenadas.add(i - 1, a);
                        continue forAristas;
                    }
                }
                aristasOrdenadas.add(a);
            }

            //Conectamos las colecciones de vertices (no conectados) mediante la arista de menor costo posible
            IArista menorArista;
            LinkedList<IVertice<T>> colOrigen, colDestino;
            while (!aristasOrdenadas.isEmpty()) {
                menorArista = aristasOrdenadas.pollFirst();
                colOrigen = colecciones.get(menorArista.getEtiquetaOrigen());
                colDestino = colecciones.get(menorArista.getEtiquetaDestino());
                if (colOrigen != colDestino) {
                    colOrigen.addAll(colDestino);
                    for (IVertice<T> v : colDestino) {
                        if (colecciones.get(v.getEtiqueta()) != colOrigen) {
                            colecciones.replace(v.getEtiqueta(), colOrigen);
                        }
                    }
                    aristasKruskal.add(menorArista);
                }
            }
        }

        IGrafoNoDirigido<T> grafo = new TGrafoNoDirigido<T>(vertices.values(), aristasKruskal);
        return grafo;
    }

    /**
     * Método para realizar una búsqueda en amplitud en el grafo.
     * @param etiquetaOrigen La etiqueta del vértice de origen.
     * @return Una colección de vértices que representa el resultado de la búsqueda.
     */
    @Override
    public Collection<IVertice<T>> bea(Comparable etiquetaOrigen) {
         if (this.getVertices().isEmpty()) {
            return null;
        } else {
            this.desvisitarVertices();
            if(this.existeVertice(etiquetaOrigen))
            {
                IVertice<T> vert = super.buscarVertice(etiquetaOrigen);
                Collection<IVertice<T>> verts = new LinkedList<IVertice<T>>();
                vert.bea(verts);
                return verts;
            }
            return null;
        }
    }

    /**
     * Método para determinar si el grafo es conexo.
     * @return Verdadero si el grafo es conexo, falso en caso contrario.
     */
    @Override
    public boolean esConexo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método para determinar si dos vértices están conectados.
     * @param origen El vértice de origen.
     * @param destino El vértice de destino.
     * @return Verdadero si los vértices están conectados, falso en caso contrario.
     */
    @Override
    public boolean conectados(IVertice<T> origen, IVertice<T> destino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
