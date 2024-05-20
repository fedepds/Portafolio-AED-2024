import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
  

        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();

        
        String[] lineasAbonados = ManejadorArchivosGenerico.leerArchivo("src/abonados.txt");
        for (String linea : lineasAbonados) {
            String[] datos = linea.split(",");
            
            TAbonado abonado = new TAbonado(datos[1], datos[0]);
            trie.insertar(abonado);

            
        }

        
        
        LinkedList<TAbonado> abonadosEncontrados = new LinkedList<>();
        String[] codigos = ManejadorArchivosGenerico.leerArchivo("src/codigos1.txt");
        String pais = codigos[0].substring(13);
        String area = codigos[1].substring(13);
        LinkedList<TAbonado> resultados = trie.buscarTelefonos(pais, area);
        abonadosEncontrados.addAll(resultados);



        
        String[] lineasSalida = new String[abonadosEncontrados.size()];
        int index = 0;
        for (TAbonado abonado : abonadosEncontrados) {
            lineasSalida[index++] = abonado.getNombre() + "," + abonado.getTelefono();
        }

        
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", lineasSalida);
        
      
        
    }
}