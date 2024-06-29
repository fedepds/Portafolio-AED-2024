package uy.edu.ucu.aed.parcial2;

import uy.edu.ucu.aed.TCaminos;

@SuppressWarnings("rawtypes")
public interface IGrafoDeLaRed {
    TCaminos<TNodoDeLaRed> caminosDesdeHasta(Comparable nodoOrigen, Comparable nodoDestino);
}
