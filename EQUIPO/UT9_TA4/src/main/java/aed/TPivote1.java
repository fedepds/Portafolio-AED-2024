package aed;

public class TPivote1 implements IPivote{
    public int encuentraPivote(int izquierda, int derecha, int[] entrada) {
        int pivote = -1;
        if (entrada[izquierda] > entrada[izquierda + 1]) {
            pivote = izquierda;
        } else {
            pivote = izquierda + 1;
        }
        return pivote;
    }
}
