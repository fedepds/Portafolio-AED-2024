public class NumerosPrimos {
    public static boolean isPrime(long n) {
        boolean prime = true;
        int i=3;
        while (i <= Math.sqrt(n))
            if (n % i == 0) {
                prime = false;
                i += 2;
                break;
            }
        while (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        }
        return false;
    }
}
