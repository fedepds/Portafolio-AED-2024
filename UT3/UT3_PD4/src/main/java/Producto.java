public class Producto implements IProducto {

    private int CodigoProducto;
    private int PrecioProducto;
    private String NombreProducto;
    private int Stock;

    public Producto(int codigoProducto, String nombre, int precio, int stock) {
        this.CodigoProducto = codigoProducto;
        this.PrecioProducto = precio;
        this.NombreProducto = nombre;
        this.Stock = stock;
    }

    public Comparable getCodProducto() {
        return CodigoProducto;
    }

    public Integer getPrecio() {
        return PrecioProducto;
    }

    public void setPrecio(Integer precio) {
        this.PrecioProducto = precio;
    }

    public Integer getStock() {
        return Stock;
    }

    public void agregarCantidadStock(Integer stock) {
        this.Stock += stock;
    }

    public void restarCantidadStock(Integer stock) {
        this.Stock -= stock;
    }

    public String getNombre() {
        return NombreProducto;
    }

    public void setNombre(String nombre) {
        this.NombreProducto = nombre;
    }

}
