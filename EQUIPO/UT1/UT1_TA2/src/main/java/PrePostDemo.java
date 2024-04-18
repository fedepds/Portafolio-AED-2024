public class PrePostDemo {
    public static void main(String[] args){
        int i = 3;
        i++;
        System.out.println(i);
        ++i;
        System.out.println(i);
        System.out.println(++i);
        System.out.println(i++);
        System.out.println(i);
    }
}
/* lo que hace este codigo es que primero imprime el valor de i que es 3, luego le suma 1 y lo imprime, luego le suma 1 y lo imprime, luego le suma 1 y lo imprime, luego imprime el valor de i y luego le suma 1 y lo imprime.*/