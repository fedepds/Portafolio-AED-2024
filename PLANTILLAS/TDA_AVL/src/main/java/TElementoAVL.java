import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class TElementoAVL<T> {
    private Comparable etiqueta;
    private TElementoAVL hijoIzq;
    private TElementoAVL hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    public TElementoAVL(Comparable unaEtiqueta, T unosDatos) {
        this.etiqueta = unaEtiqueta;
        this.datos = unosDatos;
    }

    /*Get y Set*/
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    public TElementoAVL getHijoIzq() {
        return this.hijoIzq;
    }

    public TElementoAVL getHijoDer() {
        return this.hijoDer;
    }
    public T getDatos() {
        return this.datos;
    }

    public void setHijoIzq(TElementoAVL elemento) {
        this.hijoIzq = elemento;
    }

    public void setHijoDer(TElementoAVL elemento) {
        this.hijoDer = elemento;
    }

    /*Busqueda, insercion y eliminacion*/
    public TElementoAVL buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {
            return this;
        }

        if (unaEtiqueta.compareTo(this.etiqueta) < 0 && hijoIzq != null) {
            return hijoIzq.buscar(unaEtiqueta);
        }

        if (unaEtiqueta.compareTo(this.etiqueta) > 0 && hijoDer != null){
            return hijoDer.buscar(unaEtiqueta);
        }

        return null;
    }

    /*public boolean insertar(TElementoAVL unElemento) {
        if (unElemento.getEtiqueta() == this.getEtiqueta()) {
            return false;
        }

        boolean insercion = false;
        if (unElemento.getEtiqueta().compareTo(this.getEtiqueta()) < 0) {
            if (hijoIzq == null) {
                hijoIzq = unElemento;
                insercion = true;
            } else {
                insercion = getHijoIzq().insertar(unElemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = unElemento;
                insercion = true;
            } else {
                insercion = getHijoDer().insertar(unElemento);
            }
        }

        if (insercion) {
            balancear();
        }

        return insercion;
    }*/


    // el timepo de ejecucion de insertar es: O(log n)

    public TElementoAVL<T> insertar(TElementoAVL<T> elemento) {
        int comp = elemento.getEtiqueta().compareTo(getEtiqueta());

        if (comp == 0) {
            return this;
        } else if (comp < 0) {
            if (getHijoIzq() == null) {
                setHijoIzq(elemento);
            } else {
                setHijoIzq(getHijoIzq().insertar(elemento));
            }
        } else {
            if (getHijoDer() == null) {
                setHijoDer(elemento);
            } else {
                setHijoDer(getHijoDer().insertar(elemento));
            }
        }

        return balancear(this);
    }
// el tiempo de ejecicion de eliminar es: O(log n)
    public TElementoAVL eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() != null) {
                this.setHijoIzq(this.getHijoIzq().eliminar(unaEtiqueta));
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.getHijoDer() != null) {
                this.setHijoDer(this.getHijoDer().eliminar(unaEtiqueta));
            }
            return this;
        }

        return this.quitaElNodo();
    }

    public TElementoAVL quitaElNodo(){

        if (this.getHijoIzq() == null) {
            return this.getHijoDer();
        }

        if (this.getHijoDer() == null) {
            return this.getHijoIzq();
        }

        TElementoAVL hijo = this.getHijoIzq();
        TElementoAVL padre = this;

        while (hijo.getHijoDer() != null) {
            padre = hijo;
            hijo = hijo.getHijoDer();
        }

        if (padre != this) {
            padre.setHijoDer(hijo.getHijoIzq());
            hijo.setHijoIzq(hijoIzq);
        }

        hijo.setHijoDer(hijoDer);
        return hijo;
    }

    /*Ordenes*/
    public String preOrden() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(this.etiqueta + "-");

        if (this.hijoIzq != null) {
            strBuilder.append(this.getHijoIzq().preOrden());
        }

        if (this.hijoDer != null) {
            strBuilder.append(this.getHijoDer().preOrden());
        }

        String str = strBuilder.toString();
        return str;
    }

    public String inOrden() {
        StringBuilder strBuilder = new StringBuilder();
        if (this.hijoIzq != null) {
            strBuilder.append(this.getHijoIzq().inOrden());
        }

        strBuilder.append(this.etiqueta + "-");

        if (this.hijoDer != null) {
            strBuilder.append(this.getHijoDer().inOrden());
        }

        String str = strBuilder.toString();
        return str;
    }

    public String postOrden() {
        StringBuilder strBuilder = new StringBuilder();
        if (this.hijoIzq != null) {
            strBuilder.append(this.getHijoIzq().postOrden());
        }

        if (this.hijoDer != null) {
            strBuilder.append(this.getHijoDer().postOrden());
        }

        strBuilder.append(this.etiqueta + "-");

        String str = strBuilder.toString();
        return str;
    }

    /*Otros metodos*/
    public int obtenerAltura() {
        int alturaIzq = 0;
        int alturaDer = 0;

        if(this.getHijoIzq() != null) {
            alturaIzq = this.getHijoIzq().obtenerAltura();
        }

        if(this.getHijoDer() != null) {
            alturaDer = this.getHijoDer().obtenerAltura();
        }

        return max(alturaIzq, alturaDer) + 1;
    }

    public int obtenerCantidadHojas() {
        int cantidad = 0;

        if(this.getHijoIzq() != null) {
            cantidad += this.getHijoIzq().obtenerCantidadHojas();
        }

        if(this.getHijoDer() != null) {
            cantidad += this.getHijoDer().obtenerCantidadHojas();
        }

        if(this.getHijoIzq() == null && this.getHijoDer() == null) {
            cantidad++;
        }

        return cantidad;
    }

    public int obtenerTamanio() {
        int tamanio = 1;
        if(this.getHijoIzq() != null) {
            tamanio += this.getHijoIzq().obtenerTamanio();
        }
        if(this.getHijoDer() != null) {
            tamanio += this.getHijoDer().obtenerTamanio();
        }
        return tamanio;
    }

    public TElementoAVL obtenerMenorClave() {
        if(this.getHijoIzq() != null) {
            return this.getHijoIzq().obtenerMenorClave();
        } else {
            return this;
        }
    }

    public TElementoAVL obtenerMayorClave() {
        if(this.getHijoDer() != null) {
            return this.getHijoDer().obtenerMayorClave();
        } else {
            return this;
        }
    }

    public int obtenerCantidadNodosNivel(int nivelBuscado) {
        int cantidadIzq = 0;
        int cantidadDer = 0;

        if (this.getEtiqueta() == null) {
            return 0;
        }

        if(nivelBuscado == 0) {
            return 1;
        }

        if (this.getHijoIzq() != null) {
            cantidadIzq = this.getHijoIzq().obtenerCantidadNodosNivel(nivelBuscado-1);
        }

        if (this.getHijoDer() != null) {
            cantidadDer = this.getHijoDer().obtenerCantidadNodosNivel(nivelBuscado-1);
        }

        return cantidadDer + cantidadIzq;
    }

    public List<String> listarHojasConNivel(List<String> list, int nivel) {

        if(this.getHijoDer() == null && this.getHijoIzq() == null) {
            list.add("Hoja: " + this.getEtiqueta() + " - Nivel: " + nivel);
        }

        if(this.getHijoIzq() != null) {
            this.getHijoIzq().listarHojasConNivel(list, nivel+1);
        }

        if(this.getHijoDer() != null) {
            this.getHijoDer().listarHojasConNivel(list, nivel+1);
        }

        return list;
    }

    public boolean esArbolDeBusqueda() {
        if (this.getEtiqueta() == null) {
            return true;
        }

        if (this.getHijoIzq() != null) {
            if (this.getHijoIzq().getEtiqueta().compareTo(this.getEtiqueta()) >= 0) {
                return false;
            }
            if (!this.getHijoIzq().esArbolDeBusqueda()) {
                return false;
            }
        }

        if (this.getHijoDer() != null) {
            if (this.getHijoDer().getEtiqueta().compareTo(this.getEtiqueta()) <= 0) {
                return false;
            }
            if (!this.getHijoDer().esArbolDeBusqueda()) {
                return false;
            }
        }

        return true;
    }

    public TElementoAVL obtenerClaveInmediatamenteAnterior(Comparable unaEtiqueta) {
        if (this.getEtiqueta() == null) {
            return null;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {
            if (getHijoIzq() != null) {
                return getHijoIzq().obtenerMayorClave();
            } else {
                return null;
            }
        } else if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (getHijoIzq() != null) {
                return getHijoIzq().obtenerClaveInmediatamenteAnterior(unaEtiqueta);
            } else {
                return null;
            }
        } else {
            if (getHijoDer() != null) {
                TElementoAVL temp = getHijoDer().obtenerClaveInmediatamenteAnterior(unaEtiqueta);
                if (temp == null) {
                    return this;
                } else {
                    return temp;
                }
            } else {
                return this;
            }
        }
    }

    public TElementoAVL inmediatamenteAnterior(Comparable clave){
        if (this == null){
            return null;
        }
        if (this.etiqueta == clave){
            TElementoAVL nodoAnterior;
            if (this.hijoIzq != null){
                nodoAnterior = this.hijoIzq;
                while (nodoAnterior.hijoDer != null){
                    nodoAnterior = nodoAnterior.hijoDer;
                }
                return nodoAnterior;
            }else{
                return this;
            }
        }
        if (this.hijoIzq != null && clave.compareTo(this.etiqueta) < 0) {
            return this.hijoIzq.inmediatamenteAnterior(clave);
        }
        if (this.hijoDer != null && clave.compareTo(this.etiqueta) > 0) {
            return this.hijoDer.inmediatamenteAnterior(clave);
        }
        return null;
    }

    public int obtenerNivel(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(this.getEtiqueta())) {
            return 0;
        } else if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() != null) {
                return 1 + getHijoIzq().obtenerNivel(unaEtiqueta);
            } else {
                return 0; //Si no encuentra la etiqueta devuelve 0
            }
        } else {
            if (this.getHijoDer() != null) {
                return 1 + getHijoDer().obtenerNivel(unaEtiqueta);
            } else {
                return 0;
            }
        }
    }

    public int sumaMismoNivel(int nivel, int suma){
        if (nivel == 0){
            suma = suma + Integer.parseInt(this.etiqueta.toString());
        }
        if (nivel < 0){
            return suma;
        }
        if (this.hijoIzq != null){
            suma = this.hijoIzq.sumaMismoNivel(nivel-1,suma);
        }
        if (this.hijoDer != null){
            suma = this.hijoDer.sumaMismoNivel(nivel-1,suma);
        }
        return suma;
    }

    public int enQueNivelEstaUnNodo(Comparable unaEtiqueta, int contador) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return contador;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().enQueNivelEstaUnNodo(unaEtiqueta, contador+1);
            } else {
                contador = -1;
            }
        } else if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().enQueNivelEstaUnNodo(unaEtiqueta, contador+1);
            } else {
                contador = -1;
            }
        } else {
            contador = -1;
        }
        return contador;
    }

    public void obtenerNodosEnRango(Comparable rangoMin, Comparable rangoMax, List<TElementoAVL> nodosEnRango) {
        TElementoAVL nodoActual = this;
        if (nodoActual == null) {
            return;
        }
        if (nodoActual.getEtiqueta().compareTo(rangoMin) < 0) {
            nodoActual.getHijoDer().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
        } else if (nodoActual.getEtiqueta().compareTo(rangoMax) > 0) {
            nodoActual.getHijoIzq().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
        } else {
            nodosEnRango.add(nodoActual);
            nodoActual.getHijoIzq().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
            nodoActual.getHijoDer().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
        }
    }

    public boolean esIdentico(TElementoAVL otroArbol){
        if (this == null && otroArbol == null){
            return true;
        }
        if (this == null || otroArbol == null){
            return false;
        }
        if (!this.equals(otroArbol)){
            return false;
        }
        return this.getHijoIzq().esIdentico(otroArbol.getHijoIzq()) && this.getHijoDer().esIdentico(otroArbol.getHijoDer());
    }

    public int menoresQue(Comparable unaclave) {
        int contador = 0;
        if (this.etiqueta == unaclave) {
            if (this.getHijoIzq() != null) {
                contador += this.getHijoIzq().menoresQue(unaclave);
            }
            if (this.getHijoDer() != null) {
                contador += this.getHijoDer().menoresQue(unaclave);
            }
        } else if (this.etiqueta.compareTo(unaclave) < 0) {
            contador += 1;
            if (this.getHijoIzq() != null) {
                contador += this.getHijoIzq().menoresQue(unaclave);
            }
            if (this.getHijoDer() != null) {
                contador += this.getHijoDer().menoresQue(unaclave);
            }
        } else {
            if (this.getHijoIzq() != null) {
                contador += this.getHijoIzq().menoresQue(unaclave);
            }
            if (this.getHijoDer() != null) {
                contador += this.getHijoDer().menoresQue(unaclave);
            }
        }
        return contador;
    }

    public void listar(ArrayList<T> unArrayList) {
        if (this.getDatos().toString() == "true"){ // un parametro para listar por ese
            unArrayList.add((T) this);
        }
        if (this.getHijoIzq() != null) {
            this.getHijoIzq().listar(unArrayList);
        }
        if (this.getHijoDer() != null) {
            this.getHijoDer().listar(unArrayList);
        }
    }

    /*public boolean igualesBordes(TArbolAVL otroArbol) {

    }*/

    public String imprimirRango(Comparable inferior, Comparable superior) {
        StringBuilder strBuilder = new StringBuilder();
        if (this.getEtiqueta().compareTo(inferior) >= 0 || this.getEtiqueta().compareTo(superior) <= 0){
            strBuilder.append(this.getEtiqueta()+"");
        }
        if (this.getHijoIzq() != null){
            strBuilder.append(this.getHijoIzq().imprimirRango(inferior,superior));
        }
        if (this.getHijoDer() != null){
            strBuilder.append(this.getHijoDer().imprimirRango(inferior,superior));
        }
        return strBuilder.toString();
    }

    public int obtenerBalance() {
        int alturaIzq = 0;
        int alturaDer = 0;

        if (this.getHijoIzq() != null) {
            alturaIzq = getHijoIzq().obtenerAltura();
        }

        if (this.getHijoDer() != null) {
            alturaDer = getHijoDer().obtenerAltura();
        }

        return alturaDer - alturaIzq;
    }

    private TElementoAVL<T>  balancear(TElementoAVL<T> nodoActual) {
        int balance = obtenerBalance();
        if (balance <= -2) {
            if (getHijoIzq() != null) {
                if (getHijoIzq().obtenerBalance() <= -1) {
                    return rotacionLL(nodoActual);
                } else {
                    return rotacionLR(nodoActual);
                }
            }
        } else if (balance >= 2) {
            if (getHijoDer() != null) {
                if (getHijoDer().obtenerBalance() >= 1) {
                    return rotacionRR(nodoActual);
                } else {
                    return rotacionRL(nodoActual);
                }
            }
        }

        return nodoActual;
    }

    /*Rotaciones*/
    public TElementoAVL rotacionLL(TElementoAVL k2) {
        TElementoAVL k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        return k1;
    }

    public TElementoAVL rotacionRL(TElementoAVL k1) {
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        return rotacionRR(k1);
    }

    public TElementoAVL rotacionLR(TElementoAVL k3) {
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        return rotacionLL(k3);
    }

    public TElementoAVL rotacionRR(TElementoAVL k1) {
        TElementoAVL k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        return k2;
    }
}
