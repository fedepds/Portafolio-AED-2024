package unidad;

public class PruebaAtributos {
    int numero = 10;
    float flotante = 10.5f;
    char letra = 'a';
    boolean bandera = true;

    public static void main(String[] args) {
        PruebaAtributos pa = new PruebaAtributos();
        System.out.println("El valor de numero es: " + pa.numero);
        System.out.println("El valor de flotante es: " + pa.flotante);
        System.out.println("El valor de letra es: " + pa.letra);
        System.out.println("El valor de bandera es: " + pa.bandera);

    }
}