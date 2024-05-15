package uy.edu.ucu.aed;

public class Hash implements IHash{
    private int[] tabla = new int[10];
    @Override
    public int buscar(int unaClave) {
        return 0;
    }

    @Override
    public int insertar(int unaClave) {
        return 0;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return unaClave % tabla.length;

    }
    public int otraFuncionHashing(int unaClave) {
        int resultado = 0;
        for (char c :String.valueOf(unaClave).toCharArray()){
            resultado += Integer.parseInt(String.valueOf(c));

        }
        return resultado % tabla.length;
    }
    public int funcionHashingAgustin(int unaClave) {
        return unaClave % 23;
    }
}
