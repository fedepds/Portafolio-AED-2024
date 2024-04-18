public class SucursalesConTDA {
    Lista sucursales;

    public SucursalesConTDA(){
        sucursales = new Lista();
    }
    public void agregarSurcursal(Comparable sucursal){
        if (sucursales.buscar(sucursal) != null) {
            System.out.println("La sucursal ya existe");

        }else {
            sucursales.insertar(new Nodo(sucursal,sucursal.toString()));
        }

    }

    public String buscarSucursal(Comparable sucursal){
        return sucursales.buscar(sucursal).getDato().toString();
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