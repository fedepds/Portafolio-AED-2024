import java.util.*;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;
    
    public boolean esVacio(){
        return raiz == null;
    }

    @Override
    public void insertar(String palabra, LinkedList<Integer> paginas) {
        if (esVacio()) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, paginas);
    }

    @Override
    public void imprimir() {
        if (!esVacio()) {
            raiz.imprimir();
        }
    }

    public LinkedList<Integer> buscarPaginas(String palabra) {
        if (!esVacio()) {
            return raiz.buscarPaginas(palabra);
        }
        return null;
    }
    
    private HashMap<String, LinkedList<Integer>> obtenerPalabras(String[] libro){
        String[] palabrasLinea;
        HashMap<String, LinkedList<Integer>> palabras = new HashMap<>();
        int contador = 0;
        for (String i : libro){
            contador++;
            palabrasLinea = i.split(" ");
            for(String a : palabrasLinea){
                String nuevaPalabra = filtrarPalabra(a.toLowerCase());
                if(nuevaPalabra.length() > 0){
                    LinkedList<Integer> listaPalabra = palabras.get(nuevaPalabra);
                    int numeroDePagina = (contador / 50) + 1;
                    if(listaPalabra != null){
                        if (!listaPalabra.contains(numeroDePagina)){
                            listaPalabra.addFirst(numeroDePagina);
                        }
                    }else{
                        listaPalabra = new LinkedList();
                        listaPalabra.addFirst(numeroDePagina);
                        palabras.put(nuevaPalabra, listaPalabra);
                    }
                }
            }       
        }
        return palabras;
    }
    
    private static String filtrarPalabra(String a) {
        StringBuilder nuevaPalabra =  new StringBuilder();
        for(int k = 0; k < a.length(); k++){
            int indice = a.charAt(k) - 'a';
            if (indice >= 0 & indice <= 26){
                nuevaPalabra.append(a.charAt(k));
            }
        }
        return nuevaPalabra.toString();
    }
    
    public void indizarLibro(String libroTexto){
        if (!esVacio()){
            String[] libro = ManejadorArchivosGenerico.leerArchivo(libroTexto);
            HashMap<String, LinkedList<Integer>> palabras = obtenerPalabras(libro);
            for (String palabra :  palabras.keySet()){
               LinkedList paginasDeLaPalabra = buscarPaginas(palabra);
               if (paginasDeLaPalabra != null){
                   insertar(palabra, palabras.get(palabra));
               }
            }
        }
    }
    
    public void hacerIndiceLibro(String libroTexto){
        String[] libro = ManejadorArchivosGenerico.leerArchivo(libroTexto);
        HashMap<String, LinkedList<Integer>> palabras = obtenerPalabras(libro);
        for (String palabra :  palabras.keySet()){
           insertar(palabra, new LinkedList());
        }
    }
    
    public void imprimirIndice(){
        if (!esVacio()) {
            raiz.imprimirIndice("", raiz);
        }
    }
    
    @Override
    public String buscar(String palabra){
        if (!esVacio()) {
            return raiz.buscar(palabra);
        }
        return "";
    }
    
    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> listaResultado = new LinkedList<>();
        if (raiz != null){
            prefijo = prefijo.toLowerCase();
            raiz.predecir(prefijo, listaResultado);
        }
        return listaResultado;
    }

}
