/**
 * SucursalesConTDA
 */
public class SucursalesConTDA {
// • Agregar una sucursal
// • Buscar una sucursal
// • Quitar una sucursal
// • Listar todas las sucursales
// • Indicar la cantidad de sucursales
// • Indicar si el directorio de sucursales está o no vacío
    Lista<String> sucursales;

    public SucursalesConTDA(){
        sucursales = new Lista<>();
    }
    public void agregarSurcursal(Comparable sucursal){
        sucursales.insertar(new Nodo<String>(sucursal,sucursal.toString()));
    } 

    public Nodo buscarSucursal(Comparable sucursal){
        return sucursales.buscar(sucursal);
    }

    public void quitarSucursal(Comparable sucursal){
        sucursales.eliminar(sucursal);
    }
    public String[] listarSucursales(){
        String[] listaSucursales = sucursales.imprimir().split(" ");

        return listaSucursales;
    }
    public String[] listarSucursales(String separador){
        String[] listaSucursales = sucursales.imprimir(separador).split(separador);

        return listaSucursales;
    }
    public int cantidadSucursales(){
        return listarSucursales().length;
    }

    public boolean directorioVacio(){
        return sucursales.esVacia();
    }

}