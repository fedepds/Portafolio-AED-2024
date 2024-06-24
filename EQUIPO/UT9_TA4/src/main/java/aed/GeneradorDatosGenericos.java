package aed;
import java.util.Random;

public class GeneradorDatosGenericos {
	private static int TAMANIO_MAX = 32000;

	public int[] generarDatosAleatorios(int tamanio) {
		Random rnd = new Random();
		// Vector con los valores
		int[] datosGenerados = new int[tamanio];
		// Vector para verificar si ya tiene valor
		boolean[] datosUtilizados = new boolean[tamanio];
		// Estos son los valores que van a estar en el vector i valor del vector
		for (int i = 0; i < datosGenerados.length; i++) { // O(N)
			// recibe un valor aleatorio que sera el indice
			int j = rnd.nextInt(tamanio);
			// Revisa si ya tiene valor ese indice, si lo tiene recorre hasta encontrar
			// uno sin
			while (datosUtilizados[j]) { // O(N)
				j = (j + 1) % tamanio;
			}
			datosGenerados[j] = i;
			datosUtilizados[j] = true;
		}
		return datosGenerados;
		// O(N*N) = O(N²)
	}

	public int[] generarDatosAleatorios(){
		return generarDatosAleatorios(TAMANIO_MAX);
	}

	public int[] generarDatosAscendentes(int tamanio) {
		int[] copiaAscendente = new int[tamanio];
		for (int i = 0; i < tamanio; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}

	public int[] generarDatosAscendentes() {
		return generarDatosAscendentes(TAMANIO_MAX);
	}

	public int[] generarDatosDescendentes(int tamanio) {
		int[] copiaDescendente = new int[tamanio];
		for (int i = 0; i < tamanio; i++) {
			copiaDescendente[i] = tamanio - i;
		}
		return copiaDescendente;
	}

	public int[] generarDatosDescendentes() {
		return generarDatosDescendentes(TAMANIO_MAX);
	}
}
