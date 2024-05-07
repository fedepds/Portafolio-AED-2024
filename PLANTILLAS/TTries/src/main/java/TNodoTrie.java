import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList();
    }
    
    public LinkedList<Integer> getPaginas(){
        return this.paginas;
    }

    @Override
    public void insertar(String unaPalabra, LinkedList<Integer> paginasPalabra) {
        unaPalabra = unaPalabra.toLowerCase();
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        for (Integer i : paginasPalabra){
            nodo.getPaginas().addFirst(i);
        }
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    
    public void imprimirIndice(String prefijo, TNodoTrie nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                StringBuilder paginasLista = new StringBuilder(prefijo);
                paginasLista.append(" - Paginas: "); 
                for (Integer i : nodo.getPaginas()){
                    paginasLista.append(i).append(" ");
                }
                System.out.println(paginasLista.toString());
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirIndice(prefijo + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
         s = s.toLowerCase();
        TNodoTrie nodoActual = this;
        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodoActual.hijos[indice] == null) {
                return null;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if(nodoActual.esPalabra){
            return nodoActual;
        }
        return null;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
       if(nodo.esPalabra){
            palabras.add(s);
        }
        TNodoTrie nodoActual = nodo;
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (nodo.hijos[c] != null) {
                predecir(s+(char)(c + 'a'), palabras, nodoActual.hijos[c]);
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodoActual = this;
        for (int c = 0; c < prefijo.length(); c++) {
            int indice = prefijo.charAt(c) - 'a';
            if (nodoActual.hijos[indice] == null) {
                return;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        predecir(prefijo, palabras, nodoActual);
    }

    
    public LinkedList<Integer> buscarPaginas(String s) {
        s = s.toLowerCase();
        TNodoTrie nodoActual = this;
        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodoActual.hijos[indice] == null) {
                return null;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if(nodoActual.esPalabra){
            return nodoActual.getPaginas();
        }
        return null;
    }
    
    @Override
    public String buscar(String s) {
        s = s.toLowerCase();
        TNodoTrie nodoActual = this;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodoActual.hijos[indice] == null) {
                return "La palabra " + s + " no existe en el indice. Cantidad de comparaciones realizadas: " + (i+1);
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if (nodoActual.esPalabra){
            StringBuilder mensaje = new StringBuilder("Palabra: ");
            mensaje.append(s);
            mensaje.append(", Paginas en la que se encuetra: ");
            for (Integer a : nodoActual.getPaginas()){
                mensaje.append(a).append(" ");
            }
            return mensaje.toString();
        }
        return "La palabra no existe en el indice. Cantidad de comparaciones realizadas: " + (i+1);
   }
}
