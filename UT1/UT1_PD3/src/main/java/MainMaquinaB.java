public class MainMaquinaB {
    public static void main(String[] args) {
        Gato gato1 = new Gato("Garfield");
        Gato gato2 = new Gato("Tom");
        System.out.println(gato1.getNombre());
        System.out.println(gato2.getNombre());
        gato1.maullar();
        gato2.maullar();
        System.out.println(gato1.respondeA("Garfield"));
        System.out.println(gato2.respondeA("Garfield"));
        gato1.correr();
        gato2.caminar();

    }
}
