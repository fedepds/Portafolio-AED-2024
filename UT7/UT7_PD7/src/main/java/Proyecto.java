import java.util.LinkedList;
import java.util.Stack;

public class Proyecto {
    public static void main(String[] args) {

            ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();


            TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/Tareas.txt", "src/Precedencias.txt",
                    false, TGrafoDirigido.class);

        // Crear un array de strings que contenga la longitud de la trayectoria interna, la longitud media de la trayectoria interna y la altura del TArbolDeProductos
        int cont = 0;
        String[] salida = new String[gd.ordenacionTopologica_lista().size()];
                for( TVertice v : gd.ordenacionTopologica_lista()){
                    salida[cont] = String.valueOf(v.getEtiqueta());
                    cont++;
                }


        manejadorArchivosGenerico.escribirArchivo("src/salida.txt", salida);




    }
}
