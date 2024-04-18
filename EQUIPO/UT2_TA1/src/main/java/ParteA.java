public class ParteA {

    public static int factorial(int num) {
        for(int i=num-1; i>0; i--){
            if (num == 0) {
                return 1;
            } else {
                return num * factorial(num - 1);
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int numero= 5;
        System.out.println(factorial(numero));
    }

}
