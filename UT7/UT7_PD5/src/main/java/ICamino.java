/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface ICamino {

    boolean agregarAdyacencia(TAdyacencia adyacenciaActual);

    TCamino copiar();

    boolean eliminarAdyacencia(TAdyacencia adyacenciaActual);


    String imprimirEtiquetas();
    
}
