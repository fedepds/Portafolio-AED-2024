package uy.edu.ucu.aed;

public class Main {
    public static void main(String[] args) {
        // Cargar el árbol a partir del archivo
        TArbolDeProductos arbolProductos = new TArbolDeProductos();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("productos.txt");
        for (String linea : lineas) {
            String[] producto = linea.split(",");
            Producto nuevProducto = new Producto(Integer.parseInt(producto[0]), producto[1]);
            arbolProductos.insertar(producto[0], nuevProducto);
        }
        // Invocar el método solicitado
        int tamaño = arbolProductos.obtenerTamaño();
        double lTI = arbolProductos.raiz.longTraInt(0)[0];
        double resultado = arbolProductos.longIntMed();
        // Mostrar por consola el reusltado
        System.out.println("Tamaño del arbol: " + tamaño);
        System.out.println("LTI: " + lTI);
        System.out.println("La longitud de trayectoria interna media es: " + resultado);

        System.out.println("La longitud de trayectoria interna mediaV2 es: " + arbolProductos.longIntMedv2());
        String[] salida = {
                "LTI: " + String.valueOf(arbolProductos.raiz.longTraInt(0)[0]),
                "Altura del arbol: " + String.valueOf(arbolProductos.obtenerAltura()),
                "LTIM: " + String.valueOf(resultado)
        };
        ManejadorArchivosGenerico.escribirArchivo("salida.txt", salida);
    }
}
