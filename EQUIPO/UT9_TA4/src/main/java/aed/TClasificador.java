package aed;

public class TClasificador {
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;


public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, IPivote pivoteFuncion) {
    switch (metodoClasificacion) {
    case METODO_CLASIFICACION_QUICKSORT:
        return ordenarPorQuickSort(datosParaClasificar, pivoteFuncion);
    default:
        System.err.println("Este codigo no deberia haberse ejecutado");
        break;
    }
    return datosParaClasificar;
}

protected int[] ordenarPorQuickSort(int[] datosParaClasificar, IPivote pivoteFuncion) {
    quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1,pivoteFuncion);
    return datosParaClasificar;
}

private void quicksort(int[] entrada, int i, int j, IPivote pivoteFuncion) {
    int izquierda = i;
    int derecha = j;

    int posicionPivote = pivoteFuncion.encuentraPivote(izquierda,derecha,entrada); 
    if (posicionPivote >= 0){
        int pivote = entrada[posicionPivote];  
        while (izquierda <= derecha) {
            while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                izquierda++; 
            }

            while ((pivote <= entrada[derecha]) && (derecha > i)) {
                derecha--; 
            }

            if (izquierda <= derecha) {
                intercambiar(entrada, izquierda, derecha); 
                izquierda++;
                derecha--;
            }
        }
    }
        if (i < derecha)
            quicksort(entrada, i, derecha, pivoteFuncion); 
        if (izquierda < j)
            quicksort(entrada, izquierda, j, pivoteFuncion); 
    
}


private void intercambiar(int[] vector, int pos1, int pos2) {
    int temp = vector[pos2];
    vector[pos2] = vector[pos1];
    vector[pos1] = temp;
}

}


