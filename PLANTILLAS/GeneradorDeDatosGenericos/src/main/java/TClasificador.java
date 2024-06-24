
public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
	public static final int METODO_CLASIFICACION_QUICKSORT = 4;
	public static final int METODO_CLASIFICACION_HEAPSORT = 5;

	/**
	 * Punto de entrada al clasificador
	 *
	 * @param metodoClasificacion
	 * @param orden
	 * @param tamanioVector
	 * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
	 */
	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
		switch (metodoClasificacion) {
			case METODO_CLASIFICACION_INSERCION:
				return ordenarPorInsercion(datosParaClasificar);
			case METODO_CLASIFICACION_SHELL:
				return ordenarPorShell(datosParaClasificar);
			case METODO_CLASIFICACION_BURBUJA:
				return ordenarPorBurbuja(datosParaClasificar);
			case METODO_CLASIFICACION_QUICKSORT:
				return ordenarPorQuickSort(datosParaClasificar);
			case METODO_CLASIFICACION_HEAPSORT:
				return ordenarPorHeapSort(datosParaClasificar);
			default:
				System.err.println("Este codigo no deberia haberse ejecutado");
				break;
		}
		return datosParaClasificar;
	}

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	private int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

		for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i++) {
					j = i - inc;
					while (j >= 0 && datosParaClasificar[j] > datosParaClasificar[j + inc]) {
						intercambiar(datosParaClasificar, j, j + inc);
						j -= inc;
					}
				}
			}
		}
		return datosParaClasificar;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
		if (datosParaClasificar == null) {
			return null;
		}
		for (int i = 1; i < datosParaClasificar.length; i++) {
			int elementoActual = datosParaClasificar[i];
			int j = i - 1;
			while ((j >= 0) && (elementoActual < datosParaClasificar[j])) {
				datosParaClasificar[j + 1] = datosParaClasificar[j];
				j = j - 1;
			}
			datosParaClasificar[j + 1] = elementoActual;
		}
		return datosParaClasificar;
	}

	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		int n = datosParaClasificar.length - 1;
		for (int i = 0; i < n; i++) {
			for (int j = n; j >= (i + 1); j--) {
				if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
					intercambiar(datosParaClasificar, j - 1, j);
				}
			}
		}
		return datosParaClasificar;
	}

	protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
		quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
		return datosParaClasificar;
	}

	private void quicksort(int[] entrada, int i, int j) {
		int izquierda = i;
		int derecha = j;

		int posicionPivote = encuentraPivote(izquierda, derecha, entrada);
		if (posicionPivote >= 0) {
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
			quicksort(entrada, i, derecha);
		if (izquierda < j)
			quicksort(entrada, izquierda, j);
	}

	private int encuentraPivote(int izquierda, int derecha, int[] entrada) {
		int pivote = -1;
		if (entrada[izquierda] > entrada[izquierda + 1]) {
			pivote = izquierda;
		} else {
			pivote = izquierda + 1;
		}
		return pivote;
	}

	protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
		for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { // Armo el heap inicial de n-1 div 2 hasta 0
			armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
		}
		for (int i = datosParaClasificar.length - 1; i >= 1; i--) { // Error i>1 ==> i>=1
			intercambiar(datosParaClasificar, 0, i);
			armaHeap(datosParaClasificar, 0, i - 1);
		}
		return datosParaClasificar;
	}

	private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
		if (primero < ultimo) {
			int r = primero;
			while (r <= ultimo / 2) {
				if (ultimo == 2 * r) { // r tiene un hijo solo
					if (datosParaClasificar[r] < datosParaClasificar[r * 2]) {
						intercambiar(datosParaClasificar, r, 2 * r); // guardar 2*r en variable
					}
					r = ultimo;
				} else { // r tiene 2 hijos
					int posicionIntercambio = 0;
					if (datosParaClasificar[2 * r] < datosParaClasificar[2 * r + 1]) {
						posicionIntercambio = 2 * r + 1;
					} else {
						posicionIntercambio = 2 * r;
					}
					if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
						intercambiar(datosParaClasificar, r, posicionIntercambio);
						r = posicionIntercambio;
					} else {
						r = ultimo;
					}
				}
			}
		}
	}

	public boolean estaOrdenado(int[] datosAVerificar, boolean orden) {
		if (!orden) {
			for (int i = 0; i < datosAVerificar.length - 1; i++) {
				if (datosAVerificar[i] <= datosAVerificar[i + 1]) {
					return false;
				}
			}
			return true;
		} else {
			for (int i = 0; i < datosAVerificar.length - 1; i++) {
				if (datosAVerificar[i] >= datosAVerificar[i + 1]) {
					return false;
				}
			}
			return true;
		}

	}
}
