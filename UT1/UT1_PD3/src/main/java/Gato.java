public class Gato implements Mamifero{
    private String nombre;
    public Gato(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void maullar() {
        System.out.println("miau");
    }
    public boolean respondeA(String nombre) {
        return this.nombre.equals(nombre);
    }
    @Override
    public void caminar() {}

    @Override
    public void correr(){}
    @Override
    public void saltar(){}

}
