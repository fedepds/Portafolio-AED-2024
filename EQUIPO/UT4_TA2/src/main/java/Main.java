
/**
 *
 * @author ernesto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] claves = ManejadorArchivosGenerico.leerArchivo("/Users/federicopizarro/Desktop/UT4_TA2/src/main/java/claves1.txt");
        int contAgregadosArbol = 0;
        int contAgregadosArray = 0;
        String[] lineasArchivo = new String[claves.length];
        TArbolBB arbol = new TArbolBB<>();
        for (String clave : claves) {
            TElementoAB elemento = new TElementoAB<String>(clave, clave);
            if (arbol.insertar(elemento)) {
                contAgregadosArbol++;
                lineasArchivo[contAgregadosArray] = clave + " " + contAgregadosArbol;
                contAgregadosArray++;
            } else {
                lineasArchivo[contAgregadosArray] = clave + "  0";
                contAgregadosArray++;
            }

        }
        ManejadorArchivosGenerico.escribirArchivo("arbol", lineasArchivo);

        System.err.println(arbol.preOrden());

        claves = ManejadorArchivosGenerico.leerArchivo("/Users/federicopizarro/Desktop/UT4_TA2/src/main/java/consultaPrueba.txt");
        contAgregadosArbol = 0;
        contAgregadosArray = 0;
        lineasArchivo = new String[claves.length];
        for (String clave : claves) {
            if (arbol.buscar(clave) != null) {
                contAgregadosArbol++;
                lineasArchivo[contAgregadosArray] = clave + " " + contAgregadosArbol;
                contAgregadosArray++;
            } else {
                lineasArchivo[contAgregadosArray] = clave + " -" + contAgregadosArbol;
                contAgregadosArray++;
            }

        }
        ManejadorArchivosGenerico.escribirArchivo("busqueda", lineasArchivo);

        System.err.println(arbol.postOrden());
        System.err.println(arbol.inOrden());

    }

}
