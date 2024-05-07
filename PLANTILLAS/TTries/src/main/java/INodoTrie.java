import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface INodoTrie {

    String buscar(String s); 
    void imprimir();

    void insertar(String unaPalabra, LinkedList<Integer> paginas);
    public void predecir(String prefijo, LinkedList<String> palabras);
    
    
}
