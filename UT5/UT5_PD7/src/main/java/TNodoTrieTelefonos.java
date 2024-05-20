import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private TNodoTrieTelefonos[] hijos;
    private String nombre;

    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[11]; 
        nombre = null;
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = this;

        for (int i = 0; i < primerosDigitos.length(); i++) {
            int digito = primerosDigitos.charAt(i) - '0';
            if (digito < 0 || digito > 9 || nodo.hijos[digito] == null) {
                
                return;
            }
            nodo = nodo.hijos[digito];
        }

        buscarEnProfundidad(nodo, primerosDigitos, abonados);
    }


    private void buscarEnProfundidad(TNodoTrieTelefonos nodo, String numeroAcumulado, LinkedList<TAbonado> abonados) {
        if (nodo.nombre != null) {
            insertarOrdenado(abonados, new TAbonado(nodo.nombre, numeroAcumulado));
        }

        for (int c = 0; c < 10; c++) {
            if (nodo.hijos[c] != null) {
                buscarEnProfundidad(nodo.hijos[c], numeroAcumulado + c, abonados);
            }
        }
    }

    private void insertarOrdenado(LinkedList<TAbonado> abonados, TAbonado nuevoAbonado) {
        if (abonados.isEmpty()) {
            abonados.add(nuevoAbonado);
            return;
        }
        for (int i = 0; i < abonados.size(); i++) {
            if (nuevoAbonado.getNombre().compareTo(abonados.get(i).getNombre()) < 0) {
                abonados.add(i, nuevoAbonado);
                return;
            }
        }
        abonados.add(nuevoAbonado);
    }



    @Override
    public void insertar(TAbonado unAbonado) {
        String nombre = unAbonado.getNombre();
        insertarNumero(nombre, unAbonado.getTelefono());
    }

    private void insertarNumero(String nombreAbonado, String numeroTelefonico) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < numeroTelefonico.length(); c++) {
            int digito = numeroTelefonico.charAt(c) - '0'; 
            if (nodo.hijos[digito] == null) {
                nodo.hijos[digito] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[digito];
        }
        nodo.nombre=nombreAbonado;
    }

    
}

    

