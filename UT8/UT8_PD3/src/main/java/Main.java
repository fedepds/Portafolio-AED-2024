
public class Main {

    public static void main(String[] args) {
       // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "src/barrio.txt",
                "src/distancias.txt",
                false, TGrafoRedElectrica.class);
       
        /*
           
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        
        */
        
        //Hago mas de una implementación como pide el pd.
        TAristas arista = laRed.mejorRedElectrica();
        double contador = 0.0;
        for(TArista a : arista){
            contador += a.getCosto();
        }
        String mensaje = "PRIMERO IMPLEMENTACION\nCOSTO TOTAL: " + contador/2 +"\n"+ arista.imprimirEtiquetas();
        ManejadorArchivosGenerico.escribirArchivo("src/redelectrica.txt", mensaje.split("\n"));
        
        arista = laRed.mejorRedElectrica2();
        contador = 0.0;
        for(TArista a : arista){
            contador += a.getCosto();
        }
        mensaje = "SEGUNDA IMPLEMENTACION\nCOSTO TOTAL: " + contador/2 +"\n"+ arista.imprimirEtiquetas();
        ManejadorArchivosGenerico.escribirArchivo("src/redelectrica.txt", mensaje.split("\n"));
        
    }
}
