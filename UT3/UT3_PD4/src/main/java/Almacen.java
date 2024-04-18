import static java.lang.Integer.*;

public class Almacen implements IAlmacen {
    private Lista<IProducto> listaProductos;
    private String direccion;
    private String telefono;
    private String nombre;

    public Almacen(String nombre) {
        this.listaProductos = new Lista<>();
        this.nombre = nombre;
        this.direccion = "undefined";
        this.telefono = "undefined";
    }

    public Almacen(String nombre, String direccion, String telefono) {
        this.listaProductos = new Lista<>();
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Lista<IProducto> getListaProductos() {
        return listaProductos;
    }

    // FALTA IMPLEMENTAR
    public long obtenerValorStock() {
        long valorStock = 0;
        String claves = listaProductos.imprimir();
        String[] clavesArray = claves.split(" ");
        for (String clave : clavesArray) {
            IProducto producto = listaProductos.buscar(clave);
            valorStock += producto.getPrecio() * producto.getStock();
        }
        return valorStock;
    }

    public void insertarProducto(IProducto unProducto) {
        this.listaProductos.insertar(unProducto, unProducto.getCodProducto());
    }

    public boolean eliminarProducto(Comparable codProducto) {
        return this.listaProductos.eliminar(codProducto);
    }

    public String imprimirProductos() {
        return this.listaProductos.imprimir();
    }

    public String imprimirSeparador(String separador) {
        return this.listaProductos.imprimir(separador);
    }

    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        IProducto producto = this.listaProductos.buscar(codProducto);
        if (producto != null) {
            producto.agregarCantidadStock(cantidad);
            return true;
        }
        return false;
    }

    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        IProducto producto = this.listaProductos.buscar(codProducto);
        if (producto != null) {
            producto.restarCantidadStock(cantidad);
            return producto.getStock();
        }
        return -1;
    }

    public IProducto buscarPorCodigo(Comparable codProducto) {
        return this.listaProductos.buscar(codProducto);
    }

    // El array viene previamente creado y ordenado
    private Producto[] insertarArrayOrdenado(Producto[] array, Producto elemento, int next) {
        int i = 0;
        while (i < next && array[i].getNombre().compareTo(elemento.getNombre()) < 0) {
            i++;
        }
        if (i < next) {
            for (int j = next; j > i; j--) {
                array[j] = array[j - 1];
            }
        }
        array[i] = elemento;

        return array;
    }

    public void listarOrdenadoPorNombre() {
        String claves = listaProductos.imprimir(",");
        String[] clavesArray = claves.split(",");
        Producto[] productosOrdenados = new Producto[clavesArray.length];
        short next = 0;
        for (String clave : clavesArray) {
            IProducto producto = buscarPorCodigo(clave);
            productosOrdenados = insertarArrayOrdenado(productosOrdenados, (Producto) producto, next);
            next++;
        }
        for (Producto producto : productosOrdenados) {
            System.out.println("Nombre: " + producto.getNombre() + " | Stock: " + producto.getStock());
        }
    }

    public IProducto buscarPorDescripcion(String descripcion) {
        String claves = listaProductos.imprimir();
        String[] clavesArray = claves.split(" ");
        for (String clave : clavesArray) {
            IProducto producto = listaProductos.buscar(clave);
            if (producto.getNombre().equals(descripcion)) {
                return producto;
            }
        }
        return null;
    }

    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }

    public Integer ingresarStock(String rutaArchivo) {
        Integer compraTotal = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            try {
                IProducto producto = buscarPorCodigo(Integer.parseInt(datos[0].replaceAll("[^0-9]", "")));
                if (producto == null) {
                    producto = new Producto(Integer.parseInt(datos[0].replaceAll("[^0-9]", "")), datos[1], Integer.parseInt(datos[2].replaceAll("[^0-9]", "")), Integer.parseInt(datos[3].replaceAll("[^0-9]", "")));
                    this.insertarProducto(producto);
                } else {
                    producto.agregarCantidadStock(Integer.parseInt(datos[3].replaceAll("[^0-9]", "")));
                }
                compraTotal += Integer.parseInt(datos[2].replaceAll("[^0-9]", "")) * Integer.parseInt(datos[3].replaceAll("[^0-9]", ""));
            } catch (NumberFormatException e) {
                System.err.println("La cadena no se pudo convertir a un número entero.");
            }
        }
        return compraTotal;
    }
    public Integer ventaStock(String rutaArchivo) {
        Integer ventaTotal = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            IProducto prod = this.buscarPorCodigo(parseInt(datos[0]));
            if (prod != null) {
                prod.restarCantidadStock(parseInt(datos[1]));
                ventaTotal += prod.getPrecio() * parseInt(datos[1]);
            }
        }
        return ventaTotal;
    }

}
