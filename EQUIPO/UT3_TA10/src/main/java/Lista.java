public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (nodo == null || nodo.getSiguiente() != null) {
            throw new IllegalArgumentException("El nodo ya esta en otra lista");
        }
        if (primero == null) {
            primero = nodo;
        } else {
            nodo.setSiguiente(primero);
            primero = nodo;
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> nodoActual = primero;
        while(nodoActual != null){
            if(nodoActual.getEtiqueta().equals(clave)){
                return nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }
    public Nodo<T> getPrimero(){
        return primero;
    }
    @Override
    public boolean eliminar(Comparable clave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

    @Override
    public String imprimir() {
        Nodo actual = primero;
        StringBuilder lista = new StringBuilder();  
        while(actual != null){
            lista.append(actual.getEtiqueta() + " ");
            actual = actual.getSiguiente();
        }
        return lista.toString().trim();
    }

    @Override
    public String imprimir(String separador) {
        Nodo actual = primero;
        StringBuilder lista = new StringBuilder();  
        while(actual != null){
            
            if(actual.getSiguiente() != null){
                lista.append(actual.getEtiqueta() + separador);    
            }else{
                lista.append(actual.getEtiqueta());
            }
            actual = actual.getSiguiente();
        }
        return lista.toString().trim();
    }

    @Override
    public int cantElementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantElementos'");
    }

    @Override
    public boolean esVacia() {
        if(primero == null){
            return true;
        }
        return false;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrimero'");
    }

    // implementar los metodos indicados en la interfaz
}
