/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // imprimendo suc1 con tdalista
        String[] paths = { "suc1.txt", "suc2.txt", "suc3.txt", "sucursales.txt" };
        // SucursalesConTDA suc1 = new SucursalesConTDA();
        // SucursalesConTDA suc2 = new SucursalesConTDA();
        // SucursalesConTDA suc3 = new SucursalesConTDA();
        
        // for (String path : paths) {
            String path = "suc3.txt";
            String[] suc1 = ManejadorArchivosGenerico.leerArchivo(path);

            // Construir Scursales con TDALista
            SucursalesConTDA suc1TDALista = new SucursalesConTDA();
            SucursalesLinkedLista sucursal2 = new SucursalesLinkedLista();
            for (String sucursal : suc1) {
                suc1TDALista.agregarSurcursal(sucursal);
                sucursal2.agregar(sucursal);
            }
            /* 
            for (String sucursal : suc1TDALista.listarSucursales()) {
                System.out.println(sucursal);

            }
            */
     
            System.out.println(sucursal2.listar());
       
            
   

        // }
    }
}
