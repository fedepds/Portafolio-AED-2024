public class Main {
    public static void main(String[] args) {
        SucursalesConTDA sucursales = new SucursalesConTDA();
        String sourceFile = "/Users/federicopizarro/Desktop/UT3_PD6/src/main/suc1.txt";
        String[] sucursalesArray = ManejadorArchivosGenerico.leerArchivo(sourceFile);

        for (int i=0; i<sucursalesArray.length; i++) {
            sucursales.agregarSurcursal(sucursalesArray[i]);
        }
        System.out.println(sucursales.listarSucursales(","));
        System.out.println(sucursales.sucursales.imprimir());

    }
}
