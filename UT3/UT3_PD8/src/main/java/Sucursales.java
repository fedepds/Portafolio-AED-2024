import java.util.ArrayList;

public class Sucursales {
    private ArrayList<String> sucursales;

    public Sucursales() {
        sucursales = new ArrayList<>();
    }

    public void agregarSucursal(String sucursal) {
        sucursales.add(sucursal);
    }

    public int buscarSucursal(String sucursal) {
        return sucursales.indexOf(sucursal);
    }

    public void quitarSucursal(String sucursal) {
        sucursales.remove(sucursal);
    }

    public void listarSucursales() {
        for (String sucursal : sucursales) {
            System.out.println(sucursal);
        }
    }

    public int cantSucursales() {
        return sucursales.size();
    }

    public boolean esVacio() {
        return sucursales.isEmpty();
    }

    public String imprimir(String separador){
        String res="";
        for (int i = 0; i < sucursales.size(); i++) {
            res+=sucursales.get(i)+separador;
        }
        return res;
    }

    public String buscarPorIndice(int index) {
        return sucursales.get(index);
    }

}

