public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen("Almacen 1", "Calle 123", "123456789");
        Producto producto1 = new Producto(10001, "Producto 1", 1, 100);
        Producto producto2 = new Producto(1001, "Producto 2", 2, 200);
        Producto producto3 = new Producto(1112, "Producto 3", 3, 300);
        System.err.println("Direccion: " + almacen.getDireccion());
        System.err.println("Telefono: " + almacen.getTelefono());
        System.err.println("Nombre: " + almacen.getNombre());
        almacen.insertarProducto(producto1);
        almacen.insertarProducto(producto2);
        almacen.insertarProducto(producto3);
        almacen.listarOrdenadoPorNombre();
        System.err.println("Cantidad de productos: " + almacen.cantidadProductos());
        almacen.eliminarProducto(10001);
        almacen.eliminarProducto(1001);
        almacen.eliminarProducto(1112);
        System.err.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.err.println("Compra total: $" + almacen.ingresarStock("/Users/federicopizarro/Desktop/UT3_PD4/src/main/archivos almacen/altas.txt"));
        System.err.println("Cantidad de productos: " + almacen.cantidadProductos());
        System.err.println("Venta total: $" + almacen.ventaStock("/Users/federicopizarro/Desktop/UT3_PD4/src/main/archivos almacen/ventas.txt"));
        System.err.println("Valor de stock total: $" + almacen.obtenerValorStock());

    }
}
