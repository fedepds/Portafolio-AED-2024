package uy.edu.ucu.aed.parcial2;

enum TipoDeNodo {
    SWITCH(1),
    NODO_DE_PROCESAMIENTO(2);

    private final int value;

    TipoDeNodo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TipoDeNodo fromInt(int i) {
        for (TipoDeNodo type : TipoDeNodo.values()) {
            if (type.getValue() == i) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value for TipoDeNodo: " + i);
    }
}

public class TNodoDeLaRed {

    public TNodoDeLaRed(int id, String nombre, TipoDeNodo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    private int id;
    private String nombre;
    private TipoDeNodo tipo;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeNodo getTipo() {
        return tipo;
    }
}
