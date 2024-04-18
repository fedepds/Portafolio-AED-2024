public class Perro implements Mamifero{
    private String nombre;
    public Perro(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void ladrar() {
        System.out.println("wof");
    }
    public boolean respondeA(String nombre) {
        return this.nombre.equals(nombre);
    }

    @Override
    public void caminar() {

    }

    @Override
    public void correr() {

    }

    @Override
    public void saltar() {

    }
}
