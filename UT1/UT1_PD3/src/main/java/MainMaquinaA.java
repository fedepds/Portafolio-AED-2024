public class MainMaquinaA {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Firulais");
        Perro perro2 = new Perro("Rex");
        System.out.println(perro1.getNombre());
        System.out.println(perro2.getNombre());
        perro1.ladrar();
        perro2.ladrar();
        System.out.println(perro1.respondeA("Firulais"));
        System.out.println(perro2.respondeA("Firulais"));

        perro1.correr();
        perro2.caminar();

    }
}
