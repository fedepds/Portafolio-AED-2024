import java.util.LinkedList;

public class SucursalesLinkedLista {

    LinkedList<String> lista = new LinkedList<>();

    public boolean agregar(String elemento) {

        return lista.add(elemento);

    }

    public int buscar(String elem) {

        return lista.indexOf(elem);

    }

    public Boolean quitar(String elem) {
        return lista.remove(elem);
    }

    public String listar() {
        String resultado = "";

        for (String string : lista) {
            resultado = resultado + string + ";_";
        }
        return resultado;

    }

    public int cantidadSucursales() {
        return lista.size();

    }

    public boolean esVacio() {

        return lista.isEmpty();
    }

}
