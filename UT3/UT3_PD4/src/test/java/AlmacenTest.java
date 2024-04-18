import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlmacenTest {
    private Almacen almacen;
    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    void setUp() {
        almacen = new Almacen("Almacen Test", "Calle 123", "123456789");
        producto1 = new Producto(10001, "Producto 1", 1, 100);
        producto2 = new Producto(1001, "Producto 2", 2, 200);
    }

    @Test
    void getDireccion() {
        assertEquals("Calle 123", almacen.getDireccion());

    }

    @Test
    void setDireccion() {
        String expectedDireccion = "Calle 123";
        almacen.setDireccion(expectedDireccion);
        assertEquals(expectedDireccion, almacen.getDireccion());

    }

    @Test
    void getTelefono() {
        assertEquals("123456789", almacen.getTelefono());
    }

    @Test
    void setTelefono() {
        String expectedTelefono = "987654321";
        almacen.setTelefono(expectedTelefono);
        assertEquals(expectedTelefono, almacen.getTelefono());
    }

    @Test
    void getNombre() {
        assertEquals("Almacen Test", almacen.getNombre());
    }

    @Test
    void getListaProductos() {

    }

    @Test
    void obtenerValorStock() {
    }

    @Test
    void insertarProducto() {
        almacen.insertarProducto(producto1);
        almacen.insertarProducto(producto2);
        assertEquals(2, almacen.getListaProductos().cantElementos());
    }

    @Test
    void eliminarProducto() {
        almacen.insertarProducto(producto1);
        almacen.insertarProducto(producto2);
        assertEquals(2, almacen.getListaProductos().cantElementos());
        almacen.eliminarProducto(10001);
        assertEquals(1, almacen.getListaProductos().cantElementos());
    }

    @Test
    void imprimirProductos() {
    }

    @Test
    void imprimirSeparador() {
    }

    @Test
    void agregarStock() {

    }

    @Test
    void restarStock() {
    }

    @Test
    void buscarPorCodigo() {
    }

    @Test
    void listarOrdenadoPorNombre() {
    }

    @Test
    void buscarPorDescripcion() {
    }

    @Test
    void cantidadProductos() {
    }

    @Test
    void ingresarStock() {
    }

    @Test
    void ventaStock() {
    }
}