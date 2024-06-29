package uy.edu.ucu.aed.parcial2;

import uy.edu.ucu.aed.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class TVerticeDeLaRed extends TVertice<TNodoDeLaRed> {

    private static TNodoDeLaRed crearNodo(String unaEtiqueta, String tipoDeVertice) {
        String[] parts = unaEtiqueta.split("_");
        int id = Integer.parseInt(parts[1]);

        TipoDeNodo tipo = TipoDeNodo.fromInt(Integer.parseInt(tipoDeVertice));

        return new TNodoDeLaRed(id, unaEtiqueta, tipo);
    }

    public TVerticeDeLaRed(Object... args) { 
        super((String) args[0]);
    
        this.datos = crearNodo((String) args[0], (String) args[1]);
    }

    public TCaminos<TNodoDeLaRed> caminoDesdeHasta(Comparable etVertDest, TCamino<TNodoDeLaRed> caminoPrevio, TCaminos<TNodoDeLaRed> todosLosCaminos) {
        this.setVisitado(true);
        for (IAdyacencia<TNodoDeLaRed>adyacencia : this.getAdyacentes()) {
            IVertice<TNodoDeLaRed> destino = adyacencia.getDestino();
            if (destino.getDatos().getTipo() == TipoDeNodo.SWITCH) {
                if (!destino.getVisitado()) {
                    if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                        TCamino<TNodoDeLaRed> copia = caminoPrevio.copiar();
                        copia.agregarAdyacencia(adyacencia);
                        todosLosCaminos.getCaminos().add(copia);
                    } else {
                        caminoPrevio.agregarAdyacencia(adyacencia);
                        destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                        caminoPrevio.eliminarAdyacencia(adyacencia);
                    }
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }
}
