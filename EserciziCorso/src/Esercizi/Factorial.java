public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(1) == (1));
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    private static long factorial(int n) {
        //inserite il vostro codice qui
        if(n == 0) return 1;
        long out = 1;
        for(int i = 1; i <= n; i++){
            out = out * i;
        }
        return out;
    }
}