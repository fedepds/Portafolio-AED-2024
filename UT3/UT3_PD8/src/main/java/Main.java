public class Main {
    public static void main(String[] args) {
        Sucursales sucursales= new Sucursales();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("/Users/federicopizarro/Desktop/UT3_PD8/src/main/java/suc1.txt");
        for (String linea : lineas) {
            sucursales.agregarSucursal(linea);
        }

        System.out.println(sucursales.cantSucursales());

        sucursales.listarSucursales();

        sucursales.quitarSucursal("Chicago");

        int aux = sucursales.buscarSucursal("Hong Kong");

        if (aux != -1 && aux < sucursales.cantSucursales() -1) {
            String siguiente=sucursales.buscarPorIndice(aux +1);
            System.out.println(siguiente);
        } else {
            System.out.println("No hay siguiente");
        }
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("/Users/federicopizarro/Desktop/UT3_PD8/src/main/java/suc2.txt");
        for (String linea : lineas2) {
            sucursales.agregarSucursal(linea);
        }
        sucursales.quitarSucursal("Shenzen");
        sucursales.quitarSucursal("Tokio");
        sucursales.listarSucursales();

        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo("/Users/federicopizarro/Desktop/UT3_PD8/src/main/java/suc3.txt");
        for (String linea : lineas3) {
            sucursales.agregarSucursal(linea);
        }
        System.out.println(sucursales.imprimir(";_"));
    }
}

