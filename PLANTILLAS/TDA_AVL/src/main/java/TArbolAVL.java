import java.util.ArrayList;
import java.util.List;

public class TArbolAVL<T> {
    TElementoAVL raiz;
    public TArbolAVL() {
        raiz = null;
    }

    public TElementoAVL<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TElementoAVL<T> raiz) {
        this.raiz = raiz;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    /*busqueda, insercion y eliminacion*/
    public TElementoAVL buscar(Comparable unaEtiqueta) {
        if (raiz == null){
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    public boolean insertar(TElementoAVL<T> unElemento) {
        if (getRaiz() == null) {
            setRaiz(unElemento);
            return true;
        }

        TElementoAVL<T> temp = getRaiz().insertar(unElemento);

        if (temp != getRaiz()) {
            setRaiz(temp);
        }

        return true;
    }

    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        } else {
            System.out.println("Arbol vacio");
        }
    }


    /*Ordenes*/
    public String preOrden() {
        if (raiz == null){
            return "arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }

    public String inOrden() {
        if (raiz == null){
            return "arbol vacio";
        } else {
            return raiz.inOrden();
        }
    }

    public String postOrden() {
        if (raiz == null){
            return "arbol vacio";
        } else {
            return raiz.postOrden();
        }
    }

    /*Otros metodos*/
    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    public int obtenerAltura() {
        if(raiz == null) {
            return 0;
        } else {
            return raiz.obtenerAltura();
        }
    }

    public int obtenerTamanio() {
        if (raiz == null){
            return 1;
        }
        else {
            return raiz.obtenerTamanio();
        }
    }

    public List<String> listarHojasConNivel() {
        if(raiz == null) {
            return null;
        } else {
            List<String> list = new ArrayList<>();
            int nivel = 0;
            return raiz.listarHojasConNivel(list, nivel);
        }
    }

    public boolean esArbolDeBusqueda() {
        if(raiz == null) {
            return false;
        } else {
            return raiz.esArbolDeBusqueda();
        }
    }

    public int obtenerCantidadNodosNivel(int nivelBuscado) {
        if(raiz == null) {
            return 0;
        } else {
            return raiz.obtenerCantidadNodosNivel(nivelBuscado);
        }
    }

    public TElementoAVL obtenerMayorClave() {
        if(raiz == null) {
            return null;
        } else {
            return raiz.obtenerMayorClave();
        }
    }

    public TElementoAVL obtenerMenorClave() {
        if(raiz == null) {
            return null;
        } else {
            return raiz.obtenerMenorClave();
        }
    }

    public TElementoAVL obtenerClaveInmediatamenteAnterior(Comparable unaEtiqueta) {
        if(raiz == null) {
            return null;
        } else {
            return raiz.obtenerClaveInmediatamenteAnterior(unaEtiqueta);
        }
    }

    public TElementoAVL inmediatamenteAnterior(Comparable clave){
        if (raiz != null){
            return raiz.inmediatamenteAnterior(clave);
        }else{
            return null;
        }
    }

    public int obtenerNivel(Comparable unaEtiqueta) {
        if(raiz == null) {
            return 0;
        } else {
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }

    public int enQueNivelEstaUnNodo(Comparable etiqueta){
        if (!esVacio()){
            int contador = 0;
            return raiz.enQueNivelEstaUnNodo(etiqueta,contador);
        }
        return -1;
    }

    public List<TElementoAVL> obtenerNodosEnRango(Comparable rangoMin, Comparable rangoMax) {
        List<TElementoAVL> nodosEnRango = new ArrayList<>();
        if (raiz != null){
            raiz.obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
            return nodosEnRango;
        }
        return null;
    }

    public boolean esIdentico(TArbolAVL otroArbol){
        if (raiz == null){
            return false;
        }else {
            return raiz.esIdentico(otroArbol.raiz);
        }
    }

    public int menoresQue (Comparable unaclave){
        if (raiz != null){
            return raiz.menoresQue(unaclave);
        }
        return -1;
    }

    public String imprimirRango (Comparable inferior,Comparable superior){
        if (raiz != null){
            return raiz.imprimirRango(inferior,superior);
        }else {
            return null;
        }
    }

    public ArrayList<T> listar() {
        if (raiz != null){
            ArrayList<T> array = new ArrayList<>();
            raiz.listar(array);
            return array;
        }else{
            return null;
        }
    }

    public int sumaMismoNivel(int nivel){
        if (raiz != null){
            int suma = 0;
            return raiz.sumaMismoNivel(nivel,suma);
        }else{
            return 0;
        }
    }

    public int obtenerBalance() {
        if (raiz != null) {
            return raiz.obtenerBalance();
        } else {
            return 0;
        }
    }

    /*Rotaciones*/
    public TElementoAVL rotacionLL(TElementoAVL k2) {
        if (raiz != null) {
            return raiz.rotacionLL(k2);
        } else {
            return null;
        }
    }

    public TElementoAVL rotacionRL(TElementoAVL k1) {
        if (raiz != null) {
            return raiz.rotacionRL(k1);
        } else {
            return null;
        }
    }

    public TElementoAVL rotacionLR(TElementoAVL k3) {
        if (raiz != null) {
            return raiz.rotacionLR(k3);
        } else {
            return null;
        }
    }

    public TElementoAVL rotacionRR(TElementoAVL k1) {
        if (raiz != null) {
            return raiz.rotacionRR(k1);
        } else {
            return null;
        }
    }
}
