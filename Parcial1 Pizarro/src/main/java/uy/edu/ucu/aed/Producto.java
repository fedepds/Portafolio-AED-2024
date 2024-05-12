package uy.edu.ucu.aed;

public class Producto {
    private int identificador;
    private String nombre;

    public Producto(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }
}
